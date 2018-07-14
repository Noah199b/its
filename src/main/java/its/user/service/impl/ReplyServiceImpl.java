package its.user.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import its.user.dao.DownloadDao;
import its.user.dao.MessageDao;
import its.user.dao.ReplyDao;
import its.user.dao.ResourceDao;
import its.user.dao.UserDao;
import its.user.entity.Message;
import its.user.entity.Reply;
import its.user.entity.User;
import its.user.exception.ServiceException;
import its.user.service.ReplyService;
import its.user.tools.ItsConstants;

@Service
public class ReplyServiceImpl implements ReplyService {
	@Resource
	ResourceDao resourceDao;
	@Resource
	MessageDao messageDao;
	@Resource
	private UserDao userDao;
	@Resource 
	private ReplyDao replyDao;
	@Resource
	private DownloadDao downloadDao;
	@Override
	public void saveReply(User user, Reply reply) throws ServiceException {
		if(reply.getContent().length()<5 || reply.getContent().length()>200)
			throw new ServiceException("评论字数限制为5-200个，请检查后重试！");
		its.user.entity.Resource rs=resourceDao.findById(reply.getResourceId());
		if(rs.getCreatedUser().equals(user.getUsername()))
			throw new ServiceException("您不能评论打分自己的资源！");
		if(downloadDao.findByResourceIdAndUser(reply.getResourceId(), user.getUsername()).size()==0)
			throw new ServiceException("您还没有下载过该资源，请先下载！");
		if(replyDao.findByResourceIdAndUser(reply.getResourceId(), reply.getCreatedUser())!=0)
			throw new ServiceException("您已对该资源评论打分，切勿重复操作！");
		//1.保存评论
		replyDao.save(reply);
		//2.增加积分2
		userDao.updateIntegral(user.getUsername(), 2);
		//3.发送消息给资源拥有者
		Message msg=new Message();
		msg.setResourceId(reply.getResourceId());
		msg.setCreatedUser(reply.getCreatedUser());
		msg.setTitle(ItsConstants.MSG_T_RESOURCE_REPLY);
		msg.setContent(ItsConstants.MSG_C_RESOURCE_REPLY+reply.getContent()
						+"&nbsp;&nbsp;&nbsp;用户评分："+reply.getScore()+"&nbsp;&nbsp;&nbsp;查看资源："
						+"<a href='resDetail"+rs.getType()+".do?id="+rs.getId()+"'>"+rs.getTitle()+"</a>");
		msg.setType(0);
		msg.setUser(rs.getCreatedUser());
		messageDao.insertMsg(msg);
		//4.更新资源评分
		resourceDao.updateScore(reply.getResourceId());		
	}
	@Override
	public List<Reply> getReplyObjet(int resourceId) {
		return replyDao.findByResourceId(resourceId);
	}
}

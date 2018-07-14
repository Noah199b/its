package its.user.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import its.user.dao.ArticleDao;
import its.user.dao.CommentDao;
import its.user.dao.MessageDao;
import its.user.dao.UserDao;
import its.user.entity.Article;
import its.user.entity.Comment;
import its.user.entity.Message;
import its.user.entity.User;
import its.user.exception.ServiceException;
import its.user.service.CommentService;
import its.user.tools.BBSCheckUtil;
import its.user.tools.ItsConstants;
@Service
public class CommentServiceImpl implements CommentService {
	@Resource
	CommentDao commentDao;
	@Resource
	ArticleDao articleDao;
	@Resource
	private MessageDao messageDao;
	@Resource
	private UserDao userDao;
	@Override
	public void saveReply(Comment comment,User user) {		
		byte[] bytes=comment.getContent().getBytes();
		if(bytes.length<10 || bytes.length>255)
			throw new ServiceException("回复内容应大于10字节小于255字节，当前输入["+bytes.length+"]字节！");
		//恶意发帖，扣除积分，消息通知。
		Comment c=commentDao.findNewByUserId(user.getId());
		if(c != null) {
			if(BBSCheckUtil.checkReplyInterval(c.getCreatedTime())) {		
				Message message=new Message();
				message.setCreatedUser("admin");
				message.setUser(user.getUsername());
				message.setType(0);
				message.setTitle(user.getUsername()+ItsConstants.MSG_T_CHECKREPLY);
				message.setContent(user.getUsername()+ItsConstants.MSG_C_CHECKREPLY);
				if(user.getIntegral()!=0) {
					if(user.getIntegral()<5) {
						userDao.updateIntegral(user.getUsername(), -user.getIntegral());
					}else{
						userDao.updateIntegral(user.getUsername(), -5);
					}	
					messageDao.insertMsg(message);
					throw new ServiceException("警告：1分钟内重复发帖，被视为恶意灌水！积分-5");
				}			
			}		
		}
		commentDao.save(comment);
		//发送消息到用户
		Article article=articleDao.findById(comment.getArticleId());
		Message message =new Message();
		if(comment.getParentId()==0) {
			message.setUser(article.getCreatedUser());
			message.setTitle(article.getCreatedUser()+ItsConstants.MSG_T_REPLY);
			message.setContent(article.getCreatedUser()+ItsConstants.MSG_C_REPLY+comment.getContent());
			userDao.updateIntegral(article.getCreatedUser(), 1);//被评论用户+1分
			userDao.updateIntegral(comment.getCreatedUser(), 2);//当前用户+2分
		}else {
			String u=commentDao.findById(comment.getParentId()).getCreatedUser();//被回复用户
			message.setUser(u);
			message.setTitle(article.getCreatedUser()+ItsConstants.MSG_T_SUBREPLY);
			message.setContent(article.getCreatedUser()+ItsConstants.MSG_C_SUBREPLY+comment.getContent());
			userDao.updateIntegral(u, 1);//被评论用户+1分
			userDao.updateIntegral(comment.getCreatedUser(), 1);//当前用户+1分
		}		
		message.setType(1);//0-通知  1-消息
		message.setCreatedUser(comment.getCreatedUser());
		message.setArticleId(article.getId());
		messageDao.insertMsg(message);	
	}
	@Override
	public Map<String, Object> getActiveUser() {
		List<Map<String,String>> list=commentDao.findActiveUser();
		Map <String, Object> map=new HashMap<String, Object>();
		map.put("active", list);
		return map;
	}
	
}

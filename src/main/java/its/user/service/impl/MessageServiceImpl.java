package its.user.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import its.user.dao.MessageDao;
import its.user.dao.UserDao;
import its.user.entity.Message;
import its.user.entity.User;
import its.user.exception.ServiceException;
import its.user.service.MessageService;
import its.user.web.PageObject;
@Service
public class MessageServiceImpl implements MessageService {
	@Resource
	private UserDao userDao;
	@Resource
	private MessageDao messageDao;
	@Override
	public Map<String, Object> getMessageAndIntegral(User user) {
		Map<String, Object> map=new HashMap<String, Object>();		
		map.put("integral", userDao.findById(user.getId()).getIntegral());
		map.put("message", messageDao.getMsgByFlagCount(user.getUsername(), 0));
		return map;
	}
	@Override
	public Map<String, Object> getMessagePage(String username, int type,int pageNo) {
		Map<String, Object> map=new HashMap<String, Object>();
		PageObject page=new PageObject();
		page.setPageSize(6);//设置分页大小 默认-5
		page.setPageCurrent(pageNo);//设置当前页
		int count= type==2 ? messageDao.getMsgByUserCount(username) : messageDao.getMsgByFlagCount(username, type);
		page.setRowCount(count);
		//分页计算起始位置  页大小*（页码-1）+1
		page.setStartIndex(page.getPageSize()*(pageNo-1));
		map.put("pageCount", page.getPageCount());//总页数
		List<Message> message= type==2 ? messageDao.getMsgByUser(username, page.getStartIndex(), page.getPageSize())
				: messageDao.getMsgByFlag(username, type, page.getStartIndex(), page.getPageSize());
		map.put("message", message);//消息对象
		map.put("page", page);//页对象
		return map;
	}
	@Override
	public Message getMessageObject(int id){
		Message message=messageDao.getMsgById(id);
		if(message.getFlag()==0) {
			messageDao.updateFlag(id, 1);//更改状态1-已读
		}
		return message;
	}
}

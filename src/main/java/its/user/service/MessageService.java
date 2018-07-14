package its.user.service;

import java.util.Map;

import its.user.entity.Message;
import its.user.entity.User;

public interface MessageService {
	/**
	 * 获取积分和未读消息数
	 * @return
	 */
	public Map<String,Object> getMessageAndIntegral(User user);
	/**
	 * 获取消息页面信息
	 * @param username 用户名
	 * @param type 0-未读 1-已读  2-全部
	 * @return 
	 */
	public Map<String,Object> getMessagePage(String username,int type,int pageNo);
	/**
	 * 获取消息内容
	 * 若不为当前用户消息内容，提示消息地址非法
	 * @param id
	 * @param user
	 * @return
	 */
	public Message getMessageObject(int id);
}

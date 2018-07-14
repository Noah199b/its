package its.user.service;

import java.util.List;

import its.user.entity.Reply;
import its.user.entity.User;

public interface ReplyService {
	/**
	 * 保存资源评论
	 * @param user
	 * @param reply
	 * @throws Exception
	 */
	public void saveReply(User user,Reply reply)throws Exception;
	/**
	 * 获取当前资源的评论
	 * @param resourceId
	 * @return
	 */
	public List<Reply> getReplyObjet(int resourceId);
}

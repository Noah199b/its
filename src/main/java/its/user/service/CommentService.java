package its.user.service;

import java.util.Map;

import its.user.entity.Comment;
import its.user.entity.User;

public interface CommentService {
	/**
	 * 发表新回复
	 * @param comment
	 */
	public void saveReply(Comment comment,User user);
	/**
	 * 获取活跃用户信息
	 * 用户ID,用户名，头像，发帖总数，回复总数
	 * @return
	 */
	public Map<String,Object> getActiveUser();
}

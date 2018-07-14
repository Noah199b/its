package its.user.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import its.user.entity.Comment;

public interface CommentDao {
	
	/**
	 * 发表新回复
	 * @param comment
	 */
	public void save(Comment comment);
	/**
	 * 查询回复内容
	 * @param id
	 */
	public List<Comment> findMainById(@Param("articleId") int id);
	/**
	 * 查询文章回复总数
	 * @param id 文章ID
	 * @return
	 */
	public int findMainCount(@Param("articleId") int id);
	/**
	 * 查询所有子回复
	 * @param id
	 * @return
	 */
	public List<Comment> findSubById(@Param("parentId") int id);
	/**
	 * 查询子回复总数
	 */
	public int findSubCount(@Param("parentId") int id);
	/**
	 * 查询活跃用户5个
	 * id,username,avatar,valid,aTotal,cTotal
	 * @return
	 */
	public List<Map<String,String>> findActiveUser();
	/**
	 * 根据ID查询回复内容
	 * @param id
	 */
	public Comment findById(@Param("id") int id);
	/**
	 * 查询用户最新的回复
	 * @param userId
	 * @return
	 */
	public Comment findNewByUserId(@Param("userId")int userId);
}

package its.user.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import its.user.entity.Reply;

public interface ReplyDao {
	/**
	 * 创建新评论
	 * @param reply
	 */
	public void save(Reply reply);
	/**
	 * 根据资源查找评论
	 * @param resourceId 资源ID
	 * @return
	 */
	public List<Reply> findByResourceId(@Param("resourceId")int resourceId);
	/**
	 * 查询用户是否评论过
	 * @param resourceId
	 * @param user
	 * @return
	 */
	public int findByResourceIdAndUser(
			@Param("resourceId")int resourceId,
			@Param("user")String user
			);
}

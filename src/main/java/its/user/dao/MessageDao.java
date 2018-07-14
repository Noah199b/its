package its.user.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import its.user.entity.Message;

public interface MessageDao {
	/**
	 * 插入一条信息消息
	 * @param message
	 */
	public void insertMsg(Message message);
	/**
	 * 查询用户所有消息
	 * @param user
	 * @return
	 */
	public  List<Message> getMsgByUser(
			@Param("user")String user,
			@Param("start")int startIndex,
			@Param("size")int pageSize
			);
	/**
	 * 查询用户所有消息总数
	 * @param user
	 * @return
	 */
	public  int getMsgByUserCount(
			@Param("user")String user
			);
	/**
	 * 根据ID查询消息
	 * @param user
	 * @return
	 */
	public  Message getMsgById(@Param("id")int id);
	/**
	 * 根据是否已读查询消息
	 * 
	 * @param user
	 * @param flag 0-未读  1-已读
	 * @return
	 */
	public List<Message> getMsgByFlag(
			@Param("user")String user,
			@Param("flag")int flag,
			@Param("start")int startIndex,
			@Param("size")int pageSize
			);
	/**
	 * 根据是否已读查询消息总数
	 * @param user
	 * @param flag
	 * @return
	 */
	public int getMsgByFlagCount(@Param("user")String user,
			@Param("flag")int flag);
	
	/**
	 * 更新消息状态 0-未读  1-已读
	 */
	public void updateFlag(@Param("id")int id,
			@Param("flag")int flag);
}

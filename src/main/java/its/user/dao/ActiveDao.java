package its.user.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import its.user.entity.Active;

public interface ActiveDao {
	/**
	 * 查询活动总数
	 * @return
	 */
	public int  findAllCount();
	/**
	 * 分页查询活动
	 * @param startIndex
	 * @param pageSize
	 * @return
	 */
	public List<Active> findAll(
			@Param("valid")Integer valid,
			@Param("start")int startIndex,
			@Param("size")int pageSize);
	/**
	 * 根据ID查询活动
	 * @param id
	 * @return
	 */
	public Active findById(@Param("id")int id);
	
}

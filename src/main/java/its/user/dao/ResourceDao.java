package its.user.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import its.user.entity.Resource;

public interface ResourceDao {
	/**
	 * 保存资源
	 * @return
	 */
	public int save(Resource resource);
	/**
	 * 查询所有资源总数
	 * @return
	 */
	public int findAllCount();
	/**
	 * 查询每一页的数据 默认最新在前
	 * @param startIndex 起始位置
	 * @param pageSize 页大小
	 * @return
	 */
	public List<Resource> findAll(
			@Param("start")int startIndex,
			@Param("size")int pageSize);
	/**
	 * 查询每一种类型的总数
	 * @param type 资源类型
	 * 0-资料 1-文献 2-视频
	 * @return
	 */
	public int findByTypeCount(@Param("type")int type);
	/**
	 * 分页查询每一种类型的资源
	 * @param type 资源类型
	 * 0-资料 1-文献 2-视频
	 * @param startIndex 起始位置
	 * @param pageSize 页大小
	 * @return
	 */
	public List<Resource> findByType(
			@Param("type")int type,
			@Param("start")int startIndex,
			@Param("size")int pageSize);
	/**
	 * 根据Id查询资源
	 * @param id
	 * @return
	 */
	public Resource findById(@Param("id")int id);
	/**
	 * 更新文件下载次数
	 * @param id
	 */
	public void updateDownloadCount(@Param("id")int id);
	/**
	 * 模糊查询
	 * @param search 资源名称
	 * @return
	 */
	public  List<Resource> search(
			@Param("search")String search,
			@Param("start")int startIndex,
			@Param("size")int pageSize);
	/**
	 * 模糊查询总数
	 * @param search 资源名称
	 * @return
	 */
	public int searchCount(@Param("search")String search);
	/**
	 * 更新资源评分
	 * @param resourceId
	 */
	public void updateScore(@Param("resourceId")int resourceId);
	/**
	 * 用户名查询资源总数
	 * @param user
	 * @return
	 */
	public int findByUserCount(@Param("user")String user);
	/**
	 * 用户名分页查询
	 * @param user
	 * @param startIndex
	 * @param pageSize
	 * @return
	 */
	public List<Resource> findByUser(@Param("user")String user,
			@Param("start")int startIndex,
			@Param("size")int pageSize);
	/**
	 * 删除资源
	 * @param id
	 */
	public void delete(@Param("id")int id);
}

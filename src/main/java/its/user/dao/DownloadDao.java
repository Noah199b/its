package its.user.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import its.user.entity.Download;

public interface DownloadDao {
	/**
	 * 保存下载记录
	 * @param download
	 */
	public void save(Download download);
	/**
	 * 查询下载记录
	 * @param id
	 * @param user
	 * @return
	 */
	public List<Download> findByResourceIdAndUser(@Param("id")int id,@Param("user")String user);
}

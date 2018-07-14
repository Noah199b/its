package its.user.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import its.user.entity.Notice;

public interface NoticeDao {
	/**
	 * 查询公告
	 * @param size
	 * @return
	 */
	public List<Notice> findNotice(@Param("size")int size);
}

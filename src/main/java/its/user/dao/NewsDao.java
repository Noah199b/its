package its.user.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import its.user.entity.News;

public interface NewsDao {
	
	public List<News> findByNewsType(
			@Param("newsType")int newsType,
			@Param("start")int start,
			@Param("size")int size
			);
	public int findByNewsTypeCount(@Param("newsType")int newsType);
	
	public News findById(@Param("id")int id);
	
	public int updateTotalVisits(@Param("id")int id);
}

package its.user.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import its.user.entity.Article;

public interface ArticleDao {
	/**
	 * 发表新话题
	 * @param article
	 * @return
	 */
	public int save(Article article);
	
	/**
	 * 查询一周内热门总数
	 * @return
	 */
	public int findHotWeekCount();
	/**
	 * 分页查询热门
	 */
	public List<Article> findHotWeek(
			@Param("start")int startIndex,
			@Param("size")int pageSize);		
	/**
	 * 查询话题总数（按日期最新排序）
	 * @return
	 */
	public int findNewestCount();
	/**
	 * 分页查询所有（按日期最新排序）
	 * @return
	 */
	public List<Article> findNewest(
			@Param("start")int startIndex,
			@Param("size")int pageSize);
	/**
	 * 根据ID查询话题
	 * @param id
	 * @return
	 */
	public Article findById(@Param("id") int id);
	/**
	 * 根据ID使话题访问量增加1
	 */
	public void updateTotalVisits(@Param("id") int id);
	/**
	 * 按标题查询总数
	 * @param key
	 * @return
	 */
	public int findSearchCount(@Param("key")String key);
	/**
	 * 按标题分页查询话题内容
	 * @param startIndex
	 * @param pageSize
	 * @param key
	 * @return
	 */
	public List<Article> findSearch(
			@Param("start")int startIndex,
			@Param("size")int pageSize,
			@Param("key")String key);
	/**
	 * 根据用户ID查询话题
	 * @param startIndex
	 * @param pageSize
	 * @param userId
	 * @return
	 */
	public List<Article> findByUserId(
			@Param("start")int startIndex,
			@Param("size")int pageSize,
			@Param("userId")int userId);
	
	public int findByUserIdCount(@Param("userId")int userId);	
	/**
	 * 查询用户最新的发帖
	 * @param userId
	 * @return
	 */
	public Article findNewByUserId(@Param("userId")int userId);
	/**
	 * 删除话题
	 * @param id
	 */
	public void delete(@Param("id")int id);
	/**
	 * 修改话题
	 * @param article
	 */
	public void update(Article article);
}

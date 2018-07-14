package its.user.service;

import java.util.Map;

import its.user.entity.Article;
import its.user.entity.User;

public interface ArticleService {
	/**
	 * 发表新话题
	 * @throws Exception
	 */
	public void save(Article article,User user)throws Exception;
	/**
	 * 获取页面信息（话题信息）
	 * @return
	 * @throws Exception
	 */
	public Map<String,Object> doGetPage(int type,int num,String key)throws Exception;
	/**
	 * 根据id获取话题  并使其访问量增加1
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public Map<String,Object> doTDetail(int id)throws Exception;
	/**
	 * 根据id获取所有话题
	 * @param id
	 * @return
	 */
	public Map<String,Object> getOwnTopicPage(int id,int pageNo);
	/**
	 * 删除话题
	 * @param id
	 */
	public void delete(int id);
	/**
	 * 获取话题
	 * @param id
	 * @return
	 */
	public Article getEditPage(int id);
	/**
	 * 更新话题
	 * @param article
	 */
	public void update(Article article,User user)throws Exception;
}

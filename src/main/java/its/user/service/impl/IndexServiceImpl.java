package its.user.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import its.user.dao.ActiveDao;
import its.user.dao.ArticleDao;
import its.user.dao.NewsDao;
import its.user.dao.NoticeDao;
import its.user.dao.ResourceDao;
import its.user.dao.UserDao;
import its.user.entity.Active;
import its.user.entity.Article;
import its.user.entity.Notice;
import its.user.service.IndexService;
@Service
public class IndexServiceImpl implements IndexService {
	@Resource 
	NoticeDao noticeDao;
	@Resource 
	ActiveDao activeDao;
	@Resource
	ResourceDao resourceDao;
	@Resource
	ArticleDao articleDao;
	@Resource
	UserDao userDao;
	@Resource
	NewsDao newsDao;
	@Override
	public List<Notice> getNoticeObjects() {	
		return noticeDao.findNotice(5);
	}
	@Override
	public List<Active> getActiveObjects() {
		return activeDao.findAll(1, 0, 6);
	}
	@Override
	public Map<String, Object> getResourceObjects() {
		Map<String, Object> map=new HashMap<String, Object>();
		map.put("rar", resourceDao.findByType(0, 0, 5));
		map.put("pdf", resourceDao.findByType(1, 0, 5));
		map.put("video", resourceDao.findByType(2, 0, 4));
		return map;
	}
	@Override
	public Map<String, Object> getTopicObjects() {		
		List<Article> articles=articleDao.findHotWeek(0, 6);
		List<String> avatars=new ArrayList<String>();
		
		for(Article a: articles) {
			avatars.add(userDao.findByUsername(a.getCreatedUser()).get(0).getAvatar());
		}
		Map<String, Object> map=new HashMap<String, Object>();
		map.put("topic", articles);
		map.put("avatar", avatars);
		return map;
	}
	@Override
	public Map<String, Object> getIndexNewsObjects() {
		Map<String, Object> map=new HashMap<String, Object>();
		map.put("eduNews",newsDao.findByNewsType(1, 0, 4));
		map.put("timeNews",newsDao.findByNewsType(0, 0, 4));
		return map;
	}
}

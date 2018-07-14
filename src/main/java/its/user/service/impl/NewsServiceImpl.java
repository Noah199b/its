package its.user.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import its.user.dao.NewsDao;
import its.user.entity.News;
import its.user.service.NewsService;
import its.user.web.PageObject;
@Service
public class NewsServiceImpl implements NewsService {
	@Resource
	NewsDao newsDao;
	@Override
	public Map<String, Object> getNewsObjects(int newsType, int pageNo) {
		int count=newsDao.findByNewsTypeCount(newsType);
		PageObject page=new PageObject();
		page.setPageCurrent(pageNo);
		page.setPageSize(15);
		page.setRowCount(count);
		page.setStartIndex((pageNo-1)*page.getPageSize());
		List<News> list=newsDao.findByNewsType(newsType, page.getStartIndex(),page.getPageSize());
		Map<String, Object> map=new HashMap<String, Object>();
		map.put("page", page);
		map.put("pageCount", page.getPageCount());
		map.put("news", list);
		return map;
	}
	@Override
	public News getNewsById(int id) {
		newsDao.updateTotalVisits(id);//访问+1
		return newsDao.findById(id);
	}

}

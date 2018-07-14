package its.user.service;

import java.util.Map;

import its.user.entity.News;

public interface NewsService {
	
	public Map<String,Object> getNewsObjects(int newsType,int pageNo);
	
	public News getNewsById(int id);
}

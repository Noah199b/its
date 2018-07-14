package its.user.service;

import java.util.List;
import java.util.Map;

import its.user.entity.Active;
import its.user.entity.Notice;

public interface IndexService {
	
	public List<Notice> getNoticeObjects();
	
	public List<Active> getActiveObjects();

	public Map<String,Object> getResourceObjects();

	public Map<String,Object> getTopicObjects();

	public Map<String,Object> getIndexNewsObjects();
}

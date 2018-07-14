package its.user.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import its.user.dao.AuthDao;
import its.user.dao.UserDao;
import its.user.entity.Auth;
import its.user.entity.User;
import its.user.service.TeacherService;
import its.user.web.PageObject;
@Service
public class TeacherServiceImpl implements TeacherService {
	@Resource
	AuthDao authDao;
	@Resource
	UserDao userDao;
	@Override
	public Map<String, Object> getObjects(int pageNo, String search) {
		PageObject page=new PageObject();
		page.setPageCurrent(pageNo);
		page.setPageSize(6);
		int count=authDao.searchCount(search);
		page.setRowCount(count);
		page.setStartIndex((pageNo-1)*page.getPageSize());
		List<Auth> auth=authDao.search(search,page.getStartIndex(), page.getPageSize());
		List<User> user=new ArrayList<User>();
		for(Auth a:auth) {
			user.add(userDao.findByUsername(a.getUsername()).get(0));
		}	
		Map<String, Object> map=new HashMap<String, Object>();
		map.put("page", page);
		map.put("pageCount", page.getPageCount());
		map.put("auth", auth);
		map.put("user", user);		
		return map;
	}

}

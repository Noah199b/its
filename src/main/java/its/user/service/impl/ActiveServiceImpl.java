package its.user.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import its.user.dao.ActiveDao;
import its.user.entity.Active;
import its.user.service.ActiveService;
import its.user.web.PageObject;
@Service
public class ActiveServiceImpl implements ActiveService {
	@Resource
	ActiveDao activeDao;
	@Override
	public Map<String, Object> getActivePage(int pageNo) {
		PageObject page=new PageObject();
		page.setPageCurrent(pageNo);
		page.setPageSize(15);
		page.setRowCount(activeDao.findAllCount());
		page.setStartIndex(page.getPageSize()*(pageNo-1));
		List<Active> list=activeDao.findAll(null,page.getStartIndex(), page.getPageSize());
		Map<String, Object> map=new HashMap<String, Object>();
		map.put("page", page);
		map.put("pageCount", page.getPageCount());
		map.put("active", list);
		return map;
	}
	@Override
	public Active getActiveById(int id) {
		return activeDao.findById(id);
	}

}

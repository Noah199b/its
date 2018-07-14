package its.user.service;

import java.util.Map;

import its.user.entity.Active;

public interface ActiveService {
	/**
	 * 分页查询活动
	 * @param pageNo
	 * @return
	 */
	public Map<String,Object> getActivePage(int pageNo);
	/**
	 * 根据id查询活动
	 * @param id
	 * @return
	 */
	public Active getActiveById(int id);
}

package its.user.dao;

import its.user.entity.Report;

public interface ReportDao {
	/**
	 * 举报
	 * @param report
	 */
	public void save(Report report);
}

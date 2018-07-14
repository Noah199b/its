package its.user.service.impl;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import its.user.dao.ReportDao;
import its.user.dao.UserDao;
import its.user.entity.Report;
import its.user.exception.ServiceException;
import its.user.service.ReportService;
@Service
public class ReportServiceImpl implements ReportService {
	@Resource
	ReportDao reportDao;
	@Resource
	UserDao userDao;
	@Override
	public void doReport(String user,String link,String reason) throws Exception {
		if("".equals(user) && "".equals(link))
			throw new ServiceException("昵称尼玛不能同时为空！");
		if("".equals(reason))throw new ServiceException("举报原因不能为空！");
		if(user.getBytes().length>20)throw new ServiceException("昵称长度不能超过20字符！");
		if(reason.getBytes().length>255)throw new ServiceException("昵称长度不能超过255字符！");
		Report report=new Report();
		report.setReason(reason);
		if(!"".equals(user)) {
			if(userDao.findByUsername(user).size()==0)
				throw new ServiceException("举报用户不存在！");
			report.setReportId(userDao.findByUsername(user).get(0).getId());
			report.setUsername(user);
			report.setType(0);
		}else {
			Map<String,Integer> map=analysisLink(link);
			report.setType(map.get("type"));
			report.setReportId(map.get("reportId"));
		}
		report.setLink(link);
		reportDao.save(report);
	}
	/**
	 * 解析链接
	 * @param link
	 * @return type 举报类型，reportId 举报ID
	 */
	public Map<String,Integer> analysisLink(String link) {
		Map<String,Integer> map=new HashMap<String,Integer>();
		if(link.contains("tDetail")) {//话题
			map.put("type", 1);
		}else if(link.contains("resDetail")) {//资源
			map.put("type", 2);
		}else {//其它
			map.put("type", 3);
		}
		if(link.contains("?id=")) {
			int start=link.indexOf("?id=")+4;
			String reportId=link.substring(start);
			map.put("reportId","".equals(reportId)? 0 : Integer.valueOf(reportId));
		}else {
			map.put("reportId", 0);
		}
		return map;
	}
}

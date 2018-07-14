package its.user.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import its.user.service.ReportService;
import its.user.web.JsonResult;

@Controller
public class ReportController {
	@Resource
	ReportService reportService;
	@RequestMapping("doReport")
	@ResponseBody
	public JsonResult doReport(String user,String link,String reason) throws Exception {
		reportService.doReport(user, link, reason);
		return new JsonResult();
	}
	
}

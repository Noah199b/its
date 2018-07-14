package its.user.controller;


import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import its.user.service.ActiveService;
import its.user.web.JsonResult;

@Controller
public class ActiveController {	
	
	@Resource
	ActiveService activeService;
	@RequestMapping("/activeUI.do")
	public String activeUI() {
		return "active";
	}	
	//activeDetail
	@RequestMapping("/activeDetail.do")
	public String activeDetail(int id,HttpServletRequest request) {
		request.getSession().setAttribute("active", activeService.getActiveById(id));
		return "activeDetail";
	}	
	/**
	 * 获取所有活动
	 * @param pageNo
	 * @return
	 */
	@RequestMapping("getActivePage")
	@ResponseBody
	public JsonResult getActivePage(int pageNo) {
		return new JsonResult(activeService.getActivePage(pageNo));
	}
	
	
}

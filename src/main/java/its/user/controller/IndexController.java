package its.user.controller;


import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


import its.user.service.IndexService;
import its.user.web.JsonResult;

@Controller
public class IndexController {
	@Resource
	IndexService indexService;
	@RequestMapping("/indexUI.do")
	public String indexUI(HttpServletRequest rq){
		rq.getSession().setAttribute("notice", indexService.getNoticeObjects());
		return "index";
	}
	@RequestMapping("/aboutUI.do")
	public String loginUI() {
		return "about";
	}	
	@ResponseBody
	@RequestMapping("getActiveObjects")
	public JsonResult getActiveObjects() throws Exception{		
		return new JsonResult(indexService.getActiveObjects());
	}
	@ResponseBody
	@RequestMapping("getResourceObjects")
	public JsonResult getResourceObjects() throws Exception{		
		return new JsonResult(indexService.getResourceObjects());
	}
	@ResponseBody
	@RequestMapping("getTopicObjects")
	public JsonResult getTopicObjects() throws Exception{		
		return new JsonResult(indexService.getTopicObjects());
	}
	@ResponseBody
	@RequestMapping("getIndexNewsObjects")
	public JsonResult getIndexNewsObjects() throws Exception{		
		return new JsonResult(indexService.getIndexNewsObjects());
	}
}

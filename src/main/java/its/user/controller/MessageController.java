package its.user.controller;

import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import its.user.entity.User;
import its.user.service.MessageService;
import its.user.web.JsonResult;

@Controller
public class MessageController {
	@Resource
	MessageService messageService;
	@RequestMapping("/messageUI.do")
	public String messageUI() {
		return "message";
	}
	/**
	 * 消息内容查看
	 */
	@RequestMapping("/message1UI.do")
	public String message1UI(int id,HttpServletRequest request){
		request.getSession().setAttribute("messageObject", messageService.getMessageObject(id));
		return "message1";
	}
	@RequestMapping("getMessageAndIntegral.do")
	@ResponseBody
	public JsonResult getMessageAndIntegral(HttpServletRequest request) {
		User user=(User)request.getSession().getAttribute("its_user");
		Map<String,Object> map=messageService.getMessageAndIntegral(user);
		user.setIntegral((int)map.get("integral"));
		request.getSession().setAttribute("its_user", user);
		request.getSession().setAttribute("its_message", map.get("message"));
		return new JsonResult(map);
	}
	/**
	 * 获取消息页面
	 * @param type
	 * @param request
	 * @return
	 */
	@RequestMapping("getMessagePage.do")
	@ResponseBody
	public JsonResult getMessagePage(int type,int pageNo,HttpServletRequest request) {
		User user=(User)request.getSession().getAttribute("its_user");
		return new JsonResult(messageService.getMessagePage(user.getUsername(), type, pageNo));
	}
	
}

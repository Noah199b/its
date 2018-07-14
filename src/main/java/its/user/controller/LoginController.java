package its.user.controller;


import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import its.user.entity.User;
import its.user.service.UserService;
import its.user.web.JsonResult;

@Controller
public class LoginController {
	@Resource
	private UserService UserService;
	@RequestMapping("doLogin")
    @ResponseBody
    public JsonResult doLogin(String username,String password,
    		HttpServletRequest request) throws Exception{
    	User user=UserService.login(username, password);
    	HttpSession session=request.getSession();
    	session.setAttribute("its_user", user);
    	return new JsonResult();	
    }
	
	/*
	@RequestMapping("doCheckSession")
    @ResponseBody
    public JsonResult doCheckSession(
    		HttpServletRequest request) throws Exception{
		User user=(User)request.getSession().getAttribute("its_user");
		if(null==user)
			throw new ServiceException("未检测到session对象！");
		Map<String,Object> map =new HashMap<String,Object>();
		map.put("username", user.getUsername());
		map.put("userid", user.getId()+"");
    	return new JsonResult(map);	
    }	*/
	
	@RequestMapping("/doExit.do")
    public void doExit(HttpServletRequest request,HttpServletResponse response) throws Exception{	
		request.getSession().setAttribute("its_user", null);
		request.getSession().setAttribute("its_message", null);
		response.sendRedirect("indexUI.do");	
    }
}

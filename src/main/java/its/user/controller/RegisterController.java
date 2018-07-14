package its.user.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import its.user.entity.User;
import its.user.exception.ServiceException;
import its.user.service.UserService;
import its.user.web.JsonResult;

@Controller
public class RegisterController {
	@Resource
	private UserService UserService;
	/** 注册页面 */
	@RequestMapping("registerUI")
	public String RegisterUI() {	
		return "register";
	}
	/** 密码重置 */
	@RequestMapping("passwordUI")
	public String passwordUI() {	
		return "password";
	}
	/**
	 * 检查用户名是否可用
	 * @param username
	 * @return
	 * @throws Exception
	 */
    @RequestMapping("doCheckUsername")
    @ResponseBody
    public JsonResult doCheckUsername(String username) throws Exception{  
//    	System.out.println(username);
    	List<User> users=UserService.findByUsername(username);
    	if(!users.isEmpty()) {
    		throw new ServiceException("用户名已被注册！");
    	}
    	return new JsonResult();	
    }
	/**
	 * 用户注册
	 * @param entity
	 * @return
	 * @throws Exception
	 */
    @RequestMapping("doRegister")
    @ResponseBody
    public JsonResult doRegister(User entity) throws Exception{
    	System.out.println(entity.toString());
    	UserService.save(entity);
    	return new JsonResult();	
    }
    /**
     * 检查两次输入的密码是否一致
     * @param pwd1
     * @param pwd2
     * @return
     * @throws Exception
     */
    @RequestMapping("doCheckPassword")
    @ResponseBody
    public JsonResult doCheckPassword(String pwd1,String pwd2) throws Exception{
    	System.out.println(pwd1+"   "+pwd2);
    	if(!UserService.checkPassword(pwd1, pwd2)){
    		throw new ServiceException("提示：两次输入的密码不一致，请重新输入！");
    	}    	
    	return new JsonResult();	
    }
    /**
     * 发送验证码
     * @param rq
     * @return
     * @throws Exception
     */
    @RequestMapping("doSendCode")
    @ResponseBody
    public JsonResult doSendCode(String user,String mail,HttpServletRequest rq) throws Exception{
    	UserService.sendCode(user, mail, rq);
    	return new JsonResult();
    }
    /**
     * 发送验证码
     * @param rq
     * @return
     * @throws Exception
     */
    @RequestMapping("doRePassword")
    @ResponseBody
    public JsonResult doRePassword(String user,String mail,String code,String pwd,HttpServletRequest rq) throws Exception{
    	UserService.rePassword(user, mail, code,pwd, rq);
    	User u=(User)rq.getSession().getAttribute("its_user");
    	if(null!=u) {
    		rq.getSession().setAttribute("its_user", null);
    	}
    	return new JsonResult();
    }
}

package its.user.controller;

import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import its.user.entity.Auth;
import its.user.entity.User;
import its.user.exception.ServiceException;
import its.user.service.AuthService;
import its.user.tools.ItsConstants;
import its.user.web.JsonResult;

@Controller
public class AuthenticateController {
	@Resource
	AuthService authService;
	@RequestMapping("authenticateUI.do")
	public String authenticateUI(HttpServletRequest request) {
		User user=(User)request.getSession().getAttribute("its_user");
		Auth auth=authService.findByUsername(user.getUsername());
		if(auth==null) {
			return "authentication";
		}
		if(auth.getState()!=0) {
			return "message";
		}else {
			return "authentication";
		}
	}
	@RequestMapping("checkPart1")
	@ResponseBody
	public JsonResult checkPatr1(Auth auth,HttpServletRequest request) throws Exception {
		System.err.println(auth);
		authService.checkPart1(auth);
		request.getSession().setAttribute("teacher_auth", auth);
		return new JsonResult();
	}
	@RequestMapping("checkPart2")
	@ResponseBody
	public JsonResult checkPatr2(String code,String mail,HttpServletRequest request) throws Exception {
		@SuppressWarnings("unchecked")
		Map<String,String> map=(Map<String,String>)request.getSession().getAttribute("its_code");	
		if(null==map)throw new ServiceException("您还没有发送验证码，请发送后重试！");
		String c=map.get(mail);
		System.out.println(code+","+c);
		if(!c.equals(code))throw new ServiceException("验证码错误，请重试！");
		return new JsonResult();
	}
	@RequestMapping("uploadOthers")
	@ResponseBody
	public JsonResult uploadOthers(MultipartFile mFile1,MultipartFile mFile2,MultipartFile mFile3,
			MultipartFile mFile4,MultipartFile mFile5,HttpServletRequest request) throws Exception {
//		System.out.println(mFile1.getOriginalFilename());	
		authService.uploadOthers(mFile1,mFile2,mFile3,mFile4,mFile5,request);
		return new JsonResult();
	}
	
}

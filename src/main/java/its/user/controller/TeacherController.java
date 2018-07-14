package its.user.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import its.user.service.TeacherService;
import its.user.web.JsonResult;

@Controller
public class TeacherController {
	@Resource
	TeacherService teacherService;
	@RequestMapping("teacherUI")
	public String teacherUI() {
		return "teacher";
	}
	@RequestMapping("getTeacherObjects")
	@ResponseBody
	public JsonResult getObjects(int pageNo,String search) {
		System.out.println(search);
		return new JsonResult(teacherService.getObjects(pageNo, search));
	}
}

package its.user.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import its.user.entity.Article;
import its.user.entity.User;
import its.user.exception.ServiceException;
import its.user.service.ArticleService;
import its.user.service.ResourceService;
import its.user.service.UserService;
import its.user.tools.ItsConstants;
import its.user.web.JsonResult;

@Controller
public class PersonalController {
	
	@Resource
	UserService userService;
	@Resource
	ArticleService articleService;
	@Resource
	ResourceService resourceService;
	@RequestMapping("/personalUI.do")
	public String doPersonal() {
		return "personal";
	}
	@RequestMapping("/ownTopicUI.do")
	public String doOwnTopic() {
		return "ownTopic";
	}
	@RequestMapping("/ownTopic1UI.do")
	public String doOwnTopic1() {
		return "ownTopic1";
	}
	@RequestMapping("/ownResourceUI.do")
	public String doOwnResource() {
		return "ownResource";
	}	
	@RequestMapping("updateUserInfo.do")
	@ResponseBody
	public JsonResult updateUserInfo(User user,HttpServletRequest request) throws Exception {
		System.out.println(user);
		userService.updateUser(user);
		User u=(User)request.getSession().getAttribute("its_user");
		u.setAutograph(user.getAutograph());
		u.setName(user.getName());
		request.getSession().setAttribute("its_user",u);
		return new JsonResult();
	}
	
	@RequestMapping("updateAvatar.do")
	@ResponseBody
	public JsonResult updateAvatar(int id,String username,String  avatar,
			HttpServletRequest request) throws Exception {
//		System.out.println(avatar);
//		System.out.println(PubUtil.getBase64ImageData(avatar));
//		String serverPath=request.getSession().getServletContext().getRealPath("/");
//		System.out.println(serverPath);
		userService.updateAvatar(id,username, avatar,ItsConstants.UPLOADS_DOCBASE);
		User u=(User)request.getSession().getAttribute("its_user");
		u.setAvatar(ItsConstants.UPLOADS_PATH+ItsConstants.AVATAR_PATH+username+".png");
		request.getSession().setAttribute("its_user",u);
		return new JsonResult();
	}
	
	@RequestMapping("getOwnTopicPage.do")
	@ResponseBody
	public JsonResult getOwnTopicPage(int pageNo,HttpServletRequest request) {
		User user=(User)request.getSession().getAttribute("its_user");
		return new JsonResult(articleService.getOwnTopicPage(user.getId(), pageNo));
	}
	
	@RequestMapping("getOwnTopic1Page.do")
	@ResponseBody
	public JsonResult getOwnTopic1Page(int id,int pageNo) {
		return new JsonResult(articleService.getOwnTopicPage(id, pageNo));
	}
	/**加载编辑页面*/
	@RequestMapping("toEdit.do")
	public String toEditPage() {
		return "edit";
	}
	/**删除话题*/
	@RequestMapping("doDelete.do")
	@ResponseBody
	public JsonResult doDelete(int id) {
		articleService.delete(id);
		return new JsonResult();
	}
	/**获取编辑页面*/
	@RequestMapping("getEditPage.do")
	@ResponseBody
	public JsonResult getEditPage(int id,HttpServletRequest request)throws Exception {
		Article article =articleService.getEditPage(id);
		User user=(User)request.getSession().getAttribute("its_user");
		if(user.getId()!=article.getUserId()){
			throw new ServiceException("话题地址非法，将跳转到个人话题中心！");
		}
		return new JsonResult(article);
	}
	
	/**编辑话题*/
	@RequestMapping("doEdit.do")
	@ResponseBody
	public JsonResult doEdit(Article article,HttpServletRequest request)throws Exception {
		articleService.update(article,(User)request.getSession().getAttribute("its_user"));
		return new JsonResult();
	}
	/**
	 * 获取我的资源
	 * @param pageNo
	 * @param request
	 * @return
	 */
	@RequestMapping("getOwnResourcePage")
	@ResponseBody
	public JsonResult getOwnResourcePage(int pageNo,HttpServletRequest request) {
		User user=(User)request.getSession().getAttribute("its_user");
		return new JsonResult(resourceService.getOwnResourcePage(pageNo, user));
	}
	/**删除资源*/
	@RequestMapping("deleteResource")
	@ResponseBody
	public JsonResult deleteResource(int id) {
		resourceService.delete(id);
		return new JsonResult();
	}
}

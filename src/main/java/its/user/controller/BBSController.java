package its.user.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import its.user.entity.Article;
import its.user.entity.Comment;
import its.user.entity.User;
import its.user.service.ArticleService;
import its.user.service.CommentService;
import its.user.web.JsonResult;

@Controller
public class BBSController {
	@Resource
	ArticleService articleService;	
	@Resource
	CommentService commentService;	
	/**进入论坛*/
	@RequestMapping("/bbs.do")
	public String BBS() {
		return "topic";
	}
	/**发布话题界面*/
	@RequestMapping("/publicUI.do")
	public String publicUI() {
//		System.out.println(id);
		return "public";
	}
	/**话题页面*/
	@RequestMapping("/tDetail.do")
	public String tDetail() {
//		System.out.println(id);
		return "bbsDetail";
	}
	/**话题发表*/
	@ResponseBody
	@RequestMapping("doPublish.do")
	public JsonResult doPublish(Article article,HttpServletRequest request) throws Exception{
		articleService.save(article,(User)request.getSession().getAttribute("its_user"));
		System.out.println(article.getId());
		Map<String,Object> data=new HashMap<String,Object>();
		data.put("id", article.getId());
		return new JsonResult(data);
	}
	/**加载论坛首页*/
	@ResponseBody
	@RequestMapping("doGetPage.do")
	public JsonResult doGetPage(int type,int pageNo,String key) throws Exception {	
//		System.out.println(type+","+pageNo);
//		System.out.println(key);
		return new JsonResult(articleService.doGetPage(type, pageNo,key));
	}
	/**加载话题内容*/
	@ResponseBody
	@RequestMapping("getTDetail.do")
	public JsonResult getTDetail(int id) throws Exception{		
//		System.out.println("加载文章ID="+id);
		return new JsonResult(articleService.doTDetail(id));
	}
	/**发表新回复*/
	@ResponseBody
	@RequestMapping("pubParentReply.do")
	public JsonResult pubParentReply(Comment comment,HttpServletRequest request)throws Exception{
//		System.out.println(comment);
		User user=(User)request.getSession().getAttribute("its_user");
		comment.setArticleId(comment.getId());
		comment.setUserId(user.getId());
		comment.setCreatedUser(user.getUsername());
//		System.out.println(comment);
		commentService.saveReply(comment,user);
		return new JsonResult();
	}
	/**发表子回复*/
	@ResponseBody
	@RequestMapping("pubSubReply.do")
	public JsonResult pubSubReply(Comment comment,HttpServletRequest request)throws Exception{
//		System.out.println(comment);
		User user=(User)request.getSession().getAttribute("its_user");
		comment.setArticleId(comment.getId());
		comment.setUserId(user.getId());
		comment.setCreatedUser(user.getUsername());
//		System.out.println(comment);
		commentService.saveReply(comment,user);		
		return new JsonResult();
	}
	
	@ResponseBody
	@RequestMapping("getActiveUser.do")
	public JsonResult getActiveUser() {		
		return new JsonResult(commentService.getActiveUser());
	}
	
}

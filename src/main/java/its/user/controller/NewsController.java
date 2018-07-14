package its.user.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import its.user.entity.News;
import its.user.service.NewsService;
import its.user.web.JsonResult;

@Controller
public class NewsController {
	@Resource
	NewsService newsService;
	@RequestMapping("newsUI")
	public String newsUI() {
		return "news";
	}
	//newsDetail
	@RequestMapping("newsDetail")
	public String newsDetail(int id,HttpServletRequest request) {
		News news=newsService.getNewsById(id);
		if(news!=null) {
			request.getSession().setAttribute("its_news",news);
			request.getSession().setAttribute("news_content",new String(news.getContent()));
		}		
		return "newsDetail";
	}
	@RequestMapping("getNewsObjects")
	@ResponseBody
	public JsonResult getNewsObjects(int newsType,int pageNo) {
		return new JsonResult(newsService.getNewsObjects(newsType, pageNo));
	}
}

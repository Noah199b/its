package its.user.controller;

import java.net.URLEncoder;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import its.user.entity.Reply;
import its.user.entity.User;
import its.user.service.ReplyService;
import its.user.service.ResourceService;
import its.user.web.JsonResult;

@Controller
public class ResourceController {
	@Resource
	ResourceService resourceService;
	@Resource
	ReplyService replyService;	
	@RequestMapping("uploadUI.do")
	public String uploadUI(){
		return "upload";
	}
	@RequestMapping("resourceUI.do")
	public String resourceUI(){
		return "resource";
	}
	@RequestMapping("resDetail0.do")
	public String resDetail0(){
		return "resource0";
	}	
	@RequestMapping("resDetail1.do")
	public String resDetail1(){
		return "resource1";
	}
	@RequestMapping("resDetail2.do")
	public String resDetail2(int id,HttpServletRequest request){
		User user=(User)request.getSession().getAttribute("its_user");
		its.user.entity.Resource rs=(its.user.entity.Resource)resourceService.getResourceObject(id, user).get("resource");
		request.getSession().setAttribute("video_resource", rs);
		return "resource2";
	}
	/**
	 * 上传资源
	 * @param title 资源标题
	 * @param desc 资源描述
	 * @param downloadIntegral 下载所需积分
	 * @param mFile 资源文件
	 * @return
	 */
	@RequestMapping("doUpload")
    @ResponseBody
    public JsonResult doUpload(
    		String title,
    		String desc,
    		int downloadIntegral,
    		MultipartFile mFile,
    		HttpServletRequest request)throws Exception{
		User u=(User)request.getSession().getAttribute("its_user");
		its.user.entity.Resource r=
				resourceService.save(title, desc, downloadIntegral, mFile, u);
    	return new JsonResult(r);
    }
	/**获取上传进度*/
	@RequestMapping("getProccess")
    @ResponseBody
    public JsonResult getProccess(HttpServletRequest request){
    	return new JsonResult(request.getSession().getAttribute("rate"));
    }
	/**
	 * 获取资源页面
	 * @param type 类型 
	 * @param pageNo 页号
	 * @return
	 */
	@RequestMapping("getResourcePage")
    @ResponseBody
    public JsonResult getResourcePage(int type,int pageNo,String search){
    	return new JsonResult(resourceService.getResourcePage(type, pageNo,search));
    }	
	/**
	 * 获取学习资源详细页面  0
	 * @return
	 */
	@RequestMapping("getResourceObject")
    @ResponseBody
    public JsonResult getResourceObject(int id,HttpServletRequest request){		
    	return new JsonResult(resourceService.getResourceObject(id, (User)request.getSession().getAttribute("its_user")));
    }
	/**
	 * 下载前检查
	 * @param id
	 * @param request
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping("checkDownload")
    @ResponseBody
    public JsonResult checkDownload(int id,HttpServletRequest request) throws Exception{	
		User u=(User)request.getSession().getAttribute("its_user");
		its.user.entity.Resource r=resourceService.findResourceById(id);		
    	return new JsonResult(resourceService.downloadBefore(u, r));
    }		
	/**
	 * 根据ID下载资源
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping("download")
    @ResponseBody
    public byte[] download(int id,HttpServletResponse response,HttpServletRequest request) throws Exception{		
		User u=(User)request.getSession().getAttribute("its_user");
		//1.根据id执行查找操作
		its.user.entity.Resource r=resourceService.findResourceById(id);
    	//2.设置下载内容类型以及响应头(固定格式)
    	response.setContentType("appliction/octet-stream");
    	//File fileName=new String(fileName.getBytes("iso-8859-1"),"utf-8");
    	String fileName=URLEncoder.encode(
    			r.getPath().substring(r.getPath().lastIndexOf("\\")),"utf-8");
		response.setHeader("Content-disposition",
				"resource;filename="+fileName);
		//3.获得指定文件的路径对象(java.nio.Path)
        Path path=Paths.get(r.getPath());
        //4.下载扣除相应的用户积分及发送消息
        resourceService.downloadAfter(u, r);
        //5.读取path路径对应的文件,并返回字节数组       
    	return Files.readAllBytes(path);
    }
	/**
	 * 资源评分评论
	 * @param id
	 * @param content
	 * @param score
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("doResourceReply")
    @ResponseBody
    public JsonResult doResourceReply(int id,String content,int score,HttpServletRequest request) throws Exception{	
		User user=(User)request.getSession().getAttribute("its_user");
		Reply reply=new Reply();
		reply.setContent(content);
		reply.setResourceId(id);
		reply.setCreatedUser(user.getUsername());
		reply.setScore(score);
		replyService.saveReply(user, reply);
    	return new JsonResult();
    }
	/**
	 * 获取资源评论
	 * @param id 资源ID
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("getReplyObject")
    @ResponseBody
    public JsonResult getReplyObject(int id) throws Exception{			
		return new JsonResult(replyService.getReplyObjet(id));
	}
}

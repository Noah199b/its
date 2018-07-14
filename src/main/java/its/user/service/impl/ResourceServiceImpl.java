package its.user.service.impl;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;

import org.apache.commons.io.FilenameUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import its.user.dao.DownloadDao;
import its.user.dao.MessageDao;
import its.user.dao.ResourceDao;
import its.user.dao.UserDao;
import its.user.entity.Download;
import its.user.entity.Message;
import its.user.entity.User;
import its.user.exception.ServiceException;
import its.user.service.ResourceService;
import its.user.tools.ItsConstants;
import its.user.tools.PubUtil;
import its.user.web.PageObject;
@Service
public class ResourceServiceImpl implements ResourceService {
	@Resource
	ResourceDao resourceDao;
	@Resource
	MessageDao messageDao;
	@Resource
	private UserDao userDao;
	@Resource
	private DownloadDao downloadDao;
	@Override
	public its.user.entity.Resource save(String title, String desc, int downloadIntegral, MultipartFile mFile, User user)throws ServiceException{
		
		String fileTypePath=PubUtil.checkFileType(mFile)==0 ? ItsConstants.RAR_PATH
				: PubUtil.checkFileType(mFile)==1 ? ItsConstants.PDF_PATH
						: ItsConstants.VIDEO_PATH;
		//1.3实现文件上传
		//1.3.1 构建文件上传路径(d:/uploads/2017/08/15/xxxxx.png)
		SimpleDateFormat sdf=
		new SimpleDateFormat("yyyy/MM/dd");
		String dateDir=sdf.format(new Date());
		//文件分类上传
		String baseDir=ItsConstants.UPLOADS_DOCBASE+fileTypePath;
		
		File uploadDir=new File(baseDir+dateDir);
		if(!uploadDir.exists()){
			uploadDir.mkdirs();
		}
		//1.3.2 构建新的文件名(相同目录下不允许出现重复的名字)
		String srcFileName=
		mFile.getOriginalFilename();
		String destfileName=
		UUID.randomUUID().toString()+"."
		+FilenameUtils.getExtension(srcFileName);
		//1.3.3创建目标文件对象
		File dest=new File(uploadDir,
				destfileName);
		//1.3.4 实现文件上传
	    try{
	    	//实现文件上传(本质上就是文件的复制)
	    	mFile.transferTo(dest);
	    }catch(IOException e){
	    	e.printStackTrace();
	    	throw new ServiceException("文件上传失败");
	    }
	    //2.将文件信息保存到数据库
	    //存放到数据库的路径
//	    String path=ItsConstants.UPLOADS_PATH+fileTypePath+dateDir+"/"+destfileName;
	    //创建资源对象
	    its.user.entity.Resource rs=new its.user.entity.Resource();
	    rs.setTitle(title);
	    rs.setDescription(desc);
	    rs.setType(PubUtil.checkFileType(mFile));
	    rs.setPath(dest.getAbsolutePath());
	    rs.setDownloadIntegral(downloadIntegral);
	    rs.setSize(mFile.getSize());
	    rs.setCreatedUser(user.getUsername());
	    resourceDao.save(rs);
//	    System.out.println(rs.toString());
	    //更新积分
		userDao.updateIntegral(user.getUsername(), 10);
		return rs;
	}
	@Override
	public Map<String, Object> getResourcePage(int type, int pageNo,String search) {		
		int count= type==3 ? resourceDao.findAllCount()
				: type==4 ? resourceDao.searchCount(search)
				: resourceDao.findByTypeCount(type);
		PageObject page=new PageObject();
		page.setPageCurrent(pageNo);
		page.setPageSize(8);
		page.setStartIndex(page.getPageSize()*(pageNo-1));
		page.setRowCount(count);
		List<its.user.entity.Resource> rs= type==3 ? resourceDao.findAll(page.getStartIndex(), page.getPageSize())
				: type==4 ? resourceDao.search(search,page.getStartIndex(), page.getPageSize())
				: resourceDao.findByType(type,page.getStartIndex(), page.getPageSize());
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("page", page);
		map.put("count", page.getPageCount());
		map.put("resource", rs);
		List<String> valid=new ArrayList<String>();
		for(its.user.entity.Resource r:rs) {
			valid.add(userDao.findByUsername(r.getCreatedUser()).get(0).getValid()+"");
		}
		map.put("valid", valid);
		return map;
	}
	@Override
	public Map<String, Object> getResourceObject(int id, User user) {
		//1.根据ID查询资源
		its.user.entity.Resource resource=resourceDao.findById(id);		
		resource.setPath(resource.getPath().substring(2));
		System.out.println(resource.getPath());
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("resource", resource);
		String valid=userDao.findByUsername(resource.getCreatedUser()).get(0).getValid()+"";
		map.put("valid", valid);
		return map;
	}
	@Override
	public its.user.entity.Resource findResourceById(int id) {
		return resourceDao.findById(id);
	}
	@Override
	public void downloadAfter(User user, its.user.entity.Resource resource) throws Exception {		
		if(downloadDao.findByResourceIdAndUser(resource.getId(), user.getUsername()).size()==0
				&& !user.getUsername().equals(resource.getCreatedUser())) {
			//1.下载后扣除当前用户的积分
			userDao.updateIntegral(user.getUsername(), -resource.getDownloadIntegral());
			//2.为资源提供者增加相应的积分
			userDao.updateIntegral(resource.getCreatedUser(), resource.getDownloadIntegral());
			//3.发送消息给资源提供者
			Message msg=new Message();
			msg.setTitle(user.getUsername()+ItsConstants.MSG_T_DOWNLOAD+resource.getDownloadIntegral());
			msg.setContent(user.getUsername()+ItsConstants.MSG_C_DOWNLOAD
					+"<a href='resDetail"+resource.getType()+".do?id="+resource.getId()+"'>"+resource.getTitle()+"</a>");
			msg.setCreatedUser(user.getUsername());
			msg.setResourceId(resource.getId());
			msg.setUser(resource.getCreatedUser());
			messageDao.insertMsg(msg);
		}
		//4.文件下载次数+1
		resourceDao.updateDownloadCount(resource.getId());
		//5.保存下载记录
		Download d=new Download();
		d.setResourceId(resource.getId());
		d.setCreatedUser(user.getUsername());
		downloadDao.save(d);
	}
	@Override
	public int downloadBefore(User user, its.user.entity.Resource resource) throws Exception {
		if(user.getIntegral()<resource.getDownloadIntegral()) {
			throw new ServiceException("当前积分不足以下载该资源，请获取更多的积分后再来下载吧！");
		}
		if(downloadDao.findByResourceIdAndUser(resource.getId(), user.getUsername()).size()==0
				&& !user.getUsername().equals(resource.getCreatedUser())) {
			return 0;
		}else {
			return 1;
		}
	}
	@Override
	public Map<String, Object> getOwnResourcePage(int pageNo, User user) {
		int count=resourceDao.findByUserCount(user.getUsername());
		PageObject page=new PageObject();
		page.setStartIndex(page.getPageSize()*(pageNo-1));
		page.setPageCurrent(pageNo);
		page.setRowCount(count);
		List<its.user.entity.Resource> rs=resourceDao.findByUser(user.getUsername(), page.getStartIndex(), page.getPageSize());
		Map<String, Object> map=new HashMap<String, Object>();
		map.put("pageCount", page.getPageCount());
		map.put("page", page);
		map.put("resource", rs);
		return map;
	}
	@Override
	public void delete(int id) {
		resourceDao.delete(id);		
	}
}

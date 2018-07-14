package its.user.service;

import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

import its.user.entity.Resource;
import its.user.entity.User;

public interface ResourceService {
	/**
	 * 保存资源
	 * @param title
	 * @param desc
	 * @param downloadIntegral
	 * @param mFile
	 * @param user
	 * @return
	 */
	public its.user.entity.Resource save (
			String title,
    		String desc,
    		int downloadIntegral,
    		MultipartFile mFile,
    		User user)throws Exception;
	/**
	 * 所有资源
	 * @param type
	 * @param pageNo
	 * @return
	 */
	public Map<String,Object> getResourcePage(int type,int pageNo,String search);
	/**
	 * 按ID查询资源详情页面及后台操作
	 * @param id 资源id
	 * @param user 当前用户
	 * @return
	 */
	public Map<String,Object> getResourceObject(int id,User user);
	/**
	 * 按ID查询资源
	 * @param id
	 * @return
	 */
	public its.user.entity.Resource findResourceById(int id);
	/**
	 * 1.下载后扣除当前用户的积分<br>
	 * 2.为资源提供者增加相应的积分<br>
	 * 3.发送消息给资源提供者<br>
	 * 4.保存下载记录<br>
	 * 5.文件下载次数+1
	 * @param user 当前用户
	 * @param resource 当前访问的资源
	 */
	public void downloadAfter(User user,Resource resource)throws Exception;
	
	/**
	 * 下载前检查
	 * @param user 当前用户
	 * @param resource 当前访问的资源
	 * @return 0-该用户未下载过该资源<br>1-该用户已下载过该资源
	 */
	public int downloadBefore(User user,Resource resource)throws Exception;
	/**
	 * 获取个人资源
	 * @param pageNo
	 * @param user
	 * @return
	 */
	public Map<String,Object> getOwnResourcePage(int pageNo,User user);
	/**
	 * 删除资源
	 * @param id
	 */
	public void delete(int id);
}

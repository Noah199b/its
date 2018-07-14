package its.user.service.impl;

import java.io.File;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import its.user.dao.AuthDao;
import its.user.dao.MessageDao;
import its.user.entity.Auth;
import its.user.entity.Message;
import its.user.entity.User;
import its.user.exception.ServiceException;
import its.user.service.AuthService;
import its.user.tools.ItsConstants;
@Service
public class AuthServiceImpl implements AuthService {
	@Resource
	AuthDao authDao;
	@Resource
	MessageDao messageDao;
	@Override
	public void checkPart1(Auth auth) throws Exception {
		if(auth.getTel().trim().length()!=11)throw new ServiceException("手机号位数应为11位！");
		if("".equals(auth.getName().trim()))throw new ServiceException("姓名不能为空！");
		if(auth.getIdNo().trim().length()!=18)throw new ServiceException("身份证号码位数应为18位！");
		if("".equals(auth.getSpeciality().trim()))throw new ServiceException("专业不能为空！");
		if("".equals(auth.getEdu().trim()))throw new ServiceException("学历不能为空！");
		if("".equals(auth.getSchool().trim()))throw new ServiceException("毕业院校不能为空！");
		if("".equals(auth.getWorkspace().trim()))throw new ServiceException("工作单位不能为空！");
		if("".equals(auth.getQq().trim()))throw new ServiceException("QQ不能为空！");
		if("".equals(auth.getWechat().trim()))throw new ServiceException("微信不能为空！");
	}

	@Override
	public void uploadOthers(MultipartFile mFile1, MultipartFile mFile2, MultipartFile mFile3, MultipartFile mFile4,
			MultipartFile mFile5, HttpServletRequest request)throws Exception {
		User user=(User)request.getSession().getAttribute("its_user");
		Auth auth=(Auth)request.getSession().getAttribute("teacher_auth");
		if(mFile1==null || mFile2==null || mFile3==null) throw new ServiceException("请完成带*的必输项！");
		String suffix="";	
		//1.身份证正面
		suffix=mFile1.getOriginalFilename().substring(mFile1.getOriginalFilename().lastIndexOf("."));
//		System.out.println(suffix);
		if(!(".jpg".equals(suffix)||".png".equals(suffix)))
			throw new ServiceException("身份证1图片格式错误！");
		File f1=new File(ItsConstants.UPLOADS_DOCBASE+ItsConstants.AUTH_PATH+user.getUsername()+"/front"+suffix);
		if(!f1.exists()) {
			f1.mkdirs();
		}
		mFile1.transferTo(f1);
		String frontPath =ItsConstants.UPLOADS_PATH+ItsConstants.AUTH_PATH+user.getUsername()+"/front"+suffix;
		auth.setFrontPath(frontPath);
		//2.身份证反面
		suffix=mFile2.getOriginalFilename().substring(mFile2.getOriginalFilename().lastIndexOf("."));
		if(!(".jpg".equals(suffix)||".png".equals(suffix)))
			throw new ServiceException("身份证2图片格式错误！");
		File f2=new File(ItsConstants.UPLOADS_DOCBASE+ItsConstants.AUTH_PATH+user.getUsername()+"/back"+suffix);
		mFile2.transferTo(f2);
		String backPath =ItsConstants.UPLOADS_PATH+ItsConstants.AUTH_PATH+user.getUsername()+"/back"+suffix;
		auth.setBackPath(backPath);
		//3.辅助材料1
		suffix=mFile3.getOriginalFilename().substring(mFile3.getOriginalFilename().lastIndexOf("."));
		if(!(".jpg".equals(suffix)||".png".equals(suffix)))
			throw new ServiceException("辅助1图片格式错误！");
		File f3=new File(ItsConstants.UPLOADS_DOCBASE+ItsConstants.AUTH_PATH+user.getUsername()+"/aid1"+suffix);
		mFile3.transferTo(f3);
		String aidPath1 =ItsConstants.UPLOADS_PATH+ItsConstants.AUTH_PATH+user.getUsername()+"/aid1"+suffix;
		auth.setAidPath1(aidPath1);
		//4.辅助材料2
		if(mFile4!=null) {
			suffix=mFile4.getOriginalFilename().substring(mFile4.getOriginalFilename().lastIndexOf("."));
			if(!(".jpg".equals(suffix)||".png".equals(suffix)))
				throw new ServiceException("辅助2图片格式错误！");
			File f4=new File(ItsConstants.UPLOADS_DOCBASE+ItsConstants.AUTH_PATH+user.getUsername()+"/aid2"+suffix);
			mFile4.transferTo(f4);
			String aidPath2 =ItsConstants.UPLOADS_PATH+ItsConstants.AUTH_PATH+user.getUsername()+"/aid2"+suffix;
			auth.setAidPath2(aidPath2);
		}
		//5.辅助材料3
		if(mFile5!=null) {
			suffix=mFile5.getOriginalFilename().substring(mFile5.getOriginalFilename().lastIndexOf("."));
			if(!(".jpg".equals(suffix)||".png".equals(suffix)))
				throw new ServiceException("辅助3图片格式错误！");
			File f5=new File(ItsConstants.UPLOADS_DOCBASE+ItsConstants.AUTH_PATH+user.getUsername()+"/aid3"+suffix);
			mFile5.transferTo(f5);
			String aidPath3 =ItsConstants.UPLOADS_PATH+ItsConstants.AUTH_PATH+user.getUsername()+"/aid3"+suffix;
			auth.setAidPath3(aidPath3);
		}
		authDao.save(auth);
		Message message=new Message();
		message.setType(0);
		message.setCreatedUser("admin");
		message.setUser(user.getUsername());
		message.setTitle("感谢您申请认证教师！");
		message.setContent("我们将在7个工作日内对您的申请进行审核，请您耐心等待！");
		messageDao.insertMsg(message);
	}

	@Override
	public Auth findByUsername(String username) {
		return authDao.findByUsername(username);
	}

}

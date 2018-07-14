package its.user.service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartFile;

import its.user.entity.Auth;

public interface AuthService {
	public void checkPart1(Auth auth)throws Exception;

	public void uploadOthers(MultipartFile mFile1, MultipartFile mFile2, MultipartFile mFile3, MultipartFile mFile4,
			MultipartFile mFile5, HttpServletRequest request)throws Exception;
	
	public Auth findByUsername(String username);
}

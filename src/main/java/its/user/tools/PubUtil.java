package its.user.tools;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Random;

import org.springframework.web.multipart.MultipartFile;

import its.user.exception.ServiceException;
import sun.misc.BASE64Decoder;

public class PubUtil {
	
	
	/**
	 * 产生随即字符串
	 * @param m 加密秘钥10位    验证码5位
	 * @return
	 */
	public static String randomSalt(int m) {
		Random r=new Random();
		StringBuffer salt=new StringBuffer();
		for(int i=0;i<m;i++) {
			if(r.nextInt(2)==0) {
				salt.append(r.nextInt(10));
			}else {
				char str=(char)(r.nextInt(122-97+1)+97);
				salt.append(str);
			}
		}
		return salt.toString();
	}
	/**
	 * 密码进行MD5处理（32位）
	 * @param password
	 * @return
	 * @throws NoSuchAlgorithmException 
	 */
	public static String md5(String password) {
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");			
			md.update(password.getBytes());  
	         byte b[] = md.digest();  
	         int i;  
	         StringBuffer buf = new StringBuffer("");  
	         for (int offset = 0; offset < b.length; offset++) {  
	             i = b[offset];  
	             if (i < 0)  
	                 i += 256;  
	             if (i < 16)  
	                 buf.append("0");  
	             buf.append(Integer.toHexString(i));  
	         	}
	             return buf.toString();
	         } catch (NoSuchAlgorithmException e) {
	        	 throw new ServiceException("系统异常，请稍后重试！");
	         }  
	}
	/**
	 * 从URL中获取base64Image数据
	 * @param url
	 * @return
	 */
	public static String getBase64ImageData(String url) {
		return url.split("\"")[1].split(",")[1];
	}
	/**
	 * base64字符串转化图片
	 * @param imageData
	 * @param imgFilePath 文件保存路径
	 * @return
	 */
	public static boolean GenerateImage(String imageData,String imgFilePath)
		throws ServiceException{		
		if(imageData==null) return false;
		BASE64Decoder decoder=new BASE64Decoder();
		OutputStream out = null;
		try {
			byte[] b=decoder.decodeBuffer(imageData);
			for(int i=0;i<b.length;i++) {
				if(b[i]<0) b[i]+=256;
			}
			File imgFile=new File(imgFilePath);
			out=new FileOutputStream(imgFilePath);
			out.write(b);
			out.flush();
		} catch (IOException e) {
			e.printStackTrace();
			throw new ServiceException("保存头像失败，请稍后重试！");
		}finally{
			if(out!=null)
				try {
					out.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
		}
		return true;
	}
	/**
	 * 检查资源了类型 
	 * @param mFile
	 * @return
	 * @throws ServiceException
	 */
	public static int checkFileType(MultipartFile mFile)throws ServiceException{
		String path=mFile.getOriginalFilename();
		if(path.endsWith(".rar")||path.endsWith(".zip")) {			
			return 0;
		}else if(path.endsWith(".pdf")) {			
			return 1;
		}else {
			return 2;
		}
	}
}


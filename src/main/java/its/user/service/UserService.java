package its.user.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import its.user.entity.User;

public interface UserService {
	/**
	 * 用户注册
	 * @param user
	 * @throws Exception
	 */
	public void save(User user) throws Exception;
	/**
	 * 更具usernam查询用户
	 * @param username
	 * @return
	 * @throws Exception
	 */
	public List<User> findByUsername(String username) throws Exception;
	/**
	 * 检查两次输入的密码是否一致
	 * @param pwd1
	 * @param pwd2
	 * @return
	 * @throws Exception
	 */
	public boolean checkPassword(String pwd1,String pwd2)throws Exception;
	/**
	 * 用户登录
	 * @param username
	 * @param password
	 * @return 
	 * @throws Exception
	 */
	public User login(String username,String password)throws Exception;
	/**
	 * 修改用户信息
	 * @throws Exception
	 */
	public void updateUser(User user)throws Exception;
	/**
	 * 修改用户头像
	 * @param imageData
	 * @throws Exception
	 */
	public void updateAvatar(int id,String username,String avatar,String serverPath)throws Exception;
	/**
	 * 发送验证码并保存
	 * @param rq
	 * @throws Exception
	 */
	public void sendCode(String user,String mail,HttpServletRequest rq)throws Exception;
	/**
	 * 修改密码
	 * @param rq
	 * @throws Exception
	 */
	public void rePassword(String user,String mail,String code,String pwd,HttpServletRequest rq)throws Exception;
}

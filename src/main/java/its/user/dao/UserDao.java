package its.user.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import its.user.entity.User;

public interface UserDao {
	/**
	 * 注册新用户
	 * @param user
	 * @return
	 */
	public int insertUser(User user);
	/**
	 * 根据用户名查询用户信息
	 * @param username
	 * @return
	 */
	public List<User> findByUsername(@Param("username")String username);
	/**
	 * 根据ID查询用户信息
	 * @param id
	 * @return
	 */
	public User findById(@Param("id")int id);
	/**
	 * 修改用户信息
	 * @param id
	 */
	public void updateUserInfo(
			@Param("id")int id,
			@Param("user")String  user,
			@Param("name")String  name,
			@Param("autograph")String  autograph
			);
	/**
	 * 修改用户头像
	 * @param id
	 * @param avatar
	 */
	public void updateAvatar(
			@Param("id")int id,
			@Param("user")String  user,
			@Param("avatar") String avatar);
	/**
	 * 根据用户名修改用户积分
	 * @param user
	 */
	public void updateIntegral(@Param("user")String  user,@Param("integral")int integral);
	
	/**
	 * 修改用户密码
	 * @param username
	 * @param password
	 * @param salt
	 */
	public void updatePassword(@Param("user")String  username,
			@Param("pwd")String  password,
			@Param("salt")String  salt
			);
}

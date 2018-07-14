package its.user.tools;

import java.util.regex.Pattern;

public class PatternUtil {
	/**
	 * 正则表达式校验用户名
	 * （由字母数字下划线组成且开头必须是字母，至少6位，不能超过16位）
	 * @param username
	 * @return
	 */
	public static boolean checkUsername(String username) {		
		return Pattern.compile("[a-zA-Z]{1}[a-zA-Z0-9_]{5,15}").matcher(username).matches();
	}
	/**
	 * 正则表达式校验密码
	 * （由字母和数字构成，至少6位，不能超过16位）
	 * @param pwd
	 * @return
	 */
	public static boolean checkPassword(String pwd) {		
		return Pattern.compile("[a-zA-Z0-9]{6,16}").matcher(pwd).matches();
	}
	
	/**
	 * 正则表达式校验邮箱格式
	 * @param pwd
	 * @return
	 */
	public static boolean checkEmail(String email) {		
		return Pattern.compile("[a-zA-Z0-9_-]+@[a-zA-Z0-9_-]+(\\.[a-zA-Z0-9_-]+)+").matcher(email).matches();
	}
}

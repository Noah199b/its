package its.user.tools;

import java.util.Date;

public class BBSCheckUtil {
	/**
	 * 检查恶意发帖（5分钟内重复发帖）
	 * @param date 上次发帖时间
	 * @return true-恶意发帖  
	 */
	public static boolean checkPostInterval(Date date) {		
		return (new Date().getTime()-date.getTime())/1000/60 < 5;
	}
	/**
	 * 检查恶意灌水（1分钟内重复回帖）
	 * @param date 上次回帖时间
	 * @return
	 */
	public static boolean checkReplyInterval(Date date) {		
		return (new Date().getTime()-date.getTime())/1000/60 < 1;
	}
	
}

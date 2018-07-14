package its.user.tools;

public class ItsConstants {
	/**头像保存路径*/
	public final static  String AVATAR_PATH ="/images/ava/";
	/**认证材料保存路径*/
	public final static  String AUTH_PATH ="/images/auth/";
	/**资料路径*/
	public final static  String RAR_PATH ="/resources/rar/";
	/**文献路径*/
	public final static  String PDF_PATH ="/resources/pdf/";
	/**视频路径*/
	public final static  String VIDEO_PATH ="/resources/video/";
	/**tomcat  docBase*/
	public final static String UPLOADS_DOCBASE="D:/uploads";
	/**tomcat  path*/
	public final static String UPLOADS_PATH="/uploads";
	/**默认头像路径*/
	public final static  String DEFAULT_AVATAR_PATH =ItsConstants.UPLOADS_PATH+ItsConstants.AVATAR_PATH+"default.png";

//----------------------------------------------------------------------------------------------------------------------
	
	/**回复话题标题*/
	public final static String MSG_T_REPLY=" 回复了您的话题！积分+1";
	/**回复话题内容*/
	public final static String MSG_C_REPLY=" <b>回复了您的话题！内容为：</b>";
	/**回复评论标题*/
	public final static String MSG_T_SUBREPLY=" 回复了您的评论！积分+1";
	/**回复评论内容*/
	public final static String MSG_C_SUBREPLY=" <b>回复了您的评论！内容为：</b>";
	/**注册用户标题*/
	public final static String MSG_T_REGISTER=" 恭喜您，成为本站会员！积分+10";
	/**注册用户内容*/
	public final static String MSG_C_REGISTER=" <b>恭喜您，成为本站会员，在这里你可以分享学习经验，资源等内容！</b>";
	/**上传头像标题*/
	public final static String MSG_T_AVATAR=" 恭喜您，成功上传头像！积分+10";
	/**上传头像内容*/
	public final static String MSG_C_AVATAR=" <b>恭喜您，成功上传头像，这是让别人认识和记住你的重要一步！</b>";
	/**恶意发帖标题*/
	public final static String MSG_T_CHECKPOST=" 恶意发帖，积分-10";
	/**恶意发帖内容*/
	public final static String MSG_C_CHECKPOST=" <b>发现您有恶意发帖的操作，扣除积分-10！（提示：5分钟内重复发帖被视为恶意发帖）</b>";
	/**恶意灌水标题*/
	public final static String MSG_T_CHECKREPLY=" 恶意灌水，积分-5";
	/**恶意灌水内容*/
	public final static String MSG_C_CHECKREPLY=" <b>发现您有恶意灌水的操作，扣除积分-5！（提示：1分钟内重复回帖被视为恶意灌水）</b>";
	/**下载资源标题*/
	public final static String MSG_T_DOWNLOAD=" 购买了您的资源！积分+";
	/**下载资源内容*/
	public final static String MSG_C_DOWNLOAD=" <b>购买了您的资源，重复下载您将不会获得积分！点击标题查看资源：</b>";
	/**评论资源标题*/
	public final static String MSG_T_RESOURCE_REPLY=" 评论了您的资源！（购买时加分，评论操作不加分）";
	/**评论资源内容*/
	public final static String MSG_C_RESOURCE_REPLY=" <b>评论了您的资源！内容为：</b>";
}

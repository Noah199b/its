package its.user.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import javax.annotation.Resource;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

import its.user.dao.MessageDao;
import its.user.dao.UserDao;
import its.user.entity.Message;
import its.user.entity.User;
import its.user.exception.ServiceException;
import its.user.service.UserService;
import its.user.tools.ItsConstants;
import its.user.tools.PatternUtil;
import its.user.tools.PubUtil;

@Service
public class UserServiceImpl implements UserService {
	@Resource
	private UserDao userDao;
	@Resource
	private MessageDao messageDao;
	@Override
	public void save(User user) throws Exception{
		if(!PatternUtil.checkUsername(user.getUsername())) {
			throw new ServiceException("提示：用户名由字母数字下划线组成且开头必须是字母，至少6位，不能超过16位!");
		}
		if(!PatternUtil.checkPassword(user.getPassword())) {
			throw new ServiceException("提示：密码由字母和数字构成，至少6位，不能超过16位!");
		}
		if(!PatternUtil.checkEmail(user.getEmail())) {
			throw new ServiceException("提示：邮箱["+user.getEmail()+"]格式错误!");
		}
		String salt=PubUtil.randomSalt(10);
		user.setSalt(salt);
		user.setPassword(PubUtil.md5(user.getPassword()+salt));
		int count=userDao.insertUser(user);
		if(count==0) {
			throw new ServiceException("注册失败，请稍后重试!");
		}
		//发送消息到用户
		Message message =new Message();
		message.setTitle(user.getUsername()+ItsConstants.MSG_T_REGISTER);
		message.setContent(user.getUsername()+ItsConstants.MSG_C_REGISTER);
		message.setType(0);//0-通知  1-消息
		message.setUser(user.getUsername());
		message.setCreatedUser("admin");
		messageDao.insertMsg(message);
	}

	@Override
	public List<User> findByUsername(String username)throws Exception {
		if(!PatternUtil.checkUsername(username)) {
			throw new ServiceException("提示：用户名由字母数字下划线组成且开头必须是字母，至少6位，不能超过16位!");
		}
		List<User> userInfo=userDao.findByUsername(username);		
		return userInfo;
	}

	@Override
	public boolean checkPassword(String pwd1, String pwd2) throws Exception {
		if(!PatternUtil.checkPassword(pwd1)) {
			throw new ServiceException("提示：密码由字母和数字构成，至少6位，不能超过16位!");
		}
		if(!PatternUtil.checkPassword(pwd2)) {
			throw new ServiceException("提示：密码由字母和数字构成，至少6位，不能超过16位!");
		}		
		return pwd1.equals(pwd2);
	}

	@Override
	public User login(String username, String password) throws Exception {
		List<User> user=userDao.findByUsername(username);
		if(user.isEmpty())
			throw new ServiceException("提示：用户不存在！");
		for(User u:user) {
			if(!u.getPassword().equals(PubUtil.md5(password+u.getSalt())))
				throw new ServiceException("提示：密码错误，请重新输入！");
			if(u.getValid()==0)
				throw new ServiceException("提示：该账号已停止使用！");
		}
		return user.get(0);
	}

	@Override
	public void updateUser(User user) throws Exception {		
		userDao.updateUserInfo(user.getId(), user.getUsername(), user.getName(), user.getAutograph());		
	}

	@Override
	public void updateAvatar(int id,String username,String avatar,String serverPath) throws Exception {
		User user=userDao.findById(id);
		if("none".equals(avatar.trim())) throw new ServiceException("未获取到头像信息！");
		String imgData=PubUtil.getBase64ImageData(avatar);
		String path=ItsConstants.AVATAR_PATH+username+".png";
		String imgPath=serverPath+path;
		if(!PubUtil.GenerateImage(imgData, imgPath)) throw new ServiceException("头像上传失败！");
		userDao.updateAvatar(id, username,ItsConstants.UPLOADS_PATH+path);
		//只有为默认头像的情况下才加分
		if(ItsConstants.DEFAULT_AVATAR_PATH.equals(user.getAvatar())) {
			//发送消息到用户
			Message message =new Message();
			message.setTitle(username+ItsConstants.MSG_T_AVATAR);
			message.setContent(username+ItsConstants.MSG_C_AVATAR);
			message.setType(0);//0-通知  1-消息
			message.setUser(username);
			message.setCreatedUser("admin");
			messageDao.insertMsg(message);
			userDao.updateIntegral(user.getUsername(), 10);//上传头像+10分
		}
	}

	@Override
	public void sendCode(String user,String mail,HttpServletRequest rq) throws Exception {
		if("".equals(user))throw new ServiceException("用户名不能为空！");
		if("".equals(mail))throw new ServiceException("邮箱不能为空！");
		if(userDao.findByUsername(user).size()==0)throw new ServiceException("用户名不存在！");
		if(!mail.equals(userDao.findByUsername(user).get(0).getEmail()))
			throw new ServiceException("账号邮箱错误，请检查后重试！");
		// 发件人的 邮箱 和 密码（替换为自己的邮箱和密码）
	    // PS: 某些邮箱服务器为了增加邮箱本身密码的安全性，给 SMTP 客户端设置了独立密码（有的邮箱称为“授权码”）, 
	    //     对于开启了独立密码的邮箱, 这里的邮箱密码必需使用这个独立密码（授权码）。
	    String myEmailAccount = "13099215706@163.com";
	    String myEmailPassword = "Gl960811";
	    // 发件人邮箱的 SMTP 服务器地址, 必须准确, 不同邮件服务器地址不同, 一般(只是一般, 绝非绝对)格式为: smtp.xxx.com
	    // 网易163邮箱的 SMTP 服务器地址为: smtp.163.com
	    String myEmailSMTPHost = "smtp.163.com";
	    // 收件人邮箱（替换为自己知道的有效邮箱）
	    String receiveMailAccount = mail;
	    Properties props = new Properties();                    // 参数配置
        props.setProperty("mail.transport.protocol", "smtp");   // 使用的协议（JavaMail规范要求）
        props.setProperty("mail.smtp.host", myEmailSMTPHost);   // 发件人的邮箱的 SMTP 服务器地址
        props.setProperty("mail.smtp.auth", "true");            // 需要请求认证
        // PS: 某些邮箱服务器要求 SMTP 连接需要使用 SSL 安全认证 (为了提高安全性, 邮箱支持SSL连接, 也可以自己开启),
        //     如果无法连接邮件服务器, 仔细查看控制台打印的 log, 如果有有类似 “连接失败, 要求 SSL 安全连接” 等错误,
        //     打开下面 /* ... */ 之间的注释代码, 开启 SSL 安全连接。
        /*
        // SMTP 服务器的端口 (非 SSL 连接的端口一般默认为 25, 可以不添加, 如果开启了 SSL 连接,
        //                  需要改为对应邮箱的 SMTP 服务器的端口, 具体可查看对应邮箱服务的帮助,
        //                  QQ邮箱的SMTP(SLL)端口为465或587, 其他邮箱自行去查看)
        final String smtpPort = "465";
        props.setProperty("mail.smtp.port", smtpPort);
        props.setProperty("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        props.setProperty("mail.smtp.socketFactory.fallback", "false");
        props.setProperty("mail.smtp.socketFactory.port", smtpPort);
        */
        // 2. 根据配置创建会话对象, 用于和邮件服务器交互
        Session session = Session.getInstance(props);
        session.setDebug(true);                                 // 设置为debug模式, 可以查看详细的发送 log
        // 3. 创建一封邮件
        // 3.1. 创建一封邮件
        MimeMessage message = new MimeMessage(session);

        // 3.2. From: 发件人（昵称有广告嫌疑，避免被邮件服务器误认为是滥发广告以至返回失败，请修改昵称）
        message.setFrom(new InternetAddress(myEmailAccount, "ITS_Admin", "UTF-8"));

        // 3.3. To: 收件人（可以增加多个收件人、抄送、密送）
        message.setRecipient(MimeMessage.RecipientType.TO, new InternetAddress(receiveMailAccount,user, "UTF-8"));
        
        // 3.4. Subject: 邮件主题（标题有广告嫌疑，避免被邮件服务器误认为是滥发广告以至返回失败，请修改标题）
        String code=PubUtil.randomSalt(5);
        Map<String,String> map=new HashMap<String,String>();
        map.put(mail, code);
        rq.getSession().setAttribute("its_code", map);//保存到session
        message.setSubject("[互助教学系统]验证码", "UTF-8");

        // 3.5. Content: 邮件正文（可以使用html标签）（内容有广告嫌疑，避免被邮件服务器误认为是滥发广告以至返回失败，请修改发送内容）
        message.setContent("[互助教学系统]您的验证码为："+code
        		+"，验证码有效时间为30分钟。\n如果您未进行任何操作，请忽略此邮件！", "text/html;charset=UTF-8");

        // 3.6. 设置发件时间
        message.setSentDate(new Date());

        // 3.7. 保存设置
        message.saveChanges();
        // 4. 根据 Session 获取邮件传输对象
        Transport transport = session.getTransport();
     // 5. 使用 邮箱账号 和 密码 连接邮件服务器, 这里认证的邮箱必须与 message 中的发件人邮箱一致, 否则报错
        // 
        //    PS_01: 成败的判断关键在此一句, 如果连接服务器失败, 都会在控制台输出相应失败原因的 log,
        //           仔细查看失败原因, 有些邮箱服务器会返回错误码或查看错误类型的链接, 根据给出的错误
        //           类型到对应邮件服务器的帮助网站上查看具体失败原因。
        //
        //    PS_02: 连接失败的原因通常为以下几点, 仔细检查代码:
        //           (1) 邮箱没有开启 SMTP 服务;
        //           (2) 邮箱密码错误, 例如某些邮箱开启了独立密码;
        //           (3) 邮箱服务器要求必须要使用 SSL 安全连接;
        //           (4) 请求过于频繁或其他原因, 被邮件服务器拒绝服务;
        //           (5) 如果以上几点都确定无误, 到邮件服务器网站查找帮助。
        //
        //    PS_03: 仔细看log, 认真看log, 看懂log, 错误原因都在log已说明。
        transport.connect(myEmailAccount, myEmailPassword);

        // 6. 发送邮件, 发到所有的收件地址, message.getAllRecipients() 获取到的是在创建邮件对象时添加的所有收件人, 抄送人, 密送人
        transport.sendMessage(message, message.getAllRecipients());

        // 7. 关闭连接
        transport.close();
	}

	@Override
	public void rePassword(String user,String mail,String code,String pwd,HttpServletRequest rq) throws Exception {
		if("".equals(user))throw new ServiceException("用户名不能为空！");
		if("".equals(mail))throw new ServiceException("邮箱不能为空！");
		if("".equals(code))throw new ServiceException("验证码不能为空！");
		if(!PatternUtil.checkPassword(pwd)) {
			throw new ServiceException("提示：密码由字母和数字构成，至少6位，不能超过16位!");
		}
		if(userDao.findByUsername(user).size()==0)throw new ServiceException("用户名不存在！");
		if(!mail.equals(userDao.findByUsername(user).get(0).getEmail()))
			throw new ServiceException("账号邮箱错误，请检查后重试！");
		if(null==rq.getSession().getAttribute("its_code"))
			throw new ServiceException("验证码失效，请重新发送！");
		@SuppressWarnings("unchecked")
		Map<String,String> map=(Map<String,String>)rq.getSession().getAttribute("its_code");
		String c=map.get(mail);
		if(!code.equals(c))throw new ServiceException("验证码错误,请重试！");
		String salt=PubUtil.randomSalt(10);
		String password=PubUtil.md5(pwd+salt);
		userDao.updatePassword(user, password, salt);
		rq.getSession().setAttribute("its_code", null);
	}
	
}

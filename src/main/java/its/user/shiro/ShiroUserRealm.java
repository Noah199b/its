package its.user.shiro;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;

import its.user.dao.UserDao;
import its.user.entity.User;

public class ShiroUserRealm extends AuthorizingRealm{
	@Resource
	private UserDao userDao;
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		System.out.println("==doGetAuthorizationInfo==");
		User user = (User) SecurityUtils.getSubject().getSession().getAttribute("its_user");
		int userId = user.getId();		
		List<String> permsList = new ArrayList<>();
//		permsList = userDao.findUserPermissions(userId);
		//用户权限列表
		Set<String> permsSet = new HashSet<String>();
		for(String perm : permsList){
			if(perm!=null && !("".equals(perm))){
				permsSet.add(perm);
			}
		}
		System.out.println("permsSet="+permsSet);
		SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
		info.setStringPermissions(permsSet);
		return info;
	}

	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        System.out.println("==doGetAuthenticationInfo==");
		//1. �? AuthenticationToken 转换�? UsernamePasswordToken 
		UsernamePasswordToken upToken = (UsernamePasswordToken) token;
		//2. �? UsernamePasswordToken 中来获取 username
		String username = upToken.getUsername();
		//判断用户名是否存在，若存在，返回user对象
		List<User> user =userDao.findByUsername(username);
		//盐�??. 
		ByteSource credentialsSalt = ByteSource.Util.bytes(user.get(0).getSalt());
		//自动完成密码比对   - 密码的比�?:
		//通过 AuthenticatingRealm �? credentialsMatcher 属�?�来进行的密码的比对!
		SimpleAuthenticationInfo info =
		new SimpleAuthenticationInfo(
		username, user.get(0).getPassword(),credentialsSalt,getName());
		SecurityUtils.getSubject().getSession()
		.setAttribute("its_user",user);
		return info;
	}
}

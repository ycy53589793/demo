package com.filter;

import java.util.HashSet;
import java.util.Set;

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
import org.springframework.beans.factory.InitializingBean;
import org.springside.modules.security.utils.Digests;
import org.springside.modules.utils.Encodes;

import com.role.bean.Role;
import com.user.bean.User;
import com.user.service.UserService;
import com.util.EmptyUtil;
import com.util.SpringUtil;

public class ShiroDbRealm extends AuthorizingRealm implements InitializingBean {
	
	private static final int SALT_SIZE = 8;
	private String salt = Encodes.encodeHex(Digests.generateSalt(SALT_SIZE));
	
	protected UserService userService;

	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {

		ShiroUser shiroUser = (ShiroUser) getAvailablePrincipal(principals);
		
		SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
		
		Set<String> roles = new HashSet<String>();
//        Set<String> permissions = new HashSet<String>();
        for (Role role : shiroUser.roles) {
        	String roleName = role.getRoleName();
        	if("admin".equals(shiroUser.username)) {
        		info.addStringPermission(roleName+":add");
                info.addStringPermission(roleName+":edit");
                info.addStringPermission(roleName+":update");
                info.addStringPermission(roleName+":delete");
        	}
        	info.addStringPermission(roleName+":query");
            roles.add(roleName);
//            for (Permission per : role.getPermissionSet()) {  
//                permissions.add(per.getName());  
//            }  
        }
        
        info.addRoles(roles);
        
		return info;
	}

	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authcToken) throws AuthenticationException {
		
		UsernamePasswordToken token = (UsernamePasswordToken) authcToken;
		User user = userService.findUserByUserNameAndPassword(token.getUsername(), new String(token.getPassword()));
		if(EmptyUtil.isNull(user)) {
			return null;
		}
		return new SimpleAuthenticationInfo(new ShiroUser(user.getId(),user.getUsername(),user.getRoles()),
				user.getPassword(),ByteSource.Util.bytes(salt),getName());
		
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		if(EmptyUtil.isNull(userService)) {
			userService = (UserService) SpringUtil.getBean("userService");
		}
	}

	public UserService getUserService() {
		return userService;
	}
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

}

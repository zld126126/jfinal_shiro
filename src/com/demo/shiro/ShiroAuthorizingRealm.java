package com.demo.shiro;

import java.util.List;

import org.apache.shiro.authc.AccountException;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationException;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.demo.model.User;

/**
 * shiro的认证授权域
 */
public class ShiroAuthorizingRealm extends AuthorizingRealm {
	
	private static Logger log = LoggerFactory.getLogger(ShiroAuthorizingRealm.class);
	
	/**
	 * 获取当前认证实体的授权信息（授权包括：角色、权限）
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
		// 获取当前登录的用户名
		ShiroPrincipal subject = (ShiroPrincipal)super.getAvailablePrincipal(principals);
		String username = subject.getUsername();
		Integer userId = subject.getId();
		try {
			if(!subject.isAuthorized()) {
				// 获取该用户所有的权限列表
				List<String> authorities = User.dao.getAuthoritiesName(userId);
				List<String> rolelist = User.dao.getRolesName(userId);
				subject.setAuthorities(authorities);
				subject.setRoles(rolelist);
				subject.setAuthorized(true);
				log.info("用户【" + username + "】授权初始化成功");
				log.info("用户【" + username + "】 角色列表为:" + subject.getRoles());
				log.info("用户【" + username + "】 权限列表为:" + subject.getAuthorities());
			}
		} catch(RuntimeException e) {
			throw new AuthorizationException("用户【" + username + "】授权失败");
		}
		// 给当前用户设置权限
		info.addStringPermissions(subject.getAuthorities());
		info.addRoles(subject.getRoles());
		log.info("用户【" + username + "】登录成功");
		return info;
	}

	/**
	 * 根据认证方式（如表单）获取用户名称、密码
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		UsernamePasswordToken upToken = (UsernamePasswordToken) token;
		String username = upToken.getUsername();
		if (username == null) {
			log.warn("用户名不能为空");
			throw new AccountException("用户名不能为空");
		}

		User user = null;
		try {
			user = User.dao.getByName(username);
		} catch(Exception ex) {
			log.warn("获取用户失败" + ex.getMessage());
		}
		if (user == null) {
		    log.warn("用户不存在");
		    throw new UnknownAccountException("用户不存在");
		}
		ShiroPrincipal subject = new ShiroPrincipal(user);
		return new SimpleAuthenticationInfo(subject, user.get("password"), getName());
	}
}

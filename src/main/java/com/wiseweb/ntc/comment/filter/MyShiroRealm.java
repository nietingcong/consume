package com.wiseweb.ntc.comment.filter;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import com.wiseweb.ntc.entity.User;
import com.wiseweb.ntc.service.UserMng;
/**
 * 登录用户认证
 * @author ntc
 *
 */
public class MyShiroRealm extends AuthorizingRealm {
	@Autowired
	private UserMng userMng;
	/**
	 * 登录用户权限认证
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(
			PrincipalCollection principals) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * 登录用户登录认证
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(
			AuthenticationToken authenticationToken) throws AuthenticationException {
		UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
		User user = userMng.findByName(token.getUsername());
		if(user == null) {
			throw new AuthenticationException();
		} else {
			SimpleAuthenticationInfo aInfo = new SimpleAuthenticationInfo(user.getLoginName(), user.getPassWord(), ByteSource.Util.bytes(token.getUsername()), getName());
			Session session = SecurityUtils.getSubject().getSession();
			session.setAttribute("cUser", user);
			return aInfo;
		}
	}

}

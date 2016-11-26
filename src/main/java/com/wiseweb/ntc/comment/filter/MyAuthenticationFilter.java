package com.wiseweb.ntc.comment.filter;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;
import org.springframework.beans.factory.annotation.Autowired;

import com.wiseweb.ntc.comment.exception.ValidateCodeException;
import com.wiseweb.ntc.entity.User;
import com.wiseweb.ntc.service.UserMng;
/**
 * 处理用户登录请求认证
 * @author ntc
 *
 */
public class MyAuthenticationFilter extends FormAuthenticationFilter {
	private static final String VALIDATE_CODE = "VALIDATE_CODE_KEY";
	@Autowired
	private UserMng userMng;
	@Override
	protected boolean executeLogin(ServletRequest request,
			ServletResponse response) throws Exception {
		//获取输入验证码
		HttpServletRequest req = (HttpServletRequest) request;
		String code = req.getParameter("code");
		String sessionCode = (String) req.getSession().getAttribute(VALIDATE_CODE);
		//创建认证标志
		AuthenticationToken token = createToken(request, response);
		if(token == null) {
			throw new IllegalStateException("Create AuthenticationToken Error!");
		}
		if(code == null || !code.equalsIgnoreCase(sessionCode)) {
			return onLoginFailure(token, new ValidateCodeException("验证码输入错误"), request, response);
		}
		//获取用户名
		String userName = (String) token.getPrincipal();
		if(isDisabled(userName)) {
			return onLoginFailure(token, new AuthenticationException("当前用户不存在"), request, response);
		}
		
		try {
			Subject currentUser = getSubject(request, response);//当前登录用户
			currentUser.login(token);//对当前登录用户进行登录认证			
			return onLoginSuccess(token, currentUser, request, response);
		} catch(AuthenticationException e) {
			return onLoginFailure(token, e, request, response);
		}
	}
	private boolean isDisabled(String userName) {
		// TODO Auto-generated method stub
		User user = userMng.findByName(userName);
		if(user == null) return true;
		return false;
	}
	private String prefix;
	private String loginUrl;
	@Override
	public void setLoginUrl(String loginUrl) {
		// TODO Auto-generated method stub
		this.loginUrl = loginUrl;
	}
	@Override
	public String getLoginUrl() {
		// TODO Auto-generated method stub
		return loginUrl;
	}
	public String getPrefix() {
		return prefix;
	}
	public void setPrefix(String prefix) {
		this.prefix = prefix;
	}
}

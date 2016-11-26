package com.wiseweb.ntc.comment.filter;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authc.LogoutFilter;
/**
 * 退出登录过滤器
 * @author ntc
 *
 */
public class MyLogoutFilter extends LogoutFilter {

	/**
	 * 重写重定向的url请求
	 */
	@Override
	protected String getRedirectUrl(ServletRequest request,
			ServletResponse response, Subject subject) {
		return getLoginUrl();//重定向到登录页面
	}
	private String prefix;
    private String loginUrl;
    public String getPrefix() {
        return prefix;
    }
    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }
    public String getLoginUrl() {
        return loginUrl;
    }
    public void setLoginUrl(String loginUrl) {
        this.loginUrl = loginUrl;
    }
}

package com.wiseweb.ntc.comment.filter;

import java.io.IOException;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.apache.shiro.web.filter.authc.UserFilter;
import org.apache.shiro.web.util.WebUtils;
/**
 * 普通用户过滤器
 * @author ntc
 *
 */
public class MyUserFilter extends UserFilter {
	/**
	 * 未登录时重定向到登录页面
	 */
	@Override
	protected void redirectToLogin(ServletRequest request,
			ServletResponse response) throws IOException {
		String loginUrl = getLoginUrl();
        WebUtils.issueRedirect(request, response, loginUrl);
	}
	private String prefix;
    private String loginUrl;
    public String getPrefix() {
        return prefix;
    }
    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }
    @Override
    public String getLoginUrl() {
        return loginUrl;
    }
    @Override
    public void setLoginUrl(String loginUrl) {
        this.loginUrl = loginUrl;
    }
}

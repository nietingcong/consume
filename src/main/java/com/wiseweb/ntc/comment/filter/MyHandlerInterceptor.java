package com.wiseweb.ntc.comment.filter;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.wiseweb.ntc.entity.User;

public class MyHandlerInterceptor extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		start = System.currentTimeMillis();
		System.out.println("预处理开始preHandle。");
		/*User user = (User) request.getSession().getAttribute("cUser");
		if(user == null) {
			response.sendRedirect("/login.htm");
		}*/
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		System.out.println("返回视图前处理开始postHandle。"+modelAndView.getViewName());
	}

	@Override
	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		System.out.println("返回视图后处理开始afterCompletion。"
				+(System.currentTimeMillis()-start)+"ms");
	}
	
	private static Long start = 0L;
	private List<String> excludeUrls;

	public List<String> getExcludeUrls() {
		return excludeUrls;
	}
	public void setExcludeUrls(List<String> excludeUrls) {
		this.excludeUrls = excludeUrls;
	}
}

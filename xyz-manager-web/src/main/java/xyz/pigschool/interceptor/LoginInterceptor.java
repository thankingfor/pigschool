package xyz.pigschool.interceptor;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import xyz.pigschool.manager.pojo.XyzManagerUser;

public class LoginInterceptor implements HandlerInterceptor{

	private final static Logger logger = LoggerFactory.getLogger(LoginInterceptor.class);
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		logger.debug("我来到了登录拦截");
		XyzManagerUser user = (XyzManagerUser) request.getSession().getAttribute("user");
		if(user==null) {
			logger.debug("没有登录,进行拦截");
			PrintWriter out = response.getWriter();
			out.print("<script>window.top.location.href ='login'</script>");
			return false;
		}
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		
	}

}

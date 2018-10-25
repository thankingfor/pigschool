package xyz.pigschool.smk.search.exception;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

/**
 * 全局异常处理器
 * @author lyf
 */
public class GlobalExectionResolver implements HandlerExceptionResolver{

	private final static Logger logger = LoggerFactory.getLogger(GlobalExectionResolver.class);
	
	@Override
	public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler,
			Exception ex) {
		//打印控制台
		ex.printStackTrace();
		//写日志
		logger.debug("测试输出的日志。。。。。。。");
		logger.info("系统发生异常了。。。。。。。");
		logger.error("系统发生异常", ex);
		//发邮件
		//使用jmail工具包。发短信使用第三方的Webservice。
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("error/msg");
		//跳转错误页面
		return modelAndView;
	}

}

package kr.or.nextit.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class InterceptorTest extends HandlerInterceptorAdapter {

	private final Logger log = LoggerFactory.getLogger(this.getClass());

	/**
	 * This implementation always returns {@code true}.
	 */
	@Override
	public boolean preHandle(
			HttpServletRequest request,
			HttpServletResponse response,
			Object handler
		) throws Exception {

		log.debug(">>> {}.preHandle()", this.getClass().getCanonicalName());
		log.debug(">>> 전처리 인터셉터");

		return true;
	}

	/**
	 * This implementation is empty.
	 */
	@Override
	public void postHandle(
			HttpServletRequest request,
			HttpServletResponse response,
			Object handler,
			ModelAndView modelAndView
		) throws Exception {
		log.debug(">>> {}.postHandle()", this.getClass().getCanonicalName());
		log.debug(">>> 후처리 인터셉터");
		
	}
}

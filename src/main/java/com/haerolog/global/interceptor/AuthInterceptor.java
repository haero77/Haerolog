package com.haerolog.global.interceptor;

import com.haerolog.global.error.exception.Unauthorized;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Slf4j
public class AuthInterceptor implements HandlerInterceptor {

	private static final String ACCESS_TOKEN = "accessToken";

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		log.info(">> preHandle");

		String accessToken = request.getParameter(ACCESS_TOKEN);

		if (StringUtils.hasText(accessToken) && accessToken.equals("hodolman")) {
			return true;
		}

		throw new Unauthorized();
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
		log.info(">> postHandle");
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
		log.info(">> afterCompletions");
	}

}

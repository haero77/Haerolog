package com.haerolog.global.config.auth;

import com.haerolog.global.error.exception.UnauthorizedException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Slf4j
public class AuthInterceptor implements HandlerInterceptor {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		log.info(">> preHandle");

		String accessToken = request.getParameter("accessToken");

		if (StringUtils.hasText(accessToken) && !accessToken.isEmpty()) {
			request.setAttribute("userName", accessToken);
			return true;
		}

		throw new UnauthorizedException();
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
	}

}

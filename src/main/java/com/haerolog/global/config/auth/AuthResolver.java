package com.haerolog.global.config.auth;

import com.haerolog.global.config.auth.data.UserSession;
import com.haerolog.global.error.exception.Unauthorized;
import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import java.util.Objects;

public class AuthResolver implements HandlerMethodArgumentResolver {

	@Override
	public boolean supportsParameter(MethodParameter parameter) {
		return parameter.getParameterType().equals(UserSession.class);
	}

	/**
	 * Argument Resolver에서 인증을 처리하는 것이 좋은지는 모르겠음.
	 */
	@Override
	public Object resolveArgument(
			MethodParameter parameter,
			ModelAndViewContainer mavContainer,
			NativeWebRequest webRequest,
			WebDataBinderFactory binderFactory
	) throws Exception {
		String accessToken = webRequest.getHeader("Authorization");

		if (Objects.isNull(accessToken) || accessToken.equals("")) {
			throw new Unauthorized();
		}

		// todo 데이터베이스 사용자 확인 작업

		return new UserSession(1L);
	}

}

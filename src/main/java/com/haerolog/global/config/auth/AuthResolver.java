package com.haerolog.global.config.auth;

import com.haerolog.domain.auth.model.Session;
import com.haerolog.domain.auth.repository.SessionRepository;
import com.haerolog.global.config.auth.data.UserSession;
import com.haerolog.global.error.exception.UnauthorizedException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.MethodParameter;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.Objects;

@Slf4j
@RequiredArgsConstructor
public class AuthResolver implements HandlerMethodArgumentResolver {

    private final SessionRepository sessionRepository;

    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        return parameter.getParameterType().equals(UserSession.class); // 파라미터 타입으로 UserSession이 있으면
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
    ) {
        HttpServletRequest servletRequest = webRequest.getNativeRequest(HttpServletRequest.class);
        if (Objects.isNull(servletRequest)) {
            log.error("servletRequest is null.");
            throw new UnauthorizedException();
        }

        Cookie[] cookies = servletRequest.getCookies();
        if (cookies.length == 0) {
            log.error("No Cookie exists.");
            throw new UnauthorizedException();
        }

        String accessToken = cookies[0].getValue();

        if (!StringUtils.hasText(accessToken)) {
            throw new UnauthorizedException();
        }

        /**
         * (호돌맨) 세션이 없다는 것 자체가 인증 오류이기 때문에 여기서 에러를 던져도 괜찮을 듯.
         */
        Session session = sessionRepository.findByAccessToken(accessToken)
                .orElseThrow(UnauthorizedException::new);

        return new UserSession(session.fetchUserId());
    }

}

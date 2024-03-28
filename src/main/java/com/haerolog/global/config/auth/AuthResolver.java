package com.haerolog.global.config.auth;

import com.haerolog.domain.auth.model.Session;
import com.haerolog.domain.auth.repository.SessionRepository;
import com.haerolog.global.config.auth.data.UserSession;
import com.haerolog.global.error.exception.UnauthorizedException;
import lombok.RequiredArgsConstructor;
import org.springframework.core.MethodParameter;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

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
    ) throws Exception {
        String accessToken = webRequest.getHeader("Authorization");

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

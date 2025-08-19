package com.dragonsky.nextpage.auth.domain.resolver;

import com.dragonsky.nextpage.config.security.auth.AuthUser;
import com.dragonsky.nextpage.config.security.auth.UserDetailsProvider;
import com.dragonsky.nextpage.auth.domain.annotation.AuthenticatedUser;
import com.dragonsky.nextpage.member.domain.repository.reader.MemberReader;
import lombok.RequiredArgsConstructor;
import org.springframework.core.MethodParameter;
import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

@Component
@RequiredArgsConstructor
public class CurrentUserArgumentResolver implements HandlerMethodArgumentResolver {

    private final UserDetailsProvider userDetailsProvider;
    private final MemberReader memberReader;

    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        return parameter.hasParameterAnnotation(AuthenticatedUser.class)
                && parameter.getParameterType().equals(AuthUser.class);
    }

    @Override
    public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer,
                                  NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (authentication == null || !(authentication.getPrincipal() instanceof AuthUser)) {
            throw new AuthenticationCredentialsNotFoundException("로그인이 필요합니다.");
        }

        return (AuthUser) authentication.getPrincipal();
    }
}

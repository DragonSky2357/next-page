package com.dragonsky.nextpage.domain.auth.resolver;

import com.dragonsky.nextpage.config.security.auth.AuthUser;
import com.dragonsky.nextpage.config.security.auth.UserDetailsProvider;
import com.dragonsky.nextpage.domain.auth.annotation.CurrentUser;
import com.dragonsky.nextpage.domain.auth.service.impl.CustomUserDetails;
import com.dragonsky.nextpage.domain.member.entity.Member;
import com.dragonsky.nextpage.domain.member.repository.reader.MemberReader;
import lombok.RequiredArgsConstructor;
import org.springframework.core.MethodParameter;
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
        return parameter.hasParameterAnnotation(CurrentUser.class)
                && parameter.getParameterType().equals(Member.class);
    }

    @Override
    public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer,
                                  NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {
        AuthUser authUser = userDetailsProvider.loadUserById()
        return memberRepository.findById(authUser.id())
                .orElseThrow(() -> new NotFoundException("사용자 없음"));
    }
}

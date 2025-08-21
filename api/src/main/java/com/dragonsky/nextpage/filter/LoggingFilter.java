package com.dragonsky.nextpage.filter;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Slf4j
@Component
public class LoggingFilter implements Filter {

    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
            throws IOException, ServletException {

        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) res;

        String ipAddress = request.getHeader("X-Forwarded-For");
        if (ipAddress == null || ipAddress.isEmpty()) {
            ipAddress = request.getRemoteAddr();
        }
        String userAgent = request.getHeader("User-Agent");
        String queryString = request.getQueryString();

        // 요청 시작 로그
        long startTime = System.currentTimeMillis();
        log.info("Request Start: {} {} ip={} ua={} params={}",
                request.getMethod(),
                request.getRequestURI(),
                ipAddress,
                userAgent,
                queryString);

        // 필터 체인 실행
        chain.doFilter(request, response);

        // 요청 완료 로그
        long duration = System.currentTimeMillis() - startTime;
        log.info("Request Complete: {} {} status={} ip={} ua={} duration={}ms",
                request.getMethod(),
                request.getRequestURI(),
                response.getStatus(),
                ipAddress,
                userAgent,
                duration);
    }
}

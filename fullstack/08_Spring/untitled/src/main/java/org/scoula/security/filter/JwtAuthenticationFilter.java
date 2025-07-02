package org.scoula.security.filter;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.scoula.security.util.JwtProcessor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
@Log4j2
@RequiredArgsConstructor
public class JwtAuthenticationFilter extends OncePerRequestFilter {
    public static final String AUTHORIZATION_HEADER = "Authorization";
    public static final String BEARER_PREFIX = "Bearer "; // 끝에 공백 있음

    //생성자 DI
    private final JwtProcessor jwtProcessor;
    private final UserDetailsService userDetailsService;

    //매개변수로 전달될 요소가 JWT (String token)
    private Authentication getAuthentication(String token) {
        String username = jwtProcessor.getUsername(token);
        UserDetails princiapl = userDetailsService.loadUserByUsername(username); //예외 발생 가능
        //첫 번째 인자 : princiapl, 세 번째 인자가 권한 목록
        return new UsernamePasswordAuthenticationToken(princiapl, null, princiapl.getAuthorities());
    }

    @Override
    //doFilter 호출
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            //예외가 발생할 수 있는 곳은?
            // 1. getAuthentication
            throws ServletException, IOException {
        String bearerToken = request.getHeader(AUTHORIZATION_HEADER);
        // null이면 로그인 안한 사용자 -> "Anonymous"
        if (bearerToken != null && bearerToken.startsWith(BEARER_PREFIX)) {
            // Bearer xxxx....
            String token = bearerToken.substring(BEARER_PREFIX.length());
            // 토큰에서 사용자 정보 추출 및 Authentication 객체 구성 후 SecurityContext에 저장
            Authentication authentication = getAuthentication(token);
            //필터의 목적이라고 볼 수 있음
            SecurityContextHolder.getContext().setAuthentication(authentication);
            //getAuthentication이라는 요소도 있음
        }
        super.doFilter(request, response, filterChain);
    }
}

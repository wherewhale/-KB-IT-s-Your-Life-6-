package org.scoula.ex04.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@WebFilter(urlPatterns={ "/*" })
public class CharacterEncodeFilter implements Filter {
    @Override
    public void init(FilterConfig fConfig) throws ServletException {
    }
    @Override
    public void destroy() {
    }
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        request.setCharacterEncoding("UTF-8");
        chain.doFilter(request, response);//다음 필터로 연결 (다음 필터로 전달되며, Servlet jsp로 전달)
    }
}

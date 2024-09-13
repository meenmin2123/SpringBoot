//package com.ss.board.filter;
//
//import org.springframework.stereotype.Component;
//import javax.servlet.FilterChain;
//import javax.servlet.FilterConfig;
//import javax.servlet.ServletException;
//import javax.servlet.ServletRequest;
//import javax.servlet.ServletResponse;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import org.springframework.stereotype.Component;
//import org.springframework.web.filter.OncePerRequestFilter;
//
//import java.io.IOException;
//
//@Component
//public class CustomUrlFilter extends OncePerRequestFilter {
//
//    @Override
//    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
//            throws ServletException, IOException {
//        String requestURI = request.getRequestURI();
//
//        // '/member'로 끝나는 요청을 '/member.do'로 리다이렉트
//        if (requestURI.equals("/member")) {
//            response.sendRedirect(request.getContextPath() + "/member.do");
//            return;
//        }
//
//        // 다음 필터 또는 리소스 호출
//        filterChain.doFilter(request, response);
//    }
//}

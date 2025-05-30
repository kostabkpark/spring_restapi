package org.example.spring_ex.filter;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletRequestWrapper;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;

@Slf4j
public class MethodConversionFilter implements Filter {
  @Override
  public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
    HttpServletRequest req = (HttpServletRequest) servletRequest;
    String methodOverride = req.getHeader("X-HTTP-Method-Override");
    if (methodOverride != null && !methodOverride.isEmpty()) {
      HttpServletRequestWrapper wrapper = new HttpServletRequestWrapper(req) {
        @Override
        public String getMethod() {
          return methodOverride;
        }
      };
      filterChain.doFilter(wrapper, servletResponse);
    } else {
      filterChain.doFilter(servletRequest, servletResponse);
    }
  }
}

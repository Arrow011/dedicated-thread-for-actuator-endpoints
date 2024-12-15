package com.example.dedicated_thread.filter;

import java.io.IOException;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class ThreadLoggingFilter implements Filter {

    private static final Logger logger = LoggerFactory.getLogger(ThreadLoggingFilter.class);

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        // Initialization logic if needed
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
            String threadName = Thread.currentThread().getName();
            String requestURI = ((HttpServletRequest) request).getRequestURI();
            logger.info("Incoming request URI: {} handled by thread: {}", requestURI, threadName);
            chain.doFilter(request, response); // Continue the filter chain
    }

    @Override
    public void destroy() {
        // Cleanup logic if needed
    }
}


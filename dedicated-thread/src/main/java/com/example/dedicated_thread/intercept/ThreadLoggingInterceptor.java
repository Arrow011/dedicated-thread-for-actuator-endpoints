package com.example.dedicated_thread.intercept;


import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
public class ThreadLoggingInterceptor implements HandlerInterceptor {

    private static final Logger logger = LoggerFactory.getLogger(ThreadLoggingInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        String threadName = Thread.currentThread().getThreadGroup().getName();
        String thread = Thread.currentThread().getName();
        String requestURI = request.getRequestURI();

        logger.info("Incoming request URI: {} handled by thread: {} name :{}", requestURI, threadName, thread);
        return true; // Continue processing
    }
}

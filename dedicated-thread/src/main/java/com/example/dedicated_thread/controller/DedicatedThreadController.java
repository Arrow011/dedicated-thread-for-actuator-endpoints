package com.example.dedicated_thread.controller;

import com.example.dedicated_thread.filter.ThreadLoggingFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicInteger;

@RestController
public class DedicatedThreadController {

    private static final Logger logger = LoggerFactory.getLogger(ThreadLoggingFilter.class);
    private static final AtomicInteger counter = new AtomicInteger(1);

    @GetMapping("/dedicated/greet")
    public String greeting() throws InterruptedException {
        logger.info("User endpoint request");
        logger.info("Count: {}", counter.getAndIncrement());
        Thread.sleep(120000);
        return "Greetings from Dedicated Thread!";
    }
}

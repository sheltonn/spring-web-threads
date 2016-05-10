package com.javaninja.spring.webmvc.threads;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Service;

import java.util.UUID;

/**
 * This is the code that controls the execution of a fixed number of worker threads.
 * @author norris.shelton
 */
@Service
public class FixedThreadService {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private ThreadPoolTaskExecutor taskExecutor;

    @Autowired
    private ThreadWorker worker1;

    @Autowired
    private ThreadWorker worker2;

    @Autowired
    private ThreadWorker worker3;

    @Autowired
    private ThreadWorker worker4;

    @Autowired
    private ThreadWorker worker5;

    public String withFixedThreads() {
        worker1.setUniqueInfo("1");
        taskExecutor.execute(worker1);

        worker2.setUniqueInfo("2");
        taskExecutor.execute(worker2);

        worker3.setUniqueInfo("3");
        taskExecutor.execute(worker3);

        worker4.setUniqueInfo("4");
        taskExecutor.execute(worker4);

        worker5.setUniqueInfo("5");
        taskExecutor.execute(worker5);

        return UUID.randomUUID().toString();
    }
}

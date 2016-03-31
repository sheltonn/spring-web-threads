package com.javaninja.spring.web.threads;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Service;

/**
 * @author norris.shelton
 */
@Service
public class MyService {

    @Autowired
    private ThreadPoolTaskExecutor taskExecutor;

    @Autowired
    private MyWorker worker1;

    @Autowired
    private MyWorker worker2;

    @Autowired
    private MyWorker worker3;

    @Autowired
    private MyWorker worker4;

    @Autowired
    private MyWorker worker5;

    public void doStuff() {
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

        for (; ; ) {
            int count = taskExecutor.getActiveCount();
            System.out.println("Active Threads : " + count);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (count == 0) {
                taskExecutor.shutdown();
                break;
            }
        }
    }
}

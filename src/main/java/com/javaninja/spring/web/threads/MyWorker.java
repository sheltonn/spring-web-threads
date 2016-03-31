package com.javaninja.spring.web.threads;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.UUID;

/**
 * @author norris.shelton
 */
@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class MyWorker implements Runnable {

    private Logger logger = LoggerFactory.getLogger(getClass());

    private String uniqueInfo;

    private List<String> data = new LinkedList<>();

    public String getUniqueInfo() {
        return uniqueInfo;
    }

    public void setUniqueInfo(String uniqueInfo) {
        this.uniqueInfo = uniqueInfo;
    }

    public List<String> getData() {
        return data;
    }

    public void setData(List<String> data) {
        this.data = data;
    }

    /**
     * When an object implementing interface <code>Runnable</code> is used to create a thread, starting the thread
     * causes the object's <code>run</code> method to be called in that separately executing thread.
     * <p>
     * The general contract of the method <code>run</code> is that it may take any action whatsoever.
     * @see Thread#run()
     */
    @Override
    public void run() {
        logger.info("Started runner {}", uniqueInfo);

        try {
            Thread.sleep(new Random().nextInt(5000));
        } catch (InterruptedException e) {
            logger.error("Trouble with thread", e);
        }

        // simulating having results
        for (int i = 0; i < 5; i++) {
            data.add(UUID.randomUUID().toString());
        }

        logger.info("Runner {} finishing data={}", uniqueInfo, data);
    }
}

package com.javaninja.spring.webmvc.threads;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
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
public class ThreadWorker implements Runnable {

    private Logger logger = LoggerFactory.getLogger(getClass());

    private String uniqueInfo;

    private List<String> data = new LinkedList<>();


    public void setUniqueInfo(String uniqueInfo) {
        this.uniqueInfo = uniqueInfo;
    }

    public List<String> getData() {
        return data;
    }


    /**
     * When an object implementing interface {@code Runnable} is used to create a thread, starting the thread
     * causes the object's {@code run} method to be called in that separately executing thread.
     * <p>
     * The general contract of the method {@code run} is that it may take any action whatsoever.
     * @see Thread#run()
     */
    @Override
    public void run() {
        logger.info("Started runner {}", uniqueInfo);

        try {
            int milliseconds = new Random().nextInt(10000);
            logger.info("{} sleeping for {} ms", uniqueInfo, milliseconds);
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            logger.error("Trouble with thread", e);
        }

        // simulating having results
        for (int i = 0; i < 5; i++) {
            data.add(UUID.randomUUID().toString());
        }

        logger.info("Runner {} finishing data={}", uniqueInfo, data);
    }

    /**
     * Returns a string representation of the object. In general, the {@code toString} method returns a string that
     * "textually represents" this object. The result should be a concise but informative representation that is easy
     * for a person to read. It is recommended that all subclasses override this method.
     * <p>
     * The {@code toString} method for class {@code Object} returns a string consisting of the name of the class of
     * which the object is an instance, the at-sign character `{@code @}', and the unsigned hexadecimal representation
     * of the hash code of the object. In other words, this method returns a string equal to the value of: <blockquote>
     * <pre>
     * getClass().getName() + '@' + Integer.toHexString(hashCode())
     * </pre> </blockquote>
     * @return a string representation of the object.
     */
    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this);
    }
}

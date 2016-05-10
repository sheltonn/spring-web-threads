package com.javaninja.spring.webmvc.threads;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanInitializationException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ApplicationContextException;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.context.MessageSourceAware;
import org.springframework.context.ResourceLoaderAware;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Service;

import java.util.UUID;

/**
 * This is the code that controls the execution of a dynamic number of worker threads.
 * @author norris.shelton
 */
@Service
public class DynamicThreadService implements ApplicationContextAware {

    private ApplicationContext applicationContext;

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private ThreadPoolTaskExecutor taskExecutor;

    /**
     * Set the ApplicationContext that this object runs in. Normally this call will be used to initialize the object.
     * <p>Invoked after population of normal bean properties but before an init callback such as {@link
     * InitializingBean#afterPropertiesSet()} or a custom init-method. Invoked after {@link
     * ResourceLoaderAware#setResourceLoader}, {@link ApplicationEventPublisherAware#setApplicationEventPublisher} and
     * {@link MessageSourceAware}, if applicable.
     * @param applicationContext the ApplicationContext object to be used by this object
     * @throws ApplicationContextException in case of context initialization errors
     * @throws BeansException              if thrown by application context methods
     * @see BeanInitializationException
     */
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    public String withDynamicThreads(int threads) {

        ThreadWorker threadWorker = null;
        for (int i = 0; i < threads; i++) {
            threadWorker = applicationContext.getBean("threadWorker", ThreadWorker.class);
            threadWorker.setUniqueInfo(String.valueOf(i));
            taskExecutor.execute(threadWorker);
        }

        return UUID.randomUUID().toString();
    }
}

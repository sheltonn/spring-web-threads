package com.javaninja.spring.web.threads;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author norris.shelton
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
public class TestMyService {

    @Autowired
    private MyService myService;

    @Test
    public void doStuff() throws Exception {
        myService.doStuff();
    }

}
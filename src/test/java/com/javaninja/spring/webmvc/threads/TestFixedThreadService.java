package com.javaninja.spring.webmvc.threads;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertNotNull;

/**
 * @author norris.shelton
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
public class TestFixedThreadService {

    @Autowired
    private FixedThreadService fixedThreadService;

    @Test
    public void withFixedThreads() throws Exception {
        String result = fixedThreadService.withFixedThreads();
        assertNotNull(result);
    }
}
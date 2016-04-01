package com.javaninja.spring.webmvc.threads;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author norris.shelton
 */
@Controller
public class ThreadController {

    @Autowired
    private FixedThreadService fixedThreadService;

    @Autowired
    private DynamicThreadService dynamicThreadService;

    @RequestMapping("/fixedWorkers")
    public ModelAndView fixedWorkers() {
        ModelAndView modelAndView = new ModelAndView("thread");
        modelAndView.addObject("result", fixedThreadService.withFixedThreads());
        return modelAndView;
    }
    @RequestMapping("/dynamicWorkers")
    public ModelAndView dynamicWorkers() {
        ModelAndView modelAndView = new ModelAndView("thread");
        modelAndView.addObject("result", dynamicThreadService.withDynamicThreads(10));
        return modelAndView;
    }
}

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
    private ThreadService threadService;

    @RequestMapping("/thread")
    public ModelAndView thread() {
        ModelAndView modelAndView = new ModelAndView("thread");
        modelAndView.addObject("result", threadService.doStuff());
        return modelAndView;
    }
}

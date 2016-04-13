package com.huaxun.smart.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by lhy on 2016-04-09.
 */
public class BaseController {

    @RequestMapping(value = "failure")
    public ModelAndView failure()
    {
        // casFilter - failureUrl
        ModelAndView mav = new ModelAndView("failure");
        return mav;
    }

    @RequestMapping(value = "unauthorized")
    public ModelAndView unauthorized()
    {
        ModelAndView mav = new ModelAndView("unauthorized");
        return mav;
    }

    @RequestMapping(value = "unauthenticated")
    public ModelAndView unauthenticated()
    {
        ModelAndView mav = new ModelAndView("unauthenticated");
        return mav;
    }

    @RequestMapping(value = "e404")
    public ModelAndView e400()
    {
        ModelAndView mav = new ModelAndView("404");
        return mav;
    }

    @RequestMapping(value = "e500")
    public ModelAndView e500()
    {
        ModelAndView mav = new ModelAndView("500");
        return mav;
    }
}

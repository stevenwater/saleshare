package com.saleshare.demo.controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/demo")
public class DemoAction {
	Logger logger = Logger.getLogger(getClass());

	@RequestMapping("show")
	public ModelAndView show() {
		ModelAndView mv = new ModelAndView();
		logger.info("invoking DemoAction->showDemo");;
		mv.setViewName("demo/jsp_test");
		mv.addObject("demo", "hello spring mvc");
		return mv;
	}

}

package com.saleshare.demo.controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.saleshare.demo.Demo;

@Controller
@RequestMapping("/demo")
public class FreemarkerDemoAction {
	public final Logger logger = Logger.getLogger(getClass());
	
	@RequestMapping("freemarker")
	public String showFreemarker(@ModelAttribute("demo") Demo demo){
		logger.info("FreemarkerDemoAction->showFreemarker");;
		demo.setCode(200);
		demo.setDesc("freemarker test");
		return "demo/freemarker_test";
	}

}

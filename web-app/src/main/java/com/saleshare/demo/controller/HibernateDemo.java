package com.saleshare.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.saleshare.demo.entity.Demo;
import com.saleshare.demo.service.DemoService;

@Controller
@RequestMapping("/demo")
public class HibernateDemo {
	
	@Autowired
	private DemoService demoService;
	

	@RequestMapping("save")
	public ModelAndView saveDemo(@ModelAttribute Demo demo){
		ModelAndView mv = new ModelAndView();
		demo.setCode(200);
		demo.setDesc("hello world");
		demoService.save(demo);
		mv.addObject("result", "successful");
		mv.setViewName("demo/hibernate_test");
		return mv;
	}
	
	@RequestMapping("delete/{id}")
	public ModelAndView deleteDemo(@PathVariable int id){
		demoService.delete(Demo.class, id);
		ModelAndView mv = new ModelAndView();
		mv.addObject("result", "successful");
		mv.setViewName("demo/hibernate_test");
		return mv;
	}
	
	@RequestMapping("doubleSave")
	public ModelAndView doubleDemo(){
		Demo demo = new Demo();
		demo.setDesc("double save demo description");
		demo.setCode(400);
		demoService.saveDoubleDemo(demo);
		ModelAndView mv = new ModelAndView();
		mv.addObject("result", "successful");
		mv.setViewName("demo/hibernate_test");
		return mv;
	}
}

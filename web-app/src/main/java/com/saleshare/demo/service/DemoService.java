package com.saleshare.demo.service;

import com.saleshare.common.service.BasicService;
import com.saleshare.demo.entity.Demo;

public interface DemoService extends BasicService<Demo>{
	
	public void saveDoubleDemo(Demo demo);

}

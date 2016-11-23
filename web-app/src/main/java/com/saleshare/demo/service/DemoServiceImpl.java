package com.saleshare.demo.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.saleshare.common.service.BasicServiceImpl;
import com.saleshare.demo.entity.Demo;

@Service
public class DemoServiceImpl extends BasicServiceImpl<Demo> implements DemoService{

	@Override
	@Transactional(readOnly = false,rollbackFor = { Exception.class, RuntimeException.class })
	public void saveDoubleDemo(Demo demo) {
		save(demo);
		getSession().clear();
		save(demo);
	}

}

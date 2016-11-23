package com.saleshare.common.service;

import java.io.Serializable;

public interface BasicService<T> {

	public void save(T entity);
	
	public void delete(Class<T> clasz, Serializable id);
	
	public void update(T entity);
	
	public T findById(Class<T> clasz, Serializable id);
}

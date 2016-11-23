package com.saleshare.common.service;

import java.io.Serializable;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

@Service
@Transactional(readOnly = true)
public class BasicServiceImpl<T> implements BasicService<T>{

	public Logger logger = Logger.getLogger(getClass());

	@Autowired
	private SessionFactory sessionFactory;

	public Session getSession() {
		return this.sessionFactory.getCurrentSession();
	}

	public void flush() {
		getSession().flush();
	}

	@Override
	@Transactional(readOnly = false, rollbackFor = { Exception.class, RuntimeException.class })
	public void save(T entity) {
		Assert.notNull(entity, "entity should not be empty");
		getSession().save(entity);
	}

	@Override
	@Transactional(readOnly = false, rollbackFor = { Exception.class, RuntimeException.class })
	public void delete(Class<T> clasz, Serializable id) {
		Assert.notNull(id, "id should not be null");
		getSession().delete(findById(clasz, id));

	}

	@Override
	@Transactional(readOnly = false, rollbackFor = { Exception.class, RuntimeException.class })
	public void update(T entity) {
		Assert.notNull(entity, "entity should not be empty");
		getSession().update(entity);
	}

	@Override
	@SuppressWarnings("unchecked")
	public T findById(Class<T> clasz, Serializable id) {
		return (T) getSession().get(clasz, id);
	}

}

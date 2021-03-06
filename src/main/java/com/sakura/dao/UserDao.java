package com.sakura.dao;

import java.util.ArrayList;
import java.util.List;

import net.spy.memcached.spring.MemcachedClientFactoryBean;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.classic.Session;
import org.springframework.orm.hibernate3.HibernateTemplate;

import com.googlecode.hibernate.memcached.MemcacheClientFactory;
import com.googlecode.hibernate.memcached.spymemcached.SpyMemcache;
import com.googlecode.hibernate.memcached.spymemcached.SpyMemcacheClientFactory;
import com.sakura.entity.User;

public class UserDao {
	
	private HibernateTemplate hibernateTemplate;
	
	public void save(User user) {
		SessionFactory sessionFactory = hibernateTemplate.getSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.saveOrUpdate(user);
		tx.commit();
		session.close();
	}

	public List<User> list() {
		List<User> list = new ArrayList<User>();
		SessionFactory sessionFactory = hibernateTemplate.getSessionFactory();
		Session session = sessionFactory.openSession();
		long start = System.currentTimeMillis();
		list.add((User) session.load(User.class, 1L));
		list.add((User) session.load(User.class, 2L));
		long end = System.currentTimeMillis();
		System.out.println(end - start);
		return list;
	}
	
	public User view(Long id) {
		SessionFactory sessionFactory = hibernateTemplate.getSessionFactory();
		Session session = sessionFactory.openSession();
		long start = System.currentTimeMillis();
		User user = (User) session.load(User.class, id);
		long end = System.currentTimeMillis();
		System.err.println(end - start);
		return user;
	}
	
	/**
	 * @return the hibernateTemplate
	 */
	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	/**
	 * @param hibernateTemplate the hibernateTemplate to set
	 */
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
	
}

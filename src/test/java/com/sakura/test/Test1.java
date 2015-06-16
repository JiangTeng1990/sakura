package com.sakura.test;

import java.util.List;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sakura.dao.UserDao;
import com.sakura.entity.User;


public class Test1 {
	
	@Test
	public void testSaveuser() {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		UserDao userDao = (UserDao) context.getBean("userDao");
		
		User user = new User();
		user.setName("LiuBei");
		user.setPassword("99999");
		
		userDao.save(user);
	}
	
	@Test
	public void testSelectUser() {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		UserDao userDao = (UserDao)context.getBean("userDao");
		List<User> list = userDao.list();
		for(User user : list) {
			System.out.println(user);
		}
	}
	
	@Test
	public void testCache() {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		UserDao userDao = (UserDao)context.getBean("userDao");
		long id1 = 1L;
		long id2 = 2L;
//		for(int i = 0; i < 3; i++) {
//			User user1 = userDao.view(id1);
//			System.out.println(user1);
//			User user2 = userDao.view(id2);
//			System.out.println(user2);
//		}
		User user1 = userDao.view(id1);
		System.out.println(user1);
	}
}

package com.yayao.service.impl.test;

import static org.junit.Assert.*;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;

import com.yayao.bean.User;
import com.yayao.service.UserService;
@SuppressWarnings("deprecation")
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:config/applicationContext.xml"})
@TransactionConfiguration(transactionManager="txManager",defaultRollback = false)//true:始终回滚 false:数据提交
public class UserServiceImplTest {
	@Autowired
	@Qualifier("userService")
	UserService userService;
	@Autowired
	@Qualifier("sessionFactory")
	SessionFactory sessionFactory;
	Session session;
	@Before
	public void setUp() throws Exception {
		session=sessionFactory.openSession();
		System.out.println(session);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testUserLogin() {
		User user = userService.userLogin("聂跃2", "123456");
		System.out.println(user);
	}

	@Test
	public void testChkLoginName() {
		 boolean status = userService.chkLoginName("聂跃");
		 Assert.assertEquals(true, status);;
		 System.out.println(status);
	}

	@Test
	public void testRetrieveAccount() {
		fail("Not yet implemented");
	}

	@Test
	public void testAddUser() {
		//UserLevel userlevel=new UserLevel();
		//userlevel.setUserGrade(1);
		User user =new User();
		//user.setUserLevel(userlevel);
		user.setIntegral(new Integer(1));
		user.setUserName("聂跃");
		user.setUserPassword("123456");
		System.out.println("dsf");
		userService.addUser(user);
	}

	@Test
	public void testUpdateUser() {
		User u = userService.loadUser(1);
		//UserLevel ul = userService.loadUserLevel(1);
		//ul=null;
		//u.setUserLevel(ul);
		userService.updateUser(u);
	}

	@Test
	public void testSearchUser() {
		fail("Not yet implemented");
	}

	@Test
	public void testBrowseUser() {
		fail("Not yet implemented");
	}

	@Test
	public void testAdminBrowseUser() {
		fail("Not yet implemented");
	}

	@Test
	public void testDelUser() {
		fail("Not yet implemented");
	}

	@Test
	public void testLoadUser() {
		User u = userService.loadUser(1);
		System.out.println(u);
	}

}

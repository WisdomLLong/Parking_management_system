package service.impl;

import org.junit.Test;

import entity.Users;
import junit.framework.Assert;
import service.UsersDAO;

public class TestUsersDAOImpl {
	
	@Test
	public void testUsersLogin()
	{
		Users u = new Users(1,"zhangsan","123456");
		UsersDAO udao = new UsersDAOImpl();
		Assert.assertEquals(true, udao.usersLogin(u));
		//Junit的断言方法，判断输入的两个参数是否相等
	}
}

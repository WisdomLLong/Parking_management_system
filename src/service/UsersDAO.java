package service;

import entity.Users;

//用户业务逻辑接口
public interface UsersDAO {
	
	//用户登录方法
	public boolean usersLogin(Users u);
	
	//存储值班人员登出时间
	public boolean Saveouttime();
}


package service;

import entity.Users;

//�û�ҵ���߼��ӿ�
public interface UsersDAO {
	
	//�û���¼����
	public boolean usersLogin(Users u);
	
	//�洢ֵ����Ա�ǳ�ʱ��
	public boolean Saveouttime();
}


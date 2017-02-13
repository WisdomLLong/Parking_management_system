package service;

import java.util.List;

import entity.Cars;

//������ҵ���߼��ӿ�
public interface CarsDAO{

	//��ѯ���г�������
	public List<Cars> queryAllCars();
	
	//��ѯ���г�������
	public List<Cars> querysaveAllCars();

	//���ݳ�����Ų�ѯ��������
	public Cars queryCarsByCid(String cid);

	//��ӳ�������
	public boolean addCars(Cars c);

	//�޸ĳ�������
	public boolean updateCars(Cars c);

	//ɾ����������
	public boolean deleteCars(String cid);
	


}
package service;

import java.util.List;

import entity.Cars;

//车辆的业务逻辑接口
public interface CarsDAO{

	//查询所有车辆资料
	public List<Cars> queryAllCars();
	
	//查询所有车辆资料
	public List<Cars> querysaveAllCars();

	//根据车辆编号查询车辆资料
	public Cars queryCarsByCid(String cid);

	//添加车辆资料
	public boolean addCars(Cars c);

	//修改车辆资料
	public boolean updateCars(Cars c);

	//删除车辆资料
	public boolean deleteCars(String cid);
	


}
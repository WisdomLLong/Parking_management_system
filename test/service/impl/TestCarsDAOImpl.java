package service.impl;

import java.util.Date;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import entity.Cars;
import service.CarsDAO;

public class TestCarsDAOImpl{

	@Test
	public void testQueryAllCars()
	{
		CarsDAO sdao = new CarsDAOImpl();
		List<Cars> list = sdao.queryAllCars();
//		System.out.println(list);
		for(int i=0;i<list.size(); i++)
		{
			System.out.println(list.get(i));
		}
	}

	@Test
	public void testGetNewCid()
	{
		CarsDAOImpl sdao = new CarsDAOImpl();
		System.out.println(sdao.getNewCid());
	}
	
	@Test
	public void testAddCars()
	{
		Cars c = new Cars();
		c.setCnum("��Y AB666");
		c.setName("С��");
		c.setCbrand("����");
		c.setCtype("С�ͳ�");
		c.setCtime(new Date());
		CarsDAO sdao = new CarsDAOImpl();
		Assert.assertEquals(true, sdao.addCars(c));
	}
}
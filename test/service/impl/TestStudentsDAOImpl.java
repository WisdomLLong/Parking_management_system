package service.impl;

import java.util.Date;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import entity.Students;
import service.StudentsDAO;

public class TestStudentsDAOImpl{

	@Test
	public void testQueryAllStudents()
	{
		StudentsDAO sdao = new StudentsDAOImpl();
		List<Students> list = sdao.queryAllStudents();
//		System.out.println(list);
		for(int i=0;i<list.size(); i++)
		{
			System.out.println(list.get(i));
		}
	}

	@Test
	public void testGetNewSid()
	{
		StudentsDAOImpl sdao = new StudentsDAOImpl();
		System.out.println(sdao.getNewSid());
	}
	
	@Test
	public void testAddStudents()
	{
		Students s = new Students();
		s.setSname("张三丰");
		s.setGender("男");
		s.setBirthday(new Date());
		s.setAddress("武当山");
		StudentsDAO sdao = new StudentsDAOImpl();
		Assert.assertEquals(true, sdao.addStudents(s));
	}
}
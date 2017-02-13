package service.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import db.MyHibernateSessionFactory;
import entity.Students;
import service.StudentsDAO;
//学生业务逻辑接口的实现类
public class StudentsDAOImpl implements StudentsDAO{

	//查询所有学生资料
	public List<Students> queryAllStudents(){

		Transaction tx = null;
		List<Students> list = null;
		String  hql = "";
		try
		{
			Session session = MyHibernateSessionFactory.getSessionFactory().getCurrentSession();
			tx = session.beginTransaction();
			hql = "from Students";
			Query query = session.createQuery(hql);

			list = query.list();
			tx.commit();

			return list;
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			tx.commit();
			return list;
		}
		finally
		{
			if(tx!=null)
			{
				tx = null;
			}
		}
	}

	public Students queryStudentsBySid(String sid){

		Transaction tx = null;
		Students s = null;
		String  hql = "";
		try
		{
			Session session = MyHibernateSessionFactory.getSessionFactory().getCurrentSession();
			tx = session.beginTransaction();
			s = (Students)session.get(Students.class, sid);
			tx.commit();

			return s;
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			tx.commit();
			return s;
		}
		finally
		{
			if(tx!=null)
			{
				tx = null;
			}
		}
	}


	public boolean deleteStudents(String sid){
		Transaction tx = null;
		try
		{
			Session session = MyHibernateSessionFactory.getSessionFactory().getCurrentSession();
			tx = session.beginTransaction();
			Students s = (Students)session.get(Students.class, sid);
			session.delete(s);
			tx.commit();
			return true;

		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return false;

		}
		finally
		{
			if(tx!=null)
			{
				tx = null;
			}
		}
	}

	//生成学生的学号
	public String getNewSid()
	{
		Transaction tx =null;
		String hql = "";
		try
		{
			Session session = MyHibernateSessionFactory.getSessionFactory().getCurrentSession();
			tx = session.beginTransaction();
			//获得当前学生的最大编号
			hql = "select max(sid) from Students";
			Query query = session.createQuery(hql);
			String sid = (String)query.uniqueResult();
			if(sid==null||"".equals(sid))
			{
				//给一个默认的最大的编号
				sid = "S0000001";
			}
			else
			{
				String temp = sid.substring(1);
				//去掉第一个符号，只取后面的七位数字
				int i = Integer.parseInt(temp);
				//转化为数字类型
				i++;
				//还原为字符串
				temp = String.valueOf(i);
				int len = temp.length();
				//凑够七位
				for(int j=0 ; j<7-len;j++)
				{
					temp="0"+temp;
				}
				sid = "S"+temp;
			}
			tx.commit();
			return sid;
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			tx.commit();
			return "false";

		}
		finally
		{
			if(tx!=null)
			{
				tx = null;
			}
		}
}

	@Override
	public boolean addStudents(Students s) {
		// TODO Auto-generated method stub
		s.setSid(getNewSid());
		Transaction tx = null;
		String hql = "";
		try
		{
			Session session = MyHibernateSessionFactory.getSessionFactory().getCurrentSession();
			tx = session.beginTransaction();
			session.save(s);
			tx.commit();
			return true;
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return false;
		}
		finally
		{
			if(tx!=null)
			{
				tx = null;
			}
		}
	}

	@Override
	public boolean updateStudents(Students s) {
		// TODO Auto-generated method stub
		Transaction tx = null;

		try
		{
			Session session = MyHibernateSessionFactory.getSessionFactory().getCurrentSession();
			tx = session.beginTransaction();
			session.update(s);
			tx.commit();
			return true;
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			tx.commit();
			return false;
		}
		finally
		{
			if(tx!=null)
			{
				tx = null;
			}
		}
	}
}
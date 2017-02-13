package service.impl;

import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import db.MyHibernateSessionFactory;
import entity.Cars;
import entity.Users;
import service.UsersDAO;

public class UsersDAOImpl implements UsersDAO{

	@Override
	public boolean usersLogin(Users u) {
		// TODO Auto-generated method stub
		//事务对象
		Transaction tx = null;
		String hql = "";
		try
		{
			Session session = MyHibernateSessionFactory.getSessionFactory().getCurrentSession();
			//.getCurrentSession()方法并没有定义，为什么可以使用？
			//因为MyHibernateSessionFactory.getSessionFactory()相当于已经生成了一个sessionFactory实例
			//但又为什么不直接返回一个session实例呢？
			
			tx = session.beginTransaction();
			//条件查询，参数索引值从0开始，索引位置。通过setString,serParameter设置参数
			hql = "from Users where username=? and password=? ";
			Query query = session.createQuery(hql);
			query.setParameter(0, u.getUsername());
			query.setParameter(1, u.getPassword());
			List list = query.list();
			
			
			tx.commit();//提交事务
			if(list.size()>0)
			{
				return true;
			}
			else
			{
				return false;
			}
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
				//tx.commit();
				tx = null;
			}
		}
	}
	
	@Override
	public boolean Saveouttime(){
		
		Transaction tx = null;
		String hql = "";
		try
		{	
			int worker = getNewWid();
			System.out.println("当前值班人的id是"+getNewWid());
			
			Session session = MyHibernateSessionFactory.getSessionFactory().getCurrentSession();	
			tx = session.beginTransaction();
			//条件查询，参数索引值从0开始，索引位置。通过setString,serParameter设置参数
			hql = "update Workers w set w.workerouttime=? where w.wid=?";
			Query query = session.createQuery(hql);
			query.setParameter(0, new Date());
			query.setParameter(1, worker);
			boolean issuccess = (query.executeUpdate()>0);
			tx.commit();//提交事务
			if(issuccess)
			{
				return true;
			}
			else
			{
				return false;
			}
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
				//tx.commit();
				tx = null;
			}
		}
		
	}
	
	public int getNewWid()
	{

//			Session session = MyHibernateSessionFactory.getSessionFactory().getCurrentSession();
//			Transaction tx = session.beginTransaction();
//			//获得当前车辆的最大编号
//			String hql = "select max(wid) from Workers";
//			Query query = session.createQuery(hql);
//			int wid = (int)query.uniqueResult();
//			tx.commit();
//			tx = null;
//			return wid;
			
			Transaction tx =null;
			String hql = "";
			try
			{
				Session session = MyHibernateSessionFactory.getSessionFactory().getCurrentSession();
				tx = session.beginTransaction();
				//获得当前车辆的最大编号
				hql = "select max(wid) from Workers";
				Query query = session.createQuery(hql);
				int wid = (int)query.uniqueResult();
				tx.commit();
				return wid;
			}
			catch(Exception ex)
			{
				ex.printStackTrace();
				tx.commit();
				return 0;

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

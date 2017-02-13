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
		//�������
		Transaction tx = null;
		String hql = "";
		try
		{
			Session session = MyHibernateSessionFactory.getSessionFactory().getCurrentSession();
			//.getCurrentSession()������û�ж��壬Ϊʲô����ʹ�ã�
			//��ΪMyHibernateSessionFactory.getSessionFactory()�൱���Ѿ�������һ��sessionFactoryʵ��
			//����Ϊʲô��ֱ�ӷ���һ��sessionʵ���أ�
			
			tx = session.beginTransaction();
			//������ѯ����������ֵ��0��ʼ������λ�á�ͨ��setString,serParameter���ò���
			hql = "from Users where username=? and password=? ";
			Query query = session.createQuery(hql);
			query.setParameter(0, u.getUsername());
			query.setParameter(1, u.getPassword());
			List list = query.list();
			
			
			tx.commit();//�ύ����
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
			System.out.println("��ǰֵ���˵�id��"+getNewWid());
			
			Session session = MyHibernateSessionFactory.getSessionFactory().getCurrentSession();	
			tx = session.beginTransaction();
			//������ѯ����������ֵ��0��ʼ������λ�á�ͨ��setString,serParameter���ò���
			hql = "update Workers w set w.workerouttime=? where w.wid=?";
			Query query = session.createQuery(hql);
			query.setParameter(0, new Date());
			query.setParameter(1, worker);
			boolean issuccess = (query.executeUpdate()>0);
			tx.commit();//�ύ����
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
//			//��õ�ǰ�����������
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
				//��õ�ǰ�����������
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

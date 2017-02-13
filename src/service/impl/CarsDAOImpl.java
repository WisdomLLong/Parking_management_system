package service.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import db.MyHibernateSessionFactory;
import entity.Cars;
import service.CarsDAO;
//ѧ��ҵ���߼��ӿڵ�ʵ����
public class CarsDAOImpl implements CarsDAO{

	//��ѯ����ѧ������
	public List<Cars> queryAllCars(){

		Transaction tx = null;
		List<Cars> list = null;
		String  hql = "";
		try
		{
			Session session = MyHibernateSessionFactory.getSessionFactory().getCurrentSession();
			tx = session.beginTransaction();
			hql = "from Cars";
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
	
	public List<Cars> querysaveAllCars(){

		Transaction tx = null;
		List<Cars> list = null;
		String  hql = "";
		try
		{
			Session session = MyHibernateSessionFactory.getSessionFactory().getCurrentSession();
			tx = session.beginTransaction();
			hql = "from CarsSave";
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

	public Cars queryCarsByCid(String cid){

		Transaction tx = null;
		Cars c = null;
		try
		{
			Session session = MyHibernateSessionFactory.getSessionFactory().getCurrentSession();
			tx = session.beginTransaction();
			c = (Cars)session.get(Cars.class, cid);
			tx.commit();

			return c;
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			tx.commit();
			return c;
		}
		finally
		{
			if(tx!=null)
			{
				tx = null;
			}
		}
	}


	public boolean deleteCars(String cid){
		Transaction tx = null;
		try
		{
			Session session = MyHibernateSessionFactory.getSessionFactory().getCurrentSession();
			tx = session.beginTransaction();
			Cars s = (Cars)session.get(Cars.class, cid);
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

	//���ɳ�������
	public String getNewCid()
	{
		Transaction tx =null;
		String hql = "";
		try
		{
			Session session = MyHibernateSessionFactory.getSessionFactory().getCurrentSession();
			tx = session.beginTransaction();
			//��õ�ǰ�����������
			hql = "select max(cid) from Cars";
			Query query = session.createQuery(hql);
			String cid = (String)query.uniqueResult();
			if(cid==null||"".equals(cid))
			{
				//��һ��Ĭ�ϵ����ı��
				cid = "C0000001";
			}
			else
			{
				String temp = cid.substring(1);
				//ȥ����һ�����ţ�ֻȡ�������λ����
				int i = Integer.parseInt(temp);
				//ת��Ϊ��������
				i++;
				//��ԭΪ�ַ���
				temp = String.valueOf(i);
				int len = temp.length();
				//�չ���λ
				for(int j=0 ; j<7-len;j++)
				{
					temp="0"+temp;
				}
				cid = "C"+temp;
			}
			tx.commit();
			return cid;
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
	public boolean addCars(Cars c) {
		// TODO Auto-generated method stub
		c.setCid(getNewCid());
		Transaction tx = null;
		String hql = "";
		try
		{
			Session session = MyHibernateSessionFactory.getSessionFactory().getCurrentSession();
			tx = session.beginTransaction();
			session.save(c);
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
	public boolean updateCars(Cars c) {
		// TODO Auto-generated method stub
		Transaction tx = null;
		try
		{
			Session session = MyHibernateSessionFactory.getSessionFactory().getCurrentSession();
			tx = session.beginTransaction();
			session.update(c);
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
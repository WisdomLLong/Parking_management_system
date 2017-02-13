package service.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import db.MyHibernateSessionFactory;
import entity.Cars;
import entity.Workers;
import service.WorkersDAO;

public class WorkersDAOImpl implements WorkersDAO{

	@Override
	public boolean addWorkers(Workers w) {
		// TODO Auto-generated method stub
		Transaction tx = null;
		try
		{
			Session session = MyHibernateSessionFactory.getSessionFactory().getCurrentSession();
			tx = session.beginTransaction();
			session.save(w);
//			System.out.println("ֵ����Ա����ɹ�");
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

			
		//�õ�ֵ����Ա������
				public String getWorkername()
				{
					Transaction tx =null;
					String hql = "";
					try
					{
						Session session = MyHibernateSessionFactory.getSessionFactory().getCurrentSession();
						tx = session.beginTransaction();
						//������һ��ֵ����Ա������
						hql = "select max(workername) from Workers";
						Query query = session.createQuery(hql);
						String workername = (String)query.uniqueResult();
						tx.commit();
						return workername;
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
				
		public List<Workers> queryAllWorkers() {
			Transaction tx = null;
			List<Workers> list = null;
			String  hql = "";
			try
			{
				Session session = MyHibernateSessionFactory.getSessionFactory().getCurrentSession();
				tx = session.beginTransaction();
				hql = "from Workers";
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
}

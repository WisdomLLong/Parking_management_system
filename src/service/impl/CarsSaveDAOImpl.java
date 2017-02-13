package service.impl;

import org.hibernate.Session;
import org.hibernate.Transaction;

import db.MyHibernateSessionFactory;
import entity.CarsSave;
import service.CarsSaveDAO;

public class CarsSaveDAOImpl implements CarsSaveDAO{

	@Override
	public boolean addCarsSave(CarsSave c) {
		// TODO Auto-generated method stub
		Transaction tx = null;
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

}

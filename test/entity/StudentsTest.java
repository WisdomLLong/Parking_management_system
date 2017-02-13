package entity;


import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import org.hibernate.tool.hbm2ddl.SchemaExport;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import entity.Students;
import db.MyHibernateSessionFactory;

//������
public class StudentsTest {
	
	private SessionFactory sessionFactory;
	private Session session;
	private Transaction transaction;
	
	@Before
	public void init()
	{
		//�������ö���
		Configuration config = new Configuration().configure();
		//��������ע�����
		ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(config.getProperties()).buildServiceRegistry();
		//�����Ự��������
		sessionFactory = config.buildSessionFactory(serviceRegistry);
		//�Ự����
		session = sessionFactory.openSession();
		//��������
		transaction = session.beginTransaction();
	}
	
	@After
	public void destory()
	{
		transaction.commit();//�ύ����
		session.close();//�رջỰ
		sessionFactory.close();//�رջỰ����
	}

	@Test
	public void NewTable()
	{//�����յı�ṹ
		//�������ö���
		Configuration config = new Configuration().configure();
		SchemaExport export = new SchemaExport(config);
		export.create(true , true);
		//��һ��true��ʾ���ɱ�ṹ���ڶ���true��ʾ���sql���
	}
}

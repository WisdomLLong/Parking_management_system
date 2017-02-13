package entity;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import org.junit.Test;

public class TestStudetns {
	
	//���Ӳ�������
		@Test
		public void testSaveStudents()
		{
			//�������ö���
			Configuration config = new Configuration().configure();
			//��������ע�����
			ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(config.getProperties()).buildServiceRegistry();
			//�����Ự��������
			SessionFactory sessionFactory = config.buildSessionFactory(serviceRegistry);
			//�Ự����
			Session session = sessionFactory.getCurrentSession();
			//�����������
			Transaction tx= session.beginTransaction();

			Students s1 = new Students("S0000001","������","��",new Date(),"�䵱ɽ");
			Students s2 = new Students("S0000002","����","��",new Date(),"�һ���");
			Students s3 = new Students("S0000003","����","Ů",new Date(),"�һ���");

			session.save(s1);
			session.save(s2);
			session.save(s3);

			tx.commit();
			sessionFactory.close();
		}
}
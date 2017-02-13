package entity;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import org.junit.Test;

public class TestCars {
	
	//��Ӳ�������
		@Test
		public void testSaveCars()
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

			Cars c1 = new Cars("C0000001","��Y AA666","����","����","С�ͳ�",new Date());
			Cars c2 = new Cars("C0000002","��Y AB777","�ɲ�","����","С�ͳ�",new Date());
			Cars c3 = new Cars("C0000003","��Y AC888","С��","��ͨ","���ͳ�",new Date());
			
			Users u1 = new Users(1,"lisi","123456");
			
			session.save(c1);
			session.save(c2);
			session.save(c3);
			session.save(u1);

			tx.commit();
			sessionFactory.close();
		}
}

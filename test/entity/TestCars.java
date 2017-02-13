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
	
	//添加测试数据
		@Test
		public void testSaveCars()
		{
			//创建配置对象
			Configuration config = new Configuration().configure();
			//创建服务注册对象
			ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(config.getProperties()).buildServiceRegistry();
			//创建会话工厂对象
			SessionFactory sessionFactory = config.buildSessionFactory(serviceRegistry);
			//会话对象
			Session session = sessionFactory.getCurrentSession();
			//创建事务对象
			Transaction tx= session.beginTransaction();

			Cars c1 = new Cars("C0000001","京Y AA666","调调","大众","小型车",new Date());
			Cars c2 = new Cars("C0000002","京Y AB777","采采","奔驰","小型车",new Date());
			Cars c3 = new Cars("C0000003","京Y AC888","小黑","宇通","大型车",new Date());
			
			Users u1 = new Users(1,"lisi","123456");
			
			session.save(c1);
			session.save(c2);
			session.save(c3);
			session.save(u1);

			tx.commit();
			sessionFactory.close();
		}
}

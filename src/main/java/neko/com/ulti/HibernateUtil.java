package neko.com.ulti;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class HibernateUtil {
	private static final SessionFactory sessionFactory = buildSessionFactory();

	private static SessionFactory buildSessionFactory() {
		try {
			// Tạo đối tượng StandardServiceRegistry từ file cấu hình hibernate.cfg.xml
			StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml")
					.build();
			// Tạo SessionFactory từ metadata của các entity được khai báo trong
			// hibernate.cfg.xml
			return new MetadataSources(registry).buildMetadata().buildSessionFactory();
		} catch (Exception e) {
			// Xử lý ngoại lệ
			e.printStackTrace();
			throw new ExceptionInInitializerError("Initialization of SessionFactory failed: " + e.getMessage());
		}
	}

	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public static Session getCurrentSession() {
		return getSessionFactory().getCurrentSession();
	}
}

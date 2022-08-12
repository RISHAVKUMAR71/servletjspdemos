import org.hibernate.Session;

import com.samples.domain.Message;
import com.samples.utils.HibernateUtils;


public class HibernateTest {

	public static void main(String[] args) {
		
		Session session = HibernateUtils.getSessionFactory().openSession();
		
		session.beginTransaction();
		
		Message message = new Message("Hello world with Hibernate"); 
		
		session.save(message);
		
		session.getTransaction().commit();
		
		session.close();
		
	}
}
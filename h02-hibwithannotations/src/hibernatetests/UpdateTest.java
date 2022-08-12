package hibernatetests;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.samples.domain.Message;
import com.samples.utils.HibernateUtils;

public class UpdateTest {

	public static void main(String[] args) {

		Session session1 = HibernateUtils.getSessionFactory().openSession();
		Transaction txn = session1.getTransaction();
		txn.begin();
		Message message = session1.get(Message.class, 4);
		System.out.println(message);
		txn.commit();
		session1.close();

		message.setText("Object with Id 4 changed text");		// message object is detached
		
		Session session2 = HibernateUtils.getSessionFactory().openSession();
		session2.beginTransaction();
		session2.update(message);
		session2.getTransaction().commit();
		session2.close();

	}
}
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.tutorial.Student;

public class HQLExample {
	
	public static void main(String[] args) {
		
		 SessionFactory factory=new Configuration().configure().buildSessionFactory();
		 
		 Session s=factory.openSession();
		 
		 String query="from Student where city =: x";
		 
		 Query q=s.createQuery(query);
		 q.setParameter("x","gadhinglaj");
		 List<Student> studentList=q.list();
		 
		 for(Student stu : studentList) {
			 System.out.println(stu.getName());
		 }
		 
		 s.close();
		 factory.close();
	}
}

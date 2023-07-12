package om.cascade;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.map.Answer;
import com.map.Question;

public class CascadeExample {
	
	public static void main(String[] args) {
		
		
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
	
			Session s = factory.openSession();
			
			Question q=new Question();
			q.setQuestionId(101);
			q.setQuestion("What is cascading");
			
			Answer a=new Answer(201,"In Hibernate it is an important concept");
			Answer a1=new Answer(301,"Second ans");
			Answer a2=new Answer(401,"3rd ans");
			
			List<Answer> list=new ArrayList<Answer>();
			list.add(a);
			list.add(a1);
			list.add(a2);
			
			q.setAnswers(list);
			s.beginTransaction();
			
			s.save(q); 
			s.getTransaction().commit();
			
			
			s.close();
			factory.close();
	}
}

package com.tutorial;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class EmDemo {
	
	public static void main(String[] args) {
		
		SessionFactory factory=new Configuration().configure().buildSessionFactory();
		
		Student s1=new Student();
		Certificate certificate1=new Certificate();
		
		s1.setId(2);
		s1.setName("Aftab");
		s1.setCity("KOlhapur");
		certificate1.setCourse("java");
		certificate1.setDuration("30 days");
		s1.setCerti(certificate1);
		
		Student s2=new Student();
		Certificate certificate2=new Certificate();
		
		s2.setId(3);
		s2.setName("bushra");
		s2.setCity("KOlhapur");
		certificate2.setCourse("JDBC");
		certificate2.setDuration("20 days");
		s2.setCerti(certificate2);
		
		Session session=factory.openSession();
		 session.beginTransaction();
		 session.save(s1);
		 session.save(s2);
		 session.getTransaction().commit();
	        
		 session.close();
		factory.close();
		
	}
}

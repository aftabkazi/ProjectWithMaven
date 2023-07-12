package com.tutorial;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class FetchDemo {
	
	public static void main(String[] args) {
		
		SessionFactory factory=new Configuration().configure().buildSessionFactory();
		Session session=factory.openSession();
		//get -student-id-101
		Student student=(Student)session.get(Student.class, 101);
		
		Address ad=(Address)session.get(Address.class,1);
		
		System.out.println("student : "+student);
		System.out.println("Address: "+ad);
		session.close();
		factory.close();
	}

}

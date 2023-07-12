package com.map1;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class MappingDemo {

	public static void main(String[] args) {

		SessionFactory factory = new Configuration().configure().buildSessionFactory();

		Emp e1 = new Emp();
		e1.setEid(1);
		e1.setName("Aftab");

		Emp e2 = new Emp();
		e2.setEid(2);
		e2.setName("Bushra");

		Project p1 = new Project();
		p1.setPid(10);
		p1.setProjectName("Quiz");

		Project p2 = new Project();
		p2.setPid(20);
		p2.setProjectName("RAAS");

		List<Emp> empList = new ArrayList<Emp>();
		List<Project> projectList = new ArrayList<Project>();

		empList.add(e1);
		empList.add(e2);

		projectList.add(p1);
		projectList.add(p2);

		e1.setProjects(projectList);// both project are assigned to Aftab
		p2.setEmps(empList);// RAAS project is assigned to both emp Aftab and Bushra
		
		Session session = factory.openSession();
		session.beginTransaction();
		
		session.save(p1);
		session.save(p2);
		session.save(e1);
		session.save(e2);
		
		session.getTransaction().commit();

		session.close();
		factory.close();

	}

}

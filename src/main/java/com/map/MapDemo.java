package com.map;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class MapDemo {

	public static void main(String [] args) {
		
		SessionFactory factory=new Configuration().configure().buildSessionFactory();
		
		
		Question q=new Question();
		q.setQuestionId(1);
		q.setQuestion("What is java");
		
		
		Answer ans=new Answer();
		ans.setAnswerId(10);
		ans.setAnswer("Java is programming language");
		ans.setQuestion(q);
		
		Answer ans1=new Answer();
		ans1.setAnswerId(11);
		ans1.setAnswer("With the help of java we can create softwares");
		ans1.setQuestion(q);
		
		Answer ans2=new Answer();
		ans2.setAnswerId(12);
		ans2.setAnswer("Java has different types of framework");
		ans2.setQuestion(q);
		
		List<Answer> answerList=new ArrayList<Answer>();
		
		answerList.add(ans);
		answerList.add(ans1);
		answerList.add(ans2);
		
		q.setAnswers(answerList);
		
		Session session=factory.openSession();
		session.beginTransaction();
		
		session.save(q);
		session.save(ans);
		session.save(ans1);
		session.save(ans2);
		
		session.getTransaction().commit();
		
		session.close();
		factory.close();
		
	}
	
}

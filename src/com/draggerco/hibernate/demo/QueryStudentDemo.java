package com.draggerco.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.draggerco.hibernate.demo.entity.Student;

public class QueryStudentDemo {

	public static void main(String[] args) {

		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class)
				.buildSessionFactory();

		Session session = factory.getCurrentSession();

		try {

			System.out.println("Creating new Student Object");
			Student stdnt = new Student("Cherlux", "G", "cherlux@gmail.com");

			session.beginTransaction();

			System.out.println("Saving the student ...");
			System.out.println(stdnt);
			session.save(stdnt);

			session.getTransaction().commit();
			
			session = factory.getCurrentSession();
			session.beginTransaction();
			System.out.println("\nGetting studente with ID: " + stdnt.getId());
			
			Student stdntRead = session.get(Student.class, stdnt.getId());
			
			System.out.println("\nGet Complete!" + stdntRead);
			System.out.println("Done! ...");
			session.getTransaction().commit();
		} finally {
			factory.close();
		}
	}

}

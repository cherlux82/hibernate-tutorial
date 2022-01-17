package com.draggerco.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.draggerco.hibernate.demo.entity.Student;

public class CreateStudentDemo {

	public static void main(String[] args) {

		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class)
				.buildSessionFactory();

		Session session = factory.getCurrentSession();

		try {

			System.out.println("Creating new Student Object");
			Student stdnt = new Student("Vicente", "Garcia", "cherlux@gmail.com");

			session.beginTransaction();

			System.out.println("Saving the student ...");

			session.save(stdnt);

			session.getTransaction().commit();
			
			System.out.println("Done! ...");
		} finally {
			factory.close();
		}
	}

}

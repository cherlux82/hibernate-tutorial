package com.draggerco.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.draggerco.hibernate.demo.entity.Student;

public class PrimaryKeyDemo {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class)
				.buildSessionFactory();

		Session session = factory.getCurrentSession();

		try {

			System.out.println("Creating new Student Object");
			Student stdnt1 = new Student("Vicente", "Garcia", "cherlux@gmail.com");
			Student stdnt2 = new Student("Jose", "Garcia", "jose@gmail.com");
			Student stdnt3 = new Student("Cristina", "Garcia", "cristina@gmail.com");
			Student stdnt4 = new Student("Anel", "Garcia", "anel@gmail.com");

			session.beginTransaction();

			System.out.println("Saving the student ...");

			session.save(stdnt1);
			session.save(stdnt2);
			session.save(stdnt3);
			session.save(stdnt4);

			session.getTransaction().commit();

			System.out.println("Done! ...");
		} finally {
			factory.close();
		}

	}

}

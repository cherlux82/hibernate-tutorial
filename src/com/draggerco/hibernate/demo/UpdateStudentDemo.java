package com.draggerco.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.draggerco.hibernate.demo.entity.Student;

public class UpdateStudentDemo {

	public static void main(String[] args) {

		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class)
				.buildSessionFactory();

		Session session = factory.getCurrentSession();

		try {

			int studentID = 1;
			
			System.out.println("Reading Student Object");
			session.beginTransaction();
			Student stdnt = session.get(Student.class, studentID);
			System.out.println(stdnt);
			session.getTransaction().commit();
			
			
			stdnt.setFirstName("Tutis");

			session = factory.getCurrentSession();
			session.beginTransaction();
			session.update(stdnt);
			session.getTransaction().commit();
			
			
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			session.createQuery("update Student set email='cherlux@gmail.com'").executeUpdate();
			session.getTransaction().commit();
			
			System.out.println("Done! ...");
		} finally {
			factory.close();
		}
	}

}

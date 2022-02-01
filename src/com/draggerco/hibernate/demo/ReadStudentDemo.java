package com.draggerco.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.draggerco.hibernate.demo.entity.Student;

public class ReadStudentDemo {

	public static void main(String[] args) {

		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class)
				.buildSessionFactory();

		Session session = factory.getCurrentSession();

		try {

			session.beginTransaction();

			List<Student> students = session.createQuery("from Student s where s.email like '%gmail%'").getResultList();
			for (Student student : students) {
				System.out.println(student);
			}
			session.getTransaction().commit();
		} finally {
			factory.close();
		}
	}

}

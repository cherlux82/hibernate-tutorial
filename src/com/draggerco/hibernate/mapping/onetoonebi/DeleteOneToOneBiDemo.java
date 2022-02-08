package com.draggerco.hibernate.mapping.onetoonebi;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteOneToOneBiDemo {

	public static void main(String[] args) {

		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class).buildSessionFactory();

		Session session = factory.getCurrentSession();

		try {

			System.out.println("Creating new Instructor Detail Object");

			session.beginTransaction();
			InstructorDetail instructorDetail = session.get(InstructorDetail.class, 5);
			instructorDetail.getInstructor().setInstructorDetail(null);
			session.delete(instructorDetail);

			session.getTransaction().commit();
			System.out.println("Done! ...");
		} finally {
			factory.close();
		}
	}

}

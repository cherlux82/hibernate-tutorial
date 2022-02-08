package com.draggerco.hibernate.mapping.onetoonebi;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class GetInstructorOneToOneBiDemo {

	public static void main(String[] args) {

		SessionFactory factory = new Configuration().configure("hibernate.cfg.otobi.xml")
				.addAnnotatedClass(Instructor.class).addAnnotatedClass(InstructorDetail.class).buildSessionFactory();

		Session session = factory.getCurrentSession();

		try {

			int id = 1;
			session.beginTransaction();
			InstructorDetail instructorDetail = session.get(InstructorDetail.class, id);
			System.out.println(instructorDetail);

			System.out.println("The associated instructor: " + instructorDetail.getInstructor());

			System.out.println("Done! ...");
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			if (session != null) {
				session.close();
				factory.close();
			}
		}
	}

}

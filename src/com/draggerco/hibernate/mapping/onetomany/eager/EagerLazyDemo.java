package com.draggerco.hibernate.mapping.onetomany.eager;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class EagerLazyDemo {

	public static void main(String[] args) {

		SessionFactory factory = new Configuration().configure("hibernate.cfg.oneToMany.xml")
				.addAnnotatedClass(Instructor.class).addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(Course.class).buildSessionFactory();

		Session session = factory.getCurrentSession();

		try {

			session.beginTransaction();
			int id = 1;
			Instructor instructor = session.get(Instructor.class, id);

			System.out.println("Instructor: " + instructor);

			session.getTransaction().commit();

			session.close();
			System.out.println("Courses: " + instructor.getCourses());
			System.out.println("Done! ...");
		} finally {
			factory.close();
		}
	}

}

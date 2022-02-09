package com.draggerco.hibernate.mapping.onetomany;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.draggerco.hibernate.mapping.onetomany.entity.Course;
import com.draggerco.hibernate.mapping.onetomany.entity.Instructor;
import com.draggerco.hibernate.mapping.onetomany.entity.InstructorDetail;

public class DeleteCoursesDemo {

	public static void main(String[] args) {

		SessionFactory factory = new Configuration().configure("hibernate.cfg.oneToMany.xml")
				.addAnnotatedClass(Instructor.class).addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(Course.class).buildSessionFactory();

		Session session = factory.getCurrentSession();

		try {

			session.beginTransaction();
			int id = 10;
			Course c = session.get(Course.class, id);

			System.out.println(c);
			session.delete(c);
			session.getTransaction().commit();

			session = factory.getCurrentSession();

			System.out.println("Done! ...");
		} finally {
			factory.close();
		}
	}

}

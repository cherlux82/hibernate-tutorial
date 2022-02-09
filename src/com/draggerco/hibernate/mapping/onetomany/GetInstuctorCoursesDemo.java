package com.draggerco.hibernate.mapping.onetomany;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.draggerco.hibernate.mapping.onetomany.entity.Course;
import com.draggerco.hibernate.mapping.onetomany.entity.Instructor;
import com.draggerco.hibernate.mapping.onetomany.entity.InstructorDetail;

public class GetInstuctorCoursesDemo {

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
			System.out.println("Courses: " + instructor.getCourses());

			session.getTransaction().commit();

			session = factory.getCurrentSession();

			System.out.println(instructor);
			System.out.println("Done! ...");
		} finally {
			factory.close();
		}
	}

}

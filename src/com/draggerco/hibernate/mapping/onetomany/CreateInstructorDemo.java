package com.draggerco.hibernate.mapping.onetomany;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.draggerco.hibernate.mapping.onetomany.entity.Course;
import com.draggerco.hibernate.mapping.onetomany.entity.Instructor;
import com.draggerco.hibernate.mapping.onetomany.entity.InstructorDetail;

public class CreateInstructorDemo {

	public static void main(String[] args) {

		SessionFactory factory = new Configuration().configure("hibernate.cfg.oneToMany.xml").addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class).buildSessionFactory();

		Session session = factory.getCurrentSession();

		try {

			System.out.println("Creating new Instructor Detail Object");

			Instructor instructor = new Instructor("Vicente", "Garcia", "cherlux@gmail.com", null);
			InstructorDetail instructorDetail = new InstructorDetail();
			instructorDetail.setHobby("Running");
			instructorDetail.setYoutubeChannel("www.youtube.com/cherlux");

			instructor.setInstructorDetail(instructorDetail);

//			Course course = new Course("Java Programming");
//
//			instructor.add(course);
			session.beginTransaction();

			session.save(instructor);

			session.getTransaction().commit();

			session = factory.getCurrentSession();

			System.out.println(instructor);
			System.out.println("Done! ...");
		} finally {
			factory.close();
		}
	}

}

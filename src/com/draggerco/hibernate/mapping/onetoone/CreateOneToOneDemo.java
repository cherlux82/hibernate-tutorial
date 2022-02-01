package com.draggerco.hibernate.mapping.onetoone;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.draggerco.hibernate.mapping.onetoone.entity.Instructor;
import com.draggerco.hibernate.mapping.onetoone.entity.InstructorDetail;

public class CreateOneToOneDemo {

	public static void main(String[] args) {

		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class).buildSessionFactory();

		Session session = factory.getCurrentSession();

		try {

			System.out.println("Creating new Instructor Detail Object");

			Instructor instructor = new Instructor("Vicente", "Garcia", "cherlux@gmail.com", null);
			InstructorDetail instructorDetail = new InstructorDetail();
			instructorDetail.setHobby("Running");
			instructorDetail.setYoutubeChannel("www.youtube.com/cherlux");

			instructor.setInstructorDetail(instructorDetail);

			session.beginTransaction();

			session.save(instructor);

			session.getTransaction().commit();
			System.out.println(instructor);
			System.out.println("Done! ...");
		} finally {
			factory.close();
		}
	}

}

package com.draggerco.hibernate.mapping.onetomanyuni;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.draggerco.hibernate.mapping.onetomanyuni.entity.Course;
import com.draggerco.hibernate.mapping.onetomanyuni.entity.Instructor;
import com.draggerco.hibernate.mapping.onetomanyuni.entity.InstructorDetail;
import com.draggerco.hibernate.mapping.onetomanyuni.entity.Review;

public class DeleteCoursesAndReviewsDemo {

	public static void main(String[] args) {

		SessionFactory factory = new Configuration().configure("hibernate.cfg.oneToManyUni.xml")
				.addAnnotatedClass(Instructor.class).addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(Course.class).addAnnotatedClass(Review.class).buildSessionFactory();

		Session session = factory.getCurrentSession();

		try {
			System.out.println("\n=====================================\n");
			session.beginTransaction();

			int id = 10;

			Course c1 = session.get(Course.class, id);
			System.out.println("\n=====================================\n");
			System.out.println(c1);
			System.out.println("\n=====================================\n");
			System.out.println(c1.getReviews());
			
			System.out.println("\n=====================================\n");
			session.delete(c1);
			System.out.println("\n=====================================\n");
			session.getTransaction().commit();

			System.out.println("\n=====================================\n");
			System.out.println("Done! ...");
		} finally {
			factory.close();
		}
	}

}

package com.draggerco.hibernate.mapping.onetomanyuni;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.draggerco.hibernate.mapping.onetomanyuni.entity.Course;
import com.draggerco.hibernate.mapping.onetomanyuni.entity.Instructor;
import com.draggerco.hibernate.mapping.onetomanyuni.entity.InstructorDetail;
import com.draggerco.hibernate.mapping.onetomanyuni.entity.Review;

public class CreateCoursesDemo {

	public static void main(String[] args) {

		SessionFactory factory = new Configuration().configure("hibernate.cfg.oneToManyUni.xml")
				.addAnnotatedClass(Instructor.class).addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(Course.class).addAnnotatedClass(Review.class).buildSessionFactory();

		Session session = factory.getCurrentSession();

		try {

			session.beginTransaction();
			System.out.println("Creating new Instructor Detail Object");
			Course c1 = new Course("Street Fighter II Course");
			Course c2 = new Course("Java 9 Certification");

			c1.addReview(new Review("Excelent Course"));
			c1.addReview(new Review("Best of all"));
			c1.addReview(new Review("Getting only perfect finishes"));

			c2.addReview(new Review("i got my cert thanks to this course"));
			c2.addReview(new Review("Best of all"));
			c2.addReview(new Review("Excelnt instructor"));

			session.save(c1);
			session.save(c2);

			session.getTransaction().commit();

			System.out.println("\n=====================================\n");
			System.out.println(c1);
			System.out.println(c1.getReviews());
			System.out.println("\n=====================================\n");
			System.out.println(c2);
			System.out.println(c2.getReviews());
			System.out.println("\n=====================================\n");

			System.out.println("Done! ...");
		} finally {
			factory.close();
		}
	}

}

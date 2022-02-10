package com.draggerco.hibernate.mapping.manytomany;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.draggerco.hibernate.mapping.manytomany.entity.Course;
import com.draggerco.hibernate.mapping.manytomany.entity.Instructor;
import com.draggerco.hibernate.mapping.manytomany.entity.InstructorDetail;
import com.draggerco.hibernate.mapping.manytomany.entity.Review;
import com.draggerco.hibernate.mapping.manytomany.entity.Student;

public class DeleteStudentsCoursesDemo {

	public static void main(String[] args) {

		SessionFactory factory = new Configuration().configure("hibernate.cfg.ManyToMany.xml")
				.addAnnotatedClass(Instructor.class).addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(Course.class).addAnnotatedClass(Review.class).addAnnotatedClass(Student.class)
				.buildSessionFactory();

		Session session = factory.getCurrentSession();

		try {
			System.out.println("\n=====================================\n");
			session.beginTransaction();
			System.out.println("\n=====================================\n");
			int id = 1;

			Student s = session.get(Student.class, id);
			System.out.println(s);

			System.out.println("\n=====================================\n");

			session.delete(s);
			session.getTransaction().commit();
			System.out.println("\n=====================================\n");

			System.out.println("Done! ...");
			System.out.println("\n=====================================\n");

		} finally {
			factory.close();
		}
	}

}

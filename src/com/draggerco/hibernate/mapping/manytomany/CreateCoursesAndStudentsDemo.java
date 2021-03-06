package com.draggerco.hibernate.mapping.manytomany;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.draggerco.hibernate.mapping.manytomany.entity.Course;
import com.draggerco.hibernate.mapping.manytomany.entity.Instructor;
import com.draggerco.hibernate.mapping.manytomany.entity.InstructorDetail;
import com.draggerco.hibernate.mapping.manytomany.entity.Review;
import com.draggerco.hibernate.mapping.manytomany.entity.Student;

public class CreateCoursesAndStudentsDemo {

	public static void main(String[] args) {

		SessionFactory factory = new Configuration().configure("hibernate.cfg.ManyToMany.xml")
				.addAnnotatedClass(Instructor.class).addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(Course.class).addAnnotatedClass(Review.class).addAnnotatedClass(Student.class)
				.buildSessionFactory();

		Session session = factory.getCurrentSession();

		try {
			System.out.println("\n=====================================\n");
			session.beginTransaction();
			int idStudent = 1;
			
			Student s = session.get(Student.class, idStudent);
			
			System.out.println("\n=====================================\n");
			System.out.println("Student: " + s);
			System.out.println("\n=====================================\n");
			
			System.out.println("Courses: " + s.getCourses());
			System.out.println("\n=====================================\n");
			
			Course c1 = new Course("Cocina internacional");
			Course c2 = new Course("Robotica");
			
			c1.addStudent(s);
			c2.addStudent(s);
			System.out.println("\n=====================================\n");
			session.save(c1);
			System.out.println("\n=====================================\n");
			session.save(c2);
			System.out.println("\n=====================================\n");
			
			
			session.getTransaction().commit();
			System.out.println("\n=====================================\n");

			System.out.println("Done! ...");
			System.out.println("\n=====================================\n");

		} finally {
			factory.close();
		}
	}

}

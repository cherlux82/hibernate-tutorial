package com.draggerco.hibernate.mapping.manytomany;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.draggerco.hibernate.mapping.manytomany.entity.Course;
import com.draggerco.hibernate.mapping.manytomany.entity.Instructor;
import com.draggerco.hibernate.mapping.manytomany.entity.InstructorDetail;
import com.draggerco.hibernate.mapping.manytomany.entity.Review;
import com.draggerco.hibernate.mapping.manytomany.entity.Student;

public class AddCoursesForStudentsDemo {

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
			
			Course c1 = new Course("Spring 5 For begginers");
			session.save(c1);
			System.out.println("\n=====================================\n");
			
			Student s1 = new Student("Angel Gael", "Garcia", "agg@draggerco.com");
			Student s2 = new Student("Ian Jorel", "Garcia", "ijgc@draggerco.com");
			
			c1.addStudent(s1);
			c1.addStudent(s2);
			
			session.save(s1);
			System.out.println("\n=====================================\n");
			session.save(s2);
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

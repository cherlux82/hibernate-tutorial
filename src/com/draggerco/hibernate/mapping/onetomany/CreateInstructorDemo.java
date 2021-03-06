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
				.addAnnotatedClass(InstructorDetail.class).addAnnotatedClass(Course.class).buildSessionFactory();

		Session session = factory.getCurrentSession();

		try {

			System.out.println("Creating new Instructor Detail Object");

			 
			session.beginTransaction();
			int id=1;
			Instructor instructor = session.get(Instructor.class, id);
			
			Course c1 = new Course("Java Programming");
			Course c2 = new Course("SQL Data QUery");
			
			instructor.add(c1);
			instructor.add(c2);
			
			session.save(c1);
			session.save(c2);
			

			session.getTransaction().commit();

			System.out.println("Done! ...");
		} finally {
			factory.close();
		}
	}

}

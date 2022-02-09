package com.draggerco.hibernate.mapping.onetomany.eager;


import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class FetchJoinDemo {

	public static void main(String[] args) {

		SessionFactory factory = new Configuration().configure("hibernate.cfg.oneToMany.xml")
				.addAnnotatedClass(Instructor.class).addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(Course.class).buildSessionFactory();

		Session session = factory.getCurrentSession();

		try {

			session.beginTransaction();
			int id = 1;

			Query<Instructor> query = session.createQuery("SELECT i FROM Instructor i JOIN FETCH i.courses where i.id=:id",
					Instructor.class);
			query.setParameter("id", id);
			
			Instructor instructor = query.getSingleResult();
			
			System.out.println("\nInstructor: " + instructor + "\n");
			session.getTransaction().commit();
			session.close();
			System.out.println("\nThe session is now closed\n");
			System.out.println("Courses: " + instructor.getCourses());
			System.out.println("Done! ...");
		} finally {
			factory.close();
		}
	}

}

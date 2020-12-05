package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class CreateStudentDemo {

	public static void main(String[] args) {
		
		// create session factory
		SessionFactory factory = new Configuration()
									.configure("hibernate.cfg.xml")
									.addAnnotatedClass(Student.class)
									.buildSessionFactory();
				
		// create session
		Session session = factory.getCurrentSession();
				
		// close session
		try {
			// create a student object
			System.out.println("Creating a  new Student Object ......");
			Student tempStuent = new Student("Nickle", "Smith", "Nickle@luv2code.com");
			
			// start a transaction
			session.beginTransaction();
			
			// save the student object
			System.out.println("We are saving the student please wait......");
			session.save(tempStuent);
			
			// commit transaction
			session.getTransaction().commit();
			
			System.out.println("Already Done!!!");
			
			
		}
		finally {
			factory.close();
		}
		
		
	}

}

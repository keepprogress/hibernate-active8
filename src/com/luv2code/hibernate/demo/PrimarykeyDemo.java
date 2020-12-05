package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Employee;

public class PrimarykeyDemo {

	public static void main(String[] args) {
		
		// create session factory
		SessionFactory factory = new Configuration()
									.configure("hibernate.cfg.xml")
									.addAnnotatedClass(Employee.class)
									.buildSessionFactory();
				
		// create session
		Session session = factory.getCurrentSession();
				
		// close session
		try {
			// create 3 employee object
			System.out.println("Creating new employee Objects ......");
			Employee tempEmployee1 = new Employee("Rock", "janson", "myMusic");
			Employee tempEmployee2 = new Employee("Nicklelas", "Cage", "myVideo");
			Employee tempEmployee3 = new Employee("John", "Seena", "myBook");

			
			// start a transaction
			session.beginTransaction();
			
			// save the employee object
			System.out.println("We are saving the employee please wait......");
			session.save(tempEmployee1);
			session.save(tempEmployee2);
			session.save(tempEmployee3);
			

			// commit transaction
			session.getTransaction().commit();
			
			System.out.println("Already Done!!!");
			
			
		}
		finally {
			factory.close();
		}
		
		
	}

}

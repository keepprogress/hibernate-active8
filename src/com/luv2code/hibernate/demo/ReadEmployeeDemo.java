package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Employee;

public class ReadEmployeeDemo {

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
			// create a employee object
			System.out.println("Creating new employee Objects ......");
			Employee tempEmployee = new Employee("Laughty", "guy", "myMusic");
		
			
			// start a transaction
			session.beginTransaction();
			
			// save the employee object
			System.out.println("We are saving the employee please wait......");
			System.out.println(tempEmployee);
			session.save(tempEmployee);
			

			// commit transaction
			session.getTransaction().commit();
			
			// find out the employee's id: primary key
			System.out.println("Saved employee. Generated id: " + tempEmployee.getId());
			
			// now get a new session and start transaction
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			// retrieve employee based on the id: primary key
			System.out.println("\nGetting employee with id: " + tempEmployee.getId());
			
			Employee myEmployee = session.get(Employee.class, tempEmployee.getId());
			
			System.out.println("Get complete: " + myEmployee);
			
			// commit the transaction
			session.getTransaction().commit();
						
			System.out.println("Already Done!!!");
			
		}
		finally {
			factory.close();
		}
		
		
	}

}

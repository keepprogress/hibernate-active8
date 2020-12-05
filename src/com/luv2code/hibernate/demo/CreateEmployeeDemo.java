package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Employee;

public class CreateEmployeeDemo {

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
			System.out.println("Creating a  new employee Object ......");
			Employee tempStuent = new Employee("Nickle", "Smith", "myMusic");
			
			// start a transaction
			session.beginTransaction();
			
			// save the employee object
			System.out.println("We are saving the employee please wait......");
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

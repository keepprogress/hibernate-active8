package com.luv2code.hibernate.demo;

import java.util.List;

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
						
			// start a transaction
			session.beginTransaction();
			
			// query employees
			List<Employee> theEmployees = session.createQuery("from Employee").list();
			
			// display the employees
			for (Employee tempEmployee : theEmployees) {
				System.out.println(tempEmployee);
			}

			// commit transaction
			session.getTransaction().commit();
			
							
			System.out.println("Already Done!!!");
			
		}
		finally {
			factory.close();
		}
		
		
	}

}

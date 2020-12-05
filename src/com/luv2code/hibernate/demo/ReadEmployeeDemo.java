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
			List<Employee> theEmployees = session.createQuery("from Employee").getResultList();
			
			// display the employees
			displayEmployees(theEmployees);

			// query employee: lastName = "janson"
			theEmployees = session.createQuery("from Employee s where s.lastName='janson'").getResultList();
			
			// display the employees
			System.out.println("\n\nEmployees who have last name of 'janson'");
			displayEmployees(theEmployees);
			
			// commit transaction
			session.getTransaction().commit();
			
							
			System.out.println("Already Done!!!");
			
		}
		finally {
			factory.close();
		}
		
		
	}

	private static void displayEmployees(List<Employee> theEmployees) {
		for (Employee tempEmployee : theEmployees) {
			System.out.println(tempEmployee);
		}
	}

}

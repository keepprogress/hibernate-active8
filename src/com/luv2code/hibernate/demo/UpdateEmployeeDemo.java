package com.luv2code.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Employee;

public class UpdateEmployeeDemo {

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
			int employeeId =3;	
			// start a transaction
			session.beginTransaction();
			
			// retrieve employee based on the id: primary key
			System.out.println("\nGetting employee with id: " + employeeId);
			
			Employee myEmployee = session.get(Employee.class, employeeId);
			
			System.out.println("Updateing employee.....");
			myEmployee.setFirstName("Snoopy");
			
			// commit transaction
			session.getTransaction().commit();
			
			// NEW CODE
			
			session = factory.getCurrentSession();
			session.beginTransaction();

			// update company for all employees
			System.out.println("Update company for all employees");
			
			session.createQuery("update from Employee set company = 'TaiwanMobileSubsidiary'")
				.executeUpdate();
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

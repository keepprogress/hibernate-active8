package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Employee;

public class DeleteEmployeeDemo {

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
			int employeeId =1;
		
			// now get a new session and start transaction
			session = factory.getCurrentSession();

			session.beginTransaction();
			
			// retrieve employee base on the id: primary key
			System.out.println("\nGetting employee with id: " + employeeId);
			
			Employee myEmployee = session.get(Employee.class, employeeId);
			
			// delete the employee
			//System.out.println("Deleting employee " + myEmployee);
			//session.delete(myEmployee);
			
			// delete student id=2
			System.out.println("Deleting employee id=2");
			
			session.createQuery("delete from Employee where id=2").executeUpdate();
			

			// commit transaction
			session.getTransaction().commit();
			
			System.out.println("Already Done!!!");
			
			
		}
		finally {
			factory.close();
		}
		
		
	}

}

package com.app;

import com.app.entities.Employee;

import java.util.List;
import java.util.Scanner;
import org.hibernate.Query;
import org.hibernate.Session;  
import org.hibernate.SessionFactory;  
import org.hibernate.Transaction;  
import org.hibernate.cfg.Configuration;

public class App 
{
	static Scanner s = new Scanner(System.in);
	static SessionFactory sessionfactory =  new Configuration().configure().addAnnotatedClass(Employee.class).buildSessionFactory();

	public static void main(String[] args) {
		int choice = 0, eid = 0;
		while(true) {
			System.out.println("Menu:\n1. Create employee\n2. Update all employee\n3. Update employee by id\n4. Delete employee - warning: this cannot be recovered\n5. Get all employee\n6. Get employee by id\n7. Exit");
			choice = s.nextInt();
			switch(choice){
				case 1: createEmployee();
						break;
					
				case 2: updateAllEmployee();
						break;
						
				case 3: System.out.println("Enter id to update Employee Details");
						eid = s.nextInt();
						updateEmployee(eid);
						break;
						
				case 4: System.out.println("Enter id to remove Employee Details");
						eid = s.nextInt();
						removeEmployee(eid);
						break;
						
				case 5 : getAllEmployees();
						break;
						
				case 6: System.out.println("Enter id to display Employee Details");
						eid = s.nextInt();
						getEmployee(eid);
						break;
				
				case 7 : return;
						
				default: break;
			}
		}
	}
	
	public static void createEmployee() {
		Session session = sessionfactory.openSession();
		Employee employee = new Employee(); 
		try {
			Transaction tnx = session.beginTransaction();
			s.nextLine();
			System.out.println("Enter First Name:");
			employee.setFname(s.nextLine());
			System.out.println("Enter Last Name:");
			employee.setLname(s.nextLine());
			System.out.println("Enter Designation:");
			employee.setDesignation(s.nextLine());
			System.out.println("Enter DOB:");
			employee.setDob(s.nextLine());
			System.out.println("Enter Age:");
			employee.setAge(s.nextInt());
			System.out.println("Enter Salary:");
			employee.setSalary(s.nextInt());
			session.save(employee);
			tnx.commit();
		}
		catch(Exception e) {
			System.out.println(e);
		}
		finally{
			session.close();
			System.out.println(employee + " added to Database");
		}
	  }
	
	public static void updateAllEmployee() {
		Session session = sessionfactory.openSession();
		try {
			Transaction tnx = session.beginTransaction();
			System.out.println("Enter New Salary:");
			s.nextLine();
			Integer newSalary = s.nextInt();
			Query query = session.createQuery("from Employee");
			List<Employee> empList = query.list();
			if(empList == null)
				System.out.println("No Employee in Database");
			else {
				for(Employee employee : empList) {
					employee.setSalary(newSalary);
					session.update(employee);
				}
			
			tnx.commit();
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		finally{
			session.close();
		}
	}
	
	public static void updateEmployee(int id){
		Session session = sessionfactory.openSession();
		try {
			Transaction tnx = session.beginTransaction();
			System.out.println("Enter New Salary");
			s.nextLine();
			Integer newSalary = s.nextInt();
			Employee employee = (Employee) session.get(Employee.class, id);
			if(employee == null)
				System.out.println("Employee doesn't exists");
			else{
				employee.setSalary(newSalary);
				session.update(employee);
				System.out.println("Employee updated: " + employee);
				tnx.commit();
			}
		}
		catch(Exception e) {
			System.out.println(e);
		}
		finally{
			session.close();
		}
	}
	
	
	public static void removeEmployee(int id){
		Session session = sessionfactory.openSession();
		try {
			Transaction tnx = session.beginTransaction();
			Employee employee = (Employee) session.get(Employee.class, id);
			if(employee == null)
				System.out.println("No Employee exists with such Id, please re-enter correct id");
			else{
				session.delete(employee);
				tnx.commit();
			}
		}
		catch(Exception e) {
			System.out.println(e);
		}
		finally{
			session.close();
			System.out.println("Successfully Deleted....");
		}
	}
	
	private static void getAllEmployees() {
		Session session = sessionfactory.openSession();
		try {
			Query q = session.createQuery("from Employee");
			List<Employee> employees = (List<Employee>)q.list();
			for (Employee temp : employees) {
				System.out.println(temp);
			}
		}
		catch(Exception e) {
			System.out.println(e);
		}
		finally{
			session.close();
		}
	}
	 
	
	public static void getEmployee(int id){
		Session session = sessionfactory.openSession();
		try {
			Transaction tnx = session.beginTransaction();
			Employee employee = (Employee) session.get(Employee.class, id);
			if(employee == null)
				System.out.println("No Employee exists with such Id, please re-enter correct id");
			else{
				System.out.println("Employee Details: " + employee + employee.getDob() + employee.getAge());
				tnx.commit();
			}
		}
		catch(Exception e) {
			System.out.println(e);
		}
		finally{
			session.close();
		}
	}
}

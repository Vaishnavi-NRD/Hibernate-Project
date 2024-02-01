package Employee.controller;

import java.util.Scanner;

import Employee.dao.EmployeeDao;
import Employee.dto.Employee;

public class EmployeeController {
	static Scanner ip = new Scanner(System.in);
	static EmployeeDao dao=new EmployeeDao();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Enter Your Choice");
		System.out.println("1.Save Employee");
		System.out.println("2.Update Employee");
		System.out.println("3.Find Employee By Id");
		System.out.println("4.Delete Employee By Id");
		System.out.println("5.verify Employee By Id and password");
		System.out.println("6.verify Employee By phone and password");
		System.out.println("7.verify Employee By email and password");
		int choice = ip.nextInt();
		switch (choice) {
		case 1: {
			save();
			break;
		}
		case 2: {
			update();
			break;
		}
		case 3: {
			findById();
			break;
		}
		case 4: {
			delete();
			break;
		}
		case 5: {
			verifyById();
			break;
		}
		case 6: {
			verifyByPhone();
			break;
		}
		case 7: {
			verifyByEmail();
			break;
		}
		default: {
			System.err.println("Invalid Choice");
		}
		}
	}
	public static void save() {
		System.out.println("Enter the name,phone,email,designtaion,salary and password to save Employee");
		Employee e =new Employee();
		e.setName(ip.next());
		e.setPhone(ip.nextLong());
		e.setEmail(ip.next());
		e.setDesg(ip.next());
		e.setSalary(ip.nextDouble());
		e.setPassword(ip.next());
		e=dao.saveEmployee(e);
		System.out.println("Employee Details saved with id"+e.getId());
	}
	public static void update() {
		System.out.println("Enter the Employee Id to update");
		int eid = ip.nextInt();
		System.out.println("Enter the name,phone,email,designtaion,salary and password to save Employee");
		Employee e = new Employee();
		e.setId(eid);
		e.setName(ip.next());
		e.setPhone(ip.nextLong());
		e.setEmail(ip.next());
		e.setDesg(ip.next());
		e.setSalary(ip.nextDouble());
		e.setPassword(ip.next());
		e = dao.updateEmployee(e);
		System.out.println("Employee Updated");
	}
	public static void findById() {
		System.out.println("Enter the Employee Id to display details");
		int eid = ip.nextInt();
		Employee e = dao.findById(eid);
		if (e != null) {
			System.out.println("Employee Id:" + e.getId());
			System.out.println("Employee Name:" + e.getName());
			System.out.println("Designation:" + e.getDesg());
			System.out.println("Salary:" + e.getSalary());
			System.out.println("Email id:" + e.getEmail());
			System.out.println("Phone Number:" + e.getPhone());
		} else {
			System.err.println("You have entered an Invalid Id");
		}
	}

	public static void delete() {
		System.out.println("Enter the Employee Id to delete");
		int eid = ip.nextInt();
		boolean deleted = dao.deleteEmployee(eid);
		if (deleted) {
			System.out.println("Employee deleted");
		} else {
			System.err.println("Cannot delete Employee!!As You have entered an Invalid Id");
		}
	}

	public static void verifyById() {
		System.out.println("Enter the Employee Id and password to verify");
		int eid = ip.nextInt();
		String password = ip.next();
		Employee e = dao.verifyEmployee(eid, password);
		if (e != null) {
			System.out.println("verification Succesfull");
			System.out.println("Employee Id:" + e.getId());
			System.out.println("Employee Name:" + e.getName());
			System.out.println("Designation:" + e.getDesg());
			System.out.println("Salary:" + e.getSalary());
			System.out.println("Email id:" + e.getEmail());
			System.out.println("Phone Number:" + e.getPhone());
		} else {
			System.err.println("You have entered an Invalid Id or Password");
		}
	}

	public static void verifyByPhone() {
		System.out.println("Enter the Employee Phone and password to verify");
		long phone = ip.nextLong();
		String password = ip.next();
		Employee e = dao.verifyEmployee(phone, password);
		if (e != null) {
			System.out.println("verification Succesfull");
			System.out.println("Employee Id:" + e.getId());
			System.out.println("Employee Name:" + e.getName());
			System.out.println("Designation:" + e.getDesg());
			System.out.println("Salary:" + e.getSalary());
			System.out.println("Email id:" + e.getEmail());
			System.out.println("Phone Number:" + e.getPhone());
		} else {
			System.err.println("You have entered an Invalid Phone Number or Password");
		}
	}

	public static void verifyByEmail() {
		System.out.println("Enter the Employee Email and password to verify");
		String email = ip.next();
		String password = ip.next();
		Employee e = dao.verifyEmployee(email, password);
		if (e != null) {
			System.out.println("verification Succesfull");
			System.out.println("Employee Id:" + e.getId());
			System.out.println("Employee Name:" + e.getName());
			System.out.println("Designation:" + e.getDesg());
			System.out.println("Salary:" + e.getSalary());
			System.out.println("Email id:" + e.getEmail());
			System.out.println("Phone Number:" + e.getPhone());
		} else {
			System.err.println("You have entered an Invalid Email Id or Password");
		}
	}
}

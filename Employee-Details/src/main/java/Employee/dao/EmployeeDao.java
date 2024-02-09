package Employee.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

import Employee.dto.Employee;


public class EmployeeDao {
	/*EntityManager provides all the necessary functions required for CRUD
	Persistence is a class of JPA
	Persistence name is mapped as given in .xml file
	createEntityManagerFactory-> its an helper method of Persistence class &
	it creates implementation object & returns reference
	*/
	EntityManager manager = Persistence.createEntityManagerFactory("jpa").createEntityManager();
	/*Further Persistence Logic is written for performing CRUD operations & Validation*/
	public Employee saveEmployee(Employee employee) {
		EntityTransaction transaction = manager.getTransaction();
		manager.persist(employee);
		transaction.begin();
		transaction.commit();
		return employee;
	}
	public Employee findById(int id) {
		return manager.find(Employee.class, id);
	}
	public Employee updateEmployee(Employee employee) {
		EntityTransaction transaction = manager.getTransaction();
		manager.merge(employee);
		transaction.begin();
		transaction.commit();
		return employee;
	}
	public Employee verifyEmployee(int id, String password) {
		Query q = manager.createQuery("select e from Employee e where e.id=?1 and e.password=?2");
		q.setParameter(1, id);
		q.setParameter(2, password);
		try {
			return (Employee) q.getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	}
	public Employee verifyEmployee(long phone, String password) {
		Query q = manager.createQuery("select e from Employee e where e.phone=?1 and e.password=?2");
		q.setParameter(1, phone);
		q.setParameter(2, password);
		try {
			return (Employee) q.getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	}

	public Employee verifyEmployee(String email, String password) {
		Query q = manager.createQuery("select e from Employee e where e.email=?1 and e.password=?2");
		q.setParameter(1, email);
		q.setParameter(2, password);
		try {
			return (Employee) q.getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	}

	public boolean deleteEmployee(int id) {
		Employee e = manager.find(Employee.class, id);
		if (e != null) {
			manager.remove(e);
			EntityTransaction entityTransaction = manager.getTransaction();
			entityTransaction.begin();
			entityTransaction.commit();
			return true;
		}
		return false;
	}
}

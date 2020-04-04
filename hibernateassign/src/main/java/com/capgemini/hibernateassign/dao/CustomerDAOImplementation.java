package com.capgemini.hibernateassign.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import com.capgemini.hibernateassign.dto.Customer_info;

public class CustomerDAOImplementation implements CustomerDAO {

	@Override
	public boolean updateCustomerInfo(Customer_info info) {

		EntityManagerFactory factory = null;
		EntityManager manager = null;
		EntityTransaction transaction = null;
		try {
			factory = Persistence.createEntityManagerFactory("TestPersistence");
			manager = factory.createEntityManager();
			transaction = manager.getTransaction();
			transaction.begin();
			Customer_info record = manager.find(Customer_info.class, 7093305808l);
			record.setCountry("america");
			transaction.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();
			return false;
		} finally {
			factory.close();
			manager.close();
		}
	}

	@Override
	public boolean deleteCustomerInfo(long contactNumber) {
		EntityManagerFactory factory = null;
		EntityManager manager = null;
		EntityTransaction transaction = null;
		try {
			factory = Persistence.createEntityManagerFactory("TestPersistence");
			manager = factory.createEntityManager();
			transaction = manager.getTransaction();
			transaction.begin();
			Customer_info record = manager.find(Customer_info.class, contactNumber);
			manager.remove(record);
			System.out.println("Record deleted");
			transaction.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();
			return false;
		} finally {
			manager.close();
			factory.close();
		}
	}

	@Override
	public boolean insertCustomerInfo(Customer_info info) {
		EntityManagerFactory factory = null;
		EntityManager manager = null;
		EntityTransaction transaction = null;
		try {

			factory = Persistence.createEntityManagerFactory("TestPersistence");
			manager = factory.createEntityManager();
			transaction = manager.getTransaction();
			transaction.begin();
			manager.persist(info);
			System.out.println("Record Saved");
			transaction.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();
			return false;
		} finally {
			manager.close();
			factory.close();
		}
	}

	@Override
	public List<Customer_info> getAllCustomers() {
		EntityManagerFactory factory = null;
		EntityManager manager = null;

		factory = Persistence.createEntityManagerFactory("TestPersistence");
		manager = factory.createEntityManager();
		String jpql = "select m from Customer_info m";
		TypedQuery<Customer_info> query = manager.createQuery(jpql, Customer_info.class);

		List<Customer_info> list = query.getResultList();

		return list;
	}

	@Override
	public Customer_info getCustomerInfo(long contactNumber) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("TestPersistence");
		EntityManager manager = factory.createEntityManager();
		Customer_info record = manager.find(Customer_info.class, contactNumber);
		factory.close();
		manager.close();
		return record;
	}
}

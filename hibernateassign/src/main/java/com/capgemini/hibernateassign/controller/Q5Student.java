package com.capgemini.hibernateassign.controller;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class Q5Student {
	public static void main(String[] args) {

		EntityManagerFactory factory = Persistence.createEntityManagerFactory("TestPersistence");
		EntityManager manager = factory.createEntityManager();

		Query query = manager.createQuery("select AVG(s.totalMarks) from Student s");
		Double result = (Double) query.getSingleResult();
		System.out.println("Average of total marks----->" + result);
		
		Query query1=manager.createQuery("select MAX(s.totalMarks) from Student s");
		Double result1=(Double)query1.getSingleResult();
		System.out.println("MAX of total marks----->"+result1);
		
		Query query2=manager.createQuery("select MIN(s.totalMarks) from Student s");
		Double result2=(Double)query2.getSingleResult();
		System.out.println("MIN of total marks----->"+result2);

		manager.close();
		factory.close();
	}

}

package com.capgemini.hibernateassign.controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import com.capgemini.hibernateassign.dto.Student;

public class Q4Student {
	public static void main(String[] args) {

		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("TestPersistence");
		EntityManager manager = factory.createEntityManager();
		String jpql = "select e from Student e where e.rollNum=:erollNum and e.subject=:esubject";
		TypedQuery<Student> query = manager.createQuery(jpql, Student.class);
		query.setParameter("erollNum", 1);
		query.setParameter("esubject", "maths");
		List<Student> recordlist = query.getResultList();
		for (Student studentInfo : recordlist) {
			System.out.println(studentInfo.getFirstName());
			System.out.println(studentInfo.getLastName());
			System.out.println(studentInfo.getTotalMarks());

			System.out.println("---------------------------------");
		}
		factory.close();
		manager.close();

	}// End Of Main

}// End Of class

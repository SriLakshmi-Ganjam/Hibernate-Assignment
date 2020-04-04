package com.capgemini.hibernateassign.controller;

import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import com.capgemini.hibernateassign.dto.Student;

public class Q3Student {
		
		public static void main(String[] args) {

			EntityManagerFactory factory=Persistence.createEntityManagerFactory("TestPersistence");
			EntityManager manager=factory.createEntityManager();
			String jpql="select s from Student s";
			TypedQuery<Student> query=manager.createQuery(jpql,Student.class );
			List<Student> recordlist=query.getResultList();
			Iterator<Student> it=recordlist.iterator();
			while(it.hasNext()) {
				Student info=it.next();
				System.out.println(info.getFirstName());
				System.out.println(info.getTotalMarks());
				System.out.println("--------------------------");
				
			}
			
			
			
			
		}
		

}

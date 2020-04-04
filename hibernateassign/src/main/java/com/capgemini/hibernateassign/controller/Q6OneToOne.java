package com.capgemini.hibernateassign.controller;


	import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.capgemini.hibernateassign.dto.StudentInfo;
import com.capgemini.hibernateassign.dto.StudentOtherInfo;

public class Q6OneToOne {
		public static void main(String[] args) {

			EntityManagerFactory factory=null;
			EntityManager manager=null;
			EntityTransaction transaction=null;

			StudentInfo info = new StudentInfo();
			info.setRollNumber(1);
			info.setName("Sri laxmi");
			info.setEmailId("srilaxmi@gmail.com");
			info.setMobileNumber(9785469332l);
			info.setGender("female");
			info.setAge(22);

			StudentOtherInfo otherInfo = new StudentOtherInfo();
			otherInfo.setFathername("Seshagiri Rao");
			otherInfo.setMothername("Rajeshwari");
			otherInfo.setReligion("Hindu");
			otherInfo.setNationality("Indian");
			otherInfo.setInfo(info);

			try {

				factory = Persistence.createEntityManagerFactory("TestPersistence");
				manager = factory.createEntityManager();
				transaction = manager.getTransaction();
				transaction.begin();
				manager.persist(otherInfo);
				System.out.println("Record Saved");
				transaction.commit();
			} catch (Exception e) {
				e.printStackTrace();
				transaction.rollback();
			}

			finally {

				manager.close();
				factory.close();
			}
		}
	}


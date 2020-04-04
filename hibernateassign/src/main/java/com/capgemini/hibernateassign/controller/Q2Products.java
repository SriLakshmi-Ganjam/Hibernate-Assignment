package com.capgemini.hibernateassign.controller;

import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import com.capgemini.hibernateassign.dto.ProductInfo;

public class Q2Products {
		public static void main(String[] args) {
			EntityManagerFactory factory=Persistence.createEntityManagerFactory("TestPersistence");
			EntityManager manager=factory.createEntityManager();
			String jpql="select p from ProductInfo p where p.price<100";
			TypedQuery<ProductInfo> query=manager.createQuery(jpql,ProductInfo.class );
			List<ProductInfo> recordlist=query.getResultList();
			Iterator<ProductInfo> it=recordlist.iterator();
			while(it.hasNext()) {
				ProductInfo info=it.next();
				System.out.println(info.getProductId());
				System.out.println(info.getProductName());
				System.out.println(info.getPrice());
				System.out.println(info.getColour());
				System.out.println(info.getWeight());
			}
			
		}
}



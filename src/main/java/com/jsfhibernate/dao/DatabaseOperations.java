package com.jsfhibernate.dao;

import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.Transaction;


import com.jsfhibernate.pojo.Book;

import com.jsfhibernate.util.HibernateUtil;



public class DatabaseOperations {

	private static EntityManager em = HibernateUtil.getEntityManagerFactory().createEntityManager();
	  private static EntityTransaction tx = em.getTransaction();
	  
	  
	  
		public static void create(Book book) {
			tx.begin();
			em.persist(book);
			tx.commit();
			em.close();
		}


}

package com.jsfhibernate.util;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import com.jsfhibernate.pojo.User;

public class UserModel {
	
	private static EntityManager em = HibernateUtil.getEntityManagerFactory().createEntityManager();
	  private static EntityTransaction tx = em.getTransaction();
	  
	  
	  
		public static void create(User user) {
			tx.begin();
			em.persist(user);
			tx.commit();
			em.close();
		}
		
		public List<User> getAllUsers(){
		
			TypedQuery<User> query = em.createQuery("Select user from User user ",User.class);
			return query.getResultList();
		}
		
		public User getById(Long id) {
			tx.begin();
			TypedQuery<User> query = em.createQuery("Select user from User user where user.id=:id ",User.class);
			query.setParameter("id", id);
			tx.commit();
			return query.getSingleResult();
			
		}
		public static void delete(Long id) {
			tx.begin();
			Query query = em.createQuery("delete  from User user where user.id=:id ");
			query.setParameter("id", id);
			query.executeUpdate();
			tx.commit();
		}
		public static void update(User user) {
			tx.begin();
			em.merge(user);
			tx.commit();
		}

}

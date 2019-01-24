package com.jsfhibernate.dao;

import javax.faces.context.FacesContext;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.jsfhibernate.pojo.Book;
import com.jsfhibernate.util.HibernateUtil;

public class DatabaseOperations {

	private static Transaction transObj;
	private static Session sessionObj = HibernateUtil.getSessionFactory().openSession();
	
	public void addStudentInDb(Object book) {		
		try {
			transObj = sessionObj.beginTransaction();
			sessionObj.save(book);
		

			// XHTML Response Text
					
		} catch (Exception exceptionObj) {
			exceptionObj.printStackTrace();
		} finally {
			transObj.commit();
		}
	}

}

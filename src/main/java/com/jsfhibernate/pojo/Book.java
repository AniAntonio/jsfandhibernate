package com.jsfhibernate.pojo;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import javax.persistence.*;

import com.jsfhibernate.dao.DatabaseOperations;

@ManagedBean @RequestScoped
@Entity
@Table(name = "book")
public class Book implements java.io.Serializable  {
    private long id;
    private String title;
    private String author;
    private float price;
    private static final long serialVersionUID = 1L;
    public static DatabaseOperations dbObj;
 
    public Book() {
    }
    @Id
    @Column(name = "book_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long getId() {
        return id;
    }
 
    public void setId(long id) {
        this.id = id;
    }
 
    public String getTitle() {
        return title;
    }
 
    public void setTitle(String title) {
        this.title = title;
    }
 
    public String getAuthor() {
        return author;
    }
 
    public void setAuthor(String author) {
        this.author = author;
    }
 
    public float getPrice() {
        return price;
    }
 
    public void setPrice(float price) {
        this.price = price;
    }
    public void saveStudentRecord() {
		System.out.println("Calling saveStudentRecord() Method To Save Student Record");
		dbObj = new DatabaseOperations();
		dbObj.addStudentInDb(this);
	}
    

}
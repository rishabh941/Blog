package com.example.demo;

import java.time.LocalDate;
import java.time.LocalTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name = "blog")
public class Blog {

	
      @Id
	  @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    public Long getId() {
		return id;
	}
	  public void setId(Long id) {
		  this.id = id;
	  }
	  public String getName() {
		  return name;
	  }
	  public void setName(String name) {
		  this.name = name;
	  }
	  public String getTopic() {
		  return topic;
	  }
	  public void setTopic(String topic) {
		  this.topic = topic;
	  }
	  public String getContent() {
		  return content;
	  }
	  public void setContent(String content) {
		  this.content = content;
	  }
	  public LocalDate getDate() {
		  return date;
	  }
	  public void setDate(LocalDate date) {
		  this.date = date;
	  }
	  public LocalTime getTime() {
		  return time;
	  }
	  public void setTime(LocalTime time) {
		  this.time = time;
	  }
	  
	  public Blog(Long id, String name, String topic, String content) {
	        this.id = id;
	        this.name = name;
	        this.topic = topic;
	        this.content = content;
	    }
	  
	  public Blog() {
		  
	  }
	  
		private String name;     
	    private String topic; 
	    
	   
	    private String content;
	    
	    private LocalDate date;
	    private LocalTime time;

	    // Getters and Setters
}

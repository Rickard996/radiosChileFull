package com.Application.model;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

//this is an Entity to be persisted in the "in-memory" H2 DB

//now, for production i will use Mysql database and JPA

@Entity
public class Radio {
	//the id
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	//the name of the radio
	private String name;
	//the icecast source
	private String icecastSource;
	//the name of the image
	private String image;
	
	//empty constructor
	public Radio() {
		
	}
	//constructor with attributes
	public Radio(String name, String icecastSource, String image) {
		super();
		this.name = name;
		this.icecastSource = icecastSource;
		this.image = image;
	}
	
	//getter and setters
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
	public String getIcecastSource() {
		return icecastSource;
	}
	public void setIcecastSource(String icecastSource) {
		this.icecastSource = icecastSource;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	
	//to String hashcode and equals
	
	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return Objects.hash(this.id, this.name, this.image, this.icecastSource);
	}
	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		if(this == obj) return true;  //same reference
		if( !(obj instanceof Radio)) return false; //if the object is NOT a Radio return false at once
		Radio otherRadio = (Radio) obj; //assume now that the object IS-A Radio
		if( otherRadio.id == this.id && otherRadio.name ==this.name) {   //my criteria
			return true;
		}else {
			return false;
		}
		
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "The radio "+this.name+" has an id of: "+this.id+" in the Database, and the icecast source is: "+this.icecastSource;
	}
	
}

package com.rudra.aks.filter.bo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.Filter;
import org.hibernate.annotations.Proxy;

@Entity
@Table( name = "person")
@Proxy(lazy = false)
//@Filter( name= "personfilter")
public class PersonBO {

	@Id
	@GeneratedValue ( strategy =  GenerationType.IDENTITY)
	private int id;
	private String First_Name;
	private String Last_Name;
	private String Street_Name;
	private String City;
	private String State;
	private String Country;
	@Transient
	private String defaultUser="user1";
	
	@Override
	public String toString() {
		return "PersonBO [id=" + id + ", First_Name=" + First_Name + ", Last_Name=" + Last_Name + ", Street_Name="
				+ Street_Name + ", City=" + City + ", State=" + State + ", Country=" + Country + "]";
	}

	public static PersonBO personBuilder(String firstName, String lastName, String streetName, String city, String state, String country) {
		PersonBO personBO = new PersonBO();
		personBO.setFirst_Name(firstName);
		personBO.setLast_Name(lastName);
		personBO.setStreet_Name(streetName);
		personBO.setCity(city);
		personBO.setState(state);
		personBO.setCountry(country);
		return personBO;
	}
	
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getFirst_Name() {
		return First_Name;
	}


	public void setFirst_Name(String first_Name) {
		this.First_Name = first_Name;
	}


	public String getLast_Name() {
		return Last_Name;
	}


	public void setLast_Name(String last_Name) {
		this.Last_Name = last_Name;
	}


	public String getStreet_Name() {
		return Street_Name;
	}


	public void setStreet_Name(String street_Name) {
		this.Street_Name = street_Name;
	}


	public String getCity() {
		return City;
	}


	public void setCity(String city) {
		this.City = city;
	}


	public String getState() {
		return State;
	}


	public void setState(String state) {
		this.State = state;
	}


	public String getCountry() {
		return Country;
	}


	public void setCountry(String country) {
		this.Country = country;
	}
	
}

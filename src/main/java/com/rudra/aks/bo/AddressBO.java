package com.rudra.aks.bo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Filter;

@Entity
@Table(name = "Address")
@Filter( name = "clientFilter", condition = "clientid = :clientidfromparam")
public class AddressBO {

	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY)
	private int id;
	private String address;
	private String country;
		
	
	@Override
	public String toString() {
		return "AddressBO [id=" + id + ", address=" + address + ", country=" + country + "]";
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public String getCountry() {
		return country;
	}


	public void setCountry(String country) {
		this.country = country;
	}


	public static class AddressBuilder {
		public static AddressBO buildAddress( String address, String country) {
			AddressBO addressBO = new AddressBO();
			addressBO.setAddress(address);
			addressBO.setCountry(country);
			return addressBO;
		}
	}
}

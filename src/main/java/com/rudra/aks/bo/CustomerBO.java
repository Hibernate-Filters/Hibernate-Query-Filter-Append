package com.rudra.aks.bo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Filter;
import org.hibernate.annotations.FilterDef;
import org.hibernate.annotations.ParamDef;

@Entity
@Table(name = "Customer")	
@FilterDef(name = "clientFilter",defaultCondition = "clientid = :clientidfromparam", parameters = @ParamDef( name = "clientidfromparam", type = "integer"))
@Filter(name = "clientFilter")
public class CustomerBO {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int		customerid;
	private String  customername;
	private String  mobileno;
	private String  emailid;
	
	
	@Override
	public String toString() {
		return "Customer [customerid=" + customerid + ", customername=" + customername + ", mobileno=" + mobileno
				+ ", emailid=" + emailid + "]";
	}
	
	public int getCustomerid() {
		return customerid;
	}
	public void setCustomerid(int customerid) {
		this.customerid = customerid;
	}
	public String getCustomername() {
		return customername;
	}
	public void setCustomername(String customername) {
		this.customername = customername;
	}
	public String getMobileno() {
		return mobileno;
	}
	public void setMobileno(String mobileno) {
		this.mobileno = mobileno;
	}
	public String getEmailid() {
		return emailid;
	}
	public void setEmailid(String emailid) {
		this.emailid = emailid;
	}
	
		
	public static class CustomerBuilder {
		public static CustomerBO buildCustomer(String customername, String mobileno, String emailid) {
			CustomerBO    cust = new CustomerBO();
			cust.setCustomername(customername);
			cust.setMobileno(mobileno);
			cust.setEmailid(emailid);
			return cust;
		}
	}
}

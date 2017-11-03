package com.rudra.aks.test;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.hibernate.Filter;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.rudra.aks.DatabaseConfig;
import com.rudra.aks.bo.AddressBO;
import com.rudra.aks.bo.CustomerBO;

public class QueryClientIDTest {/*

	private static AnnotationConfigApplicationContext	context;
	private static Session session;
	
	@BeforeClass
	public static void init() {
		context = new AnnotationConfigApplicationContext(DatabaseConfig.class);
		session = context.getBean(SessionFactory.class).openSession();
	}
	
	@Test
	public void checkNumberofCustomerWithClientOne () {
		//enabling filter clientfilter
		Filter filter = session.enableFilter("clientFilter"); 
		filter.setParameter("clientidfromparam", 1);   

		@SuppressWarnings("deprecation")
		List<CustomerBO>	custlist = session.createCriteria(CustomerBO.class).list();
		
		assertEquals( 6, custlist.size() );
	}
	
	@Test
	public void filterbotest() {
		Filter filter = session.enableFilter("clientFilter"); 
		filter.setParameter("clientidfromparam", 1); 
		@SuppressWarnings("deprecation")
		List<CustomerBO>	custlist = session.createCriteria(AddressBO.class).list();
		
		assertEquals( 6, custlist.size() );
	}
	
	
	@AfterClass
	public static void close() {
		session.close();
		context.close();
	}
*/}

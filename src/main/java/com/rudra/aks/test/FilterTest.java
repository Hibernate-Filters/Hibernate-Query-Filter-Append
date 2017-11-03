package com.rudra.aks.test;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Filter;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.annotations.FilterDef;
import org.hibernate.annotations.ParamDef;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.rudra.aks.DatabaseConfig;
import com.rudra.aks.bo.AddressBO;
import com.rudra.aks.bo.CustomerBO;

public class FilterTest {

	private static final Logger logger = Logger.getLogger(FilterTest.class);
	
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DatabaseConfig.class);
		SessionFactory sessionFactory = context.getBean(SessionFactory.class);
		Session session = sessionFactory.openSession();
		
		//enabling filter clientfilter
		Filter filter = session.enableFilter("clientFilter"); 
		filter.setParameter("clientidfromparam", 1);   
		
		/*AddressBO add1 = AddressBO.AddressBuilder.buildAddress("chennai", "india", 1);
		int addid = (Integer) session.save(add1);
		logger.info("AddresBO saved ... " + addid);*/

		//loading CustomerBO
		@SuppressWarnings("deprecation")
		List<CustomerBO>	custlist = session.createCriteria(CustomerBO.class).list();
		logger.info("========== Filter Test CustomerBO ==========  " + custlist.size());
		for(CustomerBO   c: custlist)
			logger.info("Customer id for client 1 : " + " -- " + c.getCustomerid());
		
		//loading AddressBO
		@SuppressWarnings("deprecation")
		List<AddressBO>	addlist = session.createCriteria(AddressBO.class).list();
		logger.info("========== Filter Test AddressBO ==========  " + addlist.size());
		for(AddressBO   ad: addlist)
			logger.info("Customer id for client 1 : " + ad.getId() + " -- " + ad.getAddress());
		
		
		session.close(); 
		context.close();
	}

	/*private void listCriteria(Session session) {
		CriteriaBuilder cb = session.getCriteriaBuilder();
		CriteriaQuery<CustomerBO> cq = cb.createQuery(CustomerBO.class);

		Root<CustomerBO> customerRoot = cq.from(CustomerBO.class);
		ParameterExpression<Integer> id = cb.parameter(Integer.class);

		cq.select(customerRoot).where(cb.eq(customerRoot.get("id"),id));

		TypedQuery<CustomerBO> query = em.createQuery(cq);
		query.setParameter(p, 2);
		List<CustomerBO> results = query.getResultList();
	}*/

}

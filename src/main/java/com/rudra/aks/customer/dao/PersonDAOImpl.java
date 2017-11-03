package com.rudra.aks.customer.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Filter;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.rudra.aks.filter.bo.PersonBO;

@Repository
public class PersonDAOImpl implements PersonDAO {

	@Autowired
	HibernateTemplate	hibernateTemplate;
	
	@Autowired
	SessionFactory	sessionFactory;
	
	private static final Logger logger = Logger.getLogger(PersonDAOImpl.class);
	
	
	/**
	 * 
	 */
	public int save(PersonBO customer) {
		int id = 0;
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		id = (int) session.save(customer);
		tx.commit();
		session.close();
		return id;
	}
	
	/*public int save(PersonBO customer) {
		return (Integer) hibernateTemplate.save(customer);
	}
*/
	@Override
	public void delete(PersonBO customer) {
		try {
			Session session = sessionFactory.openSession();
			Transaction tx = session.beginTransaction();
			session.delete(customer);
			tx.commit();
			session.close();
			logger.info("Customer information deleted...");
		} catch ( Exception e) { logger.error("Customer deletion failed! " + e); }
		
	}
	
	
	public List<PersonBO> search(String columnName, String searchText) {
		/*List<PersonBO>	searchResult = new ArrayList<PersonBO>();
		try {
			
			Session session = sessionFactory.openSession();
			FullTextSession	fullTextSession = Search.getFullTextSession(session);
			//fullTextSession.createIndexer().startAndWait();
			 
			// alternatively you can write the Lucene query using the Lucene query parser
			// or the Lucene programmatic API. The Hibernate Search DSL is recommended though
			QueryBuilder qb = fullTextSession.getSearchFactory().buildQueryBuilder().forEntity(PersonBO.class).get();
			
			org.apache.lucene.search.Query query = qb
					.keyword()
					.onFields(columnName)
					.matching(searchText)
					.createQuery();
			// wrap Lucene query in a org.hibernate.Query
			org.hibernate.Query hibQuery = fullTextSession.createFullTextQuery(query, PersonBO.class);
			
			// execute search
			@SuppressWarnings("unchecked")
			List<PersonBO> result = (hibQuery.list());
			logger.info("----No of matching result : " + result.size());
			searchResult = result;
			
			Iterator<PersonBO> it = result.iterator();
			logger.info("==============================List of matched search resultl: ============================");
			while (it.hasNext()) {
				PersonBO PersonBO1 = it.next();
				logger.info(PersonBO1);
			}
		} catch (Exception e) {
				logger.error("Exception occurred!" + e);
		}	
		return searchResult;*/
		return null;
	}

	@Override
	public PersonBO getPerson(int personid, String defaultUser) {
		PersonBO personBO = new PersonBO();
		try {
			Session session = sessionFactory.openSession();
			Filter enableFilter = session.enableFilter("personfilter");
			enableFilter.setParameter("defaultUser", defaultUser);
			Transaction tx = session.beginTransaction();
			personBO = session.load(PersonBO.class, personid);
			tx.commit();
			session.close();
			logger.info("Customer information deleted...");
		} catch ( Exception e) { logger.error("Person fetching failed! " + e); }
		//personBO = hibernateTemplate.get(PersonBO.class, personid);
		return personBO;
	}


}

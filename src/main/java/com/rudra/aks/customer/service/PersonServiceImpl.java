package com.rudra.aks.customer.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rudra.aks.customer.dao.PersonDAO;
import com.rudra.aks.filter.bo.PersonBO;

@Service
public class PersonServiceImpl implements PersonService {

	@Autowired
	PersonDAO		persondao;
	
	private static final Logger logger = Logger.getLogger(PersonServiceImpl.class);
	
	
	public int save(PersonBO person) {
		return persondao.save(person);
	}


	public List<PersonBO> search(String columnName, String searchText) {
		return persondao.search(columnName, searchText);
	}


	@Override
	public void delete(PersonBO person) {
		persondao.delete(person);
		
	}


	@Override
	public PersonBO getPerson(int personid, String defaultUser) {
		return persondao.getPerson(personid, defaultUser);
	}
	
	
}

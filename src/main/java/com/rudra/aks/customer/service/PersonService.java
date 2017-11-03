package com.rudra.aks.customer.service;

import java.util.List;

import com.rudra.aks.bo.CustomerBO;
import com.rudra.aks.filter.bo.PersonBO;

public interface PersonService {
	int save(PersonBO person);
	List<PersonBO>	search(String columnName, String searchText);
	void delete(PersonBO person);
	PersonBO getPerson(int personid, String defaultUser);
}

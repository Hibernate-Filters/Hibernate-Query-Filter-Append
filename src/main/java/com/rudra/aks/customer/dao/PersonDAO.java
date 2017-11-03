package com.rudra.aks.customer.dao;

import java.util.List;

import com.rudra.aks.bo.CustomerBO;
import com.rudra.aks.filter.bo.PersonBO;

public interface PersonDAO {
	int save(PersonBO customer);
	List<PersonBO>	search(String columnName, String searchText);
	void delete(PersonBO customer);
	PersonBO getPerson(int personid, String defaultUser);
}

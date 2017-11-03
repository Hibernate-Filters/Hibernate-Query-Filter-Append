package com.rudra.aks.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.rudra.aks.customer.service.PersonService;
import com.rudra.aks.filter.bo.PersonBO;

@RestController
@RequestMapping(path = "/person")
public class PersonController {

	@Autowired
	PersonService		personService;
	
	private static final Logger logger = Logger.getLogger(PersonController.class);
	
	@RequestMapping(path = "/save", method = RequestMethod.POST, consumes="application/json")
	public	ResponseEntity<?>	savePerson(@RequestBody PersonBO person) {
		logger.info("Person controller >>");
		try {
			return new ResponseEntity<Integer>(personService.save(person), HttpStatus.OK);
		} catch (Exception e ) {
			logger.error("Exception : " + e);
			return new ResponseEntity<String>("Exception : ", HttpStatus.BAD_REQUEST);
		}
	}
	
	@RequestMapping(path = "/search/{columnName}/{searchText}", method = RequestMethod.GET)
	public List<PersonBO>	search(@PathVariable String columnName, @PathVariable String searchText) {
		return personService.search(columnName, searchText);
	}
	
	@RequestMapping(path = "/delete", method = RequestMethod.POST)
	public	ResponseEntity<?>	delete(@RequestBody PersonBO person) {
		logger.info("Person controller >>");
		try {
			personService.delete(person);
			return new ResponseEntity<>("Person info deleted...", HttpStatus.OK);
		} catch (Exception e ) {
			logger.error("Exception : " + e);
			return new ResponseEntity<String>("Exception while deletion: ", HttpStatus.BAD_REQUEST);
		}
	}
	
	@RequestMapping(path = "/get/{personid}", method = RequestMethod.GET)
	public ResponseEntity<?>	getPerson(@PathVariable int personid, @RequestHeader HttpHeaders header) {
		String defaultUser = "user1";
		if( header.containsKey("userid") ) {
			List<String> list = header.get("userid");
			defaultUser = list.get(0);
			logger.info("key : " + list.size() + "  " + list.get(0));
		}
		return new ResponseEntity<>(personService.getPerson(personid, defaultUser), HttpStatus.OK);
	}
	
		@RequestMapping(path = "/", method = RequestMethod.GET)
	public String	testRestCall() {
		return "Customer Service Starting ....";
	}
}

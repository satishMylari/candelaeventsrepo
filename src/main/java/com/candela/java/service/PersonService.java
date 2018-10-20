package com.candela.java.service;
import java.util.Hashtable;

import org.audit4j.core.annotation.Audit;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.candela.java.*;

import com.candela.java.model.Person;
@Service
@Audit
public class PersonService {
	Hashtable<String,Person> Persons=new Hashtable<String,Person>();
	 int key = 3;
	
	public PersonService() {
		Person person = new Person();
		person.setAge(25);
		person.setFirstNme("sai");
		person.setLastName("ram");
		person.setId("1");
		
		Persons.put("1",person);
		
		person = new Person();
		person.setAge(35);
		person.setFirstNme("omsri");
		person.setLastName("ragvendra");
		person.setId("2");
		Persons.put("2",person);
		
	}
	
	public Person getPerson(String id) {
		if (Persons.containsKey(id))
			return Persons.get(id);
		else
			return null;
		}
	
	@Audit
    public String savePerson(Person person) {
 
		System.out.println(" Calling save personService  @@@@@@");
		System.out.println(" print person ID " + person.getId()); 
		Persons.put(person.getId(),person);
        System.out.println(" Calling save personService @@@@@@@");
        
        return "Person information saved successfully audited ::." ;
    }
	
	@Audit
    public String saveAuditPerson(Person person) {
 
		System.out.println(" start Calling saveAuditPerson inside personService");
		System.out.println(" print person ID " + person.getId()); 
		Persons.put(person.getId(),person);
        System.out.println(" start Calling saveAuditPerson inside personService");
        
        return "Person information saved successfully audited ::." ;
    }
	
public Hashtable<String ,Person> getAll(){
	return Persons;
}
}

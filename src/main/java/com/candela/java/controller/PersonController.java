package com.candela.java.controller;

import java.util.Hashtable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.candela.java.model.Person;
import com.candela.java.service.PersonService;


@RestController
@RequestMapping("/persons")
public class PersonController {
    @Autowired
	PersonService ps;
    
    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;
    
    @RequestMapping("{id}")
    public Person getPerson(@PathVariable("id") String id) {
    	return ps.getPerson(id);
    }
    
    @RequestMapping("/all")
    public Hashtable<String, Person> getAll() {
    	return ps.getAll();
    }
    
    @PostMapping(path = "/save-person-info")
    public String personInfo(@RequestBody Person person) {
    	System.out.println(" PersonController Personnnn  " + person.toString());
		System.out.println(" Calling save info @@@@@@@@@@@@@@@@@@@@@@@");
		Person personData = new Person();
		System.out.println(" Calling save info 111 @@@@@@@@@@@@@@@@@@@@@@@");
		personData.setId(person.getId());
		personData.setFirstNme(person.getFirstNme());
		personData.setLastName(person.getLastName());
		personData.setAge(person.getAge());
		System.out.println(" Calling save info 111222 @@@@@@@@@@@@@@@@@@@@@@@");
       ps.savePerson(personData);
   	System.out.println(" Calling save info 111 333 @@@@@@@@@@@@@@@@@@@@@@@");
        System.out.println(" Completed Calling save info @@@@@@@@@@@@@@@@@@@@@@@");
        return "Person information saved successfully ::." ;
    }
    
    
    @PostMapping(path = "/save-person-audit")
    public String auditInfo(@RequestBody Person person) {
    	System.out.println(" PersonController auditInfo  " + person.toString());
		
		Person personData = new Person();
		System.out.println(" @@@@@@@@@@@ Calling auditInfo @@@@@@@@@@@");
		personData.setId(person.getId());
		personData.setFirstNme(person.getFirstNme());
		personData.setLastName(person.getLastName());
		personData.setAge(person.getAge());
		System.out.println(" @@@@@@@@@@@ Calling auditInfo  @@@@@@@@@@@");
       ps.saveAuditPerson(personData);
  
        System.out.println(" Completed Calling auditInfo @@@@@@@@@@@@@@@@@@@@@@@");
        return "Person information audited successfully ::." ;
    }
    
    
    @RequestMapping("/")
    public String  getMessage() {
    	return "Hello World";
    }
    
    @KafkaListener(topics = "candelaEvent-topic")
    public void listen(String message) {
       System.out.println("Received Messasge in group - group-id: " + message);
    }
    @PostMapping(path = "/save-person-info-topic")
     public String sendPersonInfoToKafka(@RequestBody Person person) {
       	System.out.println(" PersonController Personnnn to Kafka " + person.toString());
        kafkaTemplate.send("candelaEvent-topic", person.toString());
        return "Person information saved to kafka queue ::." ;
     }
}

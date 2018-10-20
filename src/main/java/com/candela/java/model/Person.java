package com.candela.java.model;

public class Person {
 String id;
 String firstNme;
 String lastName;
 int age;
 public Person() {}
 @Override
public String toString() {
	return "Person [id=" + id + ", firstNme=" + firstNme + ", lastName=" + lastName + ", age=" + age + "]";
}
public Person(String id,  String firstNme, String lastName,int age) {
     this.id = id;
     this.firstNme = firstNme;
     this.lastName = lastName;
     this.age = age;
 }
public String getId() {
	return id;
}
public void setId(String id) {
	this.id = id;
}
public String getFirstNme() {
	return firstNme;
}
public void setFirstNme(String firstNme) {
	this.firstNme = firstNme;
}
public String getLastName() {
	return lastName;
}
public void setLastName(String lastName) {
	this.lastName = lastName;
}
public int getAge() {
	return age;
}
public void setAge(int age) {
	this.age = age;
}
 
 
}

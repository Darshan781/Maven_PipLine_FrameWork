package com.demoapps.TestData;

import com.github.javafaker.Faker;

public class DynamicDataGenerator {
	
 static	Faker fake = new Faker();
	
 public static String getFirstName() {
	return fake.name().firstName();
		
	}
public static String getLastName() {
		return fake.name().lastName();
	}
public static String getEmailId() {
	return fake.internet().emailAddress();
}
public static String getPassword() {
	return fake.internet().password(6, 8, true, true, true);
}
  public static String getGender() {
	return  fake.options().option("Male","Female");
	
}
}

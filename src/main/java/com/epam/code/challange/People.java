package com.epam.code.challange;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Builder
public class People {
	
	int age;
	String location;
	double salary;
	String gender;
	
}

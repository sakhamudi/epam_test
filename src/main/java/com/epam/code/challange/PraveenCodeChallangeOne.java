package com.epam.code.challange;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.stream.Collectors;

public class PraveenCodeChallangeOne {

	public static void main(String args[]) {

		People p1 = People.builder().age(10).gender("M").location("Hyderabad").salary(10000.00).build();
		People p2 = People.builder().age(20).gender("F").location("Chenni").salary(90000.00).build();
		People p3 = People.builder().age(30).gender("M").location("Hyderabad").salary(10000.00).build();
		People p4 = People.builder().age(40).gender("F").location("Chenni").salary(10000.00).build();

		List<People> peopleList = Arrays.asList(p1, p2, p3, p4);

		  getMaxSalary(peopleList);
		  getLocationPeople(peopleList);
		  
		// grater salry
		// list me people who are from diff location

	}
	
	public static void getLocationPeople(List<People> peopleList){
		
		Map<String, List<People>>  result = peopleList.stream().collect(Collectors.groupingBy(People::getLocation));
		System.out.println(result);
		
	}

	
	public static void getMaxSalary(List<People> peopleList) {

		OptionalDouble maxSalery = peopleList.stream().mapToDouble(people -> people.getSalary()).max();

		if (maxSalery.isPresent()) {
			System.out.println("Max Salry in List is ::" + maxSalery.getAsDouble());
		}
	}

}

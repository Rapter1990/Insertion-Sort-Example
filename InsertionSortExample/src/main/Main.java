package main;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import insertionsort.InsertionSortProcess;
import model.Person;
import util.DefineValues;
import util.ShowProcess;

public class Main {

	private static ArrayList<Person> personList = new ArrayList<>();
	private static ArrayList<Person> sortedpersonList = new ArrayList<>();
	
	public static void main(String[] args) throws ParseException {
		
		
		personList = DefineValues.defineValues(personList);
		
		
		System.out.println("---------------------------------");
		System.out.println("BEFORE INSERTION SORT byId");
		ShowProcess.showValues(personList);	
		Person[] personsById = InsertionSortProcess.byId(personList);
		// Convert Array to ArrayList
		sortedpersonList = new ArrayList<>(Arrays.asList(personsById));
		System.out.println("AFTER INSERTION SORT byId");
		ShowProcess.showValues(sortedpersonList);	
		System.out.println("---------------------------------\n");
		
		System.out.println("BEFORE INSERTION SORT byLastName");		
		ShowProcess.showValues(personList);				
		sortedpersonList = InsertionSortProcess.byLastName(personList);	
		System.out.println("AFTER INSERTION SORT byLastName");
		ShowProcess.showValues(sortedpersonList);
		System.out.println("---------------------------------\n");
		
		System.out.println("BEFORE INSERTION SORT byName");
		ShowProcess.showValues(personList);
		sortedpersonList = InsertionSortProcess.byName(personList);
		System.out.println("AFTER INSERTION SORT byName");
		ShowProcess.showValues(sortedpersonList);
		System.out.println("---------------------------------\n");
		
		System.out.println("BEFORE INSERTION SORT byAge");		
		ShowProcess.showValues(personList);
		Person[] personsByAge = InsertionSortProcess.byAge(personList);
		// Convert Array to ArrayList
		sortedpersonList = new ArrayList<>(Arrays.asList(personsByAge));
		System.out.println("AFTER INSERTION SORT byAge");
		ShowProcess.showValues(sortedpersonList);
		System.out.println("---------------------------------");
		
		System.out.println("BEFORE INSERTION SORT byRegisterDate");		
		ShowProcess.showValues(personList);
		Person[] personsByRegisterDate = InsertionSortProcess.byRegisterDate(personList);
		// Convert Array to ArrayList
		sortedpersonList = new ArrayList<>(Arrays.asList(personsByRegisterDate));
		System.out.println("AFTER INSERTION SORT byRegisterDate");
		ShowProcess.showValues(sortedpersonList);
		System.out.println("---------------------------------");
	}
}

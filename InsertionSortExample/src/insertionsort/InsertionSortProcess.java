package insertionsort;

import java.text.Collator;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Locale;

import model.Person;

public class InsertionSortProcess {

	public static Person[] byId(ArrayList<Person> personList) {

		// Convert ArrayList to Array
		Person[] persons = personList.toArray(new Person[personList.size()]);

		for (int i = 1; i < persons.length; i++) {
			Person selectedPerson = persons[i];
			int loc = i;

			while ((loc > 0) && (new Long(persons[loc - 1].getId()).compareTo(selectedPerson.getId()) > 0)) {
				persons[loc] = persons[loc - 1];
				loc--;
			}
			persons[loc] = selectedPerson;
		}

		return persons;
	}

	public static ArrayList<Person> byLastName(ArrayList<Person> personList) {

		Comparator<Person> compTr = new Comparator<Person>() {
			@Override
			public int compare(Person p0, Person p1) {
				Collator collator = Collator.getInstance(new Locale("tr", "TR"));
				return collator.compare(p0.getLastname(), p1.getLastname());
			}
		};
		
		

		// Convert ArrayList to Array
		Person[] persons = personList.toArray(new Person[personList.size()]);

		for (int i = 1; i < persons.length; i++) {
			Person selectedPerson = persons[i];
			int loc = i; 
			while ((loc > 0) && (greaterThan(compTr, persons[loc - 1], selectedPerson))) {
				persons[loc] = persons[loc - 1];
				loc--;
			}
			persons[loc] = selectedPerson;
		}
		
		// Convert Array to ArrayList
		personList = new ArrayList<>(Arrays.asList(persons));
		//Collections.sort(personList,compTr);
		

		return personList;
	}

	public static ArrayList<Person> byName(ArrayList<Person> personList) {
		
		Comparator<Person> compTr = new Comparator<Person>() {
			@Override
			public int compare(Person p0, Person p1) {
				Collator collator = Collator.getInstance(new Locale("tr", "TR"));
				return collator.compare(p0.getName(), p1.getName());
			}
		};
		
		// Convert ArrayList to Array
		Person[] persons = personList.toArray(new Person[personList.size()]);

		for (int i = 1; i < persons.length; i++) {
			Person selectedPerson = persons[i];
			int loc = i;
			while ((loc > 0) && (greaterThan(compTr, persons[loc - 1], selectedPerson))) {
				persons[loc] = persons[loc - 1];
				loc--;
			}
			persons[loc] = selectedPerson;
		}
		
		// Convert Array to ArrayList
		personList = new ArrayList<>(Arrays.asList(persons));
		
		//Collections.sort(personList,compTr);

		return personList;
	}

	public static Person[] byAge(ArrayList<Person> personList) {
		
		// Convert ArrayList to Array
		Person[] persons = personList.toArray(new Person[personList.size()]);

		for (int i = 1; i < persons.length; i++) {
			Person selectedPerson = persons[i];
			int loc = i;

			while ((loc > 0) && (new Integer(persons[loc - 1].getAge()).compareTo(selectedPerson.getAge()) > 0)) {
				persons[loc] = persons[loc - 1];
				loc--;
			}
			persons[loc] = selectedPerson;
		}

		return persons;
	}
	
	public static Person[] byRegisterDate(ArrayList<Person> personList) {
		
		Comparator<Person> compTr = new Comparator<Person>() {
			@Override
			public int compare(Person p0, Person p1) {
				if(p0.getRegisterDate().before(p1.getRegisterDate())){
					return -1;
				}else if(p0.getRegisterDate().after(p1.getRegisterDate())) {
					return 1;
				}else {
					return 0;
				}
			}
		};
		
		// Convert ArrayList to Array
		Person[] persons = personList.toArray(new Person[personList.size()]);

		for (int i = 1; i < persons.length; i++) {
			Person selectedPerson = persons[i];
			int loc = i;

			while ((loc > 0) && (greaterThan(compTr, persons[loc - 1], selectedPerson))) {
				persons[loc] = persons[loc - 1];
				loc--;
			}
			persons[loc] = selectedPerson;
		}

		return persons;
	}
	
	private static boolean greaterThan(Comparator comp, Person x, Person y) { 
        return comp.compare(x,y) > 0;
    }
	
}

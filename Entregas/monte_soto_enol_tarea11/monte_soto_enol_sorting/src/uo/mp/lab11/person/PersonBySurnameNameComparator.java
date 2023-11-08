package uo.mp.lab11.person;

import java.util.Comparator;

public class PersonBySurnameNameComparator implements Comparator<Person> {


	@Override
	public int compare(Person p1, Person p2) {
		if (p1.getSurname().compareTo(p2.getSurname()) == 0) {
			return (p1.getName().compareTo(p2.getName()));
		} else {
			return (p1.getSurname().compareTo(p2.getSurname()));
		}
	}

}

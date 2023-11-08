package uo.mp.lab01.plane.ui;

import uo.mp.lab01.plane.model.Person;
import uo.mp.lab01.plane.model.Plane;

public class Main {

	public static void main(String[] args) {
		
		Person pilot = new Person("Manolo", 23);
		Plane myPlane = new Plane(pilot, 'X', 10000);
		
		System.out.println("Datos del avión:\n" + myPlane.toString());

	}

}

package uo.mp.s6.greenhouse.controllers;

import java.util.ArrayList;
import java.util.List;

import uo.mp.s6.greenhouse.actuators.doors.Door;
import uo.mp.s6.greenhouse.sensors.TemperatureSensor;

/**
 * 
 * @author Lectures of Programming Methodology
 * @version 2.0
 */
public class TemperatureController {
	public static final double MAX_TEMPERATURE = 22;
	public static final double MIN_TEMPERATURE = 19;

	private List<TemperatureSensor> sensors = new ArrayList<>();	
	private List<Door> doors = new ArrayList<>();
		
		
	public void add(TemperatureSensor sensor) {
		this.sensors.add(sensor);
	}

	public void add(Door door) {
		this.doors.add(door);
	}

	/**
	 * Handles the doors to keep the temperature under control between 19 and 22 degrees
	 *
	 * @return A list of messages generated when monitoring
	 */
	public List<String> monitor() {
		
				
		/*
		 * Outside is cold, so opening the doors always involves cooling inside.
		 * When getAverageTemperature is greater than maxTemperature 
		 * 	- Some doors should be opened for cooling (if possible)
		 *	- Each degree of difference 
		 *		(getAverageTemperature-maxTemperature) involves opening 10% 
		 *		of the doors (if possible)
		 * 	- Show a message telling how many doors are about to 
		 * 		be opened (if possible)
		 * 
		 * When getAverageTemperature is lower than minTemperature 
		 *	- Some doors should be closed for heating (if possible)
		 *	- Each degree of difference 
		 * 		(minTemperature-getAverageTemperature) involves opening 10% 
		 * 		of the doors (if possible)
		 * - Show a message telling how many doors are about to be 
		 *		closed (if possible)
		 *
		 * Otherwise, a message showing the average temperature is 
		 * 	simply shown on the console
		 */

		/*
		 *  Holds strings to be returned to the control panel to inform the 
		 *  gardener after each and every execution of method monitor()
		 */
		List<String> messages = new ArrayList<String>();	
		
		double avgTemp = getAverageTemperature();
		
		if(avgTemp > MAX_TEMPERATURE) {
			messages.addAll(coolDown(avgTemp));
		}
		
		else if(avgTemp < MIN_TEMPERATURE) {
			messages.addAll(warmUp(avgTemp));
		}
		
		else {
			messages.add(rightTemperature(avgTemp));
		}
		
		return messages;
	}
	
	/**
	 * Warms up the greenhouse
	 * @param temp the average temperature calculate
	 * @return a list of messages to inform the gardener, produced while trying
	 * 		to warm up the greenhouse
	 */
	private List<String> warmUp(double temp) {
		List<String> messages = new ArrayList<String>();
		messages.add("Warming up the greenhouse...");
		// Hacer en casa.
		return messages;
	}
	
	/**
	 * Tries to close doorsToClose doors
	 * @param doorsToClose number of doors to close
	 * @return a list of messages to inform the gardener, produced while trying
	 * 		close as many doors as the argument
	 */
	private List<String> closeDoors(int doorsToClose) {
		return null;
	}
	
	/**
	 * Cools down the greenhouse
	 * @param temp the average temperature calculate
	 * @return a list of messages to inform the gardener, produced while trying
	 * 		to cool down the greenhouse
	 */
	private List<String> coolDown(double temp) {
		
		List<String> messages = new ArrayList<String>();
		messages.add(String.format("Current temp is %2.2f degrees. It is too hot.", temp));
		
		int doorsToOpen = (int) ((temp-MAX_TEMPERATURE) * 0.1 * doors.size());
		messages.addAll(openDoors(doorsToOpen));
		
		return messages;
		
	}

	/**
	 * Tries to open doorsToOpen doors
	 * @param doorsToOpen number of doors to open
	 * @return a list of messages to inform the gardener, produced while trying
	 * 		open as many doors as the argument
	 */
	private List<String> openDoors(int doorsToOpen) {	
		
		List<String> messages = new ArrayList<String>();
		messages.add(doorsToOpen+ " doors must be opened");
		
		for(int i=0; i < doors.size() && doorsToOpen > 0; i++) {
			if(doors.get(i).isOpened()) {
				messages.add(doors.get(i).open());
				doorsToOpen--;
			}
		}
		
		return messages;
		
	}
	
	
	private String rightTemperature(double temp) {
		return "Average temperature " +  temp + " is right";
	}
	
	/**
	 * Gets the average temperature in the greenhouse.
	 * 
	 * @return The average temperature in the greenhouse.
	 */
	private double getAverageTemperature() {
		double addition = 0;
		for(TemperatureSensor sensor : sensors) {
			addition += sensor.getTemperature();
		}
		return addition / sensors.size();
	}

}

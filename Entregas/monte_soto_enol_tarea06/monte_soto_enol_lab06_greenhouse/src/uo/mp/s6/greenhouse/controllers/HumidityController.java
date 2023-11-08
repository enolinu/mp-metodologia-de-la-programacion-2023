package uo.mp.s6.greenhouse.controllers;

import java.util.ArrayList;
import java.util.List;

import uo.mp.greenhouse.actuators.irrigators.Irrigator;
import uo.mp.greenhouse.actuators.irrigators.Position;
import uo.mp.s6.greenhouse.sensors.HumiditySensor;

/**
 * @author enolmontesoto
 *
 */
public class HumidityController {
	
	private static final int DRY_LIMIT = 40;
	private static final int DAMP_LIMIT = 60;
	
	private List<HumiditySensor> sensors = new ArrayList<HumiditySensor>();
	private Irrigator irrigator = new Irrigator();
	
	public void add(HumiditySensor sensor) {
		this.sensors.add(sensor);
	}
	
	public List<String> monitor() {
		
		List<String> messages = new ArrayList<String>();	
		
		double avgHumidity = getAverageHumidity();
		messages.add("Current humidity is " + avgHumidity);
		
		if(avgHumidity >= DRY_LIMIT && avgHumidity <= DAMP_LIMIT) {
			messages.add("Humidity is right");
			return messages;
		} 
		
		if(avgHumidity > (DAMP_LIMIT + 20)) {
			messages.add("It is too DAMP.");
			messages.addAll(changeIrrigatorPosition(Position.OFF));
		}
		
		else if(avgHumidity < (DRY_LIMIT - 20)) {
			messages.add("It is too DRY.");
			messages.addAll(changeIrrigatorPosition(Position.HIGH));
		}
		
		else if(avgHumidity > DAMP_LIMIT) {
			messages.add("It is a little too DAMP.");
			messages.addAll(nextIrrigatorPosition());
		}
		
		else if(avgHumidity < DRY_LIMIT) {
			messages.add("It is a little too dry.");
			messages.addAll(nextIrrigatorPosition());
		}

		return messages;
	}
	
	private List<String> changeIrrigatorPosition(Position pos) {
		List<String> messages = new ArrayList<String>();
		messages.add(irrigator.changePosition(pos));
		return messages;
	}
	
	private List<String> nextIrrigatorPosition() {
		List<String> messages = new ArrayList<String>();
		messages.add(irrigator.nextPosition());
		return messages;
	}
	
	/**
	 * Gets the average humidity in the greenhouse.
	 * 
	 * @return The average humidity in the greenhouse.
	 */
	private double getAverageHumidity() {
		double addition = 0;
		for(HumiditySensor sensor : sensors) {
			addition += sensor.getHumidity();
		}
		return addition / sensors.size();
	}

}

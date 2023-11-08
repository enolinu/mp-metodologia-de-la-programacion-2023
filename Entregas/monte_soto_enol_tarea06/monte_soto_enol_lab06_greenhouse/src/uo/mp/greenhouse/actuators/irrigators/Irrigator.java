/**
 * 
 */
package uo.mp.greenhouse.actuators.irrigators;

/**
 * @author enolmontesoto
 *
 */
public class Irrigator {
	
	private Position position;
	
	public Irrigator() {
		this.setPosition(Position.OFF);
	}

	public Position getPosition() {
		return position;
	}

	private void setPosition(Position position) {
		this.position = position;
	}
	
	public String changePosition(Position newPosition) {
		
		Position oldPosition = getPosition();
		setPosition(newPosition);
		return "Irrigator system is " + oldPosition + " and is set to " + newPosition;
		 
	}
	
	public String nextPosition() {
		
		Position oldPosition = getPosition();
		Position newPosition = obtainNextPosition();
		setPosition(newPosition);
		return "Irrigator system is " + oldPosition + " and is set to " + newPosition;
		 
	}
	
	private Position obtainNextPosition() {
		
		switch(position) {
		case OFF: return Position.LOW;
		case LOW: return Position.MEDIUM;
		case MEDIUM: return Position.HIGH;
		default: return position;
		
		}
	}
	
	

}

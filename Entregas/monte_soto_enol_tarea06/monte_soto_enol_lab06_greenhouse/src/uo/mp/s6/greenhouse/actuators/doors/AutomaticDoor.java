/**
 * 
 */
package uo.mp.s6.greenhouse.actuators.doors;

import java.util.Random;

import uo.mp.s6.greenhouse.controllers.devicescanner.Scanneable;

/**
 * @author enolmontesoto
 *
 */
public class AutomaticDoor extends Door implements Scanneable {

	public AutomaticDoor(int id) {
		super(id);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public String open(){
		if ( ! isOpened()) {			
			setOpened(true);
			return "  The door " + getId() + " is opening.";
		}
		return "";
	}
	
	@Override
	public String close(){
		if ( isOpened()) {
			setOpened(false);
			return "  The door " + getId() + " is closing.";
		}
		return "";
	}

	@Override
	public boolean check() {
		
		return new Random().nextDouble() >= 0.05;
		
	}	

}

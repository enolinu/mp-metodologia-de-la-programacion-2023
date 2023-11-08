package uo.mp.s6.greenhouse.actuators.doors;

/**
 * <p>Title: Door</p>
 * <p>Description: Class that simulates a door.</p>
 * <p>Copyright: Copyright (c) 2022</p>
 * <p>Computer Science Engineering School</p>
 * <p>Programming Methodology</p>
 * 
 * @author Lectures of Programming Methodology
 * @version 2.0
 */
public class Door {

	private boolean opened = false;
	private int id;
	
	public Door(int id) {
		this.id = id;
	}

	public boolean isOpened() {
		return this.opened;
	}
	
	protected void setOpened(boolean cond) {
		this.opened = cond;
	}
	
	protected int getId() {
		return id;
	}
	
	public String open(){
		if ( ! opened) {			
			opened = true;
			return "  Please, open the door " + id;
		}
		return "";
	}

	public String close(){
		if ( opened) {
			opened = false;
			return "  Please, close the door " + id;
		}
		return "";
	}	
}

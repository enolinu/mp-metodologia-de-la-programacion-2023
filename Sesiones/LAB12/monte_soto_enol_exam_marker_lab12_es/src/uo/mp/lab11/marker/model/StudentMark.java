package uo.mp.lab11.marker.model;

import java.io.Serializable;

public class StudentMark implements Comparable<StudentMark>, Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String id;
	private Double mark;
	
	/** 
	 * @param id
	 * @param mark If is < 0, attribute mark is set to zero.  
	 * @throws IllegalArgumentException if 
	 * 			- id is null or blank
	 */
	public StudentMark(String id, double mark) {
		this.id = id;
		this.mark = mark;
	}

	public double getMark() {
		return this.mark;
	}

	public String getStudentId() {
		return this.id;
	}

	@Override
	public int compareTo(StudentMark sm) {
		return ((Double)sm.getMark()).compareTo(mark); // Orden descendente.
		
		// return ((Double)mark).compareTo(o.get(mark)); Orden ascendente.
	}
	
	public String serialize() {
		return id + "\t" + mark;
	}

}

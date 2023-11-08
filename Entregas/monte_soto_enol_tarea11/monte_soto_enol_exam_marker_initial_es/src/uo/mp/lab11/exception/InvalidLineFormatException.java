package uo.mp.lab11.exception;

import uo.mp.util.check.ArgumentChecks;

public class InvalidLineFormatException extends Exception {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int line;

	public InvalidLineFormatException() {
		// TODO Auto-generated constructor stub
	}
	
	public InvalidLineFormatException(String msg) {
		super(msg);
	}
	
	public InvalidLineFormatException(int line, String msg) {
		
		super(msg);
		
		ArgumentChecks.isTrue(line >= 0);
		this.line = line;
		
	}
	
	@Override
	public String getMessage() {
		return "Error en línea " + line + ": " + super.getMessage();
	}

}

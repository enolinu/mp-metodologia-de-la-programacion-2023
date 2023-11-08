package uo.mp.lab11.exception;

import uo.mp.util.check.ArgumentChecks;

public class LineFormatException extends Exception {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int line;

	public LineFormatException() {
		// TODO Auto-generated constructor stub
	}
	
	public LineFormatException(String msg) {
		super(msg);
	}
	
	public LineFormatException(int line, String msg) {
		
		super(msg);
		
		ArgumentChecks.isTrue(line >= 0);
		this.line = line;
		
	}
	
	@Override
	public String getMessage() {
		return "Error en línea " + line + ": " + super.getMessage();
	}

}

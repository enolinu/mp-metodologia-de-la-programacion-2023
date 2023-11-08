package uo.mp.lab11.exception;

import uo.mp.util.check.ArgumentChecks;

public class ExamMarkerException extends Exception {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int line;

	public ExamMarkerException() {
		// TODO Auto-generated constructor stub
	}
	
	public ExamMarkerException(String msg) {
		super(msg);
	}
	
	public ExamMarkerException(int line, String msg) {
		
		super(msg);
		
		ArgumentChecks.isTrue(line >= 0);
		this.line = line;
		
	}
	
	@Override
	public String getMessage() {
		return "Error en línea " + line + ": " + super.getMessage();
	}

}

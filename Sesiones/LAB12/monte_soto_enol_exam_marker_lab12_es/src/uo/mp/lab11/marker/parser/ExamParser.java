package uo.mp.lab11.marker.parser;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import uo.mp.lab11.exception.ExamMarkerException;
import uo.mp.lab11.marker.model.StudentExam;
import uo.mp.util.check.ArgumentChecks;
import uo.mp2223.util.log.Logger;

public class ExamParser {
	
	private int lineNumber = 1;
	
	/**
	 * 
	 * @param lines
	 * @return
	 * @throws IllegalArgumentException if lines is null
	 */
	public List<StudentExam> parse(List<String> lines) {
		ArgumentChecks.isTrue(lines != null, "Illegal null list");
		List<StudentExam> res = new LinkedList<>();
		for(String line: lines) {
			try {
				checkIsBlank(line);
				res.add( parseLine( line ) );
			}catch(ExamMarkerException e) {
				Logger.log(e.getMessage());
			}
			lineNumber++;
		}
		return res;
	}

	private StudentExam parseLine(String line) {
		String parts[] = line.split("\t");
		String studentCode = parts[0];
		List<String> res = new ArrayList<>();
		
		for(int i = 1; i < parts.length; i++) {
			res.add( parts[i] );
		}
		StudentExam se = new StudentExam( studentCode, res );

		return se;
	}
	
	private void checkIsBlank(String line) throws ExamMarkerException {
		if(line.isBlank()) {
			throw new ExamMarkerException(lineNumber, "Linea en blanco");
		}
	}

}

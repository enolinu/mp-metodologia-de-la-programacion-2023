package uo.mp.lab11.marker.parser;

import java.util.LinkedList;
import java.util.List;
import uo.mp.lab11.exception.LineFormatException;
import uo.mp.lab11.marker.model.question.ChoiceQuestion;
import uo.mp.lab11.marker.model.question.GapQuestion;
import uo.mp.lab11.marker.model.question.Question;
import uo.mp.lab11.marker.model.question.ValueQuestion;
import uo.mp.util.check.ArgumentChecks;
import uo.mp2223.util.log.Logger;

public class QuestionParser {
	
	
	private int number = 0;

	/**
	 * 
	 * @param lines
	 * @return
	 * @throws IllegalArgumentException if lines is null
	 */
	public List<Question> parse(List<String> lines) {
		
		ArgumentChecks.isTrue(lines != null);
		List<Question> res = new LinkedList<>();
		
		for(String line: lines) {
			try {
				checkIsBlank(line);
				res.add( parseQuestion(number, line ) );
			}catch(LineFormatException e) {
				Logger.log(e.getMessage());
			}
		}

		return res;
	}

	private Question parseQuestion(int number, String line) throws LineFormatException  {
		
		String[] elements = line.split("\t");
		String type = elements[0];
		String weight = elements[1];
		String answer = elements[2];
		
		if(type.equals("choice")) {
			return new ChoiceQuestion(number, parseDouble(weight), answer);
		}
		
		if(type.equals("gap")) {
			return new GapQuestion(number, parseDouble(weight), answer);
		}
		
		if(type.equals("value")) {
			return new ValueQuestion(number, parseDouble(weight), parseDouble(answer));
		}
		
		return null;
		
	}

	private double parseDouble(String value) throws LineFormatException {
		try {
			return Double.parseDouble(value);
		} catch(NumberFormatException e) {
			throw new LineFormatException("No se pudo parsear el dato " + value +" a precisión doble");
		}
		
	}
	
	private void checkIsBlank(String line) throws LineFormatException {
		if(line.isBlank()) {
			throw new LineFormatException(number, "Linea en blanco");
		}
	}
			
			
			

}

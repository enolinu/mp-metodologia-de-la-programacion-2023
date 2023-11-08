package uo.mp.lab11.marker.parser;

import java.util.LinkedList;
import java.util.List;

import uo.mp.lab11.marker.model.question.ChoiceQuestion;
import uo.mp.lab11.marker.model.question.GapQuestion;
import uo.mp.lab11.marker.model.question.Question;
import uo.mp.lab11.marker.model.question.ValueQuestion;
import uo.mp.util.check.ArgumentChecks;

public class QuestionParser {

	/**
	 * 
	 * @param lines
	 * @return
	 * @throws IllegalArgumentException if lines is null
	 */
	public List<Question> parse(List<String> lines) {
		
		ArgumentChecks.isTrue(lines != null);
		List<Question> res = new LinkedList<>();
		
		int number = 0;
		
		for(String line: lines) {
			number++;
			res.add(parseQuestion(number, line));
		}

		return res;
	}

	private Question parseQuestion(int number, String line) {
		
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

	private double parseDouble(String value) {
		return Double.parseDouble(value);
	}
			
			
			

}

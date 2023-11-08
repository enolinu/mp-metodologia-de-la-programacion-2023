package uo.mp.lab11.marker.model;

import java.util.ArrayList;
import java.util.List;

import uo.mp.lab11.marker.model.question.Question;

public class StudentExam {

	private String id;
	private ArrayList<String> answers;

	/**
	 * 
	 * @param id
	 * @param answers
	 * @throws IllegalArgumentException if 
	 * 		- id is null or blank
	 *      - id is not length five or does not contain just digits
	 * 		- answers is null
	 */
	public StudentExam(String id, List<String> answers) {
		this.id = id;
		this.answers = new ArrayList<>( answers );
	}

	/**
	 * 
	 * @param questions
	 * @return
	 * @throws IllegalArgumentException if questions is null
	 */
	public double mark(List<Question> questions) {
		
		double mark = 0;
		
		for(Question q: questions) {
			mark += q.mark(id);
		}
		
		return mark;
		
	}

	public String getId() {
		return id;
	}


}

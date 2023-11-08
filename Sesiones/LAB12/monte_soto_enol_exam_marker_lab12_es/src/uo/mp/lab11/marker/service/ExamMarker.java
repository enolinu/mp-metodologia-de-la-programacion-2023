package uo.mp.lab11.marker.service;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import uo.mp.lab11.exception.ExamMarkerException;
import uo.mp.lab11.marker.model.StudentExam;
import uo.mp.lab11.marker.model.StudentMark;
import uo.mp.lab11.marker.model.question.Question;
import uo.mp.lab11.marker.model.serialize.MarkSerializer;
import uo.mp.lab11.marker.parser.ExamParser;
import uo.mp.lab11.marker.parser.QuestionParser;
import uo.mp.lab11.marker.service.sort.ByStudentIdComparator;
import uo.mp.util.fileutil.FileUtil;
import uo.mp.util.fileutil.ZipFileUtil;


public class ExamMarker {
	/*
	 * file questions.txt is read and parsed into questions list
	 */
	private List<Question> questions = new ArrayList<>();
	/*
	 * file answers.gz is read and parsed into answers list
	 */
	private List<StudentExam> answers = new ArrayList<>();
	/*
	 * Student marks are computed and stored into marks list
	 */
	private List<StudentMark> marks = new ArrayList<>();


	/**
	 * 
	 * @param examModelFile
	 * @throws ExamMarkerException 
	 * @throws IllegalArgumentException if examModelFile is null or blank
	 * @throws FileNotFoundException if examModelFile cannot be found
	 */
	public void loadQuestions(String questionsFilename) throws ExamMarkerException {
		List<String> lines = readQuestionLines(questionsFilename);
		List<Question> questions = new QuestionParser().parse( lines );
		addQuestions( questions );
	}
	
	/*
	 * TODO : FAKE IMPLEMENTATION
	 */
	private List<String> readAnswerLines() throws ExamMarkerException {
		
		try {
			return new ZipFileUtil().readLines("answers.gz");
		} catch(FileNotFoundException e) {
			throw new ExamMarkerException("No se encontró el fichero");
		}
	}
	
	
	/*
	 * TODO : FAKE IMPLEMENTATION
	 */
	private void addQuestions(List<Question> quests) {
		this.questions = quests;
		
	}

	/**
	 * 
	 * @param answersFilename
	 * @throws FileNotFoundException if answersFile cannot be found
	 * @throws IllegalArgumentException if answersFilename is null or blank
	 * @throws ExamMarkerException when there are more than one exam for the same student 
	 */
	public void loadAnswers(String answersFilename) throws ExamMarkerException {

		List<String> lines = readAnswerLines();
		List<StudentExam> exams = new ExamParser().parse( lines );
		addExams( exams );
	}

	/*
	 * TODO: FAKE IMPLEMENTATION
	 */
	private void addExams(List<StudentExam> exams) throws ExamMarkerException {
		for(StudentExam exam: exams) {
			addExam(exam);
		}
	}
	
	private void addExam(StudentExam exam) throws ExamMarkerException {
		if(searchById(exam.getId()) == false) {
			answers.add(exam);
		} else {
			throw new ExamMarkerException("Entrega repetida del alumno: " + exam.getId());
		}
	}
	
	private boolean searchById(String id) {
		for(int i=0; i<answers.size(); i++) {
			StudentExam s = answers.get(i);
			if(s.getId().equals(id)) {
				return true;
			}
		}
		return false;
	}

	private List<String> readQuestionLines(String questionsFilename) throws ExamMarkerException {
		try {
			return new FileUtil().readLines(questionsFilename);
		} catch(FileNotFoundException e) {
			throw new ExamMarkerException("No se encontró el fichero");
		}
	}


	/**
	 * 
	 * @return the list of marks ordered by student id in ascending order
	 */
	public List<StudentMark> getMarksByStudent() {

		Collections.sort(marks, new ByStudentIdComparator());
		return new ArrayList<StudentMark>(marks);	
		
	}

	/**
	 * 
	 * @return the list of marks ordered by grade in ascending order
	 * 			For the same grade, by ascending student id
	 */
	public List<StudentMark> getMarksByMark() {
 
		Collections.sort(marks);
		return new ArrayList<StudentMark>(marks);
		
	}

	/**
	 * calculates the mark for each exam. 
	 * Generates StudentMark instances
	 */
	public void mark() {
		
		marks.clear();
		
		for(StudentExam exam: answers) {
			double total = exam.mark(questions);
			marks.add(new StudentMark(exam.getId(), total));
		}
		
	}

	/**
	 * 
	 * @param resultsFilename
	 * @throws IllegalArgumentException if resultsFilename is null or blank
	 */
	public void saveResults(String resultsFilename) {
		List<String> lines = new MarkSerializer().serialize(marks);
		new FileUtil().writeLines(resultsFilename, lines);
	}


	public List<StudentExam> getAnswers() {
		return new ArrayList<StudentExam>(answers);
	}

	public List<Question> getQuestions() {
		return new ArrayList<Question>(questions);
	}


}

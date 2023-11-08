package uo.mp2223.newsstand.service.parsers;

import java.util.ArrayList;
import java.util.List;

import uo.mp.util.check.ArgumentChecks;
import uo.mp2223.newsstand.domain.Frequency;
import uo.mp2223.newsstand.domain.Magazine;
import uo.mp2223.newsstand.domain.Newspaper;
import uo.mp2223.newsstand.domain.Publication;
import uo.mp2223.newsstand.exception.InvalidLineFormatException;
import uo.mp2223.util.log.Logger;

public class PublicationParser {
	
	private int lineNumber = 1;

	/**
	 * Transforms a list of Strings in a list of instances of Publication.
	 * Any of the following are invalid lines in the input file: 
	 * 		- blank lines, 
	 * 		- wrong number of fields in a line, and 
	 * 		- incorrect data format in numeric fields.
	 * Invalid lines will not produce a Publication instance but will throw an InvalidLineFormatException instead.
	 * As a result of processing this exception, a message will be written to a log (use Log) 
	 * @param lines non-null list of strings, probably empty
	 * 		One by each publication
	 * 				type_of_publication \t name_of_publication \t sales \t stock \t frequency
	 * 
	 * @return a list of publications
	 */
	public List<Publication> parse(List<String> lines) {
		
		ArgumentChecks.isTrue(lines != null);
		
		List<Publication> publications = new ArrayList<>();
		
		for(String line: lines) {
		
			try {
				
				checkIsBlank(line);
				Publication publication = parseLine(line);
				publications.add(publication);
				
			} catch (InvalidLineFormatException e) {
				
				Logger.log(e.getMessage());
				
			}
			
			lineNumber++;
			
		}
		
		return publications;
		
	}

	private void checkIsBlank(String line) throws InvalidLineFormatException {
		
		if(line.isBlank()) {
			throw new InvalidLineFormatException(lineNumber, "Linea en blanco");
		}
		
		
	}

	/**
	 * Analiza la linea que recibe como parámetro y la transforma en una publicación.
	 * Según el tipo, será periódico o revista. El formato de la linea es...
	 * Tipo publicación /t nombre /t stock /t vendido /t [frecuencia, si es revista.]
	 * @param line
	 * @return publicacion con los datos recibidos.
	 * @throws InvalidLineFormatException 
	 */
	private Publication parseLine(String line) throws InvalidLineFormatException {

		String[] tokens = line.split("\t");
		String type = tokens[0];
		
		if(type.equals("newspaper")) {
			return newspaperParser(tokens);
		} 
		
		else if(type.equals("magazine")) {
			return magazineParser(tokens);
		}
		
		throw new InvalidLineFormatException(lineNumber, "Tipo desconocido.");
	}
	
	/**
	 * 
	 * @param tokens
	 * @return
	 * @throws InvalidLineFormatException 
	 */
	private Publication magazineParser(String[] tokens) throws InvalidLineFormatException {
		
		checkNumberOfTokens(tokens, 5);
		
		String name = tokens[1];
		int stock = toInteger(tokens[2]);
		int sales = toInteger(tokens[3]);
		Frequency frequency = Frequency.valueOf(tokens[4]);
		
		return new Magazine(name, stock, sales, frequency);
		
	}

	/**
	 * 
	 * @param tokens
	 * @return
	 * @throws InvalidLineFormatException 
	 */
	private Publication newspaperParser(String[] tokens) throws InvalidLineFormatException {
		
		checkNumberOfTokens(tokens, 5);
		
		String name = tokens[1];
		int stock = toInteger(tokens[2]);
		int sales = toInteger(tokens[3]);
		
		return new Newspaper(name, stock, sales);
		
	}

	private void checkNumberOfTokens(String[] tokens, int numberOfTokens) throws InvalidLineFormatException {

		if(tokens.length != numberOfTokens) {
			throw new InvalidLineFormatException(lineNumber, "Número de campos incorrecto.");
		}
		
	}

	private int toInteger(String string) throws InvalidLineFormatException {
		
		try {
			return Integer.parseInt(string);
		} catch(NumberFormatException e) {
			throw new InvalidLineFormatException(lineNumber, "Formato de número erróneo.");
		}
		
	}

}

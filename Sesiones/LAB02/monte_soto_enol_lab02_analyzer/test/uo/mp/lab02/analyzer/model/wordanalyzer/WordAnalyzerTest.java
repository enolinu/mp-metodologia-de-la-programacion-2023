package uo.mp.lab02.analyzer.model.wordanalyzer;

import static org.junit.jupiter.api.Assertions.*;

//import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import uo.mp.lab02.analyzer.model.WordAnalyzer;

class WordAnalyzerTest {
	
	/*
	 * Constructor que recibe la cadena de caracteres (no blancos, no vacia, no null).
	 * Casos De Uso:
	 * 
	 * 1- Palabra con varios caracteres normales.
	 * 2- Palabra con blancos.
	 * 3- Null en lugar de palabra.
	 * 4- Palabra vacia.
	 * 
	 * 
	 */
	
	/**
	 * GIVEN Una cadena con varios caracteres normales.
	 * WHEN Construimos un analizador para esa cadena.
	 * THEN Se carga dicha cadena en el analizador.
	 */
	@Test
	void SomeCharactersForWord() {  // Es el nombre del caso.
		
		String word = "cualquier cadena";
		WordAnalyzer analyzer = new WordAnalyzer(word);
		
		assertEquals(word, analyzer.toString());
		
	}
	
	/**
	 * GIVEN Una cadena con solo blancos.
	 * WHEN: Construimos un analizador para esa cadena.
	 * THEN: Lanza una "IllegalArgumentException"
	 */
	@Test
	void AllBlankCharactersForWord() {  
		
		String word = "      ";
		
		try {
			new WordAnalyzer(word);
			fail("Esperaba salto de excepcion");
		} catch(IllegalArgumentException iAE) {
			assertTrue(true); // Si el mensaje es indiferente.
		}
		
	}

}

package uo.mp2223.util.collections;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import uo.mp2223.util.collections.impl.ArrayList;
import uo.mp2223.util.collections.impl.LinkedList;

public class AddLastTests4 {
	
	// SCENARIOS
	//1 Add en una lista vacía añade el elemento y devuelve true
	//2 Add en una lista con varios elementos, añade el elemento en la última posición y devuelve true
	//3 Se puede añadir un elemento repetido
	//4 Intentar añadir un null, se lanza IllegalArgumentException y la lista permanece igual

	public static Stream<Arguments> createLists() {
		  return Stream.of(
		      Arguments.of(new ArrayList()),
		      Arguments.of(new LinkedList())
		  );
		}

	/**
	 * GIVEN: Una lista cualquiera.
	 * WHEN: Se le añade un elemento nulo.
	 * THEN: Salta excepción y la lista no cambia.
	 */
	@ParameterizedTest@MethodSource("createLists")  
	public void nullElement(List list) {
		
		try {
			list.add(null);
			fail();
		} catch(IllegalArgumentException e) {
			assertTrue(true);
			assertEquals("[]", list.toString());
			assertEquals(0, list.size());
		}
		
	}

	@ParameterizedTest@MethodSource("createLists") 
	/**
	 * GIVEN: 
	 * WHEN: 
	 * THEN: 
	 */
	public void emptyList(List list) {
		fail();
	}
	
	/**
	 * GIVEN: 
	 * WHEN: 
	 * THEN: 
	 */
	@ParameterizedTest@MethodSource("createLists") 
	public void notNullElement(List list) {
		fail();
	}

	/**
	 * GIVEN: 
	 * WHEN: 
	 * THEN: 
	 */
	@ParameterizedTest@MethodSource("createLists")  
	public void notNullRepeatedElement(List list) {		
		fail();
	}
	


}

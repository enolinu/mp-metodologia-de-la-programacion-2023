package uo.mp.lab01.game.model.game2048;

import static org.junit.Assert.*;

import org.junit.Test;

import uo.mp.lab01.game.model.util.ForTesting;
import uo.mp.lab02.game.model.Game2048;


public class Game2048WithIntParamTest {
	
	/**
	 * WHEN Se crea un tablero con el tamano "estandar".
	 * THEN Se crea el objeto correctamente.
	 */
	@Test
	public void defaultBoardCreated() {
		
		Game2048 g = new Game2048(3);
		assertEquals(3, g.getBoardForTesting().length);
		assertNotEquals(ForTesting.BLANK, g.getBoardForTesting());
		
	}
	
	/**
	 * WHEN Se crea un tablero con el tamano minimo permitido.
	 * THEN Se crea el objeto correctamente.
	 */
	@Test
	public void minBoardCreated() {
		
		Game2048 g = new Game2048(2);
		assertEquals(2, g.getBoardForTesting().length);
		
	}
	
	/**
	 * WHEN Se crea un tablero con el tamano maximo permitido.
	 * THEN Se crea el objeto correctamente.
	 */
	@Test
	public void maxBoardCreated() {
		
		Game2048 g = new Game2048(5);
		assertEquals(5, g.getBoardForTesting().length);
		
	}
	
	/**
	 * WHEN Se crea un tablero con un valor intermedio, pero dentro de los limites.
	 * THEN Se crea el objeto correctamente.
	 */
	@Test
	public void interBoardCreated() {
		
		Game2048 g = new Game2048(4);
		assertEquals(4, g.getBoardForTesting().length);
		
	}
	
	/**
	 * WHEN Se crea un tablero de tamano demasiado pequeno.
	 * THEN Salta excepcion y no se crea el objeto.
	 */
	@Test
	public void tooSmallBoardCreated() {
		
		try {
			@SuppressWarnings("unused")
			Game2048 g = new Game2048(1);
		} catch(IllegalArgumentException iAE) {
			assertEquals(iAE.getMessage(), "The argument for the size is not valid!");
			
		}
		
	}
	
	/**
	 * WHEN Se crea un tablero de tamano demasiado grande.
	 * THEN Salta excepcion y no se crea el objeto.
	 */
	@Test
	public void tooBigBoardCreated() {
		
		try {
			@SuppressWarnings("unused")
			Game2048 g = new Game2048(100);
		} catch(IllegalArgumentException iAE) {
			assertEquals(iAE.getMessage(), "The argument for the size is not valid!");
			
		}
		
	}

}

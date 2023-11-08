package uo.mp.lab01.game.model.game2048;

import static org.junit.Assert.*;

import org.junit.Test;

import uo.mp.lab01.game.model.Game2048;
import uo.mp.lab01.game.model.util.ForTesting;


public class Game2048WithIntParamTest {
	
	/**
	 * CASO P1: Se crea un tablero con el tamano "estandar".
	 */
	@Test
	public void defaultBoardCreated() {
		
		Game2048 g = new Game2048(3);
		assertEquals(3, g.getBoardForTesting().length);
		assertNotEquals(ForTesting.BLANK, g.getBoardForTesting());
		
	}
	
	/**
	 * CASO P2: Se crea un tablero con el tamano minimo permitido.
	 */
	@Test
	public void minBoardCreated() {
		
		Game2048 g = new Game2048(2);
		assertEquals(2, g.getBoardForTesting().length);
		
	}
	
	/**
	 * CASO P3: Se crea un tablero con el tamano maximo permitido.
	 */
	@Test
	public void maxBoardCreated() {
		
		Game2048 g = new Game2048(5);
		assertEquals(5, g.getBoardForTesting().length);
		
	}
	
	/**
	 * CASO P4: Se crea un tablero con un valor intermedio, pero dentro de los limites.
	 */
	@Test
	public void interBoardCreated() {
		
		Game2048 g = new Game2048(4);
		assertEquals(4, g.getBoardForTesting().length);
		
	}
	
	/**
	 * CASO N1: Se crea un tablero de tamano demasiado pequeno.
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
	 * CASO N2: Se crea un tablero de tamano demasiado grande.
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

package uo.mp.lab01.game.model.game2048;

import static org.junit.Assert.*;

import org.junit.Test;

import uo.mp.lab01.game.model.util.ForTesting;
import uo.mp.lab02.game.model.Game2048;

public class Game2048WithBoardParamTest {
	
	/**
	 * WHEN Matriz correcta.
	 * THEN Se crea el objeto.
	 */
	@Test
	public void correctTest() {
		Game2048 g = new Game2048(ForTesting.BLANK);
		assertArrayEquals(ForTesting.BLANK, g.getBoardForTesting());
		assertEquals(3, g.getSize());
	}
	
	/**
	 * WHEN Se pasa valor incoherente.
	 * THEN Salta excepcion.
	 */
	@Test
	public void invalidBoardTest() {
		
		int[][] board = {{3,0,0},{0,5,0},{0,0,15}};
		
		try {
			new Game2048(board);
		} catch(IllegalArgumentException nPE) {
			assertEquals("Illegal value!", nPE.getMessage());
		}
		
	}
	
	/**
	 * WHEN Se pasa valor ilegal.
	 * THEN Salta excepcion.
	 */
	@Test
	public void illegalTest() {
		
		try {
			new Game2048(new int[10][10]);
		} catch(IllegalArgumentException nPE) {
			assertEquals("Illegal value!", nPE.getMessage());
		}
		
	}
	
	
}

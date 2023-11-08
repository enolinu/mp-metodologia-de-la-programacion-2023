package uo.mp.lab01.game.model.game2048;

import static org.junit.Assert.*;

import org.junit.Test;

import uo.mp.lab01.game.model.Game2048;
import uo.mp.lab01.game.model.util.ForTesting;

public class Game2048WithBoardParamTest {
	
	/**
	 * Se pasa una matriz valida.
	 */
	@Test
	public void correctTest() {
		Game2048 g = new Game2048(ForTesting.BLANK);
		assertArrayEquals(ForTesting.BLANK, g.getBoardForTesting());
		assertEquals(3, g.getSize());
	}
	
	/**
	 * Se pasa un valor nulo.
	 */
	@Test
	public void nullTest() {
		
		try {
			new Game2048(null);
		} catch(NullPointerException nPE) {
			assertEquals("Null values are not allowed!", nPE.getMessage());
		}
		
	}
	
	/**
	 * Se pasa un valor ilegal.
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

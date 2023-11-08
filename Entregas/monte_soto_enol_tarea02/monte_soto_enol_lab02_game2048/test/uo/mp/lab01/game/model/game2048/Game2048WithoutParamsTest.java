package uo.mp.lab01.game.model.game2048;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.Test;

import uo.mp.lab01.game.model.util.ForTesting;
import uo.mp.lab02.game.model.Game2048;


public class Game2048WithoutParamsTest {
	
	/**
	 * WHEN Se invoca al contructor por defecto.
	 * THEN Se crea un matriz 3x3.
	 */
	@Test
	public void createGame() {
		
		Game2048 g = new Game2048();
		assertEquals(3, g.getBoardForTesting().length);
		assertNotEquals(ForTesting.BLANK, g.getBoardForTesting());
		
	}
	

}

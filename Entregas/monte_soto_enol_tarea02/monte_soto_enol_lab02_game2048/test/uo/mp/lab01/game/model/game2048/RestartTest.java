package uo.mp.lab01.game.model.game2048;

import static org.junit.Assert.assertNotEquals;

import org.junit.Test;

import uo.mp.lab01.game.model.util.ForTesting;
import uo.mp.lab02.game.model.Game2048;

public class RestartTest {
	
	/**
	 * GIVEN Un tablero lleno.
	 * WHEN Se reinicia.
	 * THEN Se vacia.
	 */
	@Test
	public void fromFullBoardTest() {
		Game2048 g = new Game2048(ForTesting.FULL);
		g.restart();
		assertNotEquals(ForTesting.FULL, g.getBoardForTesting());
	}
	
	

}

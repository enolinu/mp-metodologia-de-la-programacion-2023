package uo.mp.lab01.game.model.game2048;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertNotEquals;
import org.junit.Test;

import uo.mp.lab01.game.model.Game2048;
import uo.mp.lab01.game.model.util.ForTesting;

public class NextTest {
	
	/**
	 * CASO P1: A partir de un tablero vacio.
	 */
	@Test
	public void fromEmptyBoardTest() {
		Game2048 g = new Game2048(ForTesting.BLANK);
		g.next();
		assertNotEquals(ForTesting.BLANK, g.getBoardForTesting());
	}
	
	/**
	 * CASO P2: A partir de un tablero lleno.
	 */
	@Test
	public void fromFullBoardTest() {
		Game2048 g = new Game2048(ForTesting.FULL);
		g.next();
		assertArrayEquals(ForTesting.FULL, g.getBoardForTesting());
	}

}

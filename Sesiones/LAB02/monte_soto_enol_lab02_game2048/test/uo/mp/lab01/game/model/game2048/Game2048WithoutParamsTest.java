package uo.mp.lab01.game.model.game2048;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.Test;

import uo.mp.lab01.game.model.Game2048;
import uo.mp.lab01.game.model.util.ForTesting;


public class Game2048WithoutParamsTest {
	
	@Test
	public void createGame() {
		Game2048 g = new Game2048();
		assertEquals(3, g.getBoardForTesting().length);
		assertNotEquals(ForTesting.BLANK, g.getBoardForTesting());
		
	}
	

}

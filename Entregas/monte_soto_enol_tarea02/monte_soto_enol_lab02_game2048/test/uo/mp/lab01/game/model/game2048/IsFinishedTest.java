package uo.mp.lab01.game.model.game2048;

import static org.junit.Assert.*;

import org.junit.Test;

import uo.mp.lab01.game.model.util.ForTesting;
import uo.mp.lab02.game.model.Game2048;

public class IsFinishedTest {
	// Escenarios:
		// caso 1: matriz completamente llena
		// caso 2: matriz parcialmente llena
	    // caso 3: matriz vac�a
		
		/**
		 * GIVEN Una matriz completamente llena
		 * WHEN Se comprueba si ha acabado el juego.
		 * THEN El juego ha termidado (true).
		 */
		@Test
		public void isBoardFull() {
		
		 // caso 1: matriz completamente llena  
			
		Game2048 game = new Game2048(ForTesting.FULL); //{{2,2,2},{2,2,2},{2,2,2}}
		assertTrue (game.isFinished());
	  }
		
		/**
		 * GIVEN Una matriz con huecos.
		 * WHEN Se comprueba si ha acabado el juego.
		 * THEN El juego no ha termidado (false).
		 */
		@Test
		public void notIsBoardFull() {
		
		 // caso 2: matriz parcialmente llena  
			
		Game2048 game = new Game2048(ForTesting.SEMIFULL22); //{{2,2,0},{2,2,0},{2,2,0}}
		assertFalse (game.isFinished());
		
		}
		
		/**
		 * GIVEN Una matriz vacia.
		 * WHEN Se comprueba si ha acabado el juego.
		 * THEN El juego no ha termidado (false).
		 */
		@Test
		public void isBoardEmpty() {
		
		 // caso 2: matriz vacia. 
			
		Game2048 game = new Game2048(ForTesting.BLANK);
		assertFalse (game.isFinished());
	  }
}

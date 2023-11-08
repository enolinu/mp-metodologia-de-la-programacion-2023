package uo.mp.lab01.game.model.game2048;

import static org.junit.Assert.assertArrayEquals;


import org.junit.Test;

import uo.mp.lab01.game.model.util.ForTesting;
import uo.mp.lab02.game.model.Game2048;

public class MoveUpTest {

	/*
	 * Casos de uso
	 * 1. Matriz con un valor por fila en columna 0
	 * 2- Matriz con un valor por fila en columna 1
	 * 3- Matriz con un valor por fila en columna 2
	 * 
	 * 4- Matriz con 2 valores por fila (en 1 y 2)
	 * 5- Matriz con 2 valores por fila (en 0 y 1)
	 * 6- Matriz con 2 valores por fila (en 1 y 3)
	 * 
	 * 7- Matriz con 3 valores por fila 
	 * 
	 */
	
	/**
	 * GIVEN Una matriz  con un valor por fila en la columna 0
	 * WHEN Se suma hacia arriba.
	 * THEN Se suman los valores identicos y se recompacta.
	 */
	@Test
	public void OneValueForRowInColumn0() {

		Game2048 game = new Game2048(ForTesting.SEMIFULL31);
		game.moveUp();
		assertArrayEquals(ForTesting.SEMIFULL3_UPCOMPACTED, game.getBoardForTesting());
		
	}
	
	/**
	 * GIVEN Una matriz  con un valor por fila en la columna 1.
	 * WHEN Se suma hacia arriba.
	 * THEN Se suman los valores identicos y se recompacta.
	 */
	@Test
	public void oneValueForRowInColumn1() {

		Game2048 game = new Game2048(ForTesting.SEMIFULL32);
		game.moveUp();
		assertArrayEquals(ForTesting.SEMIFULL3_UPCOMPACTED, game.getBoardForTesting());
		
	}
	
	/**
	 * GIVEN Una matriz  con un valor por fila en la columna 2.
	 * WHEN Se suma hacia arriba.
	 * THEN Se suman los valores identicos y se recompacta.
	 */
	@Test
	public void oneValueForRowInColumn2() {

		Game2048 game = new Game2048(ForTesting.SEMIFULL33);
		game.moveUp();
		assertArrayEquals(ForTesting.SEMIFULL3_UPCOMPACTED, game.getBoardForTesting());
		
	}
	
	/**
	 * GIVEN Una matriz dos valores por fila en las columnas 1 y 2.
	 * WHEN Se suma hacia arriba.
	 * THEN Se suman los valores identicos y se recompacta.
	 */
	@Test
	public void twoValuesForRowInColumn1And2() {

		Game2048 game = new Game2048(ForTesting.SEMIFULL41);
		game.moveUp();
		assertArrayEquals(ForTesting.SEMIFULL4_UPCOMPACTED, game.getBoardForTesting());
		
	}
	
	/**
	 * GIVEN Una matriz dos valores por fila en las columnas 0 y 1.
	 * WHEN Se suma hacia arriba.
	 * THEN Se suman los valores identicos y se recompacta.
	 */
	@Test
	public void twoValuesForRowInColumn0And1() {

		Game2048 game = new Game2048(ForTesting.SEMIFULL42);
		game.moveUp();
		assertArrayEquals(ForTesting.SEMIFULL4_UPCOMPACTED, game.getBoardForTesting());
		
	}
	
	/**
	 * GIVEN Una matriz dos valores por fila en las columnas 1 y 3.
	 * WHEN Se suma hacia arriba.
	 * THEN Se suman los valores identicos y se recompacta.
	 */
	@Test
	public void twoValuesForRowInColumn1And4() {

		Game2048 game = new Game2048(ForTesting.SEMIFULL43);
		game.moveUp();
		assertArrayEquals(ForTesting.SEMIFULL4_UPCOMPACTED, game.getBoardForTesting());
		
	}
	
	/**
	 * GIVEN Una matriz con tres valores por fila.
	 * WHEN Se suma hacia arriba.
	 * THEN Se suman los valores identicos y se recompacta.
	 */
	@Test
	public void threeValuesForRow() {
	//		public static int[][] FULL = {{2,2,2},
	//		  							  {2,2,2},
	//		  							  {2,2,2}};
		Game2048 game = new Game2048(ForTesting.FULL);
		game.moveUp();
		assertArrayEquals(ForTesting.FULL, game.getBoardForTesting());
	}	
}



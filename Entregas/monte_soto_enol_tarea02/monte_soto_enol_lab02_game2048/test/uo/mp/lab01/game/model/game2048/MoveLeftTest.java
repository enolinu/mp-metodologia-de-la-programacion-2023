package uo.mp.lab01.game.model.game2048;

import static org.junit.Assert.assertArrayEquals;


import org.junit.Test;

import uo.mp.lab01.game.model.util.ForTesting;
import uo.mp.lab02.game.model.Game2048;

public class MoveLeftTest {

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
	 * GIVEN Una matriz con un valor por fila en la columna 0.
	 * WHEN Se suma hacia la izquierda.
	 * THEN Se suman los valores identicos y se recompacta.
	 */
	@Test
	public void OneValueForRowInColumn0() {
		//		public static int[][] SEMIFULL12 = {{2,0,0},
		//                							{2,0,0},
		//                							{2,0,0}};
		Game2048 game = new Game2048(ForTesting.SEMIFULL12);
		game.moveLeft();
		assertArrayEquals(ForTesting.SEMIFULL1_LEFTCOMPACTED, game.getBoardForTesting());
	}
	
	/**
	 * GIVEN Una matriz con un valor por fila en la columna 1.
	 * WHEN Se suma hacia la izquierda.
	 * THEN Se suman los valores identicos y se recompacta.
	 */
	@Test
	public void oneValueForRowInColumn1() {
		//		public static int[][] SEMIFULL11 = {{0,2,0},
		//											{0,2,0},
		//											{0,2,0}};
		Game2048 game = new Game2048(ForTesting.SEMIFULL11);
		game.moveLeft();
		assertArrayEquals(ForTesting.SEMIFULL1_LEFTCOMPACTED, game.getBoardForTesting());
	}
	
	/**
	 * GIVEN Una matriz con un valor por fila en la columna 2.
	 * WHEN Se suma hacia la izquierda.
	 * THEN Se suman los valores identicos y se recompacta.
	 */
	@Test
	public void oneValueForRowInColumn2() {
		//		public static int[][] SEMIFULL13 = {{0,0,2},
		//											{0,0,2},
		//											{0,0,2}};
		Game2048 game = new Game2048(ForTesting.SEMIFULL13);
		game.moveLeft();
		assertArrayEquals(ForTesting.SEMIFULL1_LEFTCOMPACTED, game.getBoardForTesting());
	}
	
	/**
	 * GIVEN Una matriz con dos valores por fila en las columnas 1 y 2.
	 * WHEN Se suma hacia la izquierda.
	 * THEN Se suman los valores identicos y se recompacta.
	 */
	@Test
	public void twoValuesForRowInColumn1And2() {
	//		public static int[][] SEMIFULL21 = {{0,2,2},
	//											{0,2,2},
	//											{0,2,2}};
		Game2048 game = new Game2048(ForTesting.SEMIFULL21);
		game.moveLeft();
		assertArrayEquals(ForTesting.SEMIFULL2_LEFTCOMPACTED, game.getBoardForTesting());
	}
	
	/**
	 * GIVEN Una matriz con dos valores por fila en las columnas 0 y 1.
	 * WHEN Se suma hacia la izquierda.
	 * THEN Se suman los valores identicos y se recompacta.
	 */
	@Test
	public void twoValuesForRowInColumn0And1() {
	//		public static int[][] SEMIFULL22 = {{2,2,0},
	//											{2,2,0},
	//											{2,2,0}};
		Game2048 game = new Game2048(ForTesting.SEMIFULL22);
		game.moveLeft();
		assertArrayEquals(ForTesting.SEMIFULL2_LEFTCOMPACTED, game.getBoardForTesting());
	}
	
	/**
	 * GIVEN Una matriz con dos valores por fila en las columnas 0 y 3.
	 * WHEN Se suma hacia la izquierda.
	 * THEN Se suman los valores identicos y se recompacta.
	 */
	@Test
	public void twoValuesForRowInColumn1And4() {
	//		public static int[][] SEMIFULL23 = {{2,0,2},
	//											{2,0,2},
	//											{2,0,2}};
		Game2048 game = new Game2048(ForTesting.SEMIFULL23);
		game.moveLeft();
		assertArrayEquals(ForTesting.SEMIFULL2_LEFTCOMPACTED, game.getBoardForTesting());
	}
	
	/**
	 * GIVEN Una matriz con tres valores por fila.
	 * WHEN Se suma hacia la izquierda.
	 * THEN Se suman los valores identicos y se recompacta.
	 */
	@Test
	public void threeValuesForRow() {
	//		public static int[][] FULL = {{2,2,2},
	//		  							  {2,2,2},
	//		  							  {2,2,2}};
		Game2048 game = new Game2048(ForTesting.FULL);
		game.moveLeft();
		assertArrayEquals(ForTesting.FULL, game.getBoardForTesting());
	}	
}

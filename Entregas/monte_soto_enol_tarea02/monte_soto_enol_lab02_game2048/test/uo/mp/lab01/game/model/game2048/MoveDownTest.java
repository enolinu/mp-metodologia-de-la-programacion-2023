package uo.mp.lab01.game.model.game2048;

import static org.junit.Assert.assertArrayEquals;


import org.junit.Test;

import uo.mp.lab01.game.model.util.ForTesting;
import uo.mp.lab02.game.model.Game2048;

public class MoveDownTest {

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
	 * GIVEN Una matriz un valor por fila en la columna 0.
	 * WHEN Se suma hacia abajo.
	 * THEN Se suman los valores identicos y se recompacta.
	 */
	@Test
	public void OneValueForRowInColumn0() {

		Game2048 game = new Game2048(ForTesting.SEMIFULL31);
		game.moveDown();
		assertArrayEquals(ForTesting.SEMIFULL3_DOWNCOMPACTED, game.getBoardForTesting());
		
	}
	
	/**
	 * GIVEN Una matriz un valor por fila en la columna 1.
	 * WHEN Se suma hacia abajo.
	 * THEN Se suman los valores identicos y se recompacta.
	 */
	@Test
	public void oneValueForRowInColumn1() {

		Game2048 game = new Game2048(ForTesting.SEMIFULL32);
		game.moveDown();
		assertArrayEquals(ForTesting.SEMIFULL3_DOWNCOMPACTED, game.getBoardForTesting());
		
	}
	
	/**
	 * GIVEN Una matriz un valor por fila en la columna 2.
	 * WHEN Se suma hacia abajo.
	 * THEN Se suman los valores identicos y se recompacta.
	 */
	@Test
	public void oneValueForRowInColumn2() {

		Game2048 game = new Game2048(ForTesting.SEMIFULL33);
		game.moveDown();
		assertArrayEquals(ForTesting.SEMIFULL3_DOWNCOMPACTED, game.getBoardForTesting());
		
	}
	
	/**
	 * GIVEN Una matriz con dos valores por fila en las columnas 1 y 2.
	 * WHEN Se suma hacia abajo.
	 * THEN Se suman los valores identicos y se recompacta.
	 */
	@Test
	public void twoValuesForRowInColumn1And2() {

		Game2048 game = new Game2048(ForTesting.SEMIFULL41);
		game.moveDown();
		assertArrayEquals(ForTesting.SEMIFULL4_DOWNCOMPACTED, game.getBoardForTesting());
		
	}
	
	/**
	 * GIVEN Una matriz con dos valores por fila en las columnas 0 y 1.
	 * WHEN Se suma hacia abajo.
	 * THEN Se suman los valores identicos y se recompacta.
	 */
	@Test
	public void twoValuesForRowInColumn0And1() {

		Game2048 game = new Game2048(ForTesting.SEMIFULL42);
		game.moveDown();
		assertArrayEquals(ForTesting.SEMIFULL4_DOWNCOMPACTED, game.getBoardForTesting());
		
	}
	
	/**
	 * GIVEN Una matriz con dos valores por fila en las columnas 1 y 3.
	 * WHEN Se suma hacia abajo.
	 * THEN Se suman los valores identicos y se recompacta.
	 */
	@Test
	public void twoValuesForRowInColumn1And4() {

		Game2048 game = new Game2048(ForTesting.SEMIFULL43);
		game.moveDown();
		assertArrayEquals(ForTesting.SEMIFULL4_DOWNCOMPACTED, game.getBoardForTesting());
		
	}
	
	/**
	 * GIVEN Una matriz con tres valores por fila.
	 * WHEN Se suma hacia abajo.
	 * THEN Se suman los valores identicos y se recompacta.
	 */
	@Test
	public void threeValuesForRow() {

		Game2048 game = new Game2048(ForTesting.FULL);
		game.moveDown();
		assertArrayEquals(ForTesting.FULL, game.getBoardForTesting());
		
	}	
}




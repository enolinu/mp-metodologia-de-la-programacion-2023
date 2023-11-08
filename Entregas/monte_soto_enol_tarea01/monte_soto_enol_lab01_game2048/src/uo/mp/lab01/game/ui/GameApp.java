package uo.mp.lab01.game.ui;

import uo.mp.lab.util.console.Console;
import uo.mp.lab01.game.model.Game2048;

/**
 * <p>
 * T�tulo: Clase principal
 * </p>
 * <p>
 * Descripcion: 2048 es un juego en linea creado por Gabriele Cirulli. El
 * objetivo del juego es combinar numeros juntos (potencias de 2) con el fin de
 * alcanzar el maximo numero 2048 y ganar el juego. Para mover los numeros en el
 * tablero, se debe elegir una direccion (arriba, derecha, abajo o izquierda).
 * Todos los numeros se mueven en la direccion elegida y pueden ocurrir dos
 * cosas: los numeros se juntan en una celda que tiene el mismo numero o son
 * bloqueados si una celda contiene un numero diferente.
 * 
 * <p>
 * Copyright: Copyright (c) 2022
 * </p>
 * <p>
 * Empresa: Escuela de Ingenieria Informatica - Universidad de Oviedo
 * </p>
 * 
 * @author EMS
 * @version 1.0
 */

public class GameApp {
	private Game2048 game;

	public void run() {
		do {
			play();
		} while (userWantsAnotherPlay());
	}

	public void play() {

		game = new Game2048();

		showTitle();
		game.restart();
		do {
			System.out.println(game.toString());
			System.out.print("Elige una direccion [r R]/[l L]/[u U]/[d D]: ");
			switch (Console.readCharacter()) {
			case 'r':
			case 'R':
				game.compactRight();
				game.next();
				break;
			case 'l':
			case 'L':
				game.compactLeft();
				game.next();
				break;
			case 'u':
			case 'U':
				game.compactUp();
				game.next();
				break;
			case 'd':
			case 'D':
				game.compactDown();
				game.next();
				break;
			}

		} while (!game.isBoardFull());

		showGameOver();
	}

	/**
	 * Muestra el titulo del juego
	 */
	private void showTitle() {
		System.out.print("2048 GAME\n");
	}

	/**
	 * Muestra final del juego
	 */
	private void showGameOver() {
		System.out.println("GAME OVER");
	}

	/**
	 * Pregunta al usuario si quiere continuar
	 * @return true true quiere continuar y false en caso contrario
	 */
	private boolean userWantsAnotherPlay() {
		System.out.print("¿Quieres continuar? s/n: ");
		return  Console.readCharacter()== 's';
	}

	
}

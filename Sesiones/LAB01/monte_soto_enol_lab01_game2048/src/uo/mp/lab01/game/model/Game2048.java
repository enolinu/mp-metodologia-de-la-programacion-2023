package uo.mp.lab01.game.model;

/**
 * <p>
 * T�tulo: Clase Game2048
 * </p>
 * <p>
 * Descripci�n: A partir de un array bidimensional de n�meros y a trav�s de
 * diferentes operaciones se simula un juego llamado "2048"
 * </p>
 * <p>
 * Copyright: Copyright (c) 2023
 * </p>
 * <p>
 * Empresa: Escuela de Ingenier�a Inform�tica - Uiversidad de Oviedo
 * </p>
 * 
 * @author Profesores-MP
 * @version 2023
 */
public class Game2048 {
	

	/**
	 * Constructor sin par�metros con tablero por defecto de 3*3 
	 * Inicialmente todas las posiciones con valor 0
	 */
	public Game2048() {
	
	}

	/**
	 *Constructor que recibe el tama�o del tablero
	 *
	 *@param tama�o del tablero cuadrado. Si el tama�o no est� entre el m�nimo (2) 
	 *y el m�ximo (5) se crea un tablero con el valor por defecto (3)
	 */
	public Game2048(int size) {
			
	}
	
	/**
	 * Inicializa el tablero con la matriz recibida como par�metro, Util para prop�sito de 
	 * test.
	 * Se crea UNA COPIA (se denomina copia defensiva)del par�metro 
	 * en el tablero interno para evitar que desde fuera se pueda 
	 * modificar los valores del tablero a posteriori
	 * 
	 * @param matriz cuadrada, de dimensiones entre m�ximo (5x5) y el m�nimo (3x3)
	 * conteniendo solo valores potencia de 2. 
	 * 
	 * @throws IllegalArgumentException si par�metro null, la dimensi�n es err�nea, o 
	 * hay valores inadecuados (no son potencia de 2).
	 */
	
	public Game2048(int[][] board) {
		
	}
	
	/*
	 * @param n entero >= 0
	 * @return true si n is potencia de 2; false en otro caso
	 * 
	 */
	private boolean powerOfTwoBitwise(int n) {
		return (n & (n - 1)) == 0;  // No hay que hacer nada en este m�todo
	}

	/**
	 * Devuelve UNA COPIA de la matriz para poder usarla en las pruebas
	 * 
	 * @return copia exacta del tablero
	 */
	public int[][] getBoardForTesting() {
		return null; // quitar esta l�nea al completar		
	}
	
	
	/**
	 * Reinicia todas las posiciones a 0 y llama a next para que incluya un
	 * 2 en una posici�n aleatoria
	 */
	public void restart() {
		
	}
	
	
	/**
	 * A�ade un nuevo  2 en una posici�n aleatoria vac�a
	 * siempre que exista alguna
	 * 
	 */
	public void next() {
		
	}
	
	/**
	 * Comprueba si el tablero est� lleno. Esto ocurre cuando todas las celdas
	 * o posiciones del tablero tienen un n�mero distinto de cero
	 * @return true si est� el tablero lleno, false si hay alg�n hueco
	 */
	public boolean isBoardFull() {
		return false; // quitar esta l�nea al completar
		
	}
	
	/**
	 * Compacta el tablero a la izquierda, 
	 * dejando en cada fila todos los valores positivos consecutivos 
	 * en las primeras posiciones de la fila 
	 * y todos los ceros en las �ltimas posiciones de la fila
	 */
	public void compactLeft() {
		
	}
	
	/*
	 * Compacta una fila a la derecha
	 * Recorre la fila y si la posici�n contiene 0 se busca una posici�n a la derecha
	 * que no contenga 0 y se hace intercambio de valores.
	 * Aseg�rate de que el algoritmo es eficiente. Si ya est� compactada no sigue comprobando
	 * 
	 */
	private void compactRowLeft(int row) {
		
	}
	
	/*
	 * Busca una posici�n (columna) a la derecha de la posici�n column que 
	 * que contenga un valor positivo y devuelve la posici�n si lo encuentra
	 * 
	 * @param row, fila en la que se quire trabajar
	 * @param column, columna a partir de la cual se busca un valor hacia la derecha
	 * @return columna encontrada con valor positivo 
	 *         o -1 si no encuentra ninguna a su derecha
	 */
	private int findPositionAtRightWithValueFor(int row, int column) {
		return 0;  // sustituir y completar
	}

	/**
	 * Compacta el tablero a la derecha, 
	 * dejando en cada fila todos los valores positivos consecutivos 
	 * en las �ltimas posiciones de la fila 
	 * y todos los ceros en las primeras posiciones de la fila
	 */
	public void compactRight() {
		
	}
	
	
	
	/**
	 * Compacta el tablero hacia arriba, 
	 * dejando en cada columna todos los valores positivos consecutivos 
	 * en las primeras posiciones de las columnas 
	 * y todos los ceros en las �ltimas posiciones
	 */
	public void compactUp() {
		
	}
	
	/**
	 * Compacta el tablero hacia abajo, 
	 * dejando en cada columna todos los valores positivos consecutivos 
	 * en las �ltimas posiciones de las columnas
	 * y todos los ceros en las primeras posiciones
	 */
	public void compactDown() {
		
	}
	
	
	/**
	 * @return un String con los datos de la matriz en formato para ser mostrado por pantalla
	 * Habr� 5 espacios para cada posici�n en la misma fila y un \n al final de cada fila
	 * Ejemplo. Para luego escribir:
	 *    2    2    0
	 *    2    0    0
	 *    2    0    2
	 *    Se devuelve el String "2    2    0\n2    0    0\n2    0    2\n"
	 */
	public String toString() {
		return null; // quitar esta l�nea al completar
	}
	
	/**
	 * @return false si el jugador no ha ganado todav�a y hay algunos huecos en
	 *         el tablero; true en otro caso
	 */
	public boolean isFinished() {
		
		return true;// quitar esta l�nea al completar
	}

}

package uo.mp.lab01.game.model;

/**
 * <p>
 * Título: Clase Game2048
 * </p>
 * <p>
 * Descripción: A partir de un array bidimensional de números y a través de
 * diferentes operaciones se simula un juego llamado "2048"
 * </p>
 * <p>
 * Copyright: Copyright (c) 2023
 * </p>
 * <p>
 * Empresa: Escuela de Ingeniería Informática - Uiversidad de Oviedo
 * </p>
 * 
 * @author Profesores-MP
 * @version 2023
 */
public class Game2048 {
	

	/**
	 * Constructor sin parámetros con tablero por defecto de 3*3 
	 * Inicialmente todas las posiciones con valor 0
	 */
	public Game2048() {
	
	}

	/**
	 *Constructor que recibe el tamaño del tablero
	 *
	 *@param tamaño del tablero cuadrado. Si el tamaño no está entre el mínimo (2) 
	 *y el máximo (5) se crea un tablero con el valor por defecto (3)
	 */
	public Game2048(int size) {
			
	}
	
	/**
	 * Inicializa el tablero con la matriz recibida como parámetro, Util para propósito de 
	 * test.
	 * Se crea UNA COPIA (se denomina copia defensiva)del parámetro 
	 * en el tablero interno para evitar que desde fuera se pueda 
	 * modificar los valores del tablero a posteriori
	 * 
	 * @param matriz cuadrada, de dimensiones entre máximo (5x5) y el mínimo (3x3)
	 * conteniendo solo valores potencia de 2. 
	 * 
	 * @throws IllegalArgumentException si parámetro null, la dimensión es errónea, o 
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
		return (n & (n - 1)) == 0;  // No hay que hacer nada en este método
	}

	/**
	 * Devuelve UNA COPIA de la matriz para poder usarla en las pruebas
	 * 
	 * @return copia exacta del tablero
	 */
	public int[][] getBoardForTesting() {
		return null; // quitar esta línea al completar		
	}
	
	
	/**
	 * Reinicia todas las posiciones a 0 y llama a next para que incluya un
	 * 2 en una posición aleatoria
	 */
	public void restart() {
		
	}
	
	
	/**
	 * Añade un nuevo  2 en una posición aleatoria vacía
	 * siempre que exista alguna
	 * 
	 */
	public void next() {
		
	}
	
	/**
	 * Comprueba si el tablero está lleno. Esto ocurre cuando todas las celdas
	 * o posiciones del tablero tienen un número distinto de cero
	 * @return true si está el tablero lleno, false si hay algún hueco
	 */
	public boolean isBoardFull() {
		return false; // quitar esta línea al completar
		
	}
	
	/**
	 * Compacta el tablero a la izquierda, 
	 * dejando en cada fila todos los valores positivos consecutivos 
	 * en las primeras posiciones de la fila 
	 * y todos los ceros en las últimas posiciones de la fila
	 */
	public void compactLeft() {
		
	}
	
	/*
	 * Compacta una fila a la derecha
	 * Recorre la fila y si la posición contiene 0 se busca una posición a la derecha
	 * que no contenga 0 y se hace intercambio de valores.
	 * Asegúrate de que el algoritmo es eficiente. Si ya está compactada no sigue comprobando
	 * 
	 */
	private void compactRowLeft(int row) {
		
	}
	
	/*
	 * Busca una posición (columna) a la derecha de la posición column que 
	 * que contenga un valor positivo y devuelve la posición si lo encuentra
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
	 * en las últimas posiciones de la fila 
	 * y todos los ceros en las primeras posiciones de la fila
	 */
	public void compactRight() {
		
	}
	
	
	
	/**
	 * Compacta el tablero hacia arriba, 
	 * dejando en cada columna todos los valores positivos consecutivos 
	 * en las primeras posiciones de las columnas 
	 * y todos los ceros en las últimas posiciones
	 */
	public void compactUp() {
		
	}
	
	/**
	 * Compacta el tablero hacia abajo, 
	 * dejando en cada columna todos los valores positivos consecutivos 
	 * en las últimas posiciones de las columnas
	 * y todos los ceros en las primeras posiciones
	 */
	public void compactDown() {
		
	}
	
	
	/**
	 * @return un String con los datos de la matriz en formato para ser mostrado por pantalla
	 * Habrá 5 espacios para cada posición en la misma fila y un \n al final de cada fila
	 * Ejemplo. Para luego escribir:
	 *    2    2    0
	 *    2    0    0
	 *    2    0    2
	 *    Se devuelve el String "2    2    0\n2    0    0\n2    0    2\n"
	 */
	public String toString() {
		return null; // quitar esta línea al completar
	}
	
	/**
	 * @return false si el jugador no ha ganado todavía y hay algunos huecos en
	 *         el tablero; true en otro caso
	 */
	public boolean isFinished() {
		
		return true;// quitar esta línea al completar
	}

}

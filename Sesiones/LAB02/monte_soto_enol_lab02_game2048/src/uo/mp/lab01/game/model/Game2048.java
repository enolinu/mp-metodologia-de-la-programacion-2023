package uo.mp.lab01.game.model;

import java.util.Random;

import uo.mp.lab.util.check.ArgumentChecks;

/**
 * <p>
 * Titulo: Clase Game2048
 * </p>
 * <p>
 * Descripcion: A partir de un array bidimensional de numeros y a traves de
 * diferentes operaciones se simula un juego llamado "2048"
 * </p>
 * <p>
 * Copyright: Copyright (c) 2023
 * </p>
 * <p>
 * Empresa: Escuela de Ingenieria Informatica - Uiversidad de Oviedo
 * </p>
 * 
 * @author Profesores-MP, EMS
 * @version 2023
 */
public class Game2048 {
	
	// Constantes
	private static int DEF_SIZE = 3;
	private static int MIN_SIZE = 2;
	private static int MAX_SIZE = 5;
	
	//Atributos
	private int size;
	private int[][] board;
	

	/**
	 * Constructor sin parametros con tablero por defecto de 3*3 
	 * Inicialmente todas las posiciones con valor 0
	 */
	public Game2048() {
		
		this.setSize(DEF_SIZE);
		board = new int[DEF_SIZE][DEF_SIZE];
		placeRandomTwo();
	
	}

	/**
	 *Constructor que recibe el tamano del tablero
	 *
	 *@param tamano del tablero cuadrado. Si el tamano no esta entre el minimo (2) 
	 *y el maximo (5) se crea un tablero con el valor por defecto (3)
	 */
	public Game2048(int size) {
		
		ArgumentChecks.isTrue((size >= MIN_SIZE && size <= MAX_SIZE), "The argument for the size is not valid!") ;
		
		this.setSize(size);
		board = new int[size][size];
		placeRandomTwo();
		
	}
	
	/**
	 * Inicializa el tablero con la matriz recibida como parametro, Util para proposito de 
	 * test.
	 * Se crea UNA COPIA (se denomina copia defensiva)del parametro 
	 * en el tablero interno para evitar que desde fuera se pueda 
	 * modificar los valores del tablero a posteriori
	 * 
	 * @param matriz cuadrada, de dimensiones entre maximo (5x5) y el minimo (3x3)
	 * conteniendo solo valores potencia de 2. 
	 * 
	 * @throws IllegalArgumentException si parametro null, la dimension es erronea, o 
	 * hay valores inadecuados (no son potencia de 2).
	 */
	
	public Game2048(int[][] board) {
		
		ArgumentChecks.checkNotNull(board, "Null values are not allowed!");
		
		int dim = board.length;
		ArgumentChecks.isTrue((dim >= MIN_SIZE && dim <= MAX_SIZE), "Illegal value!") ;
		ArgumentChecks.isTrue(validateContent(board));
		
		int[][] auxiliar = new int[dim][dim]; 
		
		for(int i=0; i<dim; i++) {
			for(int j=0; j<dim; j++) {
				auxiliar[i][j] = board[i][j];
			}
		}
		
		setSize(dim);
		this.board = auxiliar;
		
	}
	
	public int getSize() {
		return size;
	}

	private void setSize(int size) {
		this.size = size;
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
		
		return copyBoard();
		
	}
	
	private int[][] copyBoard() {
		
		int[][] auxiliar = new int[size][size];
		
		for(int i=0; i<size; i++) {
			for(int j=0; j<size; j++) {
				auxiliar[i][j] = board[i][j];
			}
		}
		
		return auxiliar;
	}
	
	
	/**
	 * Reinicia todas las posiciones a 0 y llama a next para que incluya un
	 * 2 en una posicion aleatoria
	 */
	public void restart() {
		
		board = new int[size][size];
		next();
		
	}
	
	
	/**
	 * Anade un nuevo  2 en una posicion aleatoria vacia
	 * siempre que exista alguna
	 * 
	 */
	public void next() {
		if(!isBoardFull()) {
			placeRandomTwo();
		}	
	}
	
	/**
	 * Comprueba si el tablero esta lleno. Esto ocurre cuando todas las celdas
	 * o posiciones del tablero tienen un numero distinto de cero
	 * @return true si esta el tablero lleno, false si hay algun hueco
	 */
	public boolean isBoardFull() {
		
		for(int i=0; i<size; i++) {
			for(int j=0; j<size; j++) {
				if(board[i][j] == 0) {
					return false;
				}
			}
		}
		
		return true;
		
	}
	
	/**
	 * Compacta el tablero a la izquierda, 
	 * dejando en cada fila todos los valores positivos consecutivos 
	 * en las primeras posiciones de la fila 
	 * y todos los ceros en las ultimas posiciones de la fila
	 */
	public void compactLeft() {
		
		for(int i=0; i<size; i++) {
			compactRowLeft(i);
		}
		
	}
	
	/*
	 * Compacta una fila a la derecha
	 * Recorre la fila y si la posicion contiene 0 se busca una posicion a la derecha
	 * que no contenga 0 y se hace intercambio de valores.
	 * Asegurate de que el algoritmo es eficiente. Si ya esta compactada no sigue comprobando
	 * 
	 */
	private void compactRowLeft(int row) {
		
		int[] compactRow = new int[size];
		
		for(int i=0; i<size; i++) {
			if(board[row][i] != 0) {
				compactRow[count(compactRow)] = board[row][i];
			}
		}
		
		board[row] = compactRow;
	}
	
	/**
	 * Compacta el tablero a la derecha, 
	 * dejando en cada fila todos los valores positivos consecutivos 
	 * en las ultimas posiciones de la fila 
	 * y todos los ceros en las primeras posiciones de la fila
	 */
	public void compactRight() {
		
		for(int i=0; i<size; i++) {
			compactRowRight(i);
		}
		
	}

	private void compactRowRight(int row) {
		
		int[] compactRow = new int[size];
		
		for(int i=0; i<size; i++) {
			if(board[row][i] != 0) {
				compactRow[count(compactRow)] = board[row][i];
			}
		}
		
		board[row] = invert(compactRow);
		
	}
	
	/**
	 * Compacta el tablero hacia arriba, 
	 * dejando en cada columna todos los valores positivos consecutivos 
	 * en las primeras posiciones de las columnas 
	 * y todos los ceros en las �ltimas posiciones
	 */
	public void compactUp() {
		
		for(int i=0; i<size; i++) {
			compactRowUp(i);
		}
		
	}
	
	private void compactRowUp(int row) {
		
		int[] compactRow = new int[size];
		board = transpose(board);
		//System.out.println(this);
		
		for(int i=0; i<size; i++) {
			if(board[row][i] != 0) {
				compactRow[count(compactRow)] = board[row][i];
			}
		}
		
		board[row] = compactRow;
		board = transpose(board);
		
	}

	/**
	 * Compacta el tablero hacia abajo, 
	 * dejando en cada columna todos los valores positivos consecutivos 
	 * en las ultimas posiciones de las columnas
	 * y todos los ceros en las primeras posiciones
	 */
	public void compactDown() {
		
		for(int i=0; i<size; i++) {
			compactRowDown(i);
		}
		
	}
	
	private void compactRowDown(int row) {
		int[] compactRow = new int[size];
		board = transpose(board);
		
		for(int i=0; i<size; i++) {
			if(board[row][i] != 0) {
				compactRow[count(compactRow)] = board[row][i];
			}
		}
		
		board[row] = invert(compactRow);
		board = transpose(board);
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
		
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<size; i++) {
			for(int j=0; j<size; j++) {
				sb.append(String.format("%-5s", board[i][j]));
			}
			sb.append("\n");
		}
		
		return sb.toString();
		
	}
	
	/**
	 * @return false si el jugador no ha ganado todavia y hay algunos huecos en
	 *         el tablero; true en otro caso
	 */
	public boolean isFinished() {
		if(!isBoardFull()) {
			return false;
		}
		return true;
	}
	
	// Metodos privados "extra"
	
	/*
	 * Método que busca una posición libre aleatoria, en la cual coloca un "2".
	 */
	private void placeRandomTwo() {
		
		Random r = new Random();
		int row;
		int col;
		
		do {
			row = r.nextInt(getSize());
			col = r.nextInt(getSize());
		} while(board[row][col] != 0);
		
		board[row][col] = 2;
		
	}
	
	/*
	 * Método auxiliar para ordenar los elementos compactados.
	 */
	private int count(int[] array) {
		
		int counter = 0;
		
		for(int i=0; i<array.length; i++) {
			if(array[i] != 0) {
				counter++;
			}
		}
		
		return counter;
	}
	
	private int[][] transpose(int[][] matrix) {
		
		int[][] auxiliar = new int[matrix.length][matrix.length];
		
		for(int i=0; i<matrix.length; i++) {
			for(int j=0; j<matrix.length; j++) {
				auxiliar[i][j] = matrix[j][i];
			}
		}
		
		return auxiliar;
	}
	
	private int[] invert(int[] array) {
		
		int[] invertedArray = new int[array.length];
		 
        for (int i = invertedArray.length - 1, j = 0; i >= 0; i--, j++) {
        	invertedArray[i] = array[j];
        }
        
        return invertedArray;
	}
	
	private boolean validateContent(int[][] matrix) {
		for(int i=0; i<matrix.length; i++) {
			for(int j=0; j<matrix.length; j++) {
				if(!powerOfTwoBitwise(board[i][j])) {
					return false;
				}
			}
		}
		return true;
	}

}

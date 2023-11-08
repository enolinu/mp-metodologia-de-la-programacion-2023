package uo.mp.lab02.game.model;

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
	
	//Atributos
	private int size;
	private int[][] board;
	

	/**
	 * Constructor sin parametros con tablero por defecto de 3*3 
	 * Inicialmente todas las posiciones con valor 0
	 */
	public Game2048() {
		this.setSize(DEF_SIZE);
		board = new int[3][3];
		placeRandomTwo();
	
	}

	/**
	 *Constructor que recibe el tamano del tablero
	 *
	 *@param tamano del tablero cuadrado. Si el tamano no esta entre el minimo (2) 
	 *y el maximo (5) se crea un tablero con el valor por defecto (3)
	 */
	public Game2048(int size) {
		
		ArgumentChecks.isTrue((size >= 2 && size <= 5), "The argument for the size is not valid!") ;
		
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
		
		int dim = board.length;
		ArgumentChecks.isTrue((dim >= 2 && dim <= 5), "Illegal value!") ;
		ArgumentChecks.isTrue(validateValues(board), "Illegal value!") ;
		
		setSize(dim);
		this.board = copyBoard(board);
		
	}
	
	/**
	 * Método get del tamaño.
	 * @return size, la dimensión de la matriz del tablero.
	 */
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
		
		return copyBoard(this.board);
		
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
	private boolean isBoardFull() {
		
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
	 * Compacta el tablero a la derecha, 
	 * dejando en cada fila todos los valores positivos consecutivos 
	 * en las ultimas posiciones de la fila 
	 * y todos los ceros en las primeras posiciones de la fila
	 */
	private void compactRight() {
		
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
	 * Metodo que suma los numeros que proceden, compactando
	 * a la derecha antes y después de realizar la suma.
	 */
	public void moveRight() {
		
		compactRight();
		sumAllRows();
		compactRight();
		
	}
	
	/**
	 * Metodo que suma los numeros que proceden, compactando
	 * a la izquierda antes y después de realizar la suma.
	 */
	public void moveLeft() {
		
		rotateBoard();
		moveRight();
		rotateBoard();
		
	}
	
	/**
	 * Metodo que suma los numeros que proceden, compactando
	 * hacia abajo antes y después de realizar la suma.
	 */
	public void moveDown() {
		
		board = transpose(board);
		moveRight();
		board = transpose(board);
		
	}
	
	/**
	 * Metodo que suma los numeros que proceden, compactando
	 * hacia arriba antes y después de realizar la suma.
	 */
	public void moveUp() {
		
		board = transpose(board);
		rotateBoard();
		moveRight();
		rotateBoard();
		board = transpose(board);
		
	}
	
	

	/**
	 * @return un String con los datos de la matriz en formato para ser mostrado por pantalla
	 * Habra 5 espacios para cada posicion en la misma fila y un \n al final de cada fila
	 * Ejemplo. Para luego escribir:
	 *    2    2    0
	 *    2    0    0
	 *    2    0    2
	 *    Se devuelve el String "2    2    0\n2    0    0\n2    0    2\n"
	 */
	public String toString() {
		
		StringBuilder sb = new StringBuilder();
		
		for(int i=0; i<size; i++) {
			sb.append("\n");
			for(int j=0; j<size; j++) {
				sb.append(board[i][j] + "     ");
			}
		}
		
		return sb.toString();
		
	}
	
	/**
	 * Comprueba el estado de el juego.
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
	
	private int[][] copyBoard(int[][] board) {
		
		int[][] boardCopy = new int[board.length][board.length];
		
		for(int i=0; i<board.length; i++) {
			for(int j=0; j<board.length; j++) {
				boardCopy[i][j] = board[i][j];
			}
		}
		
		return boardCopy;
	}
	
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
	
	/*
	 * Intercambia filas y columnas de una matriz dada por parametro.
	 */
	private int[][] transpose(int[][] matrix) {
		
		int[][] auxiliar = new int[matrix.length][matrix.length];
		
		for(int i=0; i<matrix.length; i++) {
			for(int j=0; j<matrix.length; j++) {
				auxiliar[i][j] = matrix[j][i];
			}
		}
		
		return auxiliar;
	}
	
	/*
	 * Invierte el orden de los elementos de un array.
	 */
	private int[] invert(int[] array) {
		
		int[] invertedArray = new int[array.length];
		 
        for (int i = invertedArray.length - 1, j = 0; i >= 0; i--, j++) {
        	invertedArray[i] = array[j];
        }
        
        return invertedArray;
	}
	
	/*
	 * Comprueba que todos los valores sean multiplos de tres.
	 */
	private boolean validateValues(int[][] board) {
		
		for(int i=0; i<this.size; i++) {
			for(int j=0; i<this.size; i++) {
				if(!powerOfTwoBitwise(board[i][j])) {
					return false;
				}
			}
		}
		return true;
		
	}
	
	/*
	 * Opera una fila que se le pase como parámetro y devuelve
	 * la fila con las operaciones hechas pero sin compactar.
	 */
	private int[] sumRow(int[] row) {
		
		int[] auxiliar = row;
		
		for(int i=0; i<this.size-1; i++) {
			if(row[i] == row[i+1]) {
				auxiliar[i+1] = (row[i] + row[i+1]);
				auxiliar[i] = 0;
			}
		}
		return auxiliar;
	}
	
	/*
	 * Suma todas las filas del tablero.
	 */
	private void sumAllRows() {
		for(int i=0; i<this.size; i++) {
			board[i] = sumRow(board[i]);
		}
	}
	
	/*
	 * Rota 90º la matriz
	 */
	private void rotateBoard() {
		for(int i=0; i<size; i++) {
			board[i] = invert(board[i]);
		}
	}
}

package uo.mp.lab01.helloworld;

/**
 * Saluda y se despide
 * @author EMS
 * @version 1-FEB-2023
 *
 */
public class HelloWorld {
	
	private int counter;

	public static void main(String[] args) {
		
		// Si escribimos "syso" aparece directamente.
		System.out.println("Hola Mundo!!, me llamo " + args[0] + " " + args[1] + " " + args[2]);
		
		if (true) {
			System.out.println("Adiós");
		}
		
	}

	/**
	 * @return the counter
	 */
	public int getCounter() {
		return counter;
	}

	private void setCounter(int counter) {
		this.counter = counter;
	}

}

// Ctrl+7 Para comentar un trozo de código






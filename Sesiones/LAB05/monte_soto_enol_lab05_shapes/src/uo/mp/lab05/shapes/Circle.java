/**
 * 
 */
package uo.mp.lab05.shapes;

import java.io.PrintStream;

import uo.mp.util.check.ArgumentChecks;

/**
 * @author enolmontesoto
 *
 */
public class Circle extends Shape {
	
	private int radius;
	
	public Circle(int x, int y, int radius, Colour colour) {
		
		super(x, y, colour);
		
		ArgumentChecks.isTrue(radius >= 0);
		
		this.radius = radius;

		
	}

	@Override
	public void draw(PrintStream out) {
		
		out.println(String.format("Dibujando círculo: (%1d, %1d)  - radio: %2d - color: %s", getX(), getY(), getRadius(), getColour()));
		
	}

	/**
	 * @return the radius
	 */
	public int getRadius() {
		return radius;
	}
	
	

}

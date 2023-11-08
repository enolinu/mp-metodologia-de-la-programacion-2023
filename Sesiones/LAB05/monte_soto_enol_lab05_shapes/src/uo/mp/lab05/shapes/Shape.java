package uo.mp.lab05.shapes;

import java.io.PrintStream;

import uo.mp.lab05.drawing.interfacerepository.Drawable;

public abstract class Shape implements Drawable {

	protected int x;
	protected int y;
	protected Colour colour;

	public Shape(int x, int y, Colour colour) {
		
		this.x = x;
		this.y = y;
		this.colour = colour;
		
	}

	/**
	 * @return the x
	 */
	public int getX() {
		return x;
	}

	/**
	 * @return the y
	 */
	public int getY() {
		return y;
	}

	/**
	 * @return the colour
	 */
	public Colour getColour() {
		return colour;
	}

	@Override
	public abstract void draw(PrintStream out);

}
package assignment9;

import java.awt.Color;

import edu.princeton.cs.introcs.StdDraw;

public class Food {

	public static final double FOOD_SIZE = 0.02;
	private double x, y;
	private boolean isGood;
	
	/**
	 * Creates a new Food at a random location
	 */
	public Food(boolean isGood) {
		//ensure the food spawns fully inbounds
		this.isGood = isGood;
		respawn();
		//FIXME
	}
	
	public void respawn()
	{
		this.x = Math.random() * (1 - FOOD_SIZE * 2) + FOOD_SIZE;
		this.y = Math.random() * (1 - FOOD_SIZE * 2) + FOOD_SIZE;
	}
	
	/**
	 * Draws the Food
	 */
	public void draw() {
		if (isGood) {
			StdDraw.setPenColor(Color.GREEN); // Good fruit = green
		} else {
			StdDraw.setPenColor(Color.RED);   // Bad fruit = red
		}
		StdDraw.filledSquare(x, y, FOOD_SIZE);
	}
	
	//getters
	public double getX()
	{
		return this.x;
	}
	
	public double getY()
	{
		return this.y;
	}
	
	public boolean isGood() {
		return isGood;
	}
	
}

package assignment9;

import java.awt.event.KeyEvent;

import edu.princeton.cs.introcs.StdDraw;

public class Game {
	Snake snake = new Snake();
	Food food = new Food(true);
	Food badFood = new Food(false);
	
	private int score = 0;
	
	
	public Game() {
		StdDraw.enableDoubleBuffering();
		
		//FIXME - construct new Snake and Food objects
	}
	
	public void play() { 
		while (snake.isInbounds()) { //keep playing if snake doesnt die
			int dir = getKeypress();
			//Testing only: you will eventually need to do more work here
			System.out.println("Keypress: " + dir);
			
			/*
			 * 1. Pass direction to your snake
			 * 2. Tell the snake to move
			 * 3. If the food has been eaten, make a new one
			 * 4. Update the drawing
			 */
			snake.changeDirection(dir);
			snake.move();
			if(snake.eatFood(food)) //new food
			{
				food = new Food(true);
				score++;
			}
			
			if (snake.eatFood(badFood)) 
			{
				badFood = new Food(false);
				score--; // or snake dies, or shrinks, etc.
			}
			
			updateDrawing();
			
		}
	}
	
	private int getKeypress() {
		if(StdDraw.isKeyPressed(KeyEvent.VK_W)) {
			return 1;
		} else if (StdDraw.isKeyPressed(KeyEvent.VK_S)) {
			return 2;
		} else if (StdDraw.isKeyPressed(KeyEvent.VK_A)) {
			return 3;
		} else if (StdDraw.isKeyPressed(KeyEvent.VK_D)) {
			return 4;
		} else {
			return -1;
		}
	}
	
	/**
	 * Clears the screen, draws the snake and food, pauses, and shows the content
	 */
	private void updateDrawing() {
		//FIXME
		StdDraw.clear();
		snake.draw();
		food.draw();
		badFood.draw();
		
		//draw score
		StdDraw.setPenColor(StdDraw.BLUE);
		StdDraw.textLeft(0.02, 0.98, "Score: " + score);
		StdDraw.pause(50);
		StdDraw.show();
		
		
		/*
		 * 1. Clear screen
		 * 2. Draw snake and food
		 * 3. Pause (50 ms is good)
		 * 4. Show
		 */
	}
	
	public static void main(String[] args) {
		Game g = new Game();
		g.play();
	}
}

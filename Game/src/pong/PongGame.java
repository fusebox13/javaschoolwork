package pong;

import org.lwjgl.*;
import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.*;

import GameTestArea.AbstractEntity;
import GameTestArea.AbstractMoveableEntity;
import static org.lwjgl.opengl.GL11.*;

public class PongGame {
	
	public static final int WIDTH = 800;
	public static final int HEIGHT = 600;
	private boolean isRunning = true;
	private long lastFrame;
	private double speed = 0.2d;
	private double barWidth = 10;
	private double barHeight = 80;
	private double ballLength = 10;
	private Ball ball;
	private Bat bat;
	private Bat bat2;
	private Bat bg;
	
	public PongGame()
	{
		setUpDisplay();
		setUpOpenGL();
		setUpEntities();
		setUpTimer();
		while (isRunning)
		{
			render();
			logic(getDelta());
			input();
			Display.update();
			Display.sync(60);
			if (Display.isCloseRequested())
			{
				isRunning = false;
			}
		}
		Display.destroy();
		
	}
	
	private void input () {
		if(Keyboard.isKeyDown(Keyboard.KEY_UP)){
			bat2.setDY(-.6);
		} else if (Keyboard.isKeyDown(Keyboard.KEY_DOWN)) {
			bat2.setDY(.6);
		} else {
			bat2.setDY(0);
		}
		
		if(Keyboard.isKeyDown(Keyboard.KEY_W)){
			bat.setDY(-.6);
		} else if (Keyboard.isKeyDown(Keyboard.KEY_S)) {
			bat.setDY(.6);
		} else {
			bat.setDY(0);
		}
			
		
	}
	
	private long getTime()
	{
		return (Sys.getTime()) * 1000 / Sys.getTimerResolution();
	}
	
	private int getDelta()
	{
		long currentTime = getTime();
		int delta = (int)(currentTime - lastFrame);
		lastFrame = getTime();
		return delta;
	}
	private void setUpDisplay() {
		try 
		{
			Display.setDisplayMode(new DisplayMode(WIDTH, HEIGHT));
			Display.setTitle("Pong");
			Display.create();
		} 
		catch (LWJGLException e) 
		{
			e.printStackTrace();
			System.exit(0);
		}

	}
	
	private void setUpOpenGL() {
		glMatrixMode(GL_PROJECTION);
		glLoadIdentity();
		glOrtho(0, 800, 600, 0, 1, -1);
		glMatrixMode(GL_MODELVIEW);
	}
	
	private void setUpEntities() {
		bg = new Bat(0,0, 800, 600);
		bat = new Bat(10, HEIGHT / 2 - 80 / 2, barWidth, barHeight);
		bat2 = new Bat(WIDTH - 10*2, HEIGHT / 2 - 80/2, barWidth, barHeight);
		ball = new Ball(WIDTH / 2 - 10 / 2, HEIGHT / 2 - 10 / 2, 10, 10);
		ball.setDX(-.1);
		ball.setDY(-.1);
	}
	
	private void setUpTimer() {
		lastFrame = getTime();
	}
	
	private void render() {
		glClear(GL_COLOR_BUFFER_BIT);
		bg.draw();
		ball.draw();
		bat.draw();
		bat2.draw();
	}
	
	private void logic(int delta) {
		ball.update(delta);
		bat.update(delta);
		bat2.update(delta);
		
		
		if (ball.getX() <= bat.getX() + bat.getWidth()  &&  ball.getX() >= bat.getX() && 
				ball.getY() + 10 >= bat.getY() && ball.getY() <= bat.getY() + bat.getHeight()) {
			bat.randomizeColors();
			bg.randomizeColors();
			ball.randomizeColors();
			ball.setDX(speed += 0.01);
		}
		if (ball.getX() + 10 <= bat2.getX() + bat2.getWidth()  &&  ball.getX() + 10 >= bat2.getX() && 
				ball.getY() + 10 >= bat2.getY() && ball.getY() <= bat2.getY() + bat2.getHeight()){
			bat2.randomizeColors();
			bg.randomizeColors();
			ball.randomizeColors();
			ball.setDX(-(speed += 0.01));
		}
		if (ball.getX() < 0 || ball.getX() > WIDTH){
			ball.setX(WIDTH / 2 - 10 / 2);
			ball.setY( HEIGHT / 2 - 10 / 2);
		}
		
		if (ball.getY() < 0)
			ball.setDY(0.3);
		if (ball.getY() + 10 > HEIGHT)
			ball.setDY(-0.3);
	
	}
	
	private static class Bat extends AbstractMoveableEntity {

		public Bat(double x, double y, double width, double height) {
			super(x, y, width, height);
			// TODO Auto-generated constructor stub
		}

		@Override
		public void draw() {
			glColor3f(red, green, blue);
			glRectd(x, y, x + width, y + height);
			// TODO Auto-generated method stub
			
		}
		
	}
	
	private static class Ball extends AbstractMoveableEntity {

		public Ball(double x, double y, double width, double height) {
			super(x, y, width, height);
			// TODO Auto-generated constructor stub
		}

		@Override
		public void draw() {
			glColor3f(red, green, blue);
			glRectd(x, y, x + width, y + height);
			// TODO Auto-generated method stub
			
		}
		
	}
	
	
	public static void main(String[] args)
	{
		new PongGame();
	}

}

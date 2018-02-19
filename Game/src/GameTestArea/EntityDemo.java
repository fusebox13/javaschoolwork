package GameTestArea;

import org.lwjgl.LWJGLException;
import org.lwjgl.Sys;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.util.glu.GLU.gluPerspective;

public class EntityDemo 
{
	private long lastFrame;
	
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
	private static class Box extends AbstractMoveableEntity {

		public Box(double x, double y, double width, double height) {
			super(x, y, width, height);
			// TODO Auto-generated constructor stub
		}
		
		public void draw() {
			glRectd(x, y, x+width, y+height);
		}
		
	}
	
	private static class Point extends AbstractEntity{

		public Point(double x, double y) {
			super(x, y, 1, 1);
			// TODO Auto-generated constructor stub
		}

		@Override
		public void draw() {
			glBegin(GL_POINTS);
				glVertex2d(x, y);
			glEnd();
			// TODO Auto-generated method stub
			
		}

		@Override
		public void update(int delta) {
			//Do nothing
			
		}
		
	}
	
	public void start()
	{
		try 
		{
			Display.setDisplayMode(new DisplayMode(800, 600));
			Display.create();
		} 
		catch (LWJGLException e) 
		{
			e.printStackTrace();
			System.exit(0);
		}
		
		
		//Init code for Entities
		
		MoveableEntity box = new Box(100, 100, 50, 50);
		Entity point = new Point(10, 10);

		
		//start OpenGL
		
		glMatrixMode(GL_PROJECTION);
		glLoadIdentity();
		glOrtho(0, 800, 600, 0, 1, -1);
		glMatrixMode(GL_MODELVIEW);
		
		
		
		lastFrame = getTime();
		while (!Display.isCloseRequested())
		{
			point.setLocation(Mouse.getX(), 600 - Mouse.getY() - 1);
			//clears screen and depth buffer
			glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);
			
			
			int delta = getDelta();
			box.update(delta);
			point.update(delta);
			
			if(box.intersects(point))
			{
				box.setDX(0.02);
				
			}
			point.draw();
			box.draw();
		
			
			Display.update();
			Display.sync(60);
		}
		
		Display.destroy();
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		EntityDemo q = new EntityDemo();
		q.start();
		// TODO Auto-generated method stub

	}

}

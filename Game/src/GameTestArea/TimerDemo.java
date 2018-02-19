package GameTestArea;

import org.lwjgl.LWJGLException;
import org.lwjgl.Sys;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.util.glu.GLU.gluPerspective;

public class TimerDemo 
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
	
	public void start()
	{
		try 
		{
			Display.setDisplayMode(new DisplayMode(800, 600));
			Display.setTitle("Timer Demo(Delta)");
			Display.create();
		} 
		catch (LWJGLException e) 
		{
			e.printStackTrace();
			System.exit(0);
		}
		
		int x = 100;
		int y = 100;
		
		int dx = 1;
		int dy = 1;

		
		//start OpenGL
		
		glMatrixMode(GL_PROJECTION);
		glLoadIdentity();
		glOrtho(0, 800, 600, 0, 1, -1);
		glMatrixMode(GL_MODELVIEW);
		
		lastFrame = getTime();
		
		while (!Display.isCloseRequested())
		{
			//clears screen and depth buffer
			glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);
			
			
			
			int delta = getDelta();
			
			x+= delta * dx * 0.1;
			y+= delta * dy * 0.1;
			
			glRecti(x,y, x+30, y+30);
			
			
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
		TimerDemo q = new TimerDemo();
		q.start();
		// TODO Auto-generated method stub

	}

}

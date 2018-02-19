package GameTestArea;

import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.util.glu.GLU.gluPerspective;

public class glOrthoDemo 
{
	
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

		
		//start OpenGL
		
		glMatrixMode(GL_PROJECTION);
		glLoadIdentity();
		glOrtho(1, 1, 1, 1, -1, 1);
		//glOrtho(0, 800, 600, 0, 1, -1);
		glMatrixMode(GL_MODELVIEW);
		
		
		
		while (!Display.isCloseRequested())
		{
			//clears screen and depth buffer
			glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);
			
			
			
			/*glBegin(GL_QUADS);
				glVertex2f(400,400);
				glVertex2f(400 + 50, 400);
				glVertex2f(400 + 50, 400 + 50);
				glVertex2f(400, 400 + 50);
			glEnd();
			*/
			glPointSize(10);
			glBegin(GL_POINTS);
				glVertex2f(.5f,0);
			glEnd();
			
			glColor3f(1, 0, 0);
			glBegin(GL_TRIANGLES);
				glVertex2f(-1, -1);
				glVertex2f(1, -1);
				glVertex2f(1, 1);

			
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
		glOrthoDemo q = new glOrthoDemo();
		q.start();
		// TODO Auto-generated method stub

	}

}
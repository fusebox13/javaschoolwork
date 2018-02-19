import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.util.glu.GLU.gluPerspective;

public class Quad 
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
		glOrtho(0, 800, 600, 0, 1, -1);
		glMatrixMode(GL_MODELVIEW);
		
		
		
		while (!Display.isCloseRequested())
		{
			//clears screen and depth buffer
			glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);
			
			
			
			glBegin(GL_QUADS);
				glVertex2f(400,400);
				glVertex2f(400 + 50, 400);
				glVertex2f(400 + 50, 400 + 50);
				glVertex2f(400, 400 + 50);
			glEnd();
			
			
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
		Quad q = new Quad();
		q.start();
		// TODO Auto-generated method stub

	}

}

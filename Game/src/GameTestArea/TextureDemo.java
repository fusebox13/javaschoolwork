package GameTestArea;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.util.glu.GLU.gluPerspective;
import org.newdawn.slick.opengl.Texture;
import org.newdawn.slick.opengl.TextureLoader;

public class TextureDemo 
{
	private Texture rock;
	
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
		
		rock = loadTexture("Cool_Rock_Texture.png");

		
		//start OpenGL
		
		glMatrixMode(GL_PROJECTION);
		glLoadIdentity();
		glOrtho(0, 800, 600, 0, 1, -1);
		glMatrixMode(GL_MODELVIEW);
		glEnable(GL_TEXTURE_2D);
		
		
		
		while (!Display.isCloseRequested())
		{
			//clears screen and depth buffer
			glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);
			
			//Texture must be bound to set the current texture
			//when you want to use a new texture, you must bind it
			rock.bind();
			glBegin(GL_QUADS);
				//maps the texture to each vertice coordinate 0,0 top left, 1,0 top right, 
				//1,1 bottom right, 0,1 bottom left (1 is the entire width of the texture)
				glTexCoord2f(0,0);
				glVertex2f(0,0);
				glTexCoord2f(1,0);
				glVertex2f(400, 0);
				glTexCoord2f(1,1);
				glVertex2f(400, 400);
				glTexCoord2f(0,1);
				glVertex2f(0, 400);
			glEnd();
			
			
			Display.update();
			Display.sync(60);
		}
		
		Display.destroy();
	}
	
	private Texture loadTexture(String fileName)
	{
		try {
			return TextureLoader.getTexture("PNG", new FileInputStream(new File(fileName)));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		TextureDemo q = new TextureDemo();
		q.start();
		// TODO Auto-generated method stub

	}

}

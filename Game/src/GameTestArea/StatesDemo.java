package GameTestArea;

import org.lwjgl.LWJGLException;
import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import static org.lwjgl.opengl.GL11.*;


public class StatesDemo 
{
	private static enum State {
		INTRO, MAIN_MENU, GAME;
	}
	
	private State state = State.INTRO;
	
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
			checkInput();
			render();
			
			
			
			
			Display.update();
			Display.sync(60);
		}
		
		Display.destroy();
	}
	
	private void render()
	{
		switch(state)
		{
		case INTRO:
			glColor3f(1.0f, 0f, 0f);
			glRectf(0, 0, 800, 600);
			break;
		case GAME:
			glColor3f(0f, 1.0f, 0f);
			glRectf(0, 0, 800, 600);
			break;
		case MAIN_MENU:
			glColor3f(0f, 0f, 1.0f);
			glRectf(0, 0, 800, 600);
			break;
		}
		
	}
	
	private void checkInput()
	{
		switch(state)
		{
		case INTRO:
			if (Keyboard.isKeyDown(Keyboard.KEY_RETURN))
				state = State.MAIN_MENU;
			if (Keyboard.isKeyDown(Keyboard.KEY_ESCAPE))
			{
				Display.destroy();
				System.exit(0);
			}
			break;
		case GAME:
			if (Keyboard.isKeyDown(Keyboard.KEY_BACK))
				state = State.MAIN_MENU;
			break;
		case MAIN_MENU:
			if (Keyboard.isKeyDown(Keyboard.KEY_RETURN))
				state = State.GAME;
			if (Keyboard.isKeyDown(Keyboard.KEY_SPACE))
				state = State.INTRO;
			break;
			
		}
		
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		StatesDemo q = new StatesDemo();
		q.start();
		// TODO Auto-generated method stub

	}

}

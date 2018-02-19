

import org.lwjgl.LWJGLException;
import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;

public class Inputs
{
	
	public void start()
	{
		try 
		{
			Display.setDisplayMode(new DisplayMode(800,600));
			Display.create();
		} 
		catch (LWJGLException e) 
		{
			e.printStackTrace();
			System.exit(0);
		}
		
		//All rendering is done in this loop.
		while(!Display.isCloseRequested())
		{
			getInput();
			Display.update();
		}
		
		Display.destroy();
	}
	
	public void getInput()
	{
		if (Mouse.isButtonDown(0))
		{
			int mouseX = Mouse.getX();
			int mouseY = Mouse.getY();
			
			System.out.println("Mouse pressed at: " + mouseX + "," + mouseY);
		}
		
		if (Keyboard.isKeyDown(Keyboard.KEY_SPACE))
		{
			System.out.println("Space key is down");
		}
		
		while (Keyboard.next())
		{
			if (Keyboard.getEventKeyState()) 
			{
		
				if (Keyboard.getEventKey() == Keyboard.KEY_A) 
					System.out.println("A Key Pressed");
				
				if (Keyboard.getEventKey() == Keyboard.KEY_S) 
					System.out.println("S Key Pressed");	
				
				if (Keyboard.getEventKey() == Keyboard.KEY_D) 
					System.out.println("D Key Pressed");
				
			} 
			else 
			{
				if (Keyboard.getEventKey() == Keyboard.KEY_A) 
					System.out.println("A Key Released");
				
				if (Keyboard.getEventKey() == Keyboard.KEY_S) 
					System.out.println("S Key Released");
				
				if (Keyboard.getEventKey() == Keyboard.KEY_D) 
					System.out.println("D Key Released");	
				
			}
		}
	}

	public static void main(String[] args) 
	{
		Inputs i = new Inputs();
		i.start();
	
	

	}

}

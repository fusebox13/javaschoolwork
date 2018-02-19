package GameTestArea;

import static org.lwjgl.opengl.GL11.GL_MODELVIEW;
import static org.lwjgl.opengl.GL11.glMatrixMode;
import static org.lwjgl.opengl.GL11.glOrtho;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.lwjgl.LWJGLException;
import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.lwjgl.opengl.GL11;

import static org.lwjgl.opengl.GL11.*;

public class DisplayWindow 
{
	private List<Box> shapes = new ArrayList<Box>(16);
	private boolean selected = false;
	private volatile boolean randomColorCooldown = false;
	
	
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
		
		shapes.add(new Box(15, 15));
		shapes.add(new Box(100, 150));
		
		
		
		glMatrixMode(GL_PROJECTION);
		glLoadIdentity();
		glOrtho(0, 800, 600, 0, 1, -1);
		glMatrixMode(GL_MODELVIEW);
		
		//All rendering is done in this loop.
		while(!Display.isCloseRequested())
		{
			glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);
			
			while (Keyboard.next())
			{
				if (Keyboard.getEventKey() == Keyboard.KEY_C && Keyboard.getEventKeyState())
				{
					shapes.add(new Box(15, 15));
				}
			}
			
			if (Keyboard.isKeyDown(Keyboard.KEY_ESCAPE))
			{
				Display.destroy();
				System.exit(0);
			}
			
			
			
			for (Box box : shapes)
			{
				if(Mouse.isButtonDown(0) && box.inBounds(Mouse.getX(), 600 - Mouse.getY()) && !selected)
				{
					selected = true;
					box.selected = true;
					System.out.println("You clicked me");
				}
				if (Mouse.isButtonDown(2) && box.inBounds(Mouse.getX(), 600 - Mouse.getY()) && !selected)
				{
					box.randomizeColors();
					randomColorCooldown = true;
					new Thread(new Runnable(){
						
						public void run()
						{
							try 
							{
								Thread.sleep(200);
							}
							catch(InterruptedException e)
							{
								e.printStackTrace();
							}
							finally 
							{
								randomColorCooldown = false;
							}
						}
					}).run();
				}
				if (Mouse.isButtonDown(1))
				{
					box.selected = false;
					selected = false;
				}
				
				if(box.selected)
				{
					box.update(Mouse.getDX(), -Mouse.getDY());
				}
				box.draw();
			}
			
			Display.update();
			Display.sync(60);
		}
		
		Display.destroy();
	}
	
	private static class  Box {
		public int x, y;
		private float red, blue, green;
		public boolean selected = false;
		
		Box(int x, int y)
		{
			this.x = x;
			this.y = y;
			
			Random randomGenerator = new Random();
			red = randomGenerator.nextFloat();
			blue = randomGenerator.nextFloat();
			green = randomGenerator.nextFloat();
		}
		
		boolean inBounds(int mousex, int mousey)
		{
			if(mousex > x && mousex < x + 50 && mousey > y && mousey < y + 50)
				return true;
			else
				return false;
			
		}
		
		void update(int dx, int dy)
		{
			x += dx;
			y += dy;
		}
		
		
		void randomizeColors()
		{
			Random randomGenerator = new Random();
			red = randomGenerator.nextFloat();
			blue = randomGenerator.nextFloat();
			green = randomGenerator.nextFloat();
		}
		void draw()
		{
			glColor3f(red, green, blue);
			glBegin(GL_QUADS);
				glVertex2f(x,y);
				glVertex2f(x + 50, y);
				glVertex2f(x + 50, y + 50);
				glVertex2f(x, y + 50);
			glEnd();
			
			
		}
		
	}

	public static void main(String[] args) 
	{
		DisplayWindow display = new DisplayWindow();
		display.start();
	

	}

}

package GameTestArea;

import java.nio.FloatBuffer;
import java.text.DecimalFormat;
import java.util.Random;

import org.lwjgl.BufferUtils;
import org.lwjgl.LWJGLException;
import org.lwjgl.Sys;
import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.lwjgl.util.vector.Vector3f;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.UnicodeFont;
import org.newdawn.slick.font.effects.ColorEffect;

import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.util.glu.GLU.gluPerspective;

public class PerspectiveDemo 
{
	
	/*Quad q = new Quad(-.05f, -.1f, .05f, -.1f, -1, -2);
	Quad q2 = new Quad(.1f, -.1f, .2f, 0, -1, -2);
	Quad q3 = new Quad(.2f, 0, .2f, .1f, -1, -2);
	Quad q4 = new Quad(.2f, .1f, .1f, .2f, -1, -2);
	Quad q5 = new Quad(-.05f, .2f, .05f, .2f, -1, -2);
	Quad q6 = new Quad(-.2f, .1f, -.1f, .2f, -1, -2);
	Quad q7 = new Quad (-.2f, .1f, -.2f, 0f, -1, -2);
	Quad q8 = new Quad(-.2f, 0f, -.1f, -.1f, -1, -2);*/
	
	private static UnicodeFont font;
	private static DecimalFormat formatter = new DecimalFormat("#.##");

	private static FloatBuffer perspectiveProjectionMatrix = reserveData(16);
	private static FloatBuffer orthographicProjectionMatrix = reserveData(16);
	
	
	float lastTime = 0.0f;
	float time = 0.0f;
	float dx = 0.0f;
	float dy = 0.0f;
	float dt = 0.0f;
	
	float sensitivity = .2f;
	float movementSpeed = 20f;
	
	Cube c = new Cube(0, 0, -0.01f, .002f);
	
	CameraController camera = new CameraController(0, 0, 0);
	
	public void start()
	{
		try 
		{
			Display.setDisplayMode(new DisplayMode(800, 600));
			Display.setTitle("3D Perspective Demo");
			Display.setVSyncEnabled(true);
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
		gluPerspective((float)30, 800f / 600f, 1f, 10);
		
		
		
		
		setUpLighting();
		setUpFonts();
		
		Point[] points = new Point[10000];
		Random random = new Random();
		
		for (int i = 0; i < points.length; i++) {
			
			float x = random.nextFloat() - .5f;
			float y = random.nextFloat() - .5f;
			int z = random.nextInt(200) - 200;
			
			points[i] = new Point(x,y,z);
		}
		
		Cube[] cubes = new Cube[100];
		
		float pad = .2f;
		for (int i = 0; i < cubes.length; i++)
		{
			float x = random.nextFloat() - 0.5f;
			float y = random.nextFloat() - 0.5f;
			cubes[i] = new Cube(x,y,-2f - pad, .2f);
			pad += .4f;
		}
		
		
		
		float speed = 0.0f;
		float angle = 0.0f;
		
		lastTime = Sys.getTime();
		
		float startZ = -0.01f;
		while (!Display.isCloseRequested())
		{
			glViewport(0, 0, Display.getWidth(), Display.getHeight());
			glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);
			
			
			glMatrixMode(GL_PROJECTION);
			glLoadIdentity();
			gluPerspective((float)30, 800f / 600f, 1f, 10);
			
			glMatrixMode(GL_MODELVIEW);
			glLoadIdentity();
			glEnable(GL_DEPTH_TEST);
			glEnable(GL_LIGHTING);
			
			time=Sys.getTime();
			dt = (time - lastTime);
			lastTime = time;
			
			glPushMatrix();
			processInput();
			camera.updateCameraPosition();
			
			
			//glBegin(GL_POINTS);
				for (Point p: points) {
					if (p.z < 0.001f)
						p.z += .2f;
					else
						p.z = -200f;
					
					glColor3f(p.red, p.green, p.blue);
					glBegin(GL_POINTS);	
						glVertex3f(p.x, p.y, p.z);
					glEnd();
				}
			//glEnd();
			
		
			/*Cube c2 = new Cube(0,0,startZ-=0.01f, .02f);
			c2.draw(); */
			for (Cube c: cubes) {
				
				System.out.println(Mouse.getX() + ", " + Mouse.getY());
				if (Mouse.isButtonDown(0) && c.inBounds(Mouse.getX(), Mouse.getY()))
				{
					System.out.println("Selected");
				}
				c.draw();

			}
			glPopMatrix();
			
			glMatrixMode(GL_PROJECTION);
			glLoadIdentity();
			glOrtho(0.0f, Display.getWidth(), 0.0f, Display.getHeight(), -1.0f, 1.0f);
			
			glMatrixMode(GL_MODELVIEW);
			glLoadIdentity();
			glDisable(GL_DEPTH_TEST);
			glDisable(GL_LIGHTING);
			//glBegin(GL_QUADS);
			//maps the texture to each vertice coordinate 0,0 top left, 1,0 top right, 
			//1,1 bottom right, 0,1 bottom left (1 is the entire width of the texture)
			//glVertex2f(0,0);
			//glVertex2f(400, 0);
			//glVertex2f(400, 400);
			//glVertex2f(0, 400);
			//glEnd();
			
			Display.update();
			Display.sync(60);
		}
		
		Display.destroy();
	}
	
	public static void setOrthoOn()
	{
	        // prepare to render in 2D
	                   // so 2D stuff stays on top of 3D scene
	        glMatrixMode(GL_PROJECTION);
	        glLoadMatrix(orthographicProjectionMatrix);                         // preserve perspective view
	        
	        // clear the perspective matr
	        glMatrixMode(GL_MODELVIEW);
	        glPushMatrix();	 // Preserve the Modelview Matrix
	        glLoadIdentity();	 // clear the Modelview Matrix
	        
	        glEnable(GL_BLEND);
		    glBlendFunc(GL_SRC_ALPHA, GL_ONE_MINUS_SRC_ALPHA);
		    glDisable(GL_DEPTH_TEST);  
	        
	}
	
	public static void setOrthoOff()
	{
	        // restore the original positions and views
			glDisable(GL_BLEND);
			glEnable(GL_DEPTH_TEST);
			
			glPopMatrix();
			
	        glMatrixMode(GL_PROJECTION);
	        glLoadMatrix(perspectiveProjectionMatrix);
	        glMatrixMode(GL_MODELVIEW);
	        
	        
	        
	        	 // turn Depth Testing back on
	}
	
	
	protected static void make2D() {
        //Remove the Z axis
        glDisable(GL_LIGHTING);
        glDisable(GL_DEPTH_TEST);
        glMatrixMode(GL_PROJECTION);
        glPushMatrix();
        glLoadIdentity();
        glOrtho(0, Display.getWidth(), 0, Display.getHeight(), -1, 1);
        glMatrixMode(GL_MODELVIEW);
        glPushMatrix();
        glLoadIdentity();
        
        glEnable(GL_BLEND);
		glBlendFunc(GL_SRC_ALPHA, GL_ONE_MINUS_SRC_ALPHA);
    }

    protected static void make3D() {
        //Restore the Z axis
    	
        glPopMatrix();
        glMatrixMode(GL_PROJECTION);
        glPopMatrix();
        glMatrixMode(GL_MODELVIEW);
        glDisable(GL_BLEND);
        glEnable(GL_DEPTH_TEST);
        glEnable(GL_LIGHTING);
    }
	public void processInput()
	{
		
		if (Mouse.isButtonDown(1)) {
			dx = Mouse.getDX();
			dy = Mouse.getDY();
		
			camera.yaw(dx * sensitivity);
			camera.pitch(dy * sensitivity);
		}
		
		
		if (Keyboard.isKeyDown(Keyboard.KEY_W))
			camera.forward(movementSpeed *0.002f);
		if (Keyboard.isKeyDown(Keyboard.KEY_S))
			camera.backwards(movementSpeed * 0.002f);
		if (Keyboard.isKeyDown(Keyboard.KEY_A))
			camera.strafeLeft(movementSpeed * 0.002f);
		if (Keyboard.isKeyDown(Keyboard.KEY_D))
			camera.strafeRight(movementSpeed * 0.002f);	
		if (Keyboard.isKeyDown(Keyboard.KEY_E))
		{
			glLight(GL_LIGHT0, GL_POSITION, asFloatBuffer(new float[]{camera.position.x,camera.position.y,camera.position.z,1}));
		}
		if(Keyboard.isKeyDown(Keyboard.KEY_SPACE))
			camera.up();
		if(Keyboard.isKeyDown(Keyboard.KEY_LSHIFT))
			camera.down();
	}
	
	private static FloatBuffer asFloatBuffer(float[] values) {
		FloatBuffer buffer = BufferUtils.createFloatBuffer(values.length);
		buffer.put(values);
		buffer.flip();
		return buffer;
	}
	
	private static void setUpFonts()
	{
		java.awt.Font awtFont = new java.awt.Font("Times New Roman", java.awt.Font.BOLD, 18);
		font = new UnicodeFont(awtFont);
		font.getEffects().add(new ColorEffect(java.awt.Color.white));
		font.addAsciiGlyphs();
		try{
			font.loadGlyphs();
		} catch (SlickException e)
		{
			e.printStackTrace();
		}
	}
	
	private static void setUpLighting() {
		glShadeModel(GL_SMOOTH);
		glEnable(GL_DEPTH_TEST);
		glEnable(GL_LIGHTING);
		glEnable(GL_BLEND);
	    glBlendFunc(GL_SRC_ALPHA, GL_ONE_MINUS_SRC_ALPHA);
		glEnable(GL_LIGHT0);
		glLightModel(GL_LIGHT_MODEL_AMBIENT, asFloatBuffer(new float[]{0.05f, 0.05f, 0.05f, 1f}));
		glLight(GL_LIGHT0, GL_POSITION, asFloatBuffer(new float[]{0,0,0,1}));
		glEnable(GL_COLOR_MATERIAL);
		glColorMaterial(GL_FRONT, GL_DIFFUSE);
	}
	
	private static class Quad {
		
		float x, y, x2, y2, zNear, zFar;
		float red, green, blue;
		
		public Quad(float x, float y, float x2, float y2, float zNear, float zFar)
		{
			this.x = x;
			this.y = y;
			this.x2 = x2;
			this.y2 = y2;
			this.zNear = zNear;
			this.zFar = zFar;
			randomizeColors();
		}
		
		public void draw() {
			
			glColor3f(red, green, blue);
			glBegin(GL_QUADS);
				glVertex3f(x, y, zNear);
				glVertex3f(x2, y2, zNear);
				glVertex3f(x2, y2, zFar);
				glVertex3f(x, y, zFar);
			glEnd();
			
		}
		
		public void randomizeColors()
		{
			Random randomGenerator = new Random();
			red = randomGenerator.nextFloat();
			blue = randomGenerator.nextFloat();
			green = randomGenerator.nextFloat();
		}
		
	}

	private static class Point {
		float x, y, z;
		float red, green, blue;
		
		public Point(float x, float y, float z) {
			this.x = x;
			this.y = y;
			this.z = z;
			randomizeColors();
		}
		
		public void randomizeColors()
		{
			Random randomGenerator = new Random();
			red = randomGenerator.nextFloat();
			blue = randomGenerator.nextFloat();
			green = randomGenerator.nextFloat();
		}
		
	}
	
	private static class Cube {
		float x, y, z, width;
		float red, green, blue;
		boolean selected = false;
		
		public Cube(float x, float y, float z, float width)
		{
			this.x = x;
			this.y = y;
			this.z = z;
			this.width = width;
			randomizeColors();
			
		}
		
		public void randomizeColors()
		{
			Random randomGenerator = new Random();
			red = randomGenerator.nextFloat();
			blue = randomGenerator.nextFloat();
			green = randomGenerator.nextFloat();
		}
		
		boolean inBounds(int mousex, int mousey)
		{
			if(mousex > x && mousex < x + width && mousey > y && mousey < y + width)
				return true;
			else
				return false;
			
		}
		public void draw()
		{
			//Front Face
			glColor3f(red, green, blue);
			glBegin(GL_QUADS);
				glVertex3f(x, y, z);
				glVertex3f(x + width, y, z);
				glVertex3f(x + width, y + width, z);
				glVertex3f(x, y + width, z);
			glEnd();
			
			//Rear Face
			glColor3f(green, red, blue);
			glBegin(GL_QUADS);
				glVertex3f(x, y, z + width);
				glVertex3f(x + width, y, z + width);
				glVertex3f(x + width, y + width, z + width);
				glVertex3f(x, y + width, z + width);
			glEnd();
			
			//top
			glColor3f(green, blue, red);
			glBegin(GL_QUADS);
				glVertex3f(x, y+width, z);
				glVertex3f(x+width, y+width, z);
				glVertex3f(x+width, y+width, z+width);
				glVertex3f(x, y+width, z+width);
			glEnd();
			
			//bottom
			glColor3f(blue, red, green);
			glBegin(GL_QUADS);
				glVertex3f(x, y, z);
				glVertex3f(x+width, y, z);
				glVertex3f(x+width, y, z+width);
				glVertex3f(x, y, z+width);
			glEnd();
			
			//leftside
			glColor3f(blue, green, red);
			glBegin(GL_QUADS);
				glVertex3f(x,y,z);
				glVertex3f(x, y, z+width);
				glVertex3f(x, y+width, z+width);
				glVertex3f(x, y+width, z);
				
				
			glEnd();
			
			//rightside
			glColor3f(red, blue, blue);
			glBegin(GL_QUADS);
				glVertex3f(x+width, y, z);
				glVertex3f(x+width, y+width, z);
				glVertex3f(x+width, y+width, z+width);
				glVertex3f(x+width, y, z+width);
			glEnd();
		}
		
		public void setX(float x)
		{
			this.x = x;
		}
		
		public void setY(float y)
		{
			this.y = y;
		}
		
		public float getX()
		{
			return x;
		}
		
		public float getY()
		{
			return y;
		}
		
		public float getWidth()
		{
			return width;
		}
		
		public void select()
		{
			selected = true;
		}
		
	}
	
	public class CameraController
	{
		private Vector3f position = null;
		private float yaw = 0.0f;
		private float pitch = 0.0f;
		
		public CameraController(float x, float y, float z)
		{
			position = new Vector3f(x,y,z);
		}
		
		public void yaw(float amount)
		{
			yaw += amount;
		}
		
		public void pitch(float amount)
		{
			pitch -= amount;
		}
		
		public void forward(float distance)
		{
			position.x -= distance * (float)Math.sin(Math.toRadians(yaw));
			position.y += distance * (float) Math.tan(Math.toRadians(pitch));
			position.z += distance * (float)Math.cos(Math.toRadians(yaw));
		}
		
		public void backwards(float distance)
		{
			position.x += distance * (float)Math.sin(Math.toRadians(yaw));
			position.y -= distance * (float) Math.tan(Math.toRadians(pitch));
			position.z -= distance * (float)Math.cos(Math.toRadians(yaw));
		}
		
		public void strafeLeft(float distance)
		{
			position.x -= distance * (float)Math.sin(Math.toRadians(yaw-90));
			position.z += distance * (float)Math.cos(Math.toRadians(yaw-90));
		}
		
		public void strafeRight(float distance)
		{
			position.x -= distance * (float)Math.sin(Math.toRadians(yaw+90));
			position.z += distance * (float)Math.cos(Math.toRadians(yaw+90));
		}
		
		public void down()
		{
			position.y += movementSpeed * 0.002;
		}
		
		public void up()
		{
			position.y -= movementSpeed * 0.002;
		}
		
		public void updateCameraPosition()
		{
			glRotatef(pitch, 1.0f, 0f, 0f);
			glRotatef(yaw, 0f, 1.0f, 0f);
			glTranslatef(position.x, position.y, position.z);
		}
		
		
	}
	
	 public static FloatBuffer reserveData(int amountOfElements) {
	        return BufferUtils.createFloatBuffer(amountOfElements);
	    }
	
	
	
	
	public static void main(String[] args) 
	{
		PerspectiveDemo q = new PerspectiveDemo();
		q.start();
		// TODO Auto-generated method stub

	}

}
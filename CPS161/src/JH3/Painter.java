package JH3;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class Painter extends JFrame {

	Canvas canvas = new Canvas();
	Image bufferedImage = null;
	Dimension screenDimension = null;

	class MouseHandler extends MouseAdapter  {
		public void mousePressed(MouseEvent e) {
			canvas.mousePressed(e.getPoint());
			repaint();
		}

		public void mouseReleased(MouseEvent e) {
			canvas.mouseReleased(e.getPoint());
			repaint();

		}

		public void mouseDragged(MouseEvent e) {
			canvas.mouseDragged(e.getPoint());
			repaint();
		}
		
		public void mouseWheelMoved(MouseWheelEvent e)
		{
			
			if(e.getWheelRotation() < 0)
				System.out.println("Mousewheel moved up");
			else
				System.out.println("Mousewheel moved down");
		}

	}

	class KeyHandler implements KeyListener {

		@Override
		public void keyPressed(KeyEvent e) {
			switch (e.getKeyChar()) {
			case 'r':
				canvas.setToolType(ToolType.rectangle);
				break;
			case 'o':
				canvas.setToolType(ToolType.oval);
				break;
			case 'l':
				canvas.setToolType(ToolType.line);
				break;
			case 's':
				canvas.setToolType(ToolType.scribble);
				break;
			case 'p':
				canvas.setToolType(ToolType.polygon);
				break;
			case 'f':
				canvas.setFilled(true);
				break;
			case 'd':
				canvas.setFilled(false);
				break;
			case 'b':
				canvas.setColor(Color.blue);
				break;
			case 'm':
				canvas.setColor(Color.magenta);
				break;
			case 'g':
				canvas.setColor(Color.green);
				break;
			case KeyEvent.VK_ENTER:
				canvas.keyPressed();
				break;
			case KeyEvent.VK_BACK_SPACE:
				canvas.clear();
				break;
			case '=':
				canvas.increaseBrushSize();
				break;
			case '-':
				canvas.decreaseBrushSize();
				break;
			default: // '?' comes here
				System.out.println("r - drawType= Rectangle");
				System.out.println("o - drawType= Oval");
				System.out.println("l - drawType= Line");
				System.out.println("s - drawType= Scribble");
				System.out.println("p - drawType= Polygon");
				System.out.println("a - another Polygon");
				System.out.println("q - quit");
				System.out.println("f - filled objects");
				System.out.println("d - draw objects (not filled)");
				System.out.println("b - Use Blue Color");
				System.out.println("m - Use magenta Color");
				System.out.println("g - Use Green Color");
				break;
			}
			repaint();

		}

		@Override
		public void keyReleased(KeyEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void keyTyped(KeyEvent e) {
			// TODO Auto-generated method stub

		}

	}

	Painter() {
		super("Painter");
		setSize(1920,1080);
		setExtendedState(MAXIMIZED_BOTH);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		MouseHandler m = new MouseHandler();
		addMouseListener(m);
		addMouseMotionListener(m);
		addMouseWheelListener(m);

		KeyHandler k = new KeyHandler();
		addKeyListener(k);

		setVisible(true);
		setLayout(new BorderLayout());
	}

	public void paint(Graphics screen)
	{
		Dimension d= getSize();
		if(bufferedImage == null || !d.equals(screenDimension))
		{
			screenDimension = d;
			bufferedImage = createImage(d.width, d.height);
		}
		Graphics g = bufferedImage.getGraphics();
		
		Insets insets = getInsets();
		int top = insets.top;
		int left = insets.left;
		int bottom = insets.bottom;
		int right = insets.right;
		
		Font font = g.getFont();
		FontMetrics fm = getFontMetrics(font);
		int fontHeight = fm.getHeight();
		int maxAscent = fm.getMaxAscent();
		
		String instructions = canvas.toolProperties.instructions();
		int instructionsWidth = fm.stringWidth(instructions);
		
		g.setColor(Color.white);
		g.fillRect(0, 0, d.width, d.height);
		
		g.setColor(Color.darkGray);
		g.fillRect(left, top, d.width - left - right, fontHeight);
		
		g.setColor(Color.white);
		g.drawString(canvas.toolProperties.toString(), left, top + maxAscent);
		
		g.setColor(Color.darkGray);
		g.fillRect(left, d.height - bottom - fontHeight, d.width - left - right, fontHeight);
		g.setColor(Color.white);
		g.drawString(canvas.toolProperties.instructions(), (d.width - left - right)/2 - instructionsWidth/2 , d.height-bottom-fontHeight + maxAscent);
		
		
		canvas.draw(g);
		
		screen.drawImage(bufferedImage,0,0,this);
		
		
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Painter p = new Painter();

	}

}

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;


public class screen extends JFrame implements ActionListener
{
	public void actionPerformed(ActionEvent e)
	{
		
	}
	
	public void mousePressed(MouseListener m)
	{
		System.out.println("Mouse Pressed");
	}
	
	public void mouseReleased(MouseListener m)
	{
		
	}
	
	public void mouseClicked(MouseListener m)
	{
		
	}
	
	public void mouseEntered(MouseListener m)
	{
		
	}
	public void mouseExited(MouseListener m)
	{
		
	}
	screen()
	{
		
		
		
	}
	
	screen(Dimension d)
	{
		super("Screen Name");
		this.setSize(d);
		this.setVisible(true);
		this.setLayout(new FlowLayout());
		
		JButton button1 = new JButton("Press me");
		button1.setSize(100, 40);
		button1.setActionCommand("button1");
	
		
		add(button1);
		
		
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		Dimension dim = new Dimension(400,400);
		
		screen scr = new screen(dim);
		// TODO Auto-generated method stub

	}

}

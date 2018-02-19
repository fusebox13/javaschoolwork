package Frames;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class frameexample extends JFrame
{
	frameexample()
	{
		super("New Frame");
		setSize(800, 800);
		setVisible(true);
		setLayout(new BorderLayout());
		
		JButton b = new JButton("FUCK YOU!");
		add(b, BorderLayout.SOUTH);
		JMenuBar menubar = new JMenuBar();
		JMenu menu = new JMenu("Fuck you");
		JMenuItem item = new JMenu("FUCK YOU!!!!");
		
		menu.add(item);
		menubar.add(menu);
		setJMenuBar(menubar);
		
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		
		frameexample e = new frameexample();
		// TODO Auto-generated method stub

	}

}

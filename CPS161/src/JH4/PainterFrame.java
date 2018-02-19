package JH4;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;



public class PainterFrame extends JFrame
{
	
	
	Painter center = new Painter();
	JPanel north = new JPanel(new FlowLayout());
	JPanel west = new JPanel(new GridLayout(0,1));
	JPanel south = new JPanel(new FlowLayout());
	
	ButtonGroup tools = new ButtonGroup();
	ButtonGroup colors = new ButtonGroup();
	JButton done = new JButton("Done");
	JCheckBox fill = new JCheckBox("Fill", false);
	RadioListener r = new RadioListener();
	JLabel instructions = new JLabel(center.getCanvas().toolProperties.instructions());
	
	
	PainterFrame()
	{
		super("Proshop Paint");
		setSize(1920, 1040);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		center.getCanvas().setColor(Color.red);
		center.getCanvas().setToolType(ToolType.rectangle);
		
		createSouthJComponents();
		createNorthJComponents();
		createWestJComponents();
		
		add(south, BorderLayout.SOUTH);
		add(center, BorderLayout.CENTER);
		add(north, BorderLayout.NORTH);
		add(west, BorderLayout.WEST);
		
		
		setVisible(true);
	}
	
	public void updateInstructions()
	{
		instructions.setText(center.getCanvas().toolProperties.instructions());
	}
	
	public void createSouthJComponents()
	{
		south.add(instructions);
	}
	
	public void createNorthJComponents()
	{
		
		JRadioButton Rect = new JRadioButton("Rectangle", true);
		JRadioButton Oval = new JRadioButton("Oval", false);
		JRadioButton Scrib = new JRadioButton("Scribble", false);
		JRadioButton Poly = new JRadioButton("Polygon", false);
		JButton Clear = new JButton("Clear");
		done.setVisible(false);
		
		Rect.addActionListener(r);
		Oval.addActionListener(r);
		Scrib.addActionListener(r);
		Poly.addActionListener(r);
		fill.addActionListener(r);
		done.addActionListener(r);
		Clear.addActionListener(r);
		
		tools.add(Rect);
		tools.add(Oval);
		tools.add(Scrib);
		tools.add(Poly);
		
		north.add(Rect);
		north.add(Oval);
		north.add(Scrib);
		north.add(Poly);
		north.add(fill);
		north.add(Clear);
		north.add(done);
		
	}
	
	public void createWestJComponents()
	{
		JRadioButton Red = new JRadioButton("Red", true);
		JRadioButton Blue = new JRadioButton("Blue", true);
		JRadioButton Green = new JRadioButton("Green", true);
		
		Red.addActionListener(r);
		Blue.addActionListener(r);
		Green.addActionListener(r);
		
		colors.add(Red);
		colors.add(Blue);
		colors.add(Green);
		
		west.add(Red);
		west.add(Blue);
		west.add(Green);
	}
	
	
	
	class RadioListener implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e)
		{
			if (fill.isSelected())
				center.getCanvas().setFilled(true);
			else
				center.getCanvas().setFilled(false);
			
			switch(e.getActionCommand())
			{
			case "Oval":
				center.getCanvas().setToolType(ToolType.oval);
				fill.setVisible(true);
				done.setVisible(false);
				updateInstructions();
				break;
			case "Rectangle":
				center.getCanvas().setToolType(ToolType.rectangle);
				fill.setVisible(true);
				done.setVisible(false);
				updateInstructions();
				break;
			case "Scribble":
				center.getCanvas().setToolType(ToolType.scribble);
				fill.setVisible(false);
				done.setVisible(false);
				updateInstructions();
				break;
			case "Polygon":
				center.getCanvas().setToolType(ToolType.polygon);
				fill.setVisible(true);
				done.setVisible(true);
				updateInstructions();
				break;
			case "Red":
				center.getCanvas().setColor(Color.red);
				break;
			case "Blue":
				center.getCanvas().setColor(Color.blue);
				break;
			case "Green":
				center.getCanvas().setColor(Color.green);
				break;
			case "Done":
				center.getCanvas().keyPressed();
				break;
			case "Clear":
				center.getCanvas().clear();
				break;
			default:
						
			}
			repaint();
			
		}
		
		
	}
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		PainterFrame f = new PainterFrame();
		// TODO Auto-generated method stub

	}

}

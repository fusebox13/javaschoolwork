import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class simpleLoop extends JPanel implements ActionListener
{
	//created Button and TextField objects to be used to the entire class
	protected JButton runLoop;
	private JTextField[] textField;
	
	//Declared a serialUID to clear up a compiler warning
	private static final long serialVersionUID = 1L ;
	
	//The Actionlistener listens for the button command RUN_LOOP which has been
	//set to the runLoop JButton object in the createUI() method below
	public void actionPerformed(ActionEvent ButtonPressed)
	{
		//RUN_LOOP is the ActionCommand set to the runLoop button
		if("RUN_LOOP".equals(ButtonPressed.getActionCommand()))
		{
			//Grabs the text from the textField object array and converts
			//the Strings to integers.  Does not handle exceptions
			int start = Integer.parseInt(textField[0].getText());
			int end = Integer.parseInt(textField[1].getText());
			int steps = Integer.parseInt(textField[2].getText());
			
			//counter is used to print a line break every 10 numbers
			int counter = 0;
			
			//Prompts user to correct their input if start is greater than end
			//since the for loop will not work properly
			if (start >= end)
			{	
				System.out.println("");
				System.out.println("Error: Start value cannot be greater or equal to end value");
			}
			//Prints the sequence of numbers, and does a line break every 10 numbers
			else
			{
				System.out.println("Starting number: " + start + "\nEnding Number: " + end + "\nStep Size: " + steps);
				for (int i = start; i <= end; i+=steps)
				{
					System.out.print( i + ", ");
					counter++;
					if (counter % 10 == 0)
					{
						System.out.println("");
					}
					
				
				}
			}
		}
		
	}
	
	private void createUI()
	{
		//Creates a new Frame to add components to
		JFrame mainFrame = new JFrame("Simple Loop");
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//Creates an array of Strings to populate the text labels
		String[] textLabels = {"Start: ","End: ", "Step Size: "};
		int numLabels = textLabels.length;
		
		//Creates a panel to add the labels, textfields, and buttons to
		//used the GridLayout Layout Manager
		JPanel FormPanel = new JPanel(new GridLayout(4,1));
		
		/*Creates the Run button, sets an action command to be used by the listener
		sets a hotkey alt+r to activate the button using a keyboard command
		adds an ActionListener to this button to determine if it has been clicked*/
		runLoop = new JButton("Run Loop");
		runLoop.setActionCommand("RUN_LOOP");
		runLoop.setMnemonic(KeyEvent.VK_R);
		runLoop.addActionListener(this);
		
		//Creates an array of TextFields the same size as the textLabels String
		textField = new JTextField[numLabels];
		
		/*Populates the formPanel with textFields and corresponding labels*/
		for (int i = 0; i < numLabels; i++)
		{
			JLabel label = new JLabel(textLabels[i], JLabel.LEADING);
			FormPanel.add(label);
			textField[i] = new JTextField(10);
			textField[i].addActionListener(this);
			label.setLabelFor(textField[i]);
			FormPanel.add(textField[i]);
		}
		
		//Creates and empty panel to shift the button object one column to the right.
		JPanel placeHolder = new JPanel();
		
		FormPanel.setOpaque(true);  //Sets the formPanel opacity
		mainFrame.setContentPane(FormPanel);  //sets the content pane to the FormPanel object
		mainFrame.getContentPane().add(placeHolder); //adds the empty panel to shift the button
		mainFrame.getContentPane().add(runLoop); //adds the button

		mainFrame.pack(); //compacts the components
		mainFrame.setVisible(true); // shows the UI
		
		
	}
	
	/*Forces the program to be run on the event dispatch thread the next time it can*/
	public static void main(String [] args)
	{
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new simpleLoop().createUI();
			}
		});
		
	}
	/*Note to self:
	Add a KeyListener to listen for the enter key.
	Add JTextArea to print the output to.  
	Experiment with try/catch to handle bad input from the textField.*/

}

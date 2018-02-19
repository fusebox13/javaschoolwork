import java.awt.Dimension;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;


public class tempConverter extends JPanel implements KeyListener
{
	//Assigned a serialVersionUID to prevent a compiler warning
	private static final long serialVersionUID = 2L;
	
	//The TextFields and the Keystring can only be accessed by members of the class
	private JTextField FText;
	private JTextField CText;
	private String KeyString = "";
	
	//The KeyEvents convert the temperature in real time every time a key is pressed, released or typed
	public void keyReleased(KeyEvent key)
	{
		convert(key);
	}
	
	//clears the TextFields if the backspace key is entered
	public void keyPressed(KeyEvent key)
	{
		convert(key);
		if (key.getKeyCode() == KeyEvent.VK_BACK_SPACE)
			clearInput();
	}
	
	//calls the convert function ever time a key is typed
	public void keyTyped(KeyEvent key)
	{
		convert(key);
	}
	
	//Clears the TextFields and the KeyString
	public void clearInput()
	{
		FText.setText("");
		CText.setText("");
		KeyString = "";
		
	}
	//convert listens for a KeyEvent which is passed from the KeyListener functions above and calculates the temperatures in real time depend on which component has focus
	public void convert(KeyEvent event)
	{
		//Because the strings input are being parsed as doubles at one point, I try to catch at 
		//NumberFormatException
		try{
		
		//Checks for an event ID.  If a key is pressed it does the calculation
		if (event.getID() == KeyEvent.KEY_PRESSED && FText.hasFocus() == true)
		{
			//Stores the value of the key being pressed as a character, and concatenates it to the KeyString
			char c = event.getKeyChar();
			KeyString = KeyString + c;
			System.out.println(KeyString);
			
			//Calculates Celsius and sets the Celsius textfield to the converted temperature
			double Fahrenheit = Double.parseDouble(KeyString);
			double Celsius = (Fahrenheit - 32.0) * (5.0/9.0);
			String s = Double.toString(Celsius);
			System.out.println("Celsius: " + s);
			CText.setText(s);
			
		}
		//Does the same as the code above, except it converts to Fahrenheit and sets the FText field to the converted number
		if(event.getID() == KeyEvent.KEY_PRESSED && CText.hasFocus() == true)
		{
			char c = event.getKeyChar();
			KeyString = KeyString + c;
			System.out.println(KeyString);
			
			double Celsius = Double.parseDouble(KeyString);
			double Fahrenheit = Celsius * (9.0/5.0) + 32.0;
			String s = Double.toString(Fahrenheit);
			System.out.println("Fahrenheit: " + s);
			FText.setText(s);
		}
		}catch(NumberFormatException NFE){
			System.out.println("Error: You must input a number");
		}
	}
	
	//Creates a simple Swing UI to handle the input
	private void createUI()
	{
		
		JFrame mainFrame = new JFrame("Temperature Converter");
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainFrame.setSize(400,55);
		mainFrame.setResizable(false);
		
		JPanel MainPanel = new JPanel();
		
		FText = new JTextField(12);
		FText.addKeyListener(this);
		FText.setActionCommand("F_TEXT");
		FText.setHorizontalAlignment(JTextField.CENTER);
		FText.setMaximumSize(new Dimension(400,20));
		
		CText = new JTextField(12);
		CText.addKeyListener(this);
		CText.setActionCommand("C_TEXT");
		CText.setHorizontalAlignment(JTextField.CENTER);
		CText.setMaximumSize(new Dimension(400,20));
		
		JLabel FLabel = new JLabel("Fahrenheit");
		JLabel CLabel = new JLabel("Celsius");
		
		MainPanel.add(FLabel);
		MainPanel.add(FText);
		MainPanel.add(CLabel);
		MainPanel.add(CText);
		
		mainFrame.setContentPane(MainPanel);
		
		mainFrame.setVisible(true);
		
		
	}
	
	//Forces the program to wait for the Event Dispatcher to avoid potential thread issues
	public static void main(String [] args)
	{
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new tempConverter().createUI();
			}
		});
		
	}
}

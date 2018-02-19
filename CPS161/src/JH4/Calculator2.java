package JH4;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Calculator2 extends JFrame implements ActionListener
{
	
	
	private static final long serialVersionUID = 1L;
	
	public JPanel Text = new JPanel();
	public JPanel Numbers = new JPanel();
	JTextField textField;
	String textFieldCurrentContents = "0";
	Font f = new Font("Serif", Font.BOLD, 32);
	ActionEvent lastAction = null;
	
	Calculator2()
	{
		super("Calculator");
		setSize(300,300);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLayout(new BorderLayout());
		Numbers.setLayout(new GridLayout(4,4,6,6));
		Text.setLayout(new BorderLayout());
		
		
		textField = new JTextField(40);
		textField.setFont(f);
		textField.setEditable(false);
		Text.add(textField);
		
		createNumberButtons();
		createOperationButtons();
		
		
		
		add(Text, BorderLayout.NORTH);
		add(Numbers, BorderLayout.CENTER);
		
		setVisible(true);
		
		
		
	}
	
	public void createNumberButtons()
	{
		for (int i = 0; i < 10; i++)
		{
			JButton numberButton = new JButton("" + i);
			numberButton.addActionListener(this);
			numberButton.setFont(f);
			Numbers.add(numberButton);
		}
	}
	
	
	public void createOperationButtons()
	{
		JButton plus = new JButton("+");
		plus.addActionListener(this);
		plus.setFont(f);
		
		JButton minus = new JButton("-");
		minus.addActionListener(this);
		minus.setFont(f);
		
		JButton mult = new JButton("*");
		mult.addActionListener(this);
		mult.setFont(f);
		
		JButton div = new JButton("/");
		div.addActionListener(this);
		div.setFont(f);
		
		JButton compute = new JButton("=");
		compute.addActionListener(this);
		compute.setFont(f);
		
		JButton clear = new JButton("c");
		clear.addActionListener(this);
		clear.setFont(f);
		
		Numbers.add(plus);
		Numbers.add(minus);
		Numbers.add(mult);
		Numbers.add(div);
		Numbers.add(compute);
		Numbers.add(clear);
		
	}
	
	
		
	

	@Override
	public void actionPerformed(ActionEvent e)
	{
		switch(e.getActionCommand())
		{
		case "+":
			
			process('+');
			textFieldCurrentContents = "";
			textField.setText("");
			
			break;
		case "-":
			process('-');
			textFieldCurrentContents = "";
			textField.setText("");
		
			break;
		case "*":
			process('*');
			textFieldCurrentContents = "";
			textField.setText("");
			
			break;
		case "/":
			process('/');
			textFieldCurrentContents = "";
			textField.setText("");
			
			break;
		case "=":
			if(lastAction.getActionCommand() != "=")
			{
				doCalcs.storeNumber(textFieldCurrentContents);
			}
			textFieldCurrentContents = doCalcs.getLeft();
			textField.setText(textFieldCurrentContents);
			copyToClipboard(textFieldCurrentContents);
			break;
		case "c":
			doCalcs.clear();
			textFieldCurrentContents = "";
			textField.setText("");
			break;
		default:
			textFieldCurrentContents += e.getActionCommand();
			if(textFieldCurrentContents.charAt(0) == '0' && textFieldCurrentContents.length() > 1)
				textFieldCurrentContents = textFieldCurrentContents.substring(1);
			
			
			textField.setText(textFieldCurrentContents);
				
			
		}
		lastAction = e;
		
		// TODO Auto-generated method stub
		
	}	
	public void process(char c)
	{
		System.out.println(textFieldCurrentContents.length() + ", " + (doCalcs.getLeft().length() + 1));
		
		//Checks to see if the current contents of the text box have been modified after the left value has been stored.
		//Updates the left value if it's been modified and skips the calculation to wait for the right value
		if (textFieldCurrentContents.indexOf(doCalcs.getLeft(),0) == 0 && textFieldCurrentContents.length() > doCalcs.getLeft().length())
		{
			doCalcs.setLeft(textFieldCurrentContents);
			doCalcs.setOperator(c);
		}
		
		else
		{
			//if the current operator isn't the same as the user is intending, and the = button has not been pressed
			//do the calculation with the current operator, then update the operator and wait for the next value;
			if (doCalcs.getOperator() != c && lastAction.getActionCommand() != "=")
			{
				doCalcs.storeNumber(textFieldCurrentContents);
				doCalcs.setOperator(c);
			}
			
			else if (lastAction.getActionCommand() == "=")
				doCalcs.setOperator(c);
			else if (lastAction.getActionCommand() != "=" || Character.isDigit(lastAction.getActionCommand().charAt(0)))
				doCalcs.storeNumber(textFieldCurrentContents);
			}
		
	}
	
	public void copyToClipboard(String s)
	{
		StringSelection ss = new StringSelection(s);
		Clipboard clp = Toolkit.getDefaultToolkit().getSystemClipboard();
		clp.setContents(ss, null);
		
	}
	
	public static void main(String[] args) 
	{
		Calculator2 c = new Calculator2();
		// TODO Auto-generated method stub

	}

}

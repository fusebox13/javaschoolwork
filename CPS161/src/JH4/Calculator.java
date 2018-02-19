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

public class Calculator extends JFrame implements ActionListener
{
	
	
	private static final long serialVersionUID = 1L;
	
	public JPanel Text = new JPanel();
	public JPanel Numbers = new JPanel();
	JTextField textField;
	String textFieldCurrentContents = "0";
	Font f = new Font("Serif", Font.BOLD, 32);
	ActionEvent lastAction;
	
	Calculator()
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
			if (textFieldCurrentContents != "")
				doCalculations.add1(textFieldCurrentContents);
			textFieldCurrentContents = "";
			textField.setText("");
			break;
		case "-":
			if (textFieldCurrentContents != "")
				doCalculations.subtract1(textFieldCurrentContents);
			textFieldCurrentContents = "";
			textField.setText("");
			break;
		case "*":
			if (textFieldCurrentContents != "")
				doCalculations.multiply1(textFieldCurrentContents);
			textFieldCurrentContents = "";
			textField.setText("");
			break;
		case "/":
			if (textFieldCurrentContents != "")
				doCalculations.divide1(textFieldCurrentContents);
			textFieldCurrentContents = "";
			textField.setText("");
			break;
		case "=":
			if (Character.isDigit(lastAction.getActionCommand().charAt(0)))
			{
				String computedString = doCalculations.compute(textFieldCurrentContents);
				textField.setText(computedString);
				copyToClipboard(computedString);
				textFieldCurrentContents = computedString;
				//doCalculations.clear();
			}
			break;
		case "c":
			doCalculations.clear();
			textFieldCurrentContents = "";
			textField.setText("");
			break;
		default:
			textFieldCurrentContents += e.getActionCommand();
			
			if (textFieldCurrentContents.startsWith("0"))
					textFieldCurrentContents = textFieldCurrentContents.substring(1);
			
			//doCalculations.setRight(textFieldCurrentContents);
			textField.setText(textFieldCurrentContents);					
		}
		
		lastAction = e;
		// TODO Auto-generated method stub
		
	}
	
	public void copyToClipboard(String s)
	{
		StringSelection ss = new StringSelection(s);
		Clipboard clp = Toolkit.getDefaultToolkit().getSystemClipboard();
		clp.setContents(ss, null);
		
	}
	
	public static void main(String[] args) 
	{
		Calculator c = new Calculator();
		// TODO Auto-generated method stub

	}

}

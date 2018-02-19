import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class cashRegister extends JPanel implements ActionListener
{
	protected JButton button1, button2;
	
	public cashRegister() 
	{
		button1 = new JButton ("Button 1");
		button1.setActionCommand("Button 1");
		button1.addActionListener(this);
		
		button2 = new JButton("Button 2");
		button2.setActionCommand("Button 2");
		button2.addActionListener(this);
		
		add(button1);
		add(button2);
		
	}
	
	public void actionPerformed(ActionEvent buttonPressed)
	{
		if("Button 1".equals(buttonPressed.getActionCommand()))
			System.out.printf("Button 1 pressed");
		if("Button 2".equals(buttonPressed.getActionCommand()))
			System.out.printf("Button 2 pressed");
			
	
	}
	
	private static void createUI()
	{
		JLabel testLabel = new JLabel("test", SwingConstants.CENTER);
		JButton button3 = new JButton("Button 3");
		JFrame ButtonFrame = new JFrame("Button Frame");
		ButtonFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		cashRegister newRegister = new cashRegister();
		newRegister.setOpaque(true);
		ButtonFrame.setContentPane(newRegister);
		ButtonFrame.getContentPane().add(button3);
		ButtonFrame.getContentPane().add(testLabel);
		
		ButtonFrame.pack();
		ButtonFrame.setVisible(true);
		
	}
	
	public static void main(String[] args) 
	{
		javax.swing.SwingUtilities.invokeLater(
				new Runnable()
				{
					public void run()
					{
						createUI();
					}
				});
	}
	
	
}
import javax.swing.JOptionPane;  
  
public class popupBox
{  
public static void main(String[]args)  
{  
	String miles=JOptionPane.showInputDialog(null, "How many miles did you travel?");
	String gallons=JOptionPane.showInputDialog(null, "How many gallons of gas did you use?");
	double MPG= Double.parseDouble(miles) / Double.parseDouble(gallons);
 JOptionPane.showMessageDialog(null, "Your Miles/Gallon is " + String.format("%.2f", MPG));
}  
}  
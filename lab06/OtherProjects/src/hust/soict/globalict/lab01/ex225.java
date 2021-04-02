package hust.soict.globalict.lab01;
import javax.swing.JOptionPane;
public class ex225 
{

	public static void main(String[] args) 	
	{
		String str1, str2;
   
		str1 = JOptionPane.showInputDialog(null, "Input the first number: ", "First number", JOptionPane.INFORMATION_MESSAGE);
		double num1 = Double.parseDouble(str1);
   
   		str2 = JOptionPane.showInputDialog(null, "Input the second number: ", "Second number", JOptionPane.INFORMATION_MESSAGE);
		double num2 = Double.parseDouble(str2);

		JOptionPane.showMessageDialog(null, "Sum: " + (num1 + num2));

		JOptionPane.showMessageDialog(null, "Difference: " + (num1 - num2));
   
 		JOptionPane.showMessageDialog(null, "Product: " + (num1 * num2));
   
		if (num2 == 0) {
			JOptionPane.showMessageDialog(null, "The divisor is not valid");
		} else {
			JOptionPane.showMessageDialog(null, "Quotient: " + (num1 / num2));
		}
		
		System.exit(0);
	}

}
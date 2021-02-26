import java.util.Scanner;
public class ex2_2_5 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
   
  		System.out.print("Input first number: ");
  		double num1 = in.nextDouble();
   
  		System.out.print("Input second number: ");
  		double num2 = in.nextDouble();
   
 
  		System.out.println("Sum: " + (num1 + num2));
   
  		System.out.println("Difference: " + (num1 - num2));
   
  		System.out.println("Product:" + (num1 * num2));
   
  		System.out.println("Quotient" + (num1 / num2));
	}

}
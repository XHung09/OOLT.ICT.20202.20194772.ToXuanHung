package hust.soict.globalict.lab01.StarTriangle;
import java.util.Scanner;

public class StarTriangle {
	public static void main(String args[]) 
	{
		Scanner keyboard = new Scanner(System.in);
		
		System.out.print("Input the height of the triangle: ");
		int n = keyboard.nextInt();
		int j = 0;

	    for (int i = 1; i <= n; i++, j = 0) {
	      for (int space = 1; space <= n - i; space++) 
	      {
	        System.out.print(" ");
	      }

	      while (j != 2 * i - 1) 
	      {
	        System.out.print("*");
	        j++;
	      }

	      System.out.println();
	    }
	}
}

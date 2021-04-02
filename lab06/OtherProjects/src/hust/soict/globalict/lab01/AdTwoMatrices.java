package hust.soict.globalict.lab01;
import java.util.Scanner;

public class AdTwoMatrices {
	public static void main(String[] args)
	{
		Scanner keyboard = new Scanner(System.in);
		
		System.out.print("Number of rows: ");
		int  m = keyboard.nextInt();
		System.out.print("Number of columns: ");
		int  n = keyboard.nextInt();
		
		int A[][] = new int [m][n];
		int B[][] = new int [m][n];
		int sum[][] = new int [m][n];
		
        System.out.println("Enter all the elements of the first matrix:");
        for (int i = 0; i < m; i++)
        {
        	for (int j = 0; j < n; j++) 
        	{
        		A[i][j] = keyboard.nextInt();
        	}
        }
        
        System.out.println("Enter all the elements of the second matrix:");
        for (int i = 0; i < m; i++)
        {
        	for (int j = 0; j < n; j++) 
        	{
        		B[i][j] = keyboard.nextInt();
        	}
        }
        
        System.out.println("First Matrix:");
        for (int i = 0; i < m; i++) 
        {
            for (int j = 0; j < n; j++) 
            {
                System.out.print(A[i][j] + " ");
            }
            System.out.println("");
        }
        System.out.println("");
        
        System.out.println("Second Matrix:");
        for (int i = 0; i < m; i++) 
        {
            for (int j = 0; j < n; j++) 
            {
                System.out.print(B[i][j] + " ");
            }
            System.out.println("");
        }
        System.out.println("");
        
        // Adding 2 matrices
        for (int i = 0; i < m; i++) 
        {
            for (int j = 0; j < n; j++) 
            {
                for (int k = 0; k < n; k++) 
                {
                    sum[i][j] = A[i][j] + B[i][j];
                }
            }
        }
        
        System.out.println("Result of the addition:");
        for (int i = 0; i < m; i++) 
        {
            for (int j = 0; j < n; j++) 
            {
                System.out.print(sum[i][j] + " ");
            }
            System.out.println("");
        }
	}
}

import java.util.Arrays;
public class Array 
{
	public static void main(String[] args) 
	{
		int[] A = {1789, 2035, 1899, 1456, 2013};
		double sum = 0;
		
		for (int i: A) 
		{
			sum += i;
		}
		
		double avg = sum / A.length;
		
		Arrays.sort(A);
		
		System.out.printf("Ascendingly sorted array: %s\n", Arrays.toString(A));
		System.out.println("Sum value: " + sum);
		System.out.println("Average value: " + avg);
	}
}

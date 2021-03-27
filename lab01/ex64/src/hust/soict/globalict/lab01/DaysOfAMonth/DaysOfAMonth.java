package hust.soict.globalict.lab01.DaysOfAMonth;
import java.util.Scanner;

public class DaysOfAMonth {
	public static void main(String[] args) 
	{
		Scanner keyboard = new Scanner(System.in);
		
        int days = 0; 

        System.out.print("Input a month: ");
        String month = keyboard.nextLine();

        System.out.print("Input a year: ");
        int year = keyboard.nextInt();

        if (month.equals("1") || month.equals("3") || month.equals("5") || month.equals("7") 
        		|| month.equals("8") || month.equals("10") || month.equals("12") ||
        		month.equals("Jan.") || month.equals("Mar.") || month.equals("May") 
        		|| month.equals("July") || month.equals("Aug.") || month.equals("Oct.") 
        		|| month.equals("Dec.")) {
        	days = 31;
        }
        
        if (month.equals("January") || month.equals("March") || month.equals("May") 
        		|| month.equals("July") || month.equals("August") || month.equals("October") 
        		|| month.equals("December") || month.equals("Jan") || month.equals("Mar") 
        		|| month.equals("May") || month.equals("Jul") || month.equals("Aug") 
        		|| month.equals("Oct") || month.equals("Dec")) {
        	days = 31;
        }
        
        //__________________________________________//
        
        if (month.equals("4") || month.equals("6") || month.equals("9") || month.equals("11")) {
        	days = 30;
        }
        
        if (month.equals("Apr.") || month.equals("June") || month.equals("Sept.") || month.equals("Nov.")) {
        	days = 30;
        }
        
        if (month.equals("Apr") || month.equals("Jun") || month.equals("Sep") || month.equals("Nov")) {
        	days = 30;
        }
        
        if (month.equals("April") || month.equals("June") || month.equals("September") || month.equals("November")) {
        	days = 30;
        }
        
        //___________________________________________//
        
        if (month.equals("2") || month.equals("Feb.") || month.equals("Feb") || month.equals("February")) {
            if ((year % 400 == 0) || ((year % 4 == 0) && (year % 100 != 0))) {
                days = 29;
            } else {
                days = 28;
            }
        }
        
        //___________________________________________//
        System.out.println(month + " of " + year + " has " + days + " days.");
        	
	}
}

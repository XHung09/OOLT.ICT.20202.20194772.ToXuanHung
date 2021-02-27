import java.util.Scanner;
public class DaysOfAMonth 
{
	public static void main(String[] args) 
	{
		Scanner keyboard = new Scanner(System.in);
		
        int days = 0; 

        System.out.print("Input a month: ");
        String month = keyboard.nextLine();

        System.out.print("Input a year: ");
        int year = keyboard.nextInt();

        if (month == "1" || month == "3" || month == "5" || month == "7" 
        		|| month == "8" || month == "10" || month == "12") {
        	days = 31;
        }
        
        if (month == "Jan." || month == "Mar." || month == "May" || month == "July" 
        		|| month == "Aug." || month == "Oct." || month == "Dec.") {
        	days = 31;
        }
        
        if (month == "January" || month == "March" || month == "May" || month == "July" 
        		|| month == "August" || month == "October" || month == "December") {
        	days = 31;
        }
        
        if (month == "Jan" || month == "Mar" || month == "May" || month == "Jul" 
        		|| month == "Aug" || month == "Oct" || month == "Dec") {
        	days = 31;
        }
        
        //__________________________________________//
        
        if (month == "4" || month == "6" || month == "9" || month == "11") {
        	days = 30;
        }
        
        if (month == "Apr." || month == "June" || month == "Sept." || month == "Nov.") {
        	days = 30;
        }
        
        if (month == "Apr" || month == "Jun" || month == "Sep" || month == "Nov") {
        	days = 30;
        }
        
        if (month == "April" || month == "June" || month == "September" || month == "November") {
        	days = 30;
        }
        
        //___________________________________________//
        
        if (month == "2" || month == "Feb." || month == "Feb" || month == "February") {
            if ((year % 400 == 0) || ((year % 4 == 0) && (year % 100 != 0))) {
                n = 29;
            } else {
                n = 28;
            }
        }
        
        //___________________________________________//
        System.out.println(month + " of " + year + " has " + days + " days.");
        	
	}
}

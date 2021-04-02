package hust.soict.globalict.lab01;
import javax.swing.JOptionPane;
public class ex226
{
   	public static void main(String[] args)
	{
        	String choice ;
        	String Noti = "" , AlsoNoti = "" , NotiAgain = "";
        	Noti += "Choose one option: \n" ;
        	Noti += "1: Solving a first-degree equation with one variable a*x + b=0\n";
        	Noti += "2: Solving a  system of first-degree equations with two variables:\n";
        	Noti += "a11*x1 + a12*x2 = b1 \na21*x1 + a22*x2 = b2\n" ;
        	Noti += "3: Solving a second-degree equation with one variable a*x^2 + b*x + c = 0";

		choice = javax.swing.JOptionPane.showInputDialog(null, Noti + "\nYour choice?" , JOptionPane.INFORMATION_MESSAGE);
		switch(choice) 
		{
			case "1":
				double res;
	       			String strNum1 = JOptionPane.showInputDialog(null, "Input constant a = ", JOptionPane.INFORMATION_MESSAGE);
				double a = Double.parseDouble(strNum1) ;

				String strNum2 = JOptionPane.showInputDialog(null, "Input constant b = ", JOptionPane.INFORMATION_MESSAGE);
				double b = Double.parseDouble(strNum2) ;
	            		if(a == 0) 
				{
	            			JOptionPane.showMessageDialog(null, "Because a == 0 so there are no solutions!\n");
	            		} else {
					res = -b / a ;
				JOptionPane.showMessageDialog(null, strNum1 + "*x + " + strNum2 + " = 0\nSolution: x = " + res);
	            		}
       		   
				break ;
       		   
			case "2":
				double d0 , d1 , d2 ;
				String strNum11 = JOptionPane.showInputDialog(null, "Input constant a11", JOptionPane.INFORMATION_MESSAGE);
	            		double a11 = Double.parseDouble(strNum11);
	            
				String strNum12 = JOptionPane.showInputDialog(null, "Input constant a12", JOptionPane.INFORMATION_MESSAGE);
				double a12 = Double.parseDouble(strNum12);
	            
	            		String strNum21 = JOptionPane.showInputDialog(null, "Input constant a21", JOptionPane.INFORMATION_MESSAGE);
	            		double a21 = Double.parseDouble(strNum21);
	            
	            		String strNum22 = JOptionPane.showInputDialog(null, "Input constant a22", JOptionPane.INFORMATION_MESSAGE);
	            		double a22 = Double.parseDouble(strNum22);
	            
	            		String strNum_b1 = JOptionPane.showInputDialog(null, "Input constant b1", JOptionPane.INFORMATION_MESSAGE);
	            		double b1 = Double.parseDouble(strNum_b1);
	            
	            		String strNum_b2 = JOptionPane.showInputDialog(null, "Input constant b2", JOptionPane.INFORMATION_MESSAGE);
	            		double b2 = Double.parseDouble(strNum_b2);
	            
	            		AlsoNoti += "System of Equations:\n" + a11 + "*x1 + " + a12 + "*x2 = " + b1 + "\n" + a21 + "*x1 + " + a22 + "*x2 = " + b2 +"\n" ;
	            
				d0 = a11*a22 - a12*a21;
				d1 = b1*a22 - b2*a12;
				d2 = a11*b2 - a21*b1;
				if(d0 == 0) 
				{
	            			if(d1 == 0 && d2 == 0) 
					{
	            				JOptionPane.showMessageDialog(null, AlsoNoti + "has infinitely many solutions");
					} else {
	            				JOptionPane.showMessageDialog(null, AlsoNoti + "has no solution");
	            			}
				} else {
					double resx, resy;
	            			resx = d1/d0; 
					resy = d2/d0;
	            			JOptionPane.showMessageDialog(null, AlsoNoti 
	            							+ "has a unique solution is (x1,x2) = "
									+ "(" + resx + " , " + resy + ")");
	           		}
    			   	break;
    	   
			case "3":
				double delta, kq1, kq2 ;
    			   	String strNum_a = JOptionPane.showInputDialog(null, "Input constant a", JOptionPane.INFORMATION_MESSAGE);
	      		     	double ta = Double.parseDouble(strNum_a);
	            
	        	   	String strNum_b = JOptionPane.showInputDialog(null, "Input constant b", JOptionPane.INFORMATION_MESSAGE);
	       		    	double tb = Double.parseDouble(strNum_b);
	            
	         	  	String strNum_c = JOptionPane.showInputDialog(null, "Input constant c", JOptionPane.INFORMATION_MESSAGE);
	          	 	double tc = Double.parseDouble(strNum_c);
	           		NotiAgain += "Second-degree Equation:\n" + ta + "*x^2 + " + tb + "*x + " + tc + " = 0\n";
	           		delta = tb*tb - 4*ta*tc;
	           		
				if(delta == 0) 
				{
	        			kq1 = -tb/(2*ta);
	        		   	JOptionPane.showMessageDialog(null, NotiAgain 
	            							+ "has double root x = " + kq1 );
	          		} else if(delta > 0) {
	        			kq1 = -tb + Math.sqrt(delta); 
					kq1 /= (2*ta);
	        		   	kq2 = -tb - Math.sqrt(delta); 
					kq2 /= (2*ta);
	        		   	JOptionPane.showMessageDialog(null, NotiAgain 
	            							+ "has 2 roots are: x1 = " 
									+ kq1 + " & " + " x2 = " + kq2 );
	          		} else {
	        		  	JOptionPane.showMessageDialog(null, NotiAgain 
	            							+ "has no solution");
	          		}
    		   		break ;
    	   	
			default:
    			   	JOptionPane.showMessageDialog(null, "Choice not valid");
    			   	break;
		}
        		
		System.exit(0);
	}
}
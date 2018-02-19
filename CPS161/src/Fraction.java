
import java.util.Scanner;

public class Fraction
{
	
	/**********************
	 * Instance Variables *
	 **********************/
    private Scanner scan = new Scanner(System.in);     
    private int num=1;
    private int denom=1;
    
    
    
    /****************
     * Constructors *
     ****************/
    public Fraction()
    { 
    }
    
    public Fraction(int n, int d)
    {
    	num = n;
    	denom = d;
    }
    
    
    
    /****************
     * Set Function *
     ****************/
    public void setFraction(int n, int d)
    {
       num = n;
       denom = d;
    }
    
    
    
    /**********************
     * Adds two Fractions *
     **********************/
    public Fraction add(Fraction op)
    {
    	Fraction Temp = new Fraction(); // A Temp Fraction is used to avoid accidentally changing the the values of this fraction or the op fraction
    	
    	if (this.isZero()) // in other words 0 + a/b
    	{	
    		Temp.num = op.num;
    		Temp.denom = op.denom;
    		Temp.reduce();
    		return Temp;
    	}
    	else if(op.isZero()) // a/b + 0
    	{
    		Temp.num = num;
    		Temp.denom = denom;
    		Temp.reduce();
    		return Temp;
    	}
    	else // Runs the calculation if both fractions are non-zero
    	{
    		Temp.num = (this.num * op.denom + this.denom * op.num);
    		Temp.denom = (this.denom * op.denom);
    		Temp.reduce();
    		return Temp;
    	}
    }  
    
    
    
    /***************************
     * Subtracts two Fractions *
     ***************************/
    public Fraction subtract(Fraction op)
    {
    	Fraction Temp = new Fraction();
    	
    	if (this.isZero()) // 0 - a/b
    	{	
    		Temp.num = op.num * -1; //Flips the sign on the fraction because 0 - a/b = -a/b
    		Temp.denom = op.denom;
    		Temp.reduce();
    		return Temp;
    	}
    	else if(op.isZero())// a/b - 0
    	{
    		Temp.num = num;
    		Temp.denom = denom;
    		Temp.reduce();
    		return Temp;
    	}
    	else // Non-zero fractions
    	{
    		Temp.num = (this.num * op.denom - this.denom * op.num);
    		Temp.denom = (this.denom * op.denom);
    		Temp.reduce();
    		return Temp;
    	}
     } 
    
    
    
    /****************************
     * Multiplies two Fractions *
     ****************************/
    public Fraction multiply(Fraction op)
    {
    	Fraction Temp = new Fraction();
    	
    	Temp.num = (this.num * op.num);
    	Temp.denom = (this.denom * op.denom);
    	
    
    	Temp.reduce();
    	return Temp;
     }  
    
    
    
    /*************************
     * Divides two Fractions *
     *************************/
    public Fraction divide(Fraction op)
    {
    	Fraction Temp = new Fraction();
    	
    	Temp.num = (this.num * op.denom);
    	Temp.denom = (this.denom * op.num);
    	
    	Temp.reduce();
    	
    	return Temp;
     }  
     
     
    
     /*********************
      * Reduces Fractions *	
      *********************/
     private void reduce()
     {
    	 if (this.isZero()) // Avoids dividing by zero
    		 return;
    	 
    	 else if (num != 1 && denom != 1) // If a 1 is in the numerator or denominator, it cannot be reduced further.
    	 {
    		 int divisor = Math.max(Math.abs(num), Math.abs(denom));
    		 while (this.num % divisor != 0 || this.denom % divisor != 0) // Stops when num and denom can be evenly divided by n 
    			 divisor--; 
    		 
    		 num = num/divisor;
    		 denom = denom/divisor;
    	 }
     }
     
     /****************************************
      * Returns true if this.Fraction is zero *
      ****************************************/
     private boolean isZero()
     {
    	 return (num == 0 || denom == 0);
     }
    
     
     
     /***************************************************
      * Returns true if Fraction f equals this.Fraction *
      ***************************************************/
     public boolean equals(Fraction f)
     {
        return (this.num == f.num && this.denom == f.denom);
     }
     
     
     
     /*******************************************
      * Returns true if the Fraction is 1 or -1 *
      *******************************************/
     public boolean isOne()
     {
    	 return(Math.abs(num) == Math.abs(denom));
     }
     
     
     
     /********************************************
      * Returns true if the Fraction is negative *
      ********************************************/
     public boolean isNegative()
     {
    	 return (num < 0 || denom < 0);
     }
     
     
     
     /********************************************
      * Returns true if the Fraction is positive *
      ********************************************/
     public boolean isPositive()
     {
    	 return ((num > 0 && denom > 0) || (num < 0 && denom < 0));
     }
     
     
     
     /**************************************************************
      * Returns true if the Fraction is a whole number eg. 3/1 = 3 *
      **************************************************************/
     public boolean isWhole()
     {
    	 return(Math.abs(num) > 0 && denom == 1);
     }
     
     
     
     /*************************************************
      * Returns the value of the fraction as a String *
      *************************************************/
     public String toString()
     {
    	
    	if (this.isZero())
    		return "0";
    	else if (this.isWhole() && this.isNegative())
    		return "-" + Math.abs(num);
    	else if (this.isWhole())
    		return "" + num;
    	else if (this.isPositive())
    		return Math.abs(num) + "/" + Math.abs(denom);
    	else
    		return "-" + Math.abs(num) + "/" + Math.abs(denom);
    	
     }
     
     
     
     /************************************
      * Reads in Fractions from the user *
      ************************************/
     public void readin(String label)
     {
        while (true) // Keep trying if bad input is received
        {
            System.out.println(label);
            String temp = scan.next();
            temp = temp.trim(); // get rid of white space at the beginning and end
            int index = temp.indexOf('/');
            if (index >= 0)
            {
                String numStr = temp.substring(0, index);
                String denomStr = temp.substring(index+1);
                int n = Integer.parseInt(numStr);
                int d = Integer.parseInt(denomStr);
                if ( d != 0)  // Does not allow the user to enter a zero into the denominator
                {
                	setFraction(n,d);
                	return;
                }
                else if(n == 0 && d == 0)
                {
                	setFraction(n,d);
                	return;
                }
                
                else
                {
                	System.out.println("Error: Divide by 0\n");
                }
            }
            else
            	System.out.println("Input Fraction missing / ");
          
        }//Keep trying until you get it right
     }
     
     public static void main(String[] args)
     {
        Fraction f1= new Fraction();
        Fraction f2= new Fraction();
        Fraction f3=null;
        Scanner scan = new Scanner(System.in);
        
        while(true)
        {
            System.out.println("Enter operation: + - * / q (q ==> quit) : ");
            String input = scan.next();
            if (input.charAt(0) == 'q') return; // All done
            
            f1.readin("Enter Fraction 1: ");
            f2.readin("Enter Fraction 2: ");
            System.out.println("f1 = " + f1);
            System.out.println("f2 = " + f2);
            
            if (f1.equals(f2))
                System.out.println("f1 and f2 are equal");
            else
                System.out.println("f1 and f2 are not equal");
            
            switch (input.charAt(0))
            {                
            case '+':
                f3 = f1.add(f2);
                System.out.println( f1 + " + " + f2 + " = " + f3);
            break;

            case '-':
                f3 = f1.subtract(f2);
                System.out.println( f1 + " - " + f2 + " = " + f3);
                break;

            case '*':
                f3 = f1.multiply(f2);
                System.out.println( f1 + " x " + f2 + " = " + f3);
                break;

            case '/':
                f3 = f1.divide(f2);
                System.out.println( f1 + " / " + f2 + " = " + f3);
                break;

            default:
                System.out.println("Illegal command: "  + input );
                break;

            }
        }// end of while loop
         
     }  // end of main 
 }
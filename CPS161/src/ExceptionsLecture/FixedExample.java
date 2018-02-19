package ExceptionsLecture;

class FixedExample {
	  static int compute(int a, int b) {
	      int c;
	     try
	     {
	       // An exception occurs if b == 0
	       c= a/b;
	     }
	     catch ( ArithmeticException e)
	     {
	        System.out.println(" Probably a divide by 0 case");
	        c=0;
	     }
	     return c; 
	  }
	  public static void main(String[] args) {
	    int [] arr = new int[10];
	   
	   try
	      {
	      // An exception will occur if we don't pass parameters
	      // to this program, or the data passed is not something other
	      // than a number.
	      
	       int index = Integer.parseInt(args[0]);

	       int i = Integer.parseInt(args[1]);
	       int c = compute(10, i);
	   
	       // if index >= 10 we get an exception
	       arr[index] = c;
	       }
	   catch (NumberFormatException e)
	       {
	           System.out.println(" A non-numeric input parameter");
	           e.printStackTrace();    
	       }
	   catch (ArrayIndexOutOfBoundsException e)
	       {
	           System.out.println(" Array Index must be < 10");
	           e.printStackTrace(); 
	       }
	   
	   System.out.println(" Finished Fixed Example  *****");
	  }
	}

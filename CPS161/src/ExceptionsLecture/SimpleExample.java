package ExceptionsLecture;

class SimpleExample {
	  static int compute(int a, int b) {
	      int c;
	      try
	      { 
	        // Of b == 0, we will get an ArithmeticException
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
	    
	    // Exceptions occur if we don't have enough parameters
	    // We also get an Exception from parseInt if it a NON number
	    int index = Integer.parseInt(args[0]);
	    int i = Integer.parseInt(args[1]);
	    
	    int c = compute(10, i);
	    
	    // We can get an exception if index >= 10
	    arr[index] = c;
	    
	    System.out.println(" Finished Simple Example");
	  }
	} 
	  
	
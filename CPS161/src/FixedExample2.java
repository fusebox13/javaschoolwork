class FixedExample2 {
 static void assign(int [] arr, int index, int a, int b)
  // The following line is optional because we are dealing
  // with RuntimeExceptions
 throws ArithmeticException, ArrayIndexOutOfBoundsException
  {
     // "ducking all Exceptions and passing it off to the caller     
     arr[index] = a/b;      
  }
  public static void main(String[] args) {
    int [] arr = new int[10];
    int index;
    
    try
       {
        index = Integer.parseInt(args[0]);
        int i = Integer.parseInt(args[1]);
        assign(arr, index, 10, i);
        }
    // The following will catch all Exceptions derived from RuntimeException that 
    // haven't already been matched (i.e. NumberFormatException) 
    catch (RuntimeException e)
        {
            System.out.println(" Some Runtime Exception: " +e);
            e.printStackTrace();
        }
    
    System.out.println(" Finished Simple Example");
  }
} 
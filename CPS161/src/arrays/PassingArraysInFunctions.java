package arrays;

public class PassingArraysInFunctions {

	void funcInt(int x)
	  {
	      x = 100;
	  }
	  void funcArr(int[] arr)
	  {
	      for (int i=0; i < arr.length; i++)
		      arr[i] = 100+i;
	  }
	  
	  int[] sequentialNumbers(int count)
	  {
		  int[] x = new int[count + 1];
		  for(int i = 0; i < x.length; i++)
			  x[i] = i;
		  return x;
	  }
	  
	 
	public static void main(String[] args) {
		 int[] xarr={1,2,3,4,5};
		 
		 PassingArraysInFunctions pa = new PassingArraysInFunctions();
		 
		 int[] xreturned = pa.sequentialNumbers(13);
		 for(int i = 0; i < xreturned.length; i++)
			 System.out.println(xreturned[i] + " ");
		 
		  // Try to modify by passing an array element:
		  pa.funcInt(xarr[0]); //will not change the value of this element
		  System.out.println("Value of a[0]="+ xarr[0]);
		  
		  pa.funcArr(xarr); // arrays act like mutable classes, so this function can change all of the values
		  for (int i=0; i < xarr.length; i++)
		       System.out.println("xarr["+i+"]="+ xarr[i]);

	}

}

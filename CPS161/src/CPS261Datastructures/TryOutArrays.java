package CPS261Datastructures;

import java.util.Arrays;


public class TryOutArrays {
	
	static void tryDogs()
	{
		Dog[] arr = {new Dog("zeta", 3), new Dog("gamma", 2),
				new Dog("pi", 1), new Dog("epsilon", 3), new Dog("alpha", 6), new Dog("beta",3)};
        Dog[] otherArr = new Dog[4];
       
        //print
        String temp= Arrays.toString(arr);
        System.out.println("original=" +temp);
        
        //sort
        Arrays.sort(arr);
        temp = Arrays.toString(arr);
        System.out.println("sorted=" + temp);
        
        //binary search
        int index = Arrays.binarySearch(arr,  new Dog("gamma",2));
        System.out.println("index of gamma = " + index);
        index = Arrays.binarySearch(arr,  new Dog("rho", 7));
        System.out.println("index of rho = " + index);
        
        //fill
        Arrays.fill(otherArr, new Dog("blank",0));
        temp = Arrays.toString(otherArr);
        System.out.println("filled otherArr= " +temp);
        
        //copy
        otherArr = Arrays.copyOf(arr, 10);
        temp = Arrays.toString(otherArr);
        System.out.println("copied otherArr expanded= " +temp);
		
        //copy + truncate
        otherArr = Arrays.copyOf(arr, 5);
        temp = Arrays.toString(otherArr);
        System.out.println("copied otherArr truncated= " +temp);
        
        //copy subrange
        otherArr = Arrays.copyOfRange(arr, 2 , 9);
        temp = Arrays.toString(otherArr);
        System.out.println("copyOfRange otherArr subrange= " +temp);
        
        if (!Arrays.equals(arr, otherArr))
            System.out.println("arr is NOT the same as otherArr");
        
        otherArr = Arrays.copyOf(arr, 6);
        if (Arrays.equals(arr, otherArr))
            System.out.println("arr is the same as otherArr");
		
	}
	static void tryInts()
	{
		int[] arr = {6, 5, 3, 1, 2, 4};
        int[] otherArr = new int[4];
       
        //print
        String temp= Arrays.toString(arr);
        System.out.println("original=" +temp);
        
        //sort
        Arrays.sort(arr);
        temp = Arrays.toString(arr);
        System.out.println("sorted=" + temp);
        
        //binary search
        int index = Arrays.binarySearch(arr,  1);
        System.out.println("index of 0 = " + index);
        index = Arrays.binarySearch(arr,  7);
        System.out.println("index of 7 = " + index);
        
        //fill
        Arrays.fill(otherArr, 9);
        temp = Arrays.toString(otherArr);
        System.out.println("filled otherArr= " +temp);
        
        //copy
        otherArr = Arrays.copyOf(arr, 10);
        temp = Arrays.toString(otherArr);
        System.out.println("copied otherArr expanded= " +temp);
		
        //copy + truncate
        otherArr = Arrays.copyOf(arr, 5);
        temp = Arrays.toString(otherArr);
        System.out.println("copied otherArr truncated= " +temp);
        
        //copy subrange
        otherArr = Arrays.copyOfRange(arr, 2 , 10);
        temp = Arrays.toString(otherArr);
        System.out.println("copyOfRange otherArr subrange= " +temp);
        
        if (!Arrays.equals(arr, otherArr))
            System.out.println("arr is NOT the same as otherArr");
        
        otherArr = Arrays.copyOf(arr, 6);
        if (Arrays.equals(arr, otherArr))
            System.out.println("arr is the same as otherArr");
	}
	static void tryStrings()
	{
		String[] arr = {"zeta", "gamma", "pi", "epsilon", "alpha", "beta"};
        String [] otherArr = new String[4];
       
        //print
        String temp= Arrays.toString(arr);
        System.out.println("original=" +temp);
        
        //sort
        Arrays.sort(arr);
        temp = Arrays.toString(arr);
        System.out.println("sorted=" + temp);
        
        //binary search
        int index = Arrays.binarySearch(arr,  "gamma");
        System.out.println("index of gamma = " + index);
        index = Arrays.binarySearch(arr,  "rho");
        System.out.println("index of rho = " + index);
        
        //fill
        Arrays.fill(otherArr, "blank");
        temp = Arrays.toString(otherArr);
        System.out.println("filled otherArr= " +temp);
        
        //copy
        otherArr = Arrays.copyOf(arr, 10);
        temp = Arrays.toString(otherArr);
        System.out.println("copied otherArr expanded= " +temp);
		
        //copy + truncate
        otherArr = Arrays.copyOf(arr, 5);
        temp = Arrays.toString(otherArr);
        System.out.println("copied otherArr truncated= " +temp);
        
        //copy subrange
        otherArr = Arrays.copyOfRange(arr, 2 , 10);
        temp = Arrays.toString(otherArr);
        System.out.println("copyOfRange otherArr subrange= " +temp);
        
        if (!Arrays.equals(arr, otherArr))
            System.out.println("arr is NOT the same as otherArr");
        
        otherArr = Arrays.copyOf(arr, 6);
        if (Arrays.equals(arr, otherArr))
            System.out.println("arr is the same as otherArr");
        
	}
	
	public static void main(String[] args){
		
		//tryStrings();
		tryInts();
		//tryDogs();
	}

}

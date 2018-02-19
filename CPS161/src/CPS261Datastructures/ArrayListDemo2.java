package CPS261Datastructures;

import java.util.ArrayList;

public class ArrayListDemo2 {
	
	
	public static void main(String[] args){
	MyArrayList arr = new MyArrayList(20);
	
	arr.add("One");
	arr.add("Three");
	
	arr.add(1, "Two");
	System.out.println("After 3 adds: " + arr);
	
	arr.add("abc");
	System.out.println("After adding abc: " + arr);
	
	arr.set(3, "Four");
	System.out.println("After set(3, four): " + arr);
	
	try{
        arr.set(4, "five");
    }
    catch (IndexOutOfBoundsException e){
        System.out.println("Can't do a set on an index that doesn't exist yet: "+e);
    }
	
	arr.add(4, "five");
    System.out.println("after 5 adds: " + arr);
	
	
    try{
        arr.add(6, "seven");
    }
    catch (IndexOutOfBoundsException e){
    	System.out.println("Can't do an add in such a way as to leave a gap: "+e);
    }
    System.out.println("after all successful adds: " + arr);
    
    // Note that using indexOf requires implementing "equals".  
    // If we were adding our dog class, we would need an equals method otherwise it 
    // won't find what we are looking for.
    int index = arr.indexOf("Three");
    System.out.println("The index of three is :" + index);
    
    index = arr.indexOf("seven");
    System.out.println("The index of seven is :" + index);
    
 // The following will require the implementation of "equals"
    arr.remove("Two");
    System.out.println("after removing two: " + arr);
    
    arr.remove(0);
    System.out.println("after removing index 0: " + arr);
    
    System.out.println("Final size="+ arr.size());
    
	}

}

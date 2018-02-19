package CPS261Generics;

public class ArrayListDemo2 {

    
    public static void main(String[] args) {
        MyArrayList<String> arr = new MyArrayList<String>(20);
        
        arr.add("one");
        arr.add("three");
        
        arr.add(1, "two");
        System.out.println("after 3 adds: " + arr);
        
        arr.add("abc");
        System.out.println("after adding abc: " + arr);
        arr.set(3, "four");
        System.out.println("after set(3,four): " + arr);
        
        try
        {
            arr.set(4, "five");
        }
        catch (IndexOutOfBoundsException e)
        {
            System.out.println("Can't do a set on an index that doesn't exist yet: "+e);
        }
        
        arr.add(4, "five");
        System.out.println("after 5 adds: " + arr);
        
        try
        {
            arr.add(6, "seven");
        }
        catch (IndexOutOfBoundsException e)
        {
            System.out.println("Can't do an add in such a way as to leave a gap: "+e);
        }
        System.out.println("after all successful adds: " + arr);
        
        // Note that using indexOf requires implementing "equals".  
        // If we were adding our dog class, we would need an equals method otherwise it 
        // won't find what we are looking for.
        int index = arr.indexOf("three");
        System.out.println("The index of three is :" + index);
        
        index = arr.indexOf("seven");
        System.out.println("The index of seven is :" + index);
        
        // The following will require the implementation of "equals"
        arr.remove("two");
        System.out.println("after removing two: " + arr);
        
        arr.remove(0);
        System.out.println("after removing index 0: " + arr);
        
        System.out.println("Final size="+ arr.size());

    }

}
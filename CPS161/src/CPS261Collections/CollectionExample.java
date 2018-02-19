package CPS261Collections;


import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;


public class CollectionExample {

    
    public static void main(String[] args) {
        
        Collection<String> collection = new ArrayList<String>();
        //Collection<String> collection = new HashSet<String>();
        
        collection.add("one");
        collection.add("two");
        collection.add("three");
        collection.add("four");
        
        // Elements in the collection must implement equals method
        if (collection.contains("one"))
        {
            System.out.println("My Collection contains one");
        }
        
        Iterator<String> iter = collection.iterator();
        while (iter.hasNext())
        {
            String s = iter.next();
            System.out.println(s);
        }
        
        collection.remove("three"); // This also requires an implementation of equals
        System.out.println("************************************");
        
        Object[] obArr = collection.toArray();
        String[] arr = collection.toArray( new String[1]);
        
        for (int i=0; i < arr.length; i++)
        {
            System.out.println(arr[i]);
        }
        
        if (!collection.isEmpty())
        {
            System.out.println("Collection is NOT empty");
            collection.clear();
            if (collection.isEmpty())
                System.out.println("Collection is now empty");
        }

    }

}
package CPS261Collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ListExample {

    
    public static void main(String[] args) {
        List<String> list = new ArrayList<String>();
        // List<String> list = new LinkedList<String>();
        // List<String> list = new Vector<String>();
        
        list.add("orange");
        list.add("bannana");
        list.add("apple");
        list.add("pear");
        list.add("grape");
        list.add("peach");
        list.add("avacado");
        
        System.out.println("Original list="+list.toString());
        Collections.shuffle(list);
        System.out.println("Shuffled list="+list.toString());
        Collections.sort(list);
        System.out.println("Sorted list="+list.toString());
        
        int index = Collections.binarySearch(list, "grape");
        System.out.println("index of grape = " + index);
        
        index = Collections.binarySearch(list, "strawberry");
        System.out.println("index of strawberry = " + index);
        
        String max = Collections.max(list);
        System.out.println("max="+ max);
        
        List<String> sublist = list.subList(2, 5);
        System.out.println("sublist[2,5)=" + sublist.toString());
    }

}

package CPS261Datastructures;

import java.util.ArrayList;

public class ArrayListDemo {
	
	public static void main(String[] args){
		ArrayList arr = new ArrayList();
		
		arr.add("Red");
        arr.add(new Integer(5));
        arr.add(5);
        arr.add(new Dog("Fido", 4));

        
        for (int i=0; i < arr.size(); i++){
            Object ob = arr.get(i);
            if (ob instanceof Dog){
                Dog dog = (Dog)ob;
                dog.bark();
            } 
            else if (ob instanceof String){
                System.out.println("String: " + ob);
            }
            else if (ob instanceof Integer){
                Integer intClass =(Integer) ob;
                int x = intClass;
                System.out.println("Integer object: "+ x);
            }
        }

	}
}

package CPS261Collections;

import java.util.*;
public class Pet implements Comparable
{
    private String name;
    private double weight;
    Pet(String name, double weight)
    {
        this.name = name;
        this.weight = weight;
    }
    
    public int compareTo(Object obj)
    {
    		Pet p = (Pet)obj;
    		int retVal = name.compareTo(p.name);
    		if (retVal != 0) return retVal;
    		if (weight > p.weight) return 1;
    		return -1;    	
    }
    public String getName()
    {
        return name;
    }
    public double getWeight()
    {
        return weight;
    }
    public String toString()
    {
        return name + " " + weight;
    }
    public void increment_weight(double delta)
    {
        weight += delta;
    }
    public boolean equals(Object obj)
      {
          if (obj==null || obj.getClass() != this.getClass()) return false;
          Pet pet = (Pet)obj;
          return (weight==pet.weight) && name.equals(pet.name);
      }
    
}

class Cat extends Pet{
  Cat(String name, double weight)
  {
    super(name,weight);
  }
  public String toString(){
      return "Cat: "+super.toString();
  }
  public boolean equals(Object obj)
  {
      if (obj==null || obj.getClass() != this.getClass()) return false;
      return super.equals(obj);
  }
}

class Dog extends Pet{
   
    Dog(String name, double weight) {
      super(name,weight);
    }
    public String toString() {
        return "Dog: " + super.toString();
    }
    
      
    public boolean equals(Object obj) 
    {	
    	if (obj==null || obj.getClass() != this.getClass()) return false;
    	return super.equals(obj);
    }
        
}
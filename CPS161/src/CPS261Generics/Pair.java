package CPS261Generics;


public class Pair<T>
{
    private T first;
    private T second;

    public Pair()
    {
        first = null;
        second = null;
    }

    public Pair(T firstItem, T secondItem)
    {
        first = firstItem;
        second = secondItem;
    }

    public void setFirst(T newFirst)
    {
        first = newFirst;
    }

    public void setSecond(T newSecond)
    {
        second = newSecond;
    }

    public T getFirst()
    {
        return first;
    }

    public T getSecond()
    {
        return second;
    }

    public String toString()
    {
        return ( "[first:" + first.toString() + " second:" + second.toString() +"]");
    }

    public boolean equals(Object otherObject)
    {
        if (otherObject == null)
            return false;
        else if (getClass( ) != otherObject.getClass( ))
            return false;
        else
        {
            Pair<T> otherPair = (Pair<T>)otherObject;
            return (first.equals(otherPair.first)
               && second.equals(otherPair.second));
        }
    }
    
    public static void main(String[] args)
    {
        Pair<String> name = new Pair<String>("Kim", "Tom");
        Pair<String> name2 = new Pair<String>("Tom", "Kim");
        
        
        System.out.println("first=" + name.getFirst());
        System.out.println("second=" + name.getSecond());
        if (name.equals(name2))
            System.out.println(name.toString() + " is the same as " + name2.toString());
        else
            System.out.println(name.toString() + " is NOT the same as " + name2.toString());


        
        Pair<Integer> numbers = new Pair<Integer>(1,2); // Automatic Boxing
        Pair<Integer> numbers2 = new Pair<Integer>(2,1); // Automatic Boxing
        
        System.out.println("first=" + numbers.getFirst());
        System.out.println("second=" + numbers.getSecond());
        if (numbers.equals(numbers2))
            System.out.println(numbers.toString() + " is the same as " + numbers2.toString());
        else
            System.out.println(numbers.toString() + " is NOT the same as " + numbers2.toString());
        
        
        
    }
}
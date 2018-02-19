package CPS261MyHashSet;

import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

public class MyHashSet<T> implements Set<T>{

    int table_size = 879;
    float loadFactor;
    int totalSize = 0;
    Object[] hashTable; 
    
    MyHashSet()
    {
        this(16,  0.75f);
    }
    MyHashSet(int initialCapacity)
    {
        this(initialCapacity,  0.75f);
    }
    MyHashSet(int initialCapacity, float loadFactor)
    {
        table_size = initialCapacity;
        this.loadFactor = loadFactor;
        clear();
    }
    //  **************************  Inner class **************
    
    class Node
    {
        T value;
        Node next;
        Node(T v)
        {
            value = v;
            next = null;
        }
    }
    //  ************************** Another  Inner class **************
    class MyIterator implements Iterator<T>
    {
        int nextIndex = 0;
        Node nextNode = null;
        @Override
        public boolean hasNext() {
            if (nextNode != null)
                return true;
            while (nextIndex < table_size)
            {
                nextNode = (Node)hashTable[nextIndex++];
                if (nextNode != null)
                    return true;
            }
            
            return false;
        }

        @Override
        public T next() {
            Node temp = nextNode;
            nextNode = temp.next;
            return temp.value;
        }

        @Override
        public void remove() {
            // TODO Auto-generated method stub
            
        }
        
    }
    // *******************************************************
    private int getHashBucketIndex(Object e)
    {
        return Math.abs(e.hashCode()) % table_size;
    }
    private boolean isPresent(int index, Object e)
    {
        Node n = (Node)hashTable[index];
        while (n != null)
        {
            if (e.equals(n.value))
                return true;
            n = n.next;
        }
        return false;
    }

    @Override
    public boolean add(T e) {
        int index = getHashBucketIndex( e);
        if (isPresent(index, e))
            return false;
        
        Node toAdd = new Node(e);
        toAdd.next = (Node)hashTable[index];
        hashTable[index] = toAdd;
        totalSize +=1;
        if (totalSize > (int)(table_size * loadFactor))
            rehash();
        return true;
    }
    
    @Override
    public boolean contains(Object e) {
        int index = getHashBucketIndex( e);
        if (isPresent(index, e))
            return true;
        else
            return false;
    }
    

    @Override
    public boolean remove(Object e) {
        if (e == null)
            return false;
        int index = getHashBucketIndex( e);
        Node n = (Node)hashTable[index];
        if (n != null &&  e.equals(n.value))
        {
            // First entry in the list is being removed here.
            hashTable[index] = n.next;
            totalSize -= 1;
            return true;
        }
        Node previous = n;
        while (previous != null)
        {
            Node nextNode = previous.next;
            if (nextNode == null)
                return false;
            if (e.equals(nextNode.value))
            {
                // This removes nextNode from linked list
                previous.next = nextNode.next;
                totalSize -= 1;
                return true;
            }
            
            previous = nextNode.next;
        }
        return false;
    }
    @Override
    public Iterator<T> iterator() {
        return new MyIterator();
    }
    
    @Override
    public void clear() {
        totalSize = 0;
        hashTable = new Object[table_size];
        for (int i=0; i < table_size; i++)
            hashTable[i] = null;      
    }


    @Override
    public int size() {
        return totalSize;
    }
    
    @Override
    public boolean isEmpty() {
        if (totalSize == 0)
            return true;
        else
            return false;
    }

    private void rehash()
    {
        int new_table_size = table_size * 2;
        System.out.println("rehash: "+ new_table_size);
        
        MyHashSet<T> bigger = new MyHashSet<T>(new_table_size, loadFactor);
       
        Iterator<T> iter = iterator();
        while (iter.hasNext())
        {
            bigger.add(iter.next());
        }
        // Update our instance variables. 
        hashTable = bigger.hashTable;
        table_size = new_table_size;
        totalSize = bigger.totalSize; // probably don't need to do
        
    }
    
    
    @Override
    public boolean addAll(Collection c) {
        // TODO Auto-generated method stub
        return false;
    }

   
    

    @Override
    public boolean containsAll(Collection c) {
        // TODO Auto-generated method stub
        return false;
    }

   




    @Override
    public boolean removeAll(Collection c) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean retainAll(Collection c) {
        // TODO Auto-generated method stub
        return false;
    }


    @Override
    public Object[] toArray() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Object[] toArray(Object[] a) {
        // TODO Auto-generated method stub
        return null;
    }
    
    
    
    public static void main(String[] args)
    {
        MyHashSet<String> mhs = new MyHashSet<String>(3, .75f);
        
        mhs.add("Fido");
        mhs.add("Spike");
        mhs.add("Spike");
        mhs.add("Izzy");
        mhs.add("Spot");
        mhs.add("Lassy");
        mhs.add("Rintintin");
        mhs.add("Rusty");
        mhs.add("Rastro");
        mhs.add("Silver");
        mhs.add("Spasky");
             
        if (mhs.contains("Fido"))
            System.out.println("Fido is in the list");
        else
            System.out.println("Fido is NOT in the list");

        if (mhs.remove("Silver"))
            System.out.println("Successfully removed Silver");
        
        Iterator<String> iter = mhs.iterator();
        while (iter.hasNext())
        {
            System.out.println(iter.next());
        }
            
        
    }

}
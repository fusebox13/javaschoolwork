package CPS261Generics;

public class MyArrayList<E> {
    Object[] container;
    int numElements =0;
    
    public MyArrayList(int initialSize)
    {
        container = new Object[initialSize];
    }
    public MyArrayList()
    {
        this(10);
    }
    
    public int size()
    {
        return numElements;
    }
    public void add(E ob)
    {
        if (numElements >= container.length)
        {
            resize();
        }
        container[numElements++] = ob;
    }
    public E get(int index)
    {
        if (index < 0 || index >= numElements)
            throw new IndexOutOfBoundsException("Index out of bounds");
        return (E)container[index];
    }
    
    private void resize()
    {
        int currSize = container.length;
        Object[] nextContainer = new Object[currSize*2];
        for (int i=0; i < numElements; i++)
            nextContainer[i] = container[i];
        
        container = nextContainer;
    }
    public E set(int index, E ob)
    {
        if (index < 0  || index >= numElements)
            throw new IndexOutOfBoundsException("Index out of bounds: "+ index);
        E replacedObject = (E)container[index];
        container[index] = ob;
        
        return replacedObject;
    }
    // Inserts object at desired location
    public void add(int index, E ob)
    {
        if (index < 0  || index > numElements)
            throw new IndexOutOfBoundsException("Index out of bounds: "+ index);
        add(ob); // This will increase our size by 1 
        // Shift objects to make room for the new addition
        for (int i= numElements-1; i > index; i--)
        {
            container[i] = container[i-1];
        }
        container[index] = ob;
    }
    
    // For this to work, the objects need to implement equals
    public int indexOf(E ob)
    {
        for (int i=0; i < numElements; i++)
        {
            if (ob.equals(container[i]))
                return i;
        }
        return -1;
    }
    
    public E remove(int index)
    {
        if (index < 0  || index >= numElements)
            throw new IndexOutOfBoundsException("Index out of bounds: "+ index);
        
        // Shift everything down
        E removedObject = (E)container[index];
        for (int i= index; i < numElements-1; i++)
        {
            container[i] = container[i+1];
        }
        numElements -= 1;
        return removedObject;
    }
    
    // for this to work, the objects need to implement equals
    public boolean remove (E ob)
    {
        int index = indexOf(ob);
        if (index < 0)
            return false;
        
        remove(index);
        return true;
    }
    
    public String toString()
    {
        StringBuilder sb= new StringBuilder();
        sb.append("[ ");
        for (int i=0; i < numElements; i++)
        {
            sb.append(container[i].toString());
            if (i < numElements-1)
                sb.append(",");
        }
        sb.append(" ]");
        return sb.toString();
    }

}
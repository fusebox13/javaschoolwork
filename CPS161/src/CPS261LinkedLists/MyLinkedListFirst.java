package CPS261LinkedLists;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class MyLinkedListFirst<T> implements List<T> {
    private Node header = new Node();
    private int totalSize = 0;

    /****** Inner Class *****/
    class Node
    {
        T value;
        Node next;
        Node previous;
        
        Node()
        {
            value = null;
            next = this;
            previous = this;
        }
        
        Node(T value, Node curr)
        {
            this.value = value;
            next = curr;
            previous = curr.previous;
            curr.previous.next = this;
            curr.previous = this;
        }
        
        
    }
    
    /******* Inner class Iterator *****/
    class MyIterator implements Iterator<T>
    {
        Node lastNode = header;
        Node nextNode = header;
        
        @Override
        public boolean hasNext() {
            if (nextNode.next == lastNode)
                return false;
            return true;
        }

        @Override
        public T next() {
            nextNode = nextNode.next;
            return nextNode.value;
        }

        @Override
        public void remove() {
            removeNode(nextNode);
            
        }
        
    }
    
    public Iterator<T> iterator()
    {
        return new MyIterator();
    }
    
    private void addNode(T value, Node curr)
    {
        new Node(value, curr);
        totalSize += 1;
    }
    
    public boolean add(T value)
    {
        addNode(value, header);
        return true;
    }
    void addLast(T value)
    {
        add(value);
    }
    public void addFirst(T value)
    {
        addNode(value, header.next);
    }
    public T getFirst()
    {
        return header.next.value;
    }
    public T getlast()
    {
        return header.previous.value;
    }
   
    private void removeNode(Node n)
    {
        n.previous.next = n.next;
        n.next.previous = n.previous;
        totalSize-=1;
    }
    T removeFirst()
    {
        Node n = header.next;
        T value = n.value;
        removeNode(n);
        return value;
    }
    
    T removeLast()
    {
        Node n = header.previous;
        T value = n.value;
        removeNode(n);
        return value;
    }
   

    public int size() {
        
        return totalSize;
    }
    public boolean isEmpty() {
        if (totalSize==0)
            return true;
        else
            return false;
    }
    public void clear() {
         header = new Node();
         totalSize = 0;    
    }
    
    
    public static void main(String[] args) {
        MyLinkedListFirst<String> ml = new MyLinkedListFirst<String>();
        
        ml.add("three");
        ml.add("four");
        ml.add("five");
        ml.addFirst("two");
        ml.addFirst("one");
        
        System.out.println("Front = "+ ml.getFirst());
        System.out.println("Last = " + ml.getlast());
        
        
        Iterator<String> iter = ml.iterator();
        
        while (iter.hasNext())
        {
            String s = iter.next();
            if (s.equals("three"))
                iter.remove();
            System.out.println(s);
        }
        System.out.println("After removing three");
        iter = ml.iterator();
        while (iter.hasNext())
        {
            String s = iter.next();
            System.out.println(s);
        }
        
        ml.removeFirst();

        System.out.println("After removeFirst");
        iter = ml.iterator();
        while (iter.hasNext())
        {
            String s = iter.next();
            System.out.println(s);
        }
        

        ml.removeLast();

        System.out.println("After removeLast");
        iter = ml.iterator();
        while (iter.hasNext())
        {
            String s = iter.next();
            System.out.println(s);
        }

    }

	@Override
	public void add(int arg0, T arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean addAll(Collection<? extends T> arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addAll(int arg0, Collection<? extends T> arg1) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean contains(Object arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean containsAll(Collection<?> arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public T get(int arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int indexOf(Object arg0) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int lastIndexOf(Object arg0) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ListIterator<T> listIterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ListIterator<T> listIterator(int arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean remove(Object arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public T remove(int arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean removeAll(Collection<?> arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean retainAll(Collection<?> arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public T set(int arg0, T arg1) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<T> subList(int arg0, int arg1) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object[] toArray() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T> T[] toArray(T[] arg0) {
		// TODO Auto-generated method stub
		return null;
	}

}
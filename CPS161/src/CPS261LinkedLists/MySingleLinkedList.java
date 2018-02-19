package CPS261LinkedLists;

import java.util.Iterator;


public class MySingleLinkedList<T> {
    private Node head=null;
    private Node tail=null;
    private int totalSize = 0;

    /****** Inner Class *****/
    class Node
    {
        T value;
        Node next;

        Node(T value)
        {
            this.value = value;
            next = null;
        }

    }

    /******* Inner class Iterator *****/
    class MyIterator implements Iterator<T>
    {
        private Node nextNode = head;

        @Override
        public boolean hasNext() {
            if (nextNode== null)
                return false;
            return true;
        }

        @Override
        public T next() {
            T value = nextNode.value;
            nextNode = nextNode.next;
            return value;
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException("Iterator.remove not implemented");

        }

    }

    public Iterator<T> iterator()
    {
        return new MyIterator();
    }


    public boolean add(T value)
    {
        Node n = new Node(value);
        if (tail == null)
        {
            // First node to be added to the List
            tail = head = n;
        }
        else
        {
            tail.next = n;
            tail = n;
        }
        totalSize += 1;
        return true;
    }
    public void addFirst(T value)
    {
        Node n = new Node(value);
        n.next = head;
        if (head != null)
        {
            n.next = head;
            head = n;
        }
        else
        {
            // First node to be added to the List
            head = tail = n;
        }
        totalSize +=1;
    }
    public T getFirst()
    {
        return head.value;
    }
    public T getlast()
    {
        return tail.value;
    }

    void addLast(T value)
    {
        add(value);
    }
    T removeFirst()
    {
        if (head == null)
            throw new RuntimeException("MySingleLinkedList.removeFirst call on empty list");
        Node n = head;
        head = n.next;
        totalSize -= 1;
        return n.value;
    }

    T removeLast()
    {
        throw new UnsupportedOperationException("MySingleLinkedList.removeLast not implemented");
    }




    public static void main(String[] args) {
        MySingleLinkedList<String> ml = new MySingleLinkedList<String>();

        ml.add("one");
        ml.add("two");
        ml.add("three");
        ml.add("four");
        ml.add("five");

        System.out.println("Front = "+ ml.getFirst());
        System.out.println("Last = " + ml.getlast());


        Iterator<String> iter = ml.iterator();

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



    }

}
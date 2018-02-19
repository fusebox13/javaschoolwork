package networking;

import java.io.Serializable;
import java.util.Date;
import java.util.ArrayList;

// A serializable class that can be easily read and written 
// to a socket.  Note that all of your classes must implement
// Serializable.  If you include some one elses class, make 
// sure they too implement Serializable.  Note that most 
// Java classes (like String, Date, ArrayList, etc.) do 
// implement Serializable

public class UserInputs implements Serializable
{
    int counter=0;
    String lastMessage; // already serializable
    ArrayList<Data> list = new ArrayList<Data>(); // already serializable

// endOfLine will be '\r\n' on Windows and '\n' on Linux
    String endOfLine = System.getProperty("line.separator");
    
// BEGIN INNER CLASS
    class Data implements Serializable

    {
        Date date; // already serializable
        String str;
        Data(String s)
        {
            date = new Date();
            str =s;
        }

// toString makes it easy to create output of this class
        public String toString()
        {
            return date +" " + str;
        }
    }
 // END INNER CLASS
        
    void addMsg(String s)
    {
        list.add( new Data(s));
        counter += 1;
        lastMessage = s;
    }

// toString makes it easy to create output of this class
    public String toString()
    {
        String retval;
        retval = "counter="+counter +" lastMessage="+ lastMessage + endOfLine;
        for (int i=0; i < list.size(); i++)
            retval += list.get(i) + endOfLine;
        return retval;
        
    }
}
 
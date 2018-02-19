package binaryIOExamples;

import java.io.Serializable;

public class SomeClass implements Serializable
{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int number;
    private char letter;

    public SomeClass( )
    {
        number = 0;
        letter = 'A';
    }

    public SomeClass(int theNumber, char theLetter)
    {
        number = theNumber;
        letter = theLetter;
    }

    public String toString( )
    {
        return "Number = " + number 
                           + " Letter = " + letter;
    }

}
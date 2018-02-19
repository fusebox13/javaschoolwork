import java.util.Scanner;


public class MyStringMethods 
{

	//class variable declarations
    private String myStr="";
    
   
   /**************************************
    * Prompts the user to input a string.*
    **************************************/
    public void readString()
    {
        Scanner Keyboard = new Scanner(System.in);
        
        System.out.print("> ");
        myStr = Keyboard.nextLine();
        
        Keyboard.close();
    }
    
    
    /*************************************************************************
     * Changes the value of myStr to a new string specified by the programmer*
     *************************************************************************/ 
    public void setString(String s)
    {
        myStr = s;
    }
    
    
    /***************************************************************************
     * Counts the amount of substrings specified by the programmer within myStr*
     ***************************************************************************/
    public int countOccurrences(String subString)
    {
    	int stringPosition = 0;
    	int counter = 0;
    	
    	while (stringPosition != -1) // Loops until the subString cannot be found within myStr
    	{
    		stringPosition = myStr.indexOf(subString, stringPosition);
    		if(stringPosition != -1)
    		{
    			counter++;
    			stringPosition = stringPosition + subString.length(); // Moves the position to the next string if indexOf finds the substring within myStr
    		}
    		
    	}
    	
    	return counter;
    	
    }
    
    
    /***************************************************************************
     * Counts the amount of characters specified by the programmer within myStr*
     ***************************************************************************/
    public int countOccurrences(char c)
    {
    	int charPosition = 0;
    	int counter = 0;
    	
    	while (charPosition != -1) // Loops until c cannot be found within myStr
    	{
    		charPosition = myStr.indexOf(c, charPosition);
    		if(charPosition != -1)
    		{
    			counter++;
    			charPosition++; // Moves the position to the next character if indexOf finds the character within the myStr
    		}
    		
    	}
    	
    	return counter;
    	
    }
    
    
    /***************************************************
     * Counts the amount of upper case letters in myStr*
     ***************************************************/
    int countUpperCaseLetters()
    {
    	int counter = 0;
        
    	for(int charPosition = 0; charPosition < myStr.length(); charPosition++) //Loops exactly enough times to evaluate every character in myStr
        {
        	if (Character.isUpperCase(myStr.charAt(charPosition)) == true) //If the current character is upper case, counter is incremented by 1
        	{
        		counter++;
        	}
        }
        
    	return counter;
    	
    }
    
    
    /***************************************************
     * Counts the amount of lower case letters in myStr*
     ***************************************************/
    int countLowerCaseLetters()
    {
        int counter = 0;
        
        for(int charPosition = 0; charPosition < myStr.length(); charPosition++) //Loops exactly enough times to evaluate every character in myStr
        {
        	if (Character.isLowerCase(myStr.charAt(charPosition)) == true) //If the current character is lower case, counter is incremented by 1
        	{
        		counter++;
        	}
        }
        
    	return counter;
    	
    }
    
    
    /*******************************************************************
     * Outputs a formatted printout counting the number of substrings, *
     * characters, upper case letter and lower case letter within myStr*
     *******************************************************************/
    public void printCounts(String s, char c)
    {
        System.out.println("***************************************");
        System.out.println("Analyzing: myStr="+myStr);
        System.out.println("Number of "+s + " is "+ countOccurrences(s));
        System.out.println("Number of "+c + " is "+ countOccurrences(c));
        System.out.println("Number of Upper case letters="+ countUpperCaseLetters());
        System.out.println("Number of Lower case letters="+ countLowerCaseLetters());
    }

    
    public static void main(String[] args) {
        MyStringMethods msm = new MyStringMethods();
        msm.readString();
        msm.printCounts("big", 'a');
        
        msm.setString("Parked in a van down by the river bank .... The van had was near a lot of other vans");
        msm.printCounts("van", 'a');
        
        MyStringMethods msm2 = new MyStringMethods();
        msm2.setString("the elephant in the room wouldn't budge");
        msm2.printCounts("the", 'i');
    }
    
}
import java.util.Random;
import java.util.Scanner;

class Hangman
{
    private Scanner keyboard = new Scanner(System.in);
    private Random rand = new Random();
    
    
    private final String[] wordList = {"elephant", "tiger", "monkey", "baboon", 
    		"barbeque", "giraffe",  "simple", "zebra", "porcupine", "aardvark"};
    
  
    
    private boolean isIn(char c, String str)
    {
    	for (int i = 0; i < str.length(); i++)
    		if ( Character.toLowerCase(c) == Character.toLowerCase( str.charAt(i) ) )
    			return true;
    	return false;
    }
    
    
    
    private boolean printCurrStatus(String strToGuess, String userInputs)
    {
    	String tempString = new String();
    	for(int i = 0; i < strToGuess.length(); i++)
    	{
    		if(isIn(strToGuess.charAt(i), userInputs))
    		{
    			System.out.print(strToGuess.charAt(i) + " ");
    			tempString+=strToGuess.charAt(i);
    		}
    		else
    			System.out.print("_ ");
    	}
    	
    	System.out.println();
    	return tempString.equals(strToGuess);
 
    }
    
     
    
    private String getNextWordToGuess()
    {
    	return wordList[rand.nextInt(wordList.length)];
   
    }
    
     
    
    public void playGame()
    {
    	String input = new String();
    
    	while(true)
    	{
    		System.out.println("Would you like to play a game of Hangman? (y/n): ");
    		input = keyboard.nextLine();
    		
    		if(Character.toLowerCase(input.charAt(0)) == 'n')
    			return;
    		
    		input = "";
    		String currentWord = getNextWordToGuess();
    	
    		while (!printCurrStatus(currentWord, input))
    		{
    			System.out.print("Please guess a letter: ");
    			input += keyboard.nextLine();
    			System.out.println("\nLetters guessed: " + input);
    			
    		}
    		System.out.println("\n**************************\nCongratulations!  You win!\n**************************\n");
    		
    	}
        
    }
 
 
    public static void main(String[] args)
    {
    	Hangman newGame = new Hangman();
    	newGame.playGame();
    }
}
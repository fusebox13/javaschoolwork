package serializableTicTacToe;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Scanner;

class PauseException extends RuntimeException
{
	private static final long serialVersionUID = 1L;
}

class TicTacToe implements Serializable
{
	private static final long serialVersionUID = 1L;
    char ttt[][] = new char[3][3];
    static final char player1 = 'O';
    static final char player2 = 'X';
    char currPlayer;
    
    String playerID(char player)
    {
        if (player == player1)
            return "player1: "+player;
        else
            return "player2: "+ player;
    }
    
    void getPlayerInput(char player)
    {
       int row, col, cellVal;
       char cell;
       String temp;
       Scanner scan  =new Scanner(System.in);
       boolean continueFlag=true;
       System.out.println("Entering input for: " + playerID(player));
       do
       {
           System.out.println("enter in cell  [a, b, ... i] or p for Pause");
           temp = scan.next();
           
           if ("p".equals(temp))
        	   throw new PauseException();
           
           cell = temp.charAt(0);
           if (cell < 'a' || cell > 'i')
           {
                System.out.println(cell + " cell is out of bounds ... must be a-i");
           } 
           else
           {
                cellVal = cell - 'a';
                row = cellVal/3;
                col = cellVal % 3; 
           
                if (ttt[row][col] != ' ')
                {
                    System.out.println("Cell already taken ... try again");
                }
                else
                {  
                    ttt[row][col]=player;
                    continueFlag = false ; // done now that we found a legal spot
                }  
           }   
  
        } while (continueFlag);
    }
   
    boolean gameIsDraw()
    {
        for(int i=0; i<3; i++)
        {
            for(int j=0; j<3; j++)
                if (ttt[i][j] == ' ')
                    return false;
         }
         return true;
    }
    
    boolean winner(char player)
    {
    // Check for a win on the rows
     boolean match;
     for(int i=0; i<3; i++)
        {
            match = true;
            for(int j=0; j<3; j++)
            {
                if (ttt[i][j] != player)
                {
                    match=false;
                    break;
                }
            }
            if (match)return true; // found a row owned by player
        }
        
      // Check for a win on the Columns
      for(int i=0; i<3; i++)
        {
            match=true;
            for(int j=0; j<3; j++)
            {
                if (ttt[j][i] != player)
                {
                    match=false;
                    break;
                }
            }
            if (match) return true; // found a col owned by player
        }
        
        // Check Diagonal from top left to bottom right
        match = true;
        for (int i=0; i < 3; i++)
            if (ttt[i][i] != player)
            {
                match = false;
                break;
            }
        if (match) return true; // Player owns diagonal
        
        
        // Check Diagonal from top right to bottom left
        match = true;
        for (int i=0; i < 3; i++)
            if (ttt[i][2-i] != player)
            {
                match = false;
                break;
            }
        if (match) return true; // Player owns the other diagonal  
        
        return false; // Player hasn't won yet
    }

    void displayBoard()
    {
        System.out.println("********************************");        
        System.out.println("      ---a------b------c---");

        for (int i=0; i<3; i++)
        {
            for (int j=0; j< 3; j++)
            {
              if (j == 0) System.out.print("      |  "); 
              System.out.print(ttt[i][j]);
              if (j < 2) System.out.print( "   |  ");
              if (j==2)  System.out.print("  |");
            }
            System.out.println();
            switch (i)
            {
            case 0:
                System.out.println("      ---d------e------f---");
                break;
            case 1:
                System.out.println("      ---g------h------i---");
                break;
            case 2:
                System.out.println("      ---------------------");
                break;
            }
        }
    }
    
     
    void newgame(boolean restart)
    {
    	if (!restart)
    	{
    		currPlayer = player1;
        
        for(int i=0; i<3; i++)
            for(int j=0; j<3; j++)
                ttt[i][j] =' ';
    	}
        
        boolean continueFlag = true;        
        while (continueFlag)
        {
            displayBoard();
            if (gameIsDraw())
            {
                System.out.println("Game Ends in Draw");
                continueFlag = false;
            }
            else
            {
                getPlayerInput(currPlayer);
                if (winner(currPlayer))
                {
                    System.out.println("We have a winner: " + playerID(currPlayer));
                    displayBoard();
                    continueFlag = false;
                }
                else
                { 
                    if (currPlayer == player1) currPlayer = player2;
                        else currPlayer = player1;
                }
             }
        }
        
    }
    
    static void dumpTTT(TicTacToe g)
    {
    	try {
			ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream("PAUSE"));
			os.writeObject(g);
			os.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    
    static TicTacToe checkPause()
    {
    	File pf = new File("PAUSE");
    	TicTacToe tttGame = null;
    	if(!pf.exists())
    		return null;
    	
    	try {
			ObjectInputStream is = new ObjectInputStream(new FileInputStream("PAUSE"));
			tttGame = (TicTacToe)is.readObject();
			is.close();
			pf.delete();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	return tttGame;
    }

    
    public static void main(String[] args)
    {
    	Scanner scan  =new Scanner(System.in);
    	TicTacToe game = checkPause();
    	boolean restart = false;
    	try
    	{
	        if (game == null)
	        	game = new TicTacToe();
	        else
	        	restart = true;
	        
    		String str;
	        do
	        {
	            game.newgame(restart);
	            
	            System.out.println("Do you want to play Tic-Tac-Toe (y/n)?");
	            str= scan.next();
	        } while ("y".equals(str));
	        
	        System.out.println("Bye");
    	}
    	catch (PauseException pe)
    	{
    		dumpTTT(game);
    	}
    }    
}
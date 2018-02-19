import java.util.Scanner;


public class tictactoe 
{
	public char[][] board = new char[3][3];
	
	private char currentPlayer;
	private int moveCount = 0;
	
	public Scanner keyboard = new Scanner(System.in);
	
	
	tictactoe()
	{
		currentPlayer = 'X';
		for (int row = 0; row < 3; row++)
			for(int col = 0; col < 3; col++)
				board[row][col] = ' ';
	}
	
	boolean Won()
	{
		final long startTime = System.nanoTime();
		for (int row = 0; row < 3; row++)
		{
			if (board[row][0] == currentPlayer && board[row][1] == currentPlayer && board[row][2] == currentPlayer)
			{
				System.out.println(currentPlayer + " wins!");
				final long endTime = System.nanoTime();
				System.out.println(endTime - startTime);
				return true;
			}
		}
		
		for (int column = 0; column < 3; column++)
		{
			if (board[0][column] == currentPlayer && board[1][column] == currentPlayer && board[2][column] == currentPlayer)
			{
				System.out.println(currentPlayer + " wins!");
				final long endTime = System.nanoTime();
				System.out.println(endTime - startTime);
				return true;
			}
		}
		
		if ((board[0][0] == currentPlayer && board[1][1] == currentPlayer && board[2][2] == currentPlayer)
			|| (board[2][0] == currentPlayer && board[1][1] == currentPlayer && board[0][2] == currentPlayer))
		{
			System.out.println(currentPlayer + " wins!");
			final long endTime = System.nanoTime();
			System.out.println(endTime - startTime);
			return true;
		}
		
		final long endTime = System.nanoTime();
		System.out.println(endTime - startTime);
		
		return false;
	}
	
	boolean Won2()
	{
		final long startTime=System.nanoTime();
		for (int row = 0; row < 3; row++)
			for (int col = 0; col < 3; col++)
			{
				if (board[row][col] != currentPlayer)
					break;
				if (col >= 2)
				{
					System.out.println(currentPlayer + " wins in row " + (row + 1));
					final long endTime = System.nanoTime();
					System.out.println(endTime - startTime);
					return true;
				}
			}
		
		for (int col = 0; col < 3; col++)
			for (int row = 0; row < 3; row++)
			{
				if(board[row][col] != currentPlayer)
					break;
				if (row >=2)
				{
					System.out.println(currentPlayer + " wins in column" + (col + 1));
					final long endTime = System.nanoTime();
					System.out.println(endTime - startTime);
					return true;
				}
			}
		
		for(int diag = 0; diag < 3; diag++)
		{
			if (board[diag][diag] != currentPlayer)
				break;
			if (diag >= 2)
			{
				System.out.println(currentPlayer + " wins in the reverse diagonal");
				final long endTime = System.nanoTime();
				System.out.println(endTime - startTime);
				return true;
			}
		}
		
		int offset = 2;
		
		for(int diag=0; diag < 3; diag++)
		{
			if(board[diag][diag+offset] != currentPlayer)
				break;
			if(diag >= 2)
			{
				System.out.println(currentPlayer + " wins in the forward diagonal");
				final long endTime = System.nanoTime();
				System.out.println(endTime - startTime);
				return true;
			}
			offset-=2;
			
		}
		
		final long endTime = System.nanoTime();
		System.out.println(endTime - startTime);
		return false;
	}
	
	boolean Draw()
	{
		if (moveCount < 9)
			return false;
		else
		{
			System.out.println("Draw!");
			return true;
		}		
	}
	
	
	void getPlayerInput()
	{
		
		System.out.println("Your move " + currentPlayer + ":");
		char location = keyboard.nextLine().charAt(0);
		
		
		if (location >= 'a' && location <= 'i')
		{
			int row = getRow(location);
			int col = getColumn(location);
			char charAtThisLocation = board[row][col];
			
			if (charAtThisLocation!= ' ')
				System.out.println("This space has already been played");
			else
			{
				board[getRow(location)][getColumn(location)] = getCurrentPlayer();
				moveCount++;// play on this space
			}
				
		}
		else
			System.out.println("Invalid space!");
	}	
	
	
	char getCurrentPlayer()
	{
		return currentPlayer;
	}
	
	
	public void switchCurrentPlayer()
	{
		if (currentPlayer == 'X')
			currentPlayer = 'O';
		else
			currentPlayer = 'X';
	}
	
	
	private int getRow(char location)
	{
		location = Character.toLowerCase(location);
		
		switch(location)
		{
		case 'a': case 'b': case 'c':
			return 0;
		case 'd': case 'e': case 'f':
			return 1;
		case 'g': case 'h': case 'i':
			return 2;
		default:
			return -1;
		}
	}
	
	
	private int getColumn(char location)
	{
		location = Character.toLowerCase(location);
		
		switch(location)
		{
		case 'a': case 'd': case 'g':
			return 0;
		case 'b': case 'e': case 'h':
			return 1;
		case 'c': case 'f': case 'i':
			return 2;
		default:
			return -1;
		}
	}
	
	
	void displayBoard()
    {
        System.out.println("********************************");        
        System.out.println("      ---a------b------c---");

        for (int row=0; row<3; row++)
        {
            for (int column=0; column< 3; column++)
            {
              if (column == 0) System.out.print("      |  "); 
              System.out.print(board[row][column]);
              if (column < 2) System.out.print( "   |  ");
              if (column==2)  System.out.print("  |");
            }
            System.out.println();
            switch (row)
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
	
	
	void newGame()
	{
		while (true)
		{	
			displayBoard();
			getPlayerInput();
			if (Won() || Draw())
			{
				displayBoard();
				break;
			}
			switchCurrentPlayer();
		}
		System.out.println("Exiting game...");
	}

	
	public static void main(String[] args) 
	{
		tictactoe newGame = new tictactoe();
		newGame.newGame();

	}

}

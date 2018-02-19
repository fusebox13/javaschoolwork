package gameoflife;

import java.util.Scanner;

class MyException extends RuntimeException
{
	double density;
	MyException(double density)
	{
		super ("Bad Density: " + density);
		this.density = density;
	}
}

public class Life {

	static final int NUM_ROWS = 8;
	static final int NUM_COLS = 10;
	Organism[][] world;
	
	static Scanner keyboard = new Scanner(System.in);
	
	Life(double densityAnts, double densityPredators) 
	{
		if (densityAnts < 0 || densityAnts > 1)
			throw new MyException(densityAnts);
		world  = new Organism[NUM_ROWS][NUM_COLS];
		
		for(int i = 0; i < NUM_ROWS; i++)
		{
			for (int j = 0; j < NUM_COLS; j++)
			{	
				double prob = Math.random();
				if (prob < densityAnts) //Math.random is between 0 and 1
					world[i][j] = new Ant();
				else if (prob < densityAnts + densityPredators) // .8 .05, the probability of this running is .05
					world[i][j] = new Predator();
				else
					world[i][j] = null;
			}
		}
	}
	
	void display()
	{
		for (int r = 0; r < NUM_ROWS; r++)
		{
			for (int c = 0; c < NUM_COLS; c++)
			{
				if (world[r][c] != null)
					System.out.print(world[r][c]);
				else
					System.out.print("   ");
			}
			System.out.println();
		}
	}
	
	void playGame(boolean debug)
	{
		String response = null;
		do
		{
			display();
			worldupdate(debug);
			System.out.println("Do you want to keep going (y/n)");
			response = keyboard.next();
		} while ("y".equals(response));
	}
	
	OrganismCounts countOrganismNeighbors(int row, int col)
	{
		OrganismCounts oc = new OrganismCounts();
		for (int r = row - 1; r <= row + 1; r++)
		{
			for (int c = col - 1; c <= col+1; c++)
			{
				if(r == row && c == col) continue;
				if (r < 0 || c < 0) continue;
				if(r >= NUM_ROWS || c >= NUM_COLS) continue;
				
				Organism org = world[r][c];
				if(org == null)
					oc.empty+=1;
				else if(org instanceof Ant)
					oc.ants+=1;
				else if (org instanceof Predator)
					oc.predators+=1;
				else
					System.out.println("countNeighbors: Shouldn't get here");
				
			}
		}
		return oc;
	}
	
	WorldLocation findOrganismNeighbor(int row, int col, Organism org2Find)
	{
		WorldLocation wl = new WorldLocation();
		for (int r = row - 1; r <= row + 1; r++)
		{
			for (int c = col - 1; c <= col+1; c++)
			{
				wl.row = r;
				wl.col = c;
				
				if(r == row && c == col) continue;
				if (r < 0 || c < 0) continue;
				if(r >= NUM_ROWS || c >= NUM_COLS) continue;
				
				Organism org = world[r][c];
				if (org == null && org2Find == null)
					return wl;
				else if (org instanceof Ant && org2Find instanceof Ant)
					return wl;
				else if (org instanceof Predator && org2Find instanceof Predator)
					return wl;
			}
		}
		return null;
	}
	
	void worldupdate(boolean debugFlag)
	{
		WorldLocation debug = null;
		if(debugFlag)
			debug = new WorldLocation();
		
		for (int r = 0; r < NUM_ROWS; r++)
		{
			for (int c = 0; c < NUM_COLS; c++)
			{
				if (debug != null)
				{
					debug.row = r;
					debug.col = c;
				}
				if (world[r][c] == null)
					continue;
				OrganismCounts oc = countOrganismNeighbors(r, c);
				Action action = world[r][c].update(oc, debug);
				WorldLocation wl;
				
				switch(action.lifeAction)
				{
				case Move:
					wl = findOrganismNeighbor(r,c, null);
					if (wl != null)
					{
						world[wl.row][wl.col] = world[r][c];
						world[r][c]	= null;
					}
					else
						System.out.println("Move: Error shouldn't get here");
					break;
				case Procreate:
					wl = findOrganismNeighbor(r,c, null);
					if (wl != null)
					{
						world[wl.row][wl.col] = action.baby;
					}
					else
						System.out.println("Procreate: Error shouldn't get here");
					break;
				case Eat:
					wl = findOrganismNeighbor(r, c, action.victim);
					if (wl != null)
					{
						world[wl.row][wl.col] = world[r][c];
						world[r][c] = null;
					}
					else
						System.out.println("Eat: Error shouldn't get here");
					break;
				case Die:
					world[r][c] = null;
					break;
					
				}
			}
		}
	}
	
	
	public static void main(String[] args) 
	{
		System.out.println("Enter in Ant density (number between 0.0 and 1.0)");
		double densityAnts = keyboard.nextDouble();
		double densityPredators = keyboard.nextDouble();
		
		Life life = new Life(densityAnts, densityPredators);
		life.playGame(true);
	}

}

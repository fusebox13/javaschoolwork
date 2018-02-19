package gameoflife;

public class AntOriginal {

	static final int ISOLATION_DEATH_COUNT = 2;
	private boolean alive = false;
	private int isolationCount = 0;
	
	
	public boolean isAlive()
	{
		return alive;
	}
	
	public void setAlive(boolean setVal)
	{
		alive = setVal;
	}
	
	public String toString()
	{
		if (alive) return " A ";
		return "   ";
	}
	
	void update(int numNeighbors, int row, int col, boolean debug)
	{
		if (alive)
		{
			if (numNeighbors > 3)
			{
				alive = false;
				if(debug)
					System.out.println(row + " : " + col + " Died from crowding");
			}
			else if (numNeighbors == 0)
			{
				if (++isolationCount >= ISOLATION_DEATH_COUNT)
				{
					alive = false;
					if(debug)
						System.out.println(row + " : " + col + " Died from isolation");
				}
			}
		}
		else
		{
			if (numNeighbors == 2)
			{
				alive = true;
				if (debug)
					System.out.println(row + " : " + col + " Birth");
				
			}
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

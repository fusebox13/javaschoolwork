package gameoflife;

enum LifeAction{ Move, Procreate, Eat, Die, Nothing };

class WorldLocation
{
	int row = 0;
	int col = 0;
}

class Action
{
	LifeAction lifeAction = LifeAction.Nothing;
	Organism baby = null;
	Organism victim = null;
}

class OrganismCounts
{
	int empty = 0;
	int ants = 0;
	int predators = 0;
}

public abstract class Organism {
	
	public abstract Action update(OrganismCounts counts, WorldLocation debug);
	
	void printDebug(WorldLocation wl, String info)
	{
		if(wl == null)
			return;
		System.out.println(info + " row =" + wl.row + " col=" + wl.col);
	}

}

class Ant extends Organism
{
	int procreateCount = 0;
	
	public String toString()
	{
		return " A ";
	}
	
	public Action update(OrganismCounts counts, WorldLocation debug)
	{
		Action action = new Action();
		
		if (counts.empty > 0)
		{
			if (procreateCount >= 2)
			{
				action.lifeAction = LifeAction.Procreate;
				action.baby = new Ant();
				procreateCount = 0;
				printDebug(debug, "Ant baby ");
				return action;
			}
			action.lifeAction = LifeAction.Move;
		}
		procreateCount += 1;
		
		return action;
	}
}

class Predator extends Organism
{
	int procreateCount = 0;
	int hungerCount = 0;
	
	public String toString()
	{
		return " P ";
	}
	
	public Action update(OrganismCounts counts, WorldLocation debug)
	{
		Action action = new Action();
		
		if (counts.ants > 0)
		{
			action.lifeAction = LifeAction.Eat;
			action.victim = new Ant();
			hungerCount = 0;
			printDebug(debug, "Predator Eats ");
			return action;
		}
		
		hungerCount += 1;
		
		if (hungerCount >= 3)
		{
			action.lifeAction = LifeAction.Die;
			printDebug(debug, "Predator Dies ");
			return action;
		}
		if (counts.empty > 0)
		{
			if (procreateCount >= 8)
			{
				action.lifeAction = LifeAction.Procreate;
				action.baby = new Predator();
				procreateCount = 0;
				printDebug(debug, "Predator baby ");
				return action;
			}
			action.lifeAction = LifeAction.Move;
		}
		procreateCount += 1;
		
		
		return action;
	}
}


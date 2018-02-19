package life;

public class GameOfLife {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Living[] living = new Living[4];
		
		living[0] = new tree();
		living[1] = new Human();
		living[2] = new tree();
		living[3] = new Human();

		for (int i = 0; i < living.length; i++)
		{
			System.out.println(" living item number =" + i);
			living[i].born();
			living[i].eat();
			living[i].move();
			living[i].die();
		}
	}

}

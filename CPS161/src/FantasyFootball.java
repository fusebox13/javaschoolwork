import java.util.Arrays;
import java.util.Scanner;


public class FantasyFootball {

	private int numberOfTeams;
	private int numberOfWeeks;

	private int[][] scores;
	private String[] teamName;
	private double[] weeklyAverage;
	private double[] teamAverage;



	/**
	 * Default Constructor
	 * <p>
	 * Instantiates every class variable
	 * @see #fillTeamAverage()
	 * @see #fillWeeklyAverage()
	 */
	public FantasyFootball( )
	{
		Scanner keyboard = new Scanner(System.in);


		System.out.print("Enter number of Teams:");
		numberOfTeams = keyboard.nextInt( );
		System.out.print("Enter number of Weeks:");
		numberOfWeeks = keyboard.nextInt( );
		System.out.println();


		scores = new int[numberOfTeams][numberOfWeeks];
		teamName = new String[numberOfTeams];


		for (int teamNumber = 0; teamNumber < numberOfTeams; teamNumber++)
		{
			System.out.print("Enter the team name: ");
			teamName[teamNumber] = keyboard.next();

			for (int weekNumber = 0; weekNumber < numberOfWeeks; weekNumber++)
			{
				System.out.print("Enter score for the " + teamName[teamNumber] + " on week " + (weekNumber + 1) + ": ");
				scores[teamNumber][weekNumber] = keyboard.nextInt( );
			}

			System.out.println();
		}

		fillTeamAverage( );
		fillWeeklyAverage( );
		keyboard.close();
	}



	/**
	 * Copy Constructor
	 * 
	 * @param FF	Reads in a FantasyFootball object to be copied
	 * @see #fillScores(int[][])
	 * @see #fillTeamAverage()
	 * @see #fillWeeklyAverage()
	 */
	public FantasyFootball(FantasyFootball FF)
	{
		numberOfTeams = FF.numberOfTeams;
		numberOfWeeks = FF.numberOfWeeks;
		teamName = Arrays.copyOf(FF.teamName, FF.teamName.length);
		fillScores(FF.scores);
		fillTeamAverage( );
		fillWeeklyAverage( );
	}



	/**
	 * Populates the {@link #scores} array with the passed parameter.
	 * Used to copy the scores array in the Copy Constructor
	 *  
	 * @param tempScores	Instantiates the scores class variable
	 */
	private void fillScores(int[][] tempScores)
	{
		scores = new int[numberOfTeams][numberOfWeeks];

		for (int teamNumber = 0; teamNumber < numberOfTeams; teamNumber++)
			for (int weekNumber = 0; weekNumber < numberOfWeeks; weekNumber++)
				scores[teamNumber][weekNumber] = tempScores[teamNumber][weekNumber];
	}



	/**
	 * Instantiates the {@link #teamAverage} array
	 */
	private void fillTeamAverage( )
	{
		teamAverage = new double[numberOfTeams];

		for (int teamNumber = 0; teamNumber < numberOfTeams; teamNumber++)
		{
			double sum = 0;

			for (int weekNumber = 0; weekNumber < numberOfWeeks; weekNumber++)
				sum = sum + scores[teamNumber][weekNumber];

			teamAverage[teamNumber] = sum/numberOfWeeks;

		}
	}



	/**
	 * Instantiates the {@link #weeklyAverage} array
	 */
	private void fillWeeklyAverage( )
	{
		weeklyAverage = new double[numberOfWeeks];

		for (int weekNumber = 0; weekNumber < numberOfWeeks; weekNumber++)
		{
			double sum = 0;
			for (int teamNumber = 0; teamNumber < numberOfTeams; teamNumber++)
				sum = sum + scores[teamNumber][weekNumber];

			weeklyAverage[weekNumber] = sum/numberOfTeams;
		}
	}



	/**
	 * Displays a formatted version of:
	 * {@link #scores}, {@link #teamAverage}, and {@link #weeklyAverage}
	 */
	public void display( )
	{
		//Prints the Week row
		System.out.print("\n\t\t");
		for(int weekNumber = 1; weekNumber <= numberOfWeeks; weekNumber++)
			System.out.print("Week " + weekNumber + "\t");
		System.out.println();


		//Prints score multidimensional array including the average points per game.
		for (int teamNumber = 0; teamNumber < numberOfTeams; teamNumber++)
		{
			System.out.print(teamName[teamNumber] + ":");
			System.out.print((teamName[teamNumber].length() < 7)? "\t\t" : "\t");


			for (int weekNumber = 0; weekNumber < numberOfWeeks; weekNumber++)
				System.out.print(scores[teamNumber][weekNumber] + "\t");


			System.out.printf("| Pts/G: " + "%.2f\n", teamAverage[teamNumber] );
		}


		//Prints the weekly average score for all the teams
		System.out.print("\nWeekly average:\t");
		for (int weekNumber = 0; weekNumber < numberOfWeeks; weekNumber++)
			System.out.printf("%.2f" + "\t", weeklyAverage[weekNumber]);
		System.out.println();
	}



	/**
	 * MAIN
	 * @param args
	 */
	public static void main(String[] args)
	{
		FantasyFootball FF = new FantasyFootball();
		FF.display();

		FantasyFootball FF2 = new FantasyFootball(FF);
		FF2.display();
	}

}

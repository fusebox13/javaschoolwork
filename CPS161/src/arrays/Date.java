package arrays;

import java.util.Scanner;

public class Date
{
	private int month;
	private int day;
	private int year; //a four digit number.

	/*********************
	 * Class Constructors*
	 *********************/
	public Date( )
	{
		month = 1;
		day = 1;
		year = 2010;
	}

	public Date(int month, int day, int year)
	{
		this.month = month;
		this.day = day;
		this.year = year;
	}



	/**********************************
	 *Converts the object to a String *
	 **********************************/
	public String toString( )
	{
		return (month + "/" + day + "/" + year);
	}



	/************************************************************
	 * Determines if the Date object is currently in a leap year*
	 ************************************************************/
	private boolean isLeapYear()
	{

		return (year % 4 == 0 && year % 100 != 0 || year % 400 == 0);

	}



	/******************************************************************************
	 * Returns a numerical value for the total amount of days in the current month*
	 ******************************************************************************/
	private int daysInMonth()
	{
		switch (month)
		{

		//January, March, May, July, August, October, December
		case 1: case 3: case 5: case 7: case 8: case 10: case 12:
			return 31; //days

			//April, June, September, November	
		case 4: case 6: case 9: case 11:
			return 30;

			//February	
		case 2:
			if (this.isLeapYear() == true)
				return 29;
			else
				return 28;

			//Invalid Date
		default:
			System.out.println("Date is invalid");
			return -1;	
		}

	}


	/***********************************************************
	 * Adds days to the date object - Updates: day, month, year*
	 ***********************************************************/
	public void addDays(int daysToAdd)
	{
		while (day <= daysInMonth() && daysToAdd > 0)
		{
			day++;
			daysToAdd--;

			if (day == daysInMonth()) // When the end of the month is reached, the day is set back to 0 and month and year is incremented accordingly
			{
				day = 0;
				if (month < 12)
					month++;
				else
				{
					month = 1;
					year++;
				}
			}

		}
	}



	/***********
	 * M a i n *
	 ***********/
	public static void main(String[] args)
	{
		Date d = new Date(4,13,2010);
		d.addDays(10);
		System.out.println(d);

		Date d1 = new Date(4,13,2010);
		d1.addDays(21);
		System.out.println(d1);


		Date d2 = new Date(2,13,2010);
		d2.addDays(65);
		System.out.println(d2);


		Date d3 = new Date(2,13,2008);
		d3.addDays(65);
		System.out.println(d3);

		Date d4 = new Date(2,13,2000);
		d4.addDays(65);
		System.out.println(d4);


		Date d5 = new Date(2,13,1900);
		d5.addDays(65);
		System.out.println(d5);


		Date d6 = new Date(2,13,1900);
		d6.addDays(420);
		System.out.println(d6);

	}


}
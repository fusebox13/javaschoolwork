package JH4;

import java.math.BigInteger;

public class doCalcs 
{
	private static String left = "";
	private static String right = "";
    private static char operator;
	
	public static void setOperator(char c)
	{
		operator = c;
	}
	
	public static char getOperator()
	{
		return operator;
	}
	
	public static void setLeft(String s)
	{
		left = s;
	}
	
	public static void setRight(String s)
	{
		right = s;
	}
	
	public static String getLeft()
	{
		return left;
	}
	
	public static boolean hasLeft()
	{
		return left != "";
	}
	
	public static boolean hasRight()
	{
		return right !="";
	}
	
	public static void clear()
	{
		left = "";
		right = "";
	}
	
	public static void storeNumber(String s)
	{
		if (hasLeft())
		{
			right = s;
			compute();
		}
		else
		{
			left = s;
		}
			
	}
	
	public static void compute()
	{
		if(hasLeft() && hasRight())
		{
			System.out.print(left + operator + right + "=");
			BigInteger total = null;
			BigInteger l = new BigInteger(left);
			BigInteger r = new BigInteger(right);
			
			
			switch(operator)
			{
			case '+':
				left = l.add(r).toString();
				right = "";
				break;
			case '-':
				left = l.subtract(r).toString();
				right = "";
				break;
			case '*':
				left = l.multiply(r).toString();
				right = "";
				break;
			case '/':
				try 
				{
					left = l.divide(r).toString();
					right = "";
				}
				catch (ArithmeticException e)
				{
					left = "0";
				}
				break;
			default:
				break;
			}
			
			System.out.println(left);
			
		}
		
	}
	
	
	

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

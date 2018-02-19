package JH4;

import java.math.BigInteger;

public class doCalculations 
{
	static private long computedValue;
	static char lastOperation = '+';
	
	private static BigInteger left =  new BigInteger("0");
	private static BigInteger right = new BigInteger("0");
	private static BigInteger total = new BigInteger("0");
	
	static private BigInteger computedValue1;
	
	doCalculations()
	{
		computedValue = 0;
	}
	
	public static void setRight(String op)
	{
		right = new BigInteger(op);
		System.out.println("Right: " + right);
	}
	
	public static char getLastOperation()
	{
		return lastOperation;
	}
	
	public static void add1(String op)
	{
		right = new BigInteger(op);
		if (left.longValue() == 0 || (op.indexOf(left.toString(),0) != -1 && op.length() > left.toString().length()))
			left = right;
		else if(lastOperation != '=')
				left = left.add(right);
		
		lastOperation = '+';
	}
	
	public static void subtract1(String op)
	{
		right = new BigInteger(op);
		if(left.longValue() == 0 || (op.indexOf(left.toString(),0) != -1 && op.length() > left.toString().length()))
			left = right;
		else if(lastOperation != '=')
			left = left.subtract(right);
		
		lastOperation = '-';
	}
	
	public static void multiply1(String op)
	{
		right = new BigInteger(op);
		
		if(left.longValue() == 0 || (op.indexOf(left.toString(),0) != -1 && op.length() > left.toString().length()))
			left = right;
		else if(lastOperation != '=')
			left = left.multiply(right);
		
		lastOperation = '*';
	}
	
	public static void divide1(String op)
	{
		right = new BigInteger(op);
		
		System.out.println(left + ", " + right);
		if(left.longValue() == 0 || (op.indexOf(left.toString(),0) != -1 && op.length() > left.toString().length()))
			left = right;
		else if(lastOperation != '=')
			left = left.divide(right);
		
		lastOperation = '/';
	}
	
	public static void add(String op)
	{
		if(lastOperation != '=')
		{
			computedValue += Long.parseLong(op);
			
		}
		else
			computedValue = Long.parseLong(op);
		
		lastOperation = '+';
	}
	
	public static void subtract(String op)
	{
		if(lastOperation != '=')
		{
			if (emptyValue())
				computedValue = Long.parseLong(op);
			else
				computedValue -= Long.parseLong(op);
		}
		else
			computedValue = Long.parseLong(op);
		
		lastOperation = '-';
		
	}
	
	public static void divide(String op)
	{
		if(lastOperation != '=')
		{
			if (emptyValue())
				computedValue = Long.parseLong(op);
			else
				computedValue /= Long.parseLong(op);
		}
		else 
			computedValue = Long.parseLong(op);
		
		lastOperation = '/';
	}
	
	
	public static void multiply(String op)
	{
		if(lastOperation != '=')
		{
			if (emptyValue())
				computedValue = Long.parseLong(op);
			else
				computedValue *= Long.parseLong(op);
		}
		else
			computedValue = Long.parseLong(op);
		
		lastOperation = '*';
	}
	
	public static String compute(String op)
	{
		if (op != "")
			right = new BigInteger(op);
				
		System.out.print("" + left + lastOperation + right + "=");
		switch (lastOperation)
		{
		case '+':
			left = left.add(right);
			break;
		case '-':
			left = left.subtract(right);
			break;
		case '*':
			
			left = left.multiply(right);
			break;
		case '/':
			try{
				
				left = left.divide(right);
			}catch (ArithmeticException e)
			{
				return "0";
			}
			break;
		}
		
		lastOperation = '=';
		System.out.println(left);
		
		return left.toString();
		
	
	}
	
	public static boolean emptyValue()
	{
		return computedValue == 0;
	}
	
	public static void clear()
	{
		left = BigInteger.valueOf(0);
		right = BigInteger.valueOf(0);
		computedValue = 0;
		lastOperation = 'c';
	}


}

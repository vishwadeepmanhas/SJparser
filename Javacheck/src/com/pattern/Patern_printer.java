package com.pattern;

public class Patern_printer {
	
	public void lowerhalfdiamond(int n)
	{
		for(int i=1;i<=n;i++)
		{
			for (int j=1;j<=n;j++)
			
				{
				if(j<i)
				{System .out.print(" ");}
			else 
			{
			System .out.print("* ");
			}
				}
			System.out.println();
		}
	}

	public void upperhalfdiamond(int n)
	{
		for(int i=n;i>=1;i--)
		{
			for (int j=1;j<=n;j++)
			
				{
				if(j<i)
				{System .out.print(" ");}
			else 
			{
			System .out.print("* ");
			}
				}
			System.out.println();
		}
	}


}

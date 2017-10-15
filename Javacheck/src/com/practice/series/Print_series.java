package com.practice.series;

import java.util.ArrayList;

public class Print_series {
	
	public void print_tribonici_series(int n)
	{
		int a=0,b=1,c=2;
		for(int i=0;i<n;i++)
		{
			if (i==0)
			{
				System.out.print(a);
			}
			else if (i==1)
			{
				System.out.print(b);				
			}
			else if(i==2)
			{
				System.out.print(c);
			}
			else 
			{
				System.out.print(a+b+c);
				c=a+b+c;
				b=c-(a+b);
				a=c-(b+a);				
				
				
				
			}
			
		}
	}

	public void print_maximum_P_seq(ArrayList<Integer> Ae)
	{
		int Sum =0;
		int temp=0;
		for(int i=0;i<Ae.size();i++)
		{
			
			if(Ae.get(i)>0)
			{
			 temp+=Ae.get(i);
			 if (Sum<temp)
				 {
				 Sum=temp;
				 }
			}
			else 
			{
				temp=0;
			}
			
		}
		
	System.out.println("Hi this is Sum : "+Sum);
	}
}

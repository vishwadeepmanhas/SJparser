package com.test.arrays;

import java.util.ArrayList;

public class chunkactions {

	public void replacechunks(ArrayList<Object> array,int count,int chunkcount)
	{
		
		if(array!=null)
		{
			
		count = array.size()/chunkcount;
		for(int i=count;i>=1;i--)
		{
			for (int j=chunkcount;j>=1;j--)
			{
			System.out.print(array.get((i*chunkcount)-j)+",");
			}
			
		}
		
		}
	}
}

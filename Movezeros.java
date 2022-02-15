package com.rasheed.app.demo;

public class Movezeros {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = { 10, 0, 3, 0, 5, 68, 9, 0, 0, 0 };
		
		int arrLen= arr.length;
		
		int j=0;
		for(int i=0;i<arr.length;i++)
		{
			if(arr[i]>0)
			{
				arr[j++]=arr[i];		
			}
		
		}
		
	//	System.out.println("len"+j);
		
		int rem = arrLen - j;
		
		while(rem<arrLen)
		{
			arr[rem]=0;
			rem++;
					
		}
		
		for(int i=0;i<arrLen;i++)
		{
			System.out.print(arr[i]+",");
		}
	}

}

package dynamicProgramming;

import java.util.Arrays;

public class Knapsack {
	
	// Using recursion
	// Time Complexity: O(2^n)
	// Space Complexity: O(1)
	static int knapsackRec(int value[], int weight[], int w)
	{
		return knapsackRec(value, weight, w, weight.length);
	}
	
	static int knapsackRec(int value[], int weight[], int w, int n)
	{
		if(w == 0 || n == 0)
			return 0;
		
		if(weight[n-1] > w)
			return knapsackRec(value, weight, w, n-1);
		else
		{
			return Math.max(value[n-1] + knapsackRec(value, weight, w - weight[n-1], n-1) , 
					knapsackRec(value, weight, w, n-1));
		}
	}
	
	// Using memoization and top down approach
	// Time complexity: O(n*w)
	// Space Complexity: O(nw)
	
	static int t[][] = new int [100+1][1000+1];     // The storage    t[n+1][w+1]
	
	
	static int knapsackTD(int value[], int weight[], int w)
	{
		int n = weight.length;
		int t[][] = new int [n+1][w+1];
		//Arrays.fill(t, -1);         will only work for 1d array
		for(int [] arr : t)
			Arrays.fill(arr, -1);
		return knapsackTD(value, weight, w, n, t);
	}
	
	
	static int knapsackTD(int value[], int weight[], int w, int n, int t[][])
	{
		if(w == 0 || n == 0)
			return 0;
		if(t[n][w]!= -1)
			return t[n][w];
		
		if(weight[n-1] > w)
			return t[n][w] = knapsackTD(value, weight, w, n-1, t);
		else
		{
			return t[n][w] = Math.max(value[n-1] + knapsackTD(value, weight, w - weight[n-1], n-1, t) , 
					knapsackTD(value, weight, w, n-1, t));
		}
	}
	
	// DP or Bottom-Up Or Iterative
	// Complexity : same as memoization
	
	static int knapsackDP(int value[], int weight[], int w)
	{
		int n = weight.length;
		int t[][] = new int[n+1][w+1];
		
		
		
		for(int i = 0;i < n+1 ;i++)
		{
			for(int j = 0; j< w+1; j++)
			{
				if(i == 0 || j == 0)             // Initialization
					t[i][j] = 0;
				
				else if(weight[i-1] > j)       //IMP: for weight & value array index always will be [ _ - 1] 
					t[i][j] = t[i-1][j];
				
				else
				{
					t[i][j] = Math.max(t[i-1][j], value[i-1] + t[i-1][j - weight[i-1]]);
				}
			}
		}
		
		return t[n][w];
		
		
	}

	public static void main(String[] args) {
//		int value[] = {60,100, 120};
//		int weight[] = {10, 20, 30};
//		int w = 50;
		
		int value[] = {3, 4, 5, 6};
		int weight[] = {2, 3, 4, 5};
		int w = 5;
		
		System.out.println(knapsackRec(value, weight, w));
		System.out.println(knapsackTD(value, weight, w));
		System.out.println(knapsackDP(value, weight, w));
		
		
		

	}

}

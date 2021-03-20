package binarySearch;

import java.util.Arrays;

// find median in a row wise sorted matrix

public class MedianRowWiseSortedMatrix {
	
	static void solve(int mat[][])
	{
		int row = mat.length;
		int col = mat[0].length;
		
		// finding max and min value in the matrix to set range for bs
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
	
		for(int i=0;i<row;i++)
		{
			min = Math.min(min, mat[i][0]);
			max = Math.max(max, mat[i][col-1]);
		}
		

		int des = (row*col + 1)/2;
		
		while(min < max)
		{
			int smaller = 0;
			int mid = min + (max-min)/2;
			
			for(int i=0;i<row;i++)
			{
				int in = Arrays.binarySearch(mat[i], mid);
				// this method return index if element is found 
				// else it returns -(low + 1) where low is the index of next greater element present in array
				// so it returns the position(index + 1) on which value would be present if inserted in the
				// array
				if(in < 0)
					in = Math.abs(in) - 1;    // count of elements smaller than mid
				else
				{
					// if duplicates present than find the index of last one
					while(in < col && mat[i][in] == mid)
						in++;
					
				}
				
				smaller += in;	
				
			}
			
			if(smaller < des)       // median is greater
				min = mid + 1;
			else
				max = mid;
		}
		
		System.out.println(max);    //max == min, can print anyone
	}

	public static void main(String[] args) {
		
		int m[][] = {
				{1, 3, 5},
				{2, 6, 9},
				{3, 6, 9}
		};
		solve(m);
		
		

	}

}

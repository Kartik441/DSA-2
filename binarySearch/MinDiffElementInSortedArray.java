package binarySearch;

import java.util.Arrays;
// find the index of the number which is closest to the given number key OR
// index of the number which has minimum absolute difference with the key
public class MinDiffElementInSortedArray {
	
	static int solve(int a[], int key)
	{
		// in case element is not present in the array then after the ending of the loop
		// floor of the element is present on high index(j) and ceil is present on the low index
		Arrays.sort(a);
		int i = 0;
		int j = a.length - 1;
		
		while(i<=j)
		{
			int mid = i + (j-i)/2;
			
			if(a[mid] == key)
				return mid;
			
			else if(a[mid] < key)
				i = mid+1;
			else
				j = mid -1;
		}
		
		if(i>=a.length)               // for checking boundary conditions
			return a.length - 1;
		if(j<0)
			return 0;
		
		int diff1 = Math.abs(a[i] - key);
		int diff2 = Math.abs(a[j] - key);
		
		if(diff1 < diff2)
			return i;
		else
			return j;
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a[] = {1, 3, 8, 10, 15};
		int a1[] = {1, 5, 3, 19, 18, 15};
		System.out.println(solve(a, 7));
		System.out.println(solve(a1, 20));
		System.out.println(solve(a1, -2));

	}

}

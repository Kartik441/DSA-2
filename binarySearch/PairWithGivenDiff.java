package binarySearch;

import java.util.Arrays;

// find a pair with a given diff k

public class PairWithGivenDiff {
	// one method is to traverse from left side and for every element find (k - a[i]) on right side
	// using binary search
	// Another method
	// variation of two pointer algorithm to find a pair with a given sum
	static boolean solve(int a[], int k)
	{
		Arrays.sort(a);
		int n = a.length;
		int i=0;
		int j=1;
		
		while(i<n && j < n)
		{
			
			if( i!=j && a[j] - a[i] == k)
			{
				System.out.println(a[j] +" "+ a[i]);
				return true;
			}
			
			else if(a[j] - a[i] < k)
				j++;
			else 
			{
				i++;
				
			}
		}
		return false;
	}

	public static void main(String[] args) {
		int a[] = {5, 20, 3, 2, 50, 80};
		System.out.println(solve(a, 78));
		int a1[] = {90, 70, 20, 80, 50};
		System.out.println(solve(a1, 45));
		int a2[] = {2, 3, 4, 4, 5};
		System.out.println(solve(a2, 0));
	}

}

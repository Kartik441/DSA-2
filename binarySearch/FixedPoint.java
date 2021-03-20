package binarySearch;
// find index where index is equal to value at index in sorted array
public class FixedPoint {
	// this will not work for duplicates
	static int solve(int a[])
	{
		int n = a.length;
		
		int i=0;
		int j = n-1;
		while(i<=j)
		{
			int mid = (i+j)/2;
			
			if(a[mid] == mid)
				return mid;
			else if(a[mid] > mid)      // search on left side
				j = mid-1;
			else
				i = mid+1;
		}
		return -1;
	}

	// for sure arr[5] =3, arr[4] couldn't be magic index bcoz arr[4] must be less than or equal to arr[5]
	// left side: start = start, end = min(arr[midIndex], midIndex-1)
	// right side: start = max(arr[midIndex], midIndex+1], end = end
	// TC : O(n)
	static int solveDupl(int a[], int i,int j)
	{
		
		if(i <= j)		
		{
			int midIndex = (i+j)/2;
			int midValue = a[midIndex];
			if(midIndex == midValue)
				return midIndex;
			// search on left side
			int left = solveDupl(a, i, Math.min(midValue, midIndex-1));
			
			if(left >= 0)     // found the answer
				return left;
			// if didn't found the answer on left side than search on right side
			return solveDupl(a, Math.max(midValue,midIndex+1), j);
			
		}
		return -1;
	}

	public static void main(String[] args) {
		int a[]= {-10, -1, 0, 3, 10, 11, 30, 50, 100};
		System.out.println(solve(a));
		
		int a1[] = {-1, -2, 4, 4, 4}; 
		System.out.println(solveDupl(a1, 0, a1.length-1));
		
		int a2[] = {5, 5, 5, 5, 5, 5};
		System.out.println(solveDupl(a2, 0, a2.length -1));

	}

}

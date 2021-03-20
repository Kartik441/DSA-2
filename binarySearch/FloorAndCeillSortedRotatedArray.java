package binarySearch;

public class FloorAndCeillSortedRotatedArray {   // not in rotated array
	// similarly ceil can also be found
	// a variation is next or previous alphabet
	
	static int floor(int a[], int x)
	{
		int i = 0;
		int j = a.length - 1;
		int ans = -1;
		while(i<=j)
		{
			int mid = i + (j-i)/2;
			if(a[mid] == x)
				j = mid - 1;
			if(a[mid]<x)
			{
				ans = mid;
				i = mid + 1;
			}
			else if(a[mid] > x)
			{
				j = mid - 1;
			}
		}		
		return ans;
	}

	public static void main(String[] args) {
		int a[] = {1, 2, 5, 8, 10, 10, 12, 19};
		System.out.println(floor(a, 5));
		int a1[] = {1, 2, 8, 10, 10, 12, 19};
		System.out.println(floor(a1, 1));
		int a2[] = {1, 2, 8, 10, 10, 12, 19};
		
		System.out.println(floor(a2, 20));

	}

}

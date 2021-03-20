package binarySearch;

public class NoOfTimesArrayIsRotated {
	
	// If array is rotated right side
	
	static int times(int a[])
	{
		// first find the pivot element or minimum element
		// min element is always present in unsorted array
		int i = 0;
		int j = a.length-1;
		int pivot = -1;
		while(i<=j)
		{
			int mid = i + (j-i)/2;
			//System.out.println(mid);
			if(mid!= 0 && mid!= a.length - 1 )
			{
				if(a[mid] < a[mid-1] && a[mid] < a[mid +1])
				{
					pivot = mid;
					break;
				}
				
				else if(a[0] < a[mid])      // Means left side is a sorted array
					i = mid + 1;             // move to right side
				
				else                     // means right side is sorted
					j  = mid - 1;        // move to left side
				// ultimately we move towards unsorted array	
			}
			else
				break;
			
		}
		if(pivot == -1)             // means pivot is at first or last index
		{
			if(a[0] < a[a.length -1])
				pivot = 0;
			else
				pivot =  a.length - 1;
		}
		
		//return a.length - pivot;
		// for right rotation return pivot and change if else conditions
		 return pivot;
	}

	public static void main(String[] args) {
		
		int a[] = {11, 12, 15, 18,20, 82, 85, 2, 5, 6, 8, 9, 10};
		int a1[] = {18, 20, 2, 4, 8, 13, 16};
		int a2[] = {5, 6, 1, 2, 3, 4};
		int a3[] = {1, 2, 3, 4};
		int a4[] = {2, 1};
		int a5[] = {1};
		System.out.println(times(a));
		System.out.println(times(a1));
		System.out.println(times(a2));
		System.out.println(times(a3));
		System.out.println(times(a4));
		System.out.println(times(a5));
	}

}

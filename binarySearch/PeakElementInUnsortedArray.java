package binarySearch;

public class PeakElementInUnsortedArray {
// Concept of binary Search on answer
// function will return only one value if more than one answers are present
// IMP: The same code will work to find max element in bitonic array
	static int solve(int a[])
	{
		int i = 0;
		int j = a.length - 1;
		
		while(i<=j)
		{
			int mid = i+ (j-i)/2;
			if(mid > 0 && mid < a.length - 1)
			{
				if(a[mid] > a[mid-1] && a[mid]> a[mid+1] )      //  checking for peak element
				{
					return mid;
				}		
				else if(a[mid+1] >= a[mid])       // move to right side
				{
					i = mid+1;
				}
				else
				{
					j = mid - 1;
				}
			}
			else
			{
				break;
			}
			
		
			
		}
		if(a[0] > a[1])
			return 0;
		if(a[a.length - 1] > a[a.length - 2])
			return a.length - 1;
		
		return -1;
	}
	public static void main(String[] args) {
		int a[]=  {0, 5, 10, 20, 50};
		int a1[] = {1, 3, 8, 12, 4, 2};
		System.out.println(solve(a));
		System.out.println(solve(a1));

	}

}

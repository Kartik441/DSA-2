package binarySearch;

public class SearchInBitonicArray {
	// Code in progress
	static int search(int a[], int x)
	{
		
		int peak = PeakElementInUnsortedArray.solve(a);
		if(x == a[peak])
			return peak;
		else if(x > a[peak])
			return -1;
		else
		{
			int left = BinarySearch.binarySearch(a, 0, peak, x);
			int right = BinarySearch.binarySearch(a, peak+1, a.length - 1, x);
			if(left == -1&& right == -1)
				return -1;
			if(left == -1)
				return right;
			else 
				return left;
		}
	}

	public static void main(String[] args) {
		int a[] = {1, 3, 8, 12, 4, 2};
		int x = 2;
		System.out.println(search(a, x));

	}

}

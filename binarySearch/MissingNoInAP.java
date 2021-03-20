package binarySearch;

public class MissingNoInAP {
	// given AP series of number in array, find the missing number
	static int missingNo(int a[])
	{
		int n = a.length;
		int i=0;
		int j = n - 1;
		
		int diff = (a[n-1] - a[0]) / a.length;          //  IMP: assumption is that diff will always be integer
		
		
		while(i<j)
		{
			int mid = i + (j-i)/2;
			
			// the a[mid + 1] must exist because we return when low == high and take floor of high - low / 2
			
			if(a[mid] + diff != a[mid+1])
			{
				
				return a[mid] + diff;
			}
			
			if(mid > 0 && a[mid - 1] + diff != a[mid])
			{				
				return a[mid-1] + diff;
			}
			// if element till mid follows ap than move to right
			
			if(a[mid] == a[0] + mid * diff)             // aN = a + (N-1)*d
			{
				i = mid+1;
			}
			else
				j = mid - 1;
			
		}
		
		return Integer.MAX_VALUE;
	}

	public static void main(String[] args) {
		int a[] = {1, 6, 11, 16, 21, 31};
		int a1[] = {2, 4, 8, 10, 12, 14};
		System.out.println(missingNo(a1));
		System.out.println(missingNo(a));
	}

}

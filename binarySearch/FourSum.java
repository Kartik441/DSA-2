package binarySearch;

public class FourSum {
	// find four pairs that sum to a given value
	
	// 1 approach
	static void solve(int a[], int sum)
	{
		int n = a.length;
		
		for(int i=0;i<n;i++)
		{
			for(int j=i+1;j<n;j++)
			{
				// instead of third loop we could have used two sum algorithm
				// which can reduce complexity to n^3
				for(int k=j+1;k<n;k++)
				{
					// first element is i, second is j and third is k
					// now find fourth using binary search
					int l = BinarySearchIterative.binarySearch(a, n, (sum - (a[i] + a[j] + a[k])), k+1);
					if( l != -1)
					{
						System.out.println(a[i]+" "+a[j]+" "+a[k]+" "+a[l]);
					}
				}
			}
		}
		//System.out.println("Not found");
		
	}

	public static void main(String[] args) {
		int a[] = {10, 2, 3, 4, 5, 9, 7, 8};
		solve(a, 23);
		
		int a1[] = {1, 2, 3, 4, 5, 9, 7, 8};
		solve(a1, 16);

	}

}

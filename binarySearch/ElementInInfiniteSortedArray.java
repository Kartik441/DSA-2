package binarySearch;

public class ElementInInfiniteSortedArray {
	
	static int search(int a[], int x)
	{
		// first find the end index
		
		int i = 0;
		int j = i+1;
		while(true)
		{
			if(x >= a[i] && x <= a[j])
				break;
			else
				j = j*2;
		}
		
		// now use normal binary search to find element
		int ans = -1;
		while(i<=j)
		{
			int mid = i+(j-i)/2;
			if(a[mid] == x)
			{
				ans = mid;
				break;
			}
			
			else if(x< a[mid] )
			{
				j = mid -1;
			}
			else
				i = mid +1;
		}
		return ans;
	}

	public static void main(String[] args) {
		int arr[] = {3, 5, 7, 9, 10, 90, 100, 130, 140, 160, 170};
		System.out.println(search(arr, 10));

	}

}

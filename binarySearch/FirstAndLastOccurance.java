package binarySearch;

// a variation could be to find total count of an element

public class FirstAndLastOccurance {
	
	static int first(int a[], int x)
	{
		int i = 0;
		int j = a.length - 1;
		int first = -1;
		while(i<=j)
		{
			int mid = i + (j - i)/2;     // start + (end - start)/2;
			
			if(a[mid] == x)
			{
				first = mid;
				j = mid - 1;          // for last occurance i = mid+1
			}
			
			else if(a[mid] > x)   
			{
				j = mid -1;
			}
			
			else
			{
				i = mid +1;
			}
		}
		
		return first;
	}
	
	
	// last occurance
	static int last(int a[], int x)
	{
		int i = 0;
		int j = a.length - 1;
		int last = -1;
		while(i<=j)
		{
			int mid = (i+j)/2;
			
			if(a[mid] == x)
			{
				last = mid;
				i = mid + 1;          // for last occurance i = mid+1
			}
			
			else if(a[mid] > x)   
			{
				j = mid -1;
			}
			
			else
			{
				i = mid +1;
			}
		}
		
		return last;
	}
	
	// for counting no.  of elements
	static int count(int a[], int x)
	{
		return last(a, x) - first(a, x) + 1;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {2, 4, 10, 10, 10, 10, 10, 18, 20};
		System.out.println(first(arr, 10));
		System.out.println(count(arr, 10));

	}

}

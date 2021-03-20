package binarySearch;
// find the element that occurs more than n/2 times if it exists

public class MajorityElement {
	// one method is to sort the array and check the freq of the middle element 
	// because if majority exists than that element will definitely be at mid after sorting
	// TC : o(nlogn + n)
	
	// can also be solved using hashmap
	// TC : O(n)
	// SC : O(n)
	
	// using moore's voting algorithm
	// TC : O(n)
	// SC : O(1)
	static void solve(int a[])
	{
		int n = a.length;
		// find the candidate
		// assuming first element as the candidate
		int major = a[0];       
		int count = 1;
		for(int i=1;i<n;i++)
		{  
			if(a[i] == major)
			{
				count++;
			}
			else
				count--;
			
			if(count == 0)
			{
				major = a[i];
				count = 1;
			}
	
		}
		// checking if candidate is major element 
		count = 0;
		for(int i:a)
			if(i == major)
				count++;
		if(count > (n/2))
			System.out.println(major);
		else 
			System.out.println("Majority element not present");
	}

	public static void main(String[] args) {
		int a[] = {5, 2, 7, 3, 7, 2, 7, 7, 7 };
		solve(a);
	
	}

}

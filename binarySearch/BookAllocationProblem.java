package binarySearch;

public class BookAllocationProblem {
	// minimize the maximum number of pages read by a student
	// The same code can be used to solve painters partition problem
	
	static void binarySearchBooks(int books[],int n,int k)   //n is size of array
	{															  //k is the no. of students
		// start should be the max in an array
		int start=0;
		int end=0;
		for(int i=0;i<n;i++)
		{
			end+=books[i];
		}
		int finalAns=end;
		while(start<=end)
		{
			int mid=(start+end)/2;
			//System.out.println("mid "+mid);
			if(isValid(books,n,k,mid))
			{
				end=mid-1;
				finalAns=mid;
				//System.out.println(finalAns +" i&j"+start+" "+end);
			}
			else
			{
				start=mid+1;
			}
		}
		System.out.println(finalAns);
		
	}
	
	static boolean isValid(int books[], int n,int k, int ans)
	{
		// a student can read at most ans pages
		int students = 1;
		int currPages = 0;
		
		for(int i=0;i<n;i++)
		{
			if(currPages + books[i] <= ans)       // can read this book as well
			{
				currPages += books[i];
			}
			else
			{
				students++;
				
				currPages = books[i];
				if(currPages > ans)
					return false;
				
				if(students > k)
					return false;
				
			}
		}
		
		
		return true;
	}
	
//	static boolean isValid(int books[], int n,int k,int ans)
//	{
//		int students=1;
//		int currPages=0;
//		for(int i=0;i<n;i++)
//		{
//			if(currPages+books[i]<=ans)
//				currPages+=books[i];
//			else
//			{
//				students++;
//				currPages=0;
//				currPages+=books[i];
//				
//				if(currPages > ans)
//					return false;
//				
//			}
//			if(students>k)
//				return false;
//		}
//		if(students < k)
//			return false;
//		
//		return true;
//	
//	}	

	public static void main(String[] args) {
		int books[]= {12,34,67,90};
		int books1[] = {10, 20, 30, 40};
		binarySearchBooks(books,books.length,2);
		binarySearchBooks(books1,books1.length,2);
		
		// Painters partition cases
		int a[] = {10, 10, 10, 10};
		int k=2;
		binarySearchBooks(a,a.length,k);
		
		int a1[] = {10, 20, 30, 40};
		binarySearchBooks(a1,a1.length,2);

	}

}

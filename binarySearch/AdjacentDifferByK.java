package binarySearch;

// search in an array where adjacent differs by at most k
// diff = curr - x
// x must be at least x distance away (diff/k), so we jump (diff/k)

public class AdjacentDifferByK {
	
	static int solve(int a[],int k, int x)
	{
		int n = a.length;
		int i=0;
		
		while(i<n)
		{
			//System.out.println("i "+i);
			if(a[i] == x)
				return i;
			// 1 is used in max to make sure that i moves at least by one 
			// when other value is 0
			//i = i + Math.max(1, Math.abs(a[i] - x)/k);
			i = i + Math.max(1, (int)Math.ceil((double) Math.abs(a[i] - x)/k));
		}
		return -1;
	}

	public static void main(String[] args) {
		int a[]= {4, 5, 6, 7, 6};
		System.out.println(solve(a, 1, 6));
		
		int a1[] = {20, 40, 50, 70, 70, 60};
		System.out.println(solve(a1, 20, 60));		
		//System.out.println((float)50/20);
		int a2[] = {0, 20, 40, 50};
		System.out.println(solve(a2, 20, 50));
		
		//System.out.println(Math.floor((double)50/20) == Math.ceil((double)50/20));
		
		
	}
	
}

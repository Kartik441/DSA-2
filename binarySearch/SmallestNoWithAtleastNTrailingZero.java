package binarySearch;

public class SmallestNoWithAtleastNTrailingZero {
	// Brutefore : calculate factorial of a number and count its trailing zeroes by dividing with 10 in loop
	
	// Optimized approach:
	// zero is created when a number is multiplied by 10 OR 2*5
	// in prime factor of a number 2 are going to be more than or equal to count of 5.
	// So counting number of 5s is enough 
// No of zeroes is equal to number of 5s in prime factors of x!
// Trailing 0s in x! = Count of 5s in prime factors of x!
//                   = floor(x/5) + floor(x/25) + floor(x/125)+....
	
	
	static int number(int n)  // here n means zeroes
	{
		if(n == 1)
			return 5;
		
		int start = 0;
		int end = 5*n;
		int ans = 0;
		// binary search
		while(start <= end )
		{
			int mid = start + (end - start)/2;
			
			if(isValid(mid, n)) // in search space we can only have less or equal zeroes
			{
				end = mid - 1;
				ans = mid;
			}
			else
				start = mid + 1;
			
		}
		return ans;
	}
	
	static boolean isValid(int ans, int n)
	{
//		int temp = ans;
//		int count =0;
//		int f = 5;
//		
//		while(f<=temp)
//		{
//			count += temp/f;
//			f = f*5;
//		}
//		
		int zero_count = 0;
		int denominator = 5;
		while((ans/denominator) > 0)
		{
			zero_count += (ans/denominator);
			denominator *= 5;
		}
	
		if(zero_count >= n)
			return true;
		else
			return false;
	}
	// return number of trailing zeroes for a number
	static void findZeroes(int n)
	{
		int ans = 0;
		int denominator = 5;
		while((n/denominator) > 0)
		{
			ans += (n/denominator);
			denominator *= 5;
		}
		System.out.println(ans);
	}
	
	public static void main(String[] args) {
		System.out.println(number(6));
		// for 5 it will give 25 but five zeroes are actually not present in any factorial
		findZeroes(100);
		

	}

}

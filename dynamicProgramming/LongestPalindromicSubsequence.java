package dynamicProgramming;


public class LongestPalindromicSubsequence {
	
	static int LPS(String x)
	{
		// Reverse the string
		StringBuilder y =new StringBuilder();
		y.append(x);
		y = y.reverse();
		
		// Now find lcs
		int m = x.length();
		int n = y.length();
		
		int t[][] = new int [m+1][n+1];
		
		for(int i = 0; i< m+1;i++)
		{
			for(int j = 0; j< n+1; j++)
			{
				// Initialization
				if(i == 0 || j == 0)
					t[i][j] = 0;
				
				else if(x.charAt(i - 1) == y.charAt(j - 1))
					t[i][j] = 1 + t[i-1][j-1];
				
				else
					t[i][j] = Math.max(t[i-1][j], t[i][j-1]);
				
				
			}
		}
		 
		return t[m][n];
		
		// For minimum no of deletion to make it a palindrome
		// JUST APPEND THIS CODE:
		
		//  For minimum no of insertion to make it a palindrome also because deletion = insertion
		
//		return m - t[m][n];
	}

	public static void main(String[] args) {
		String x = "AGBCBA";
		
		String y = "GEEKSFORGEEKS";
		
		System.out.println(LPS(x));
		
		System.out.println(LPS(y));
		
		System.out.println(LPS("abb"));
		
		System.out.println(LPS("abacdfgdcaba"));

	}

}

package dynamicProgramming;

public class LongestCommonSubstring {
	
	static int LCS(String x, String y)
	{
		int m = x.length();
		int n = y.length();
		
		int a = -1;         // For finding cell of max length to print string
		int b = -1;
		
		int t[][] = new int [m+1][n+1];
		
		int max = 0;
		
		for(int i = 0; i< m+1;i++)
		{
			for(int j = 0; j< n+1; j++)
			{
				// Initialization
				if(i == 0 || j == 0)
					t[i][j] = 0;
				
				else if(x.charAt(i - 1) == y.charAt(j - 1))
				{
					t[i][j] = 1 + t[i-1][j-1];
					if(t[i][j] > max)
					{
						a = i;
						b = j;
						max = t[i][j];
					}
					
				}
				
				else
					t[i][j] = 0;
				
				
			}
		}
		
		int i = a;
		int j = b;
		String ans="";
		while(i>0 && j>0)
		{
			if(x.charAt(i-1) == y.charAt(j-1))
			{
				ans = x.charAt(i-1) + ans; 
				i = i-1;
				j = j-1;
			}
			
			else
			{
				
				break;
			}
		}
		
		System.out.println(ans);
		
		return max;
	}
	

	public static void main(String[] args) {
		
//		String x = "zxabcdezy";
//		String y = "yzabcdezx";
//		
//		System.out.println(LCS(x,y));
		
		String s ="ababsshjgkinniksregmagamg";
		StringBuilder rev = new StringBuilder();
		rev.append(s);
		rev = rev.reverse();
	
		System.out.println(LCS("abacdfgdcaba", "abacdgfdcaba"));

	}

}

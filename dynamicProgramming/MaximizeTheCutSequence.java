package dynamicProgramming;
// given a rod of length l, the task is to cut the rod in such a way that the total number of segments
// of length p, q and r is maximized. The segments can only be of length p, q and r
public class MaximizeTheCutSequence {
	// same code as min Coin change problem
	static int solve(int []coin, int sum)
	{
		int n = coin.length;
		int t[][] = new int[n+1][sum+1];
		
		
		for(int i = 0;i<n+1;i++)
		{
			for(int j =0 ;j<sum+1;j++)
			{
				// Initialization
				if(i ==0 || j==0 || i==1) {
					if(i==0)
						t[i][j] = Integer.MIN_VALUE;  // Used min instead instead of max
					if(j == 0)
						t[i][j] = 0;
					if(i == 1)
					{
						if(coin[i-1] > j)
							t[i][j] = Integer.MIN_VALUE;
						else if(j % coin[i-1] == 0)
							t[i][j] = j/coin[i-1];
						else
							t[i][j] = Integer.MIN_VALUE;		
					}
				}
				// End of Initialization
				else {
					if(coin[i-1] > j)
						t[i][j] = t[i-1][j];
					else
						t[i][j] = Math.max(t[i-1][j], 1+t[i][j - coin[i-1]]);
				}
			}
		}
		
		return t[n][sum];
	}

	public static void main(String[] args) {
		int a[] = {2, 3, 5};
		System.out.println(solve(a, 11));
		
		int a1[] = {2, 5, 5};
		System.out.println(solve(a1, 7));

	}

}

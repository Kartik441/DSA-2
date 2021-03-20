package binarySearch;

import java.util.Arrays;

public class RotiPrataSpoj {
	// rank array denotes ratings of each cook
	// each cook cooks first prata in r min, second prate in 2r and so on
	// find min time required to make par parathas
	static int  minTime(int rank[], int par)
	{
		// rank array should be sorted
		Arrays.sort(rank);
		int start = 0;
		int end = -1;
		int maxR = 0;
		
		// since array is sorted, maxR is going to be at last of array
		maxR = rank[rank.length-1];
		int ans = -1;
		// if the chef having maximum rating makes all paratas
		end = maxR * ((par*(par+1))/2);
		
		while(start <= end)
		{
			int mid = start +(end - start)/2;
			
			if(isPossible(rank, par, mid))
			{
				ans = mid;
				end = mid - 1;
			}
			else
				start = mid+1;
		}
		return ans;
	}
	
	static boolean isPossible(int rank[], int par, int ans)
	{
		int parMade = 0;
		int time = 0;
		// first allowing chef with lowest rating to cook pratas and when time exceeds than we
		// take another chef to cook prata who will cook in parallel with first chef and so on..
		for(int i=0;i<rank.length;i++)
		{
			int count = 1;
			time = 0; // initaialising time 0 because every cook will cook prata parallely
			//System.out.println(parMade);
			while(time < ans)
			{
				if(time + count*rank[i] <= ans)
				{
					time += count * rank[i];
					parMade++;
					count++;
					if(parMade >= par)
						return true;
				}
				else
					break;         // go for the next cook
			}
		}
		return false;
	}

	public static void main(String[] args) {
		int rank[] = { 1, 2, 3, 4};
		System.out.println(minTime(rank, 10));
		int rank1[] = {1};
		System.out.println(minTime(rank1, 8));
		int rank2[]= {1, 1, 1, 1, 1, 1, 1, 1};
		System.out.println(minTime(rank2, 8));
		

	}

}

package binarySearch;

public class AggressiveCows {
	
	static void binarySearchCows(int dist[],int n,int cows)
	{
		int start=0;
		int end=dist[n-1]-dist[0];
		int finalAns=0;
		while(start<=end)
		{
			int mid=(start+end)/2;
			if(isValid(dist,dist.length,cows,mid))
			{
				finalAns=mid;
				start=mid+1;
			}
			else
			{
				end=mid-1;
			}
		}
		System.out.println(finalAns);
		
	}
	
	static boolean isValid(int dist[], int n, int cows, int ans)
	{
		int cowPlaced = 1;      // placing first cow at first index
		int currDist = 0;
		
		for(int i=1;i<n;i++)
		{
			if(currDist+(dist[i] - dist[i-1]) < ans)     // cow cannot be placed because of less distance
			{
				currDist += dist[i] - dist[i-1];
			}
			else         // place the cow at this index
			{
				cowPlaced++;
				currDist = 0;
				if(cowPlaced == cows)   // if all cows are placed than return true
					return true;
			}
		}
		return false;
	}
	
//	static boolean isValid(int dist[],int n,int cows,int ans)
//	{
//		int cowPlaced=1;
//		int currDist=0;
//		for(int i=0;i<n-1;i++)
//		{
//			if(currDist+(dist[i+1]-dist[i])<ans)        // means we cannot place the cow because gap is less
//				currDist+=dist[i+1]-dist[i];
//			else
//			{
//				cowPlaced++;
//				currDist=0;
//			}
//			
//		}
//		if(cowPlaced<cows)
//			return false;
//		else
//			return true;
//		
//	}

	public static void main(String[] args) {
		
		int dist[]= {5,11,17,100};
		int dist1[] = {1, 2, 4, 8, 9, 12, 16};
		binarySearchCows(dist,dist.length,2);
		binarySearchCows(dist1,dist1.length,4);
		

	}

}

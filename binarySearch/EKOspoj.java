package binarySearch;

// cut at least m metres of wood without cutting any extra wood
// output should br the optimal sawblade length
public class EKOspoj {

	static void binarySearchEKO(int []height,int m)
	{
		int n=height.length;
		int start=0;
		int end=height[n-1];
		int ans=0;
		while(start<=end)
		{
			int mid=(start+end)/2;
			if(isfeasable(height,n,m,mid))
			{
				ans=mid;
				start=mid+1;
			}
			else
				end=mid-1;
		}
		System.out.println(ans);
	}
	
	static boolean isfeasable(int []height,int n,int m,int ans)
	{
		int woodCollected=0;
		for(int i=0;i<n;i++)
		{
			if(height[i]>ans)
				woodCollected+=(height[i]-ans);

			if(woodCollected>=m)
				return true;
		}
		return false;
	}
	public static void main(String[] args) {
		int height[]= {1,2,3,4,5,6,7};
		int height1[] = {20, 15, 10, 17};
		int height2[] = {4, 42, 40, 26, 46};
		binarySearchEKO(height,8);
		binarySearchEKO(height1,7);
		binarySearchEKO(height2,20);
	}

}

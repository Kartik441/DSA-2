package binarySearch;

public class BinarySearchIterative {
	static int binarySearch(int []a,int n,int x,int i)
	{
		int l=i;
		int r=n-1;
		while(l<=r)
		{
			int mid=(l+r)/2;
			if(a[mid]==x)
				return mid;
			else if(x<a[mid])
			{
				r=mid-1;
			}
			else
			{
				l=mid+1;
			}
		}
		
		return -1;
	}
	
	
	public static void main(String args[])
	{
		int a[]= {1,2,3,4,5,6,7,8,9,10};
		int n=a.length;
		//BinarySearchIterative obj=new BinarySearchIterative();
		int k=binarySearch(a, n, 10, 0);
		System.out.println(k);
		
	}

}

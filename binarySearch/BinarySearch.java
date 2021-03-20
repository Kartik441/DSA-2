package binarySearch;

public class BinarySearch {
	static int binarySearch(int a[],int l,int r,int x)
	{
		
		if(l<=r)
		{
			
			int mid=(l+r)/2;
			
			if(a[mid]==x) 
				return mid;
			else if(x<a[mid])//&&mid!=0)
			{
				return binarySearch( a,l,mid-1,x );
			}
			else
			{
				return binarySearch(a,mid+1,r,x);
				
			}
		}
		
		return -1;
	}
	

	public static void main(String []args)
	{
		
		int a[] = {4, 2};
		int n=a.length;
		int k=binarySearch(a, 0, n-1, 2);
		
		System.out.println(k);
		

	}

}

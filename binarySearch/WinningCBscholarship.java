 package binarySearch;

public class WinningCBscholarship {
	
	static void binarySearchScholarship(int n,int m,int x,int y)
	{
		//Search Space is the no. of students
		int start=0;
		int end=n;
	    int ans=0;
	    while(start<=end)
	    {
	    	int mid=(start+end)/2;
	    	if(isfeasable(n,m,x,y,mid))
	    	{
	    		ans=mid;
	    		start=mid+1;
	    		
	    	}
	    	else
	    		end=mid-1;
	    }
	    System.out.println(ans);
	}
	
	static boolean isfeasable(int n,int m,int x,int y,int ans)
	{
		if(  ans*x<=m+((n-ans)*y)  )
				return true;
		else
			return false;
	}

	public static void main(String[] args) {
		binarySearchScholarship(3,10,4,2);

	}

}

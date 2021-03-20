package binarySearch;

public class MedianTwoSortedArrays {
	
	// arrays of different size
	
	static float median(int a1[], int a2[])
	{
		int x = a1.length;
		int y = a2.length;
		
		int i = 0;
		int j =x;
		
		boolean isEven = false; 
		if((x + y) % 2 == 0)
			isEven = true;
		else
			isEven = false;
		
		while(i<=j)
		{
			int xPartition = (i+j)/2;         // these many element on left side of x
			
			int yPartition = (x+y+1)/2 - xPartition;

			int xleft;
			int xright;
			
			if(xPartition == 0)
				xleft = Integer.MIN_VALUE;
			else
				xleft = a1[xPartition-1];
			
			if(xPartition == x)
				xright = Integer.MAX_VALUE;
			else 
				xright = a1[xPartition];
			
			int yleft = a2[yPartition-1];
							
			int yright = a2[yPartition];
			
			if(xleft <= yright && yleft <= xright)
			{
				if(isEven)
				{
					return (float)(Math.max(xleft, yleft) + Math.min(xright, yright))/2; 
				}
				else
					return Math.max(xleft, yleft);
			}
			
			else if(xleft > yright)
			{
				j = xPartition-1;
			}
			else
			{
				i=xPartition+1;
			}
			
		}
		return -1;
	}

	public static void main(String[] args) {
		int x[] = {2, 3, 5, 8};
		int y[] = {10, 12, 14, 16, 18, 20};
		System.out.println(median(x, y));
		
		int a1[] = {1, 3, 8, 9, 15};
		int a2[] = {7, 11, 18, 19, 21, 25};
		System.out.println(median(a1, a2));
		
		int a3[] = {23, 26, 31, 35};
		int a4[] = {3, 5, 7, 9, 11, 16};
		System.out.println(median(a3, a4));
		
		int a5[] = {1, 2, 3};
		int a6[] = {6, 7, 90, 456};
		System.out.println(median(a5, a6));
		
		int a7[] = {-5, 3, 6, 12, 15};
		int a8[] = {-12, -10, -6, -3, 4, 10};
		System.out.println(median(a7, a8));
		}

	}



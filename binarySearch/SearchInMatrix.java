package binarySearch;

// search in row-coumn wise sorted matrix

public class SearchInMatrix {
	
	static void search(int mat[][], int x)
	{
		int r = mat.length;
		int c = mat[0].length;
		
		int i = 0;
		int j = c-1;
		
		while((i>=0 && i<r) && (j>=0 && j<c))
		{
			if(mat[i][j] == x)
			{
				System.out.println("Element found at "+i+" "+j);
				return;
			}
			
			else if(x > mat[i][j])
			{
				i++;
			}
			else
			{
				j--;
			}
			
			
		}
					
		System.out.println("Element not found");
			
		
	}

	public static void main(String[] args) {
		int mat[][]= {
				{10, 20, 30, 40},
				{15, 25, 35, 45},
				{27, 29, 37, 48},
				{32, 33, 39, 50}
		};
		
		search(mat, 29);
		search(mat, 100);

	}

}

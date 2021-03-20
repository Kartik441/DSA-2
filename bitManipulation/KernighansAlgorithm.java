package bitManipulation;
// count all set bits in an integer
public class KernighansAlgorithm {
	
	// right most set bit mask of x = x & (2s compliment of x)
	
	// x = A 1's & 0s....1....B 0s
	// 1's compliment OR ~x = A 0s and 1s..0..B 1s
	// 2's compliment OR ~x+1 = A 0s and 1s.1..B 0s
	// rsb OR x&x`` = A 0s.. 1..B 0s
	
	
	static void rsbm(int n)  
	{
		int rsbm = n & -n;
		// 2s compliment is same as negative of a number
		System.out.println(Integer.toBinaryString(rsbm));
	}
	
	// kerninghan's algorithm is used to calculate count of set bits which uses rsbm
	
	static void count(int n)
	{
		int count = 0;
		while(n != 0)
		{
			int rsbm = n & -n;
			n -= rsbm;
			count++;
		}
		System.out.println(count);
	}

	public static void main(String[] args) {
		rsbm(72);
		count(567);
	}

}

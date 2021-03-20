package bitManipulation;
// given two numbers a and b, and left boundary and right boundary toggle the bits of b to which a corresponds
// 1 in a given range
// also known as copy set bits in a range
public class ToggleBitsInRange {
	
	static void solve(int a, int b, int left, int right)
	{
		int mask = (1 << right - left + 1);
		mask--;
		mask = (mask << (left - 1));
		
		mask = mask & a;
		b = b | mask;
		
		System.out.println(b);
	}

	public static void main(String[] args) {
		

	}

}

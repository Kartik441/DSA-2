package binarySearch;

// given a set of points as and a line as ax+by+c = 0
// we need to find location of points to minimize total distance of all points from point on the line

public class OptimumLocationOfPoint {
	static class point
	{
		int x;
		int y;
		point(){};
		
		public point(int x, int y)
		{
			this.x = x;
			this.y = y;
		}
	}
	static class line
	{
		int a;
		int b;
		int c;
		
		public line(int a, int b, int c)
		{
			this.a = a;
			this.b = b;
			this.c = c;
		}
	}
	static int EPS = (int) (1e-9) + 1;
	static double solve(int points[][], line l)
	{
		int n = points.length;
		point []p = new point[n];
		for(int i=0;i<n;i++)
		{
			p[i] = new point(points[i][0], points[i][1]);
		}
		return solveUtil(p, n, l);
	}
	
	static double solveUtil(point p[], int n, line l)
	{
		double low = -1e6;
		double high = 1e6;
		
		while((high - low) > EPS)
		{
			double mid1 = low + (high - low)/3;
			double mid2 = high - (high - low)/3;
			
			double dist1 = compute(p, n, l, mid1);
			double dist2 = compute(p, n, l, mid2);
			
			if(dist1 < dist2)
				high = mid2;
			else
				low = mid1;
		}
		return compute(p, n, l, (low+high)/2);
	}
	
	static double compute(point p[], int n, line l, double x)
	{
		double res = 0;
		double y = -1*(l.c + l.a * x)/l.b;
		for(int i=0;i<n;i++)
		{
			res += Math.sqrt((x - p[i].x)*(x - p[i].x) +  (y-p[i].y)*(y-p[i].y));
		}
		return res;
	}

	public static void main(String[] args) {
		line l = new line(1, -1, -3);
		int points[][] = {{-3, -2}, {-1, 0}, {-1,2}, {1, 2}, {3, 4}}; 
		System.out.println(solve(points,l));

	}

}

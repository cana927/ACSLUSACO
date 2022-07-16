import java.util.*;
/*
6 8 1 5 2 3 5 3 7 9
7 6 2 9
9 3 4 6 1 8 6 4 2 8 4 
 
1 3 5 7 9 2 4 6 8 10
5 2 6 4 8 7 9 11 14 12
4 2 6 4 7 1 9 22 21 9

5 6 7 8 9 1 2 
9 8 7 6 5 0 1 2 3 4
8 6 4 2 1 3 5 7

1
1 2
1 2 3

31 41 59 26 53 58 97 93 23 84 62 64 33 83 27 
56 89 23 14 26 37 48 59 61 72 83 94
42 35 68 79 82 91 20 51 64 97 86
 */
public class _2021jrc3 {
	static Scanner sc;
	static String one;
	static String two;
	static String three; 
	static int output;
	static StringTokenizer a;
	static StringTokenizer b;
	static StringTokenizer c;
	
	
	public static void main (String [] args)  {
		init();
		solve();
		output();
	}
	public static void init () {
		sc = new Scanner (System.in);
		one = sc.nextLine();
		two = sc.nextLine();
		three = sc.nextLine();
		output = 0;
		
		a = new StringTokenizer(one);
		b = new StringTokenizer(two);
		c = new StringTokenizer(three);
	}
	public static void solve() {
		int size = Math.max (one.length(), Math.max(two.length(), three.length()));
		for (int i =0; i<size/2+1; i++) {
			int onei = 0;
			int twoi = 0;
			int threei = 0;
			if (a.hasMoreTokens()) {
				onei = Integer.valueOf(a.nextToken());
			}
			if (b.hasMoreTokens()) {
				twoi = Integer.valueOf(b.nextToken());
			}
			if (c.hasMoreTokens()) {
				threei = Integer.valueOf(c.nextToken());
			}
			output+= Math.max(onei, Math.max(twoi, threei));
		}
	}
	public static void output () { 
		System.out.println (output);
	}
	
}

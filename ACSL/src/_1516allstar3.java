import java.util.*;
import java.io.*;

public class _1516allstar3 {
	static int dividend, divisor;
	static ArrayList <Integer>  twos;
	static Scanner sc = new Scanner (System.in);
	static String out;
	
	public static void main (String [] args) {
		for (int i=0; i<10; i++) {
			init();
			solve();
			output();
		}
	}
	
	public static void init() {
		String str = sc.next();
		int one = Integer.parseInt(str.substring(0, str.length()-1));
		int two = sc.nextInt();
		if (one > two) {
			divisor = two;
			dividend = one;
		} else {
			divisor = one;
			dividend = two;
		}
		twos = new ArrayList <Integer> ();
		out = "";
		
	}
	
	public static void solve () {
		int curr = dividend;
		
		while (curr >0) {
			int r = 0;
			while (curr >= Math.pow(2, r)) {
				r++;
			}
			r--;
			twos.add((int) Math.pow(2, r));
			curr -= Math.pow(2, r);
		}
		
		if (twos.size()!=1) {
			for (int i=0; i<twos.size()-1; i++) {
				out = out + twos.get(i)*divisor + ", ";
			}
			out = out + twos.get(twos.size()-1)*divisor;
		} else {
			out = "" + twos.get(0) * divisor;
		}
	}
	
	public static void output () {
		System.out.println (out);
	}
}

/*
25, 7
36, 8
80, 12
135, 10
25, 600
18, 12
75, 15
24, 96
8, 36
250, 60

44, 11
200, 10
5, 1
63, 31
12, 4
1, 15
45, 76
688, 812
78, 35
64, 128

*/
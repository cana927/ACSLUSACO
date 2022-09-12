import java.util.*;
/*
4 6 8 1 5 6 3 5 1 1
10 24 32 8 4 4 4 3 5
10 22 32 8 7 4 4 3 5 5 5 6
17 20 27 16 7 3 5 4 6 5 1 4
43 46 50 40 5 3 1 2 4 4

 */

public class _1920jrc4 {
	static Scanner sc = new Scanner (System.in);
	static int l1, l2, l3;
	static int r;
	static int [] rolls;
	
	static int output;
	
	public static void main (String [] args) {
		for (int i =0; i<5; i++) {
			init();
			solve();
			output();
		}
		
	}
	
	public static void init() {
		
		l1 = sc.nextInt();
		l2 = sc.nextInt();
		l3 = sc.nextInt();
		output = sc.nextInt();
		r = sc.nextInt();
		rolls = new int [r];
		for (int i = 0; i<r; i++) {
			rolls [ i] = sc.nextInt();
		}
	}
	public static void solve() {
		for (int i =0; i<r; i++) {
			output = check (output, rolls[i]);
		}
	}
	public static void output () {
		if (output == -1) {
			System.out.println ("GAME OVER");
		}
		else {
			System.out.println( output);
		}
	}
	
	public static int check (int t, int r) {
		if (t+ r == l1|| t+ r==l2|| t+r==l3) {
			return t;
		}
		else if (t+r == 52) {
			return -1; 
		}
		else if (t+r >52) {
			return t;
		}
		else if (prime(t+r)) {
			for (int i =1; i<7; i++) {
				if (t+r+i == l1 || t+r+i == l2 ||t+r+i == l3) {
					return t+r+i-1;
				}
			}
			return t+r+6;
		}
		else if (square(t+r)) {
			for (int i =1; i<7; i++) {
				if (t+r-i == l1 || t+r-i == l2 ||t+r-i == l3) {
					return t+r-i+1;
				}
			}
			return t+r-6;
		}
		else if (hortvert(t, r)) {
			for (int i = t+1 ; t<53; i++) {
				if (i % r == 0) {
					return i;
				}
			}
			return t;
		}
		
		return t+r;
	}
	
	public static boolean prime (int e) {
		int w = -1; 
		for (int i = 2; i<27; i++) {
			if (e % i == 0 && i!=e) {
				w++;
			}
		}
		return w<0; 
	}
	
	public static boolean hortvert (int t, int r) {
		for (int i = 1; i<r; i++) {
			if (t+i == 7|| t+i == 12|| t+i == 17|| t+i == 22|| t+i == 26|| t+i == 35|| t+i == 40|| t+i == 45|| t+i == 50) {
				return true;
			}
		}
		return false;
	}
	
	public static boolean square (int e) {
		if (e>4) {
			int low = (int)Math.sqrt (e);
			int high = low + 1;
			if (low*low == e || high*high==e) {
				return true;
			}
		}
		return false;
	}
}

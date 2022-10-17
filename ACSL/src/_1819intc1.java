import java.util.*;
import java.io.*;

public class _1819intc1 {
	static String number;
	static int n;
	static long output;
	static Scanner sc = new Scanner (System.in);
	
	public static void main (String [] args) {
		for (int i=0; i<5; i++) {
			init();
			solve();
			output();
		}
	}
	public static void init() {
		number =sc.next(); 
		n = sc.nextInt();
		output = 0;
	}
	public static void solve() {
		String curr = "";
		for (int i = 0; i< n; i++) {
			curr += number.charAt(i);
		}
		output += Long.parseLong(curr);
		for (int i =n; i<number.length(); i++) {
			curr = curr.substring(1);
			curr += number.charAt(i);
			output += Long.parseLong(curr);
		}
	}
	public static void output () {
		System.out.println (output);
	}
}

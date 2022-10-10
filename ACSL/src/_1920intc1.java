import java.util.*;
import java.io.*;

public class _1920intc1 {
	static int p;
	static String n;
	static String output;
	static Scanner sc= new Scanner (System.in);
	
	public static void main (String [] args) {
		for (int i=0; i<5; i++) {
			init();
			solve();
			output();
		}
	}
	public static void init() {
		n = sc.next();
		p = sc.nextInt();
		output = "";
	}
	public static void solve() {
		int pdig = n.charAt(n.length()-p) - '0';
		for (int i =0; i<n.length(); i++) {
			if (i < n.length()-p) {
				output += ((n.charAt(i) - '0' + pdig)%10);
			}
			else if (i>n.length()-p) {
				output += (Math.abs(n.charAt(i) - '0' - pdig));
			}
			else {
				output += pdig;
			}
		}
	}
	public static void output () {
		System.out.println (output);
	}
}

/*
296351 5
762184 3
45873216 7
19750418 6
386257914 5

4318672 4
35197545 1
975318642 9
9876543210 5
314159265358 10

*/

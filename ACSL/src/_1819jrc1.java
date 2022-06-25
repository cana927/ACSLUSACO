import java.util.*;

public class _1819jrc1 {
	static Scanner sc;
	static String n1, n2, n3, n4, n5;
	static int [] output; 
	
	public static void main (String [] args) {
		init();
		solve();
		output();
	}
	
	public static void init() {
		sc = new Scanner (System.in);
		
		n1 = sc.next();
		n2 = sc.next();
		n3 = sc.next();
		n4 = sc.next();
		n5 = sc.next();
		
		output = new int [5];
		
	}
	public static void solve() {
		
		output[0] = n1.length();

		int w=0;
		for (int i = 0; i<n2.length(); i++) {
			w += n2.charAt(i) - '0';
		}
		output[1] = w;
		
		int d = 0;
		for (int i= 0; i<n3.length(); i=i+2) {
			d+=  n3.charAt(i) - '0';
		}
		output[2] = d;
		
		int f = 0;
		for (int i =0; i<n4.length(); i++) {
			if (n4.charAt(i) == '4') {
				f++;
			}
		}
		output [3] = f;
		
		int z = n5.length();
		if (z%2 == 1) {
			output[4] = n5.charAt(z/2)  - '0';
		}
		else {
			output[4] = n5.charAt(z/2 -1) - '0';
		}
		
	}
	public static void output() {
		for (int i=0; i<5; i++) {
			System.out.println (output[i]);
		}
	}
}

import java.util.*;
import java.io.*;

public class _1516jrc1 {
	static String octal, output;
	static Scanner sc = new Scanner (System.in);
	
	public static void main (String [] args) {
		for (int i=0; i<5; i++) {
			init();
			solve();
			output();
		}
	}
	
	public static void init() {
		octal = sc.nextLine();
		octal = octal.replaceAll(", ", "");
		output = "";
	}
	public static void solve() {
		String [] bins = new String [3];
		for (int r = 0; r< 3; r++) {
			int a = octal.charAt(r) - '0';
			bins[r] = toBin(a);
			output += toBin(a);
		}
		output += "and ";
		for (int i =0; i<3; i++) {
			String a = bins[i];
			if (a.charAt(0) == '1') {
				output += "r";
			}else {
				output += "-";
			}
			if (a.charAt(1) == '1') {
				output += "w";
			}else {
				output += "-";
			}
			if (a.charAt(2) == '1') {
				output += "x";
			}else {
				output += "-";
			}
			output += " ";
		}
		
	}
	public static void output() {
		System.out.println (output);
	}
	
	public static String toBin (int r ) {
		String a = "";
		while (r>1) {
			
			a = r%2 + a;			
			r = r/2; 
		}
		a = r + a + " ";
		while (a.length() < 4) {
			a = "0" + a;
		}
		return a;
	}
}
/*
5, 2, 6 
7, 3, 0 
4, 1, 5 
2, 3, 4 
5, 6, 7

1, 0, 4
7, 7, 2
6, 3, 5
0, 2, 6
5, 2, 7
*/
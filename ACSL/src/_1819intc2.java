import java.util.*;
import java.io.*;

public class _1819intc2 {
	static String a, b, output;
	static Scanner sc = new Scanner (System.in);
	
	public static void main (String [] args) {
		for (int i=0; i <5; i++) {
			init();
			solve();
			output();
		}
	}
	public static void init() {
		a = sc.next();
		b = sc.next();
		output = "";
		
	}
	public static void solve() {
		String cs1 = ""; //a to b left to right
		String cs2 = ""; //b to a left to right
		String cs3 = ""; //a to b right to left
		String cs4 = ""; //b to a right to left
		
		// a to b, left to right
		String one = b;
		for (int i =0; i<a.length(); i++) {
			for (int r = 0; r<one.length(); r++) {
				if (a.charAt(i) == one.charAt(r)) {
					cs1 += a.charAt(i);
					one = one.substring(r+1);
					break;
				}
			}
		}
		
		// b to a, left to right
		String two = a;
		for (int i =0; i<b.length(); i++) {
			for (int r = 0; r<two.length(); r++) {
				if (b.charAt(i) == two.charAt(r)) {
					cs2 += b.charAt(i);
					two = two.substring(r+1);
					break;
				}
			}
		}
		
		// a to b, right to left
		String three = b;
		for (int i =a.length()-1; i>=0; i--) {
			for (int r = three.length()-1; r>=0; r--) {
				if (a.charAt(i) == three.charAt(r)) {
					cs3 += a.charAt(i);
					three = three.substring(0, r);
					break;
				}
			}
		}
		
		// b to a, right to left
		String four = a;
		for (int i =b.length()-1; i>=0; i--) {
			for (int r = four.length()-1; r>=0; r--) {
				if (b.charAt(i) == four.charAt(r)) {
					cs4 += b.charAt(i);
					four = four.substring(0, r);
					break;
				}
			}
		}

		
		int [] chart = new int [26];
		for (int i =0; i<cs1.length(); i++) {
			chart[cs1.charAt(i) - 'a']++;
		}
		for (int i =0; i<cs2.length(); i++) {
			chart[cs2.charAt(i) - 'a']++;
		}
		for (int i =0; i<cs3.length(); i++) {
			chart[cs3.charAt(i) - 'a']++;
		}
		for (int i =0; i<cs4.length(); i++) {
			chart[cs4.charAt(i) - 'a']++;
		}
		
		for (int i =0; i<26; i++) {
			if (chart[i] >=4) { 
				output += (char)('a' + i);
			}
		}
		
		if (output.length() ==0) {
			output = "NONE";
		}
	}
	public static void output () {
		System.out.println (output);
	}
}

/*
abcddef vdfaddwf
friends afraid
delicious indiginous
shalom saaalaaam
happy shipshape

*/

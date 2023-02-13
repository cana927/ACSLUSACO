import java.io.*;
import java.util.*;

public class _1920intc2 {
	static String one, two;
	static ArrayList <Character> a, b;
	static Scanner sc = new Scanner (System.in);
	static int output;
	
	public static void main (String [] args) {
		for (int i =0; i<5; i++) {
			init();
			solve();
			output();
		}
	}
	public static void init() {
		a = new ArrayList <Character> ();
		b = new ArrayList<Character> ();
		one = sc.next();
		two = sc.next();
		for (int i =0; i<one.length(); i++) {
			a.add(one.charAt(i));
		}
		for (int i =0; i<two.length(); i++) {
			b.add(two.charAt(i));
		}
		output = 0;
	}
	public static void solve() {
		while (hasSimilar()) {
			for (int i =0; i<Math.min(a.size(), b.size()); i++) {
				if (a.get(i) == b.get(i)) {
					a.remove(i);
					b.remove(i);
					i--;
				}
			}
			for (int i =0; i<Math.min(a.size(), b.size()); i++) {
				if (b.size()>=i+2 && a.get(i) == b.get(i+1)) {
					b.remove(i);
					break;
				}
				else if (a.size()>=i+2 && b.get(i) == a.get(i+1) ) {
					a.remove(i);
					break;
				}
			}
			/*for (int i =0; i<a.size(); i++) {
				System.out.print (a.get(i));
			}
			System.out.println();
			for (int i =0; i<b.size(); i++) {
				System.out.print (b.get(i));
			}
			System.out.println();
			*/
		}
		int minLength = Math.min(a.size(), b.size());
		for (int i = 0; i<minLength; i++) {
			output += a.get(i) - b.get(i);
		}
		output += a.size() - minLength;
		output += b.size() - minLength;
	}
	public static void output () {
		System.out.println (output);
	}
	public static boolean hasSimilar () {
		if (a.size() > b.size() ) {
			for (int i =1; i<b.size(); i++) {
				if (b.get(i) == a.get(i-1) || b.get(i) == a.get(i) || b.get(i) == a.get(i+1)) {
					return true;
				}
			}
		} else if (a.size() < b.size()){
			for (int i =1; i<a.size(); i++) {
				if (a.get(i) == b.get(i-1)||a.get(i) == b.get(i) || a.get(i) == b.get(i+1)) {
					return true;
				}
			}
		} else {
			for (int i =1; i<a.size()-1; i++) {
				if (a.get(i) == b.get(i-1) ||a.get(i) == b.get(i) || a.get(i) == b.get(i+1)) {
					return true;
				}
			}
		}
		return false;
	}
}

/*
BLAMEABLENESSES BLAMELESSNESSES 
MEZZAMINES RAZZMATAZZ 
ABBREVIATIONS ABBREVIATORS 
ABCDEFGHIJKLMNO ABKCLDZZHQJWWLX 
ABCDEFGHIJKL ABXEWFRRH

MYARTLOLLIPOPS MYLARBALLOONS
MASSACHUSETTSBAYCOLONY MINUTEMANNATIONALHISTORICALPARK
LOWERMACTOWNSHIPPA CRANBERRYTOWNSHIPPA
AMERICANCOMPUTERSCIENCELEAGUE NATIONALACADEMICGAMESLEAGUE
ABCDEFGHIJK ABDCEFGKILKJMN

*/

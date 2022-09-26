import java.util.*;
import java.io.*;

public class _1718jrc4 {
	static Scanner sc = new Scanner (System.in);
	static StringTokenizer st;
	static ArrayList<Character> arr;
	static ArrayList<Character> nums;
	static int pos;
	static String phrase;
	static int output;
	
	public static void main (String [] args) {
		for (int i =0; i<5; i++) {
			init();
			solve();
			output();
		}
	}
	public static void init() {
		arr = new ArrayList<Character>(); 
		nums = new ArrayList<Character>(); 
		st = new StringTokenizer(sc.nextLine());
		pos = Integer.parseInt(st.nextToken());
		pos -= 1;
		phrase = "";
		while (st.hasMoreTokens()) { 
			phrase += st.nextToken();
		}
		phrase = phrase.toLowerCase();
		output = 0;
	}
	public static void solve() {
		for (int i =0; i<phrase.length();i ++) {
			
			// add letter
			char letter = phrase.charAt(i);
			int e = 0;
			for (int r = 0; r<=arr.size(); r++)  {
				if (r == arr.size()) {
					arr.add(letter);
					break;
				}
				else if (letter<= arr.get(r)) {
					arr.add(r, letter);
					break;
				}
			}
			
			// check position
			if (arr.size() >pos) {
				char lap  = arr.get(pos);
				for (int r = 0; r<nums.size(); r++)  {
					if (lap == nums.get(r)) {
						e++;
					}
				}
			}
			if (e<1 && arr.size() >pos) {
				output ++;
				nums.add(arr.get(pos));
			}
		}
	}
	public static void output () {
		System.out.println (output);
	}
	
}

/*
2 Computer
2 COMPUTER bat
3 COMPUTER
4 ACSL is fun
9 the xylophone

*/
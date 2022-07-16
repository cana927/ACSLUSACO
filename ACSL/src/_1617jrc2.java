/*
314159265
11223344
25897257
91
9876543210

1123581321345589
19782017
574839285638204927
4
2178281828
*/

import java.util.*;

public class _1617jrc2 {
	static Scanner sc;
	static String all;
	static String output;
	
	public static void main(String []args) {
		sc = new Scanner (System.in);
		for (int d= 0; d<5; d++) {
			init();
			solve();
			output();
		}
	}
	public static void init() {
		all = sc.nextLine();
		output = "";
	}
	
	public static void solve() {
		int current =  all.charAt(0) - '0';
		output += current;
		
		for (int i = 1; i<all.length(); i++) {
			int r = all.charAt(i)- '0'; 
			
			int length = 0;
			while (r<=current) {
				length++;
				if (i+length <=all.length()) {
					r = Integer.valueOf(all.substring(i, i+length));
				} else {
					length = -1;
					break;
				}
			}
			
			if (length >0 ) {
				output = output + " " + r;
				current = Integer.valueOf(all.substring(i, i+length));
				i = i + length - 1;
			} else if (length ==0) {
				output = output + " " + r;
				current = all.charAt(i) - '0';
			}
		}
	}
	
	public static void output() {
		System.out.println (output);
	}
}

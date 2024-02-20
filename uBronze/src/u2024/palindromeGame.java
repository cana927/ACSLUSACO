package u2024; // 7/13

import java.io.*;
import java.util.*;

public class palindromeGame {
	public static void main (String [] args ) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());
		
		StringBuilder sb = new StringBuilder();
		
		for (int i = 0; i<T; i++) {
			long stones = Integer.parseInt(in.readLine());
			long plays = 0;
			long cut = 0;
			
			while (stones > 10) {
				cut = stones - 10;
				
				while (!isPalin(cut)) {
					if (cut == 10) {
						cut = 9;
					}
					else {
						cut-=10;
					}
				}
				
				stones = stones - cut;
				plays ++;
			}
			
			if (stones == 10) {
				plays ++;
			}
			
			if (plays % 2 == 0) {
				sb.append("B\n");
			}else {
				sb.append("E\n");
			}
		}
		String s = sb.toString(); 
		s = s.substring(0, s.length()-1);
		System.out.println(s);
	}
	public static Boolean isPalin (long n) {
		String s = "" + n;
		for (int i = 0; i<s.length()/2; i++) {
			if (s.charAt(i) != s.charAt(s.length()-1-i)) {
				return false;
			}
		}
		return true;
	}
}

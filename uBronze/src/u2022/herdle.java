package u2022;
//package u2022;

import java.io.*;
import java.util.*;

public class herdle {
	public static void main (String [] args) throws IOException {
		int [] lettersA = new int [26];
		int [] lettersB = new int [26];
		
		char [] A = new char [9];
		char [] B = new char [9];
		
		int green = 0;
		int yellow = 0;
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		for (int i = 0; i< 3; i++) {
			String s = in.readLine();
			
			for (int r = 0; r<3; r++) {
				A[3*i + r] = s.charAt(r);
				lettersA[s.charAt(r)-'A'] ++;
			}
		}
		for (int i = 0; i< 3; i++) {
			String s = in.readLine();
			
			for (int r = 0; r<3; r++) {
				B[3*i + r] = s.charAt(r);
				lettersB[s.charAt(r)-'A'] ++;
			}
		}
		
		for (int i = 0; i<9; i++) {
			if (A[i] == B[i]) {
				green ++;
				lettersA[A[i]-'A'] --;
				lettersB[A[i]-'A'] --;
			}
		}
		
		for (int i =0; i<26; i++) {
			if (lettersA[i] > 0) {
				yellow += Math.min(lettersA[i], lettersB[i]);
			}
		}
		
		System.out.println (green);
		System.out.println (yellow);
	}
}

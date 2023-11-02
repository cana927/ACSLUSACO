//package u2022;

import java.io.*;
import java.util.*;

public class nonTransitiveDice {
	public static void main (String [] args) throws IOException  {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(in.readLine());
		
		for (int t = 0; t<T; t++) {
			int [] A = new int [4];
			int [] B = new int [4];
			
			Boolean isPossible = false;
			
			String s = in.readLine();
			StringTokenizer st = new StringTokenizer (s);
			
			for (int i = 0; i<4; i++) {
				A[i] = Integer.parseInt (st.nextToken());
			}
			for (int i = 0; i<4; i++) {
				B[i] = Integer.parseInt (st.nextToken());
			}
			
			if (secondIsGreater (A, B)) {
				for (int a = 1; a<11; a++) {
					for (int b = 1; b<11; b++) {
						for (int c = 1; c<11; c++) {
							for (int d = 1; d<11; d++) {
								int [] C = {a, b, c, d};
								if (secondIsGreater (B,C) && secondIsGreater (C,A)) {
									isPossible = true;
								}
							}
						}
					}
				}
			}
			if (secondIsGreater (B,A)) {
				for (int a = 1; a<11; a++) {
					for (int b = 1; b<11; b++) {
						for (int c = 1; c<11; c++) {
							for (int d = 1; d<11; d++) {
								int [] C = {a, b, c, d};
								if (secondIsGreater (C,B) && secondIsGreater (A,C)) {
									isPossible = true;
								}
							}
						}
					}
				}
			}
			
			if (isPossible) {
				System.out.println ("yes");
			}
			else {
				System.out.println ("no");
			}
		}
	}
	
	public static boolean secondIsGreater (int [] A, int [] B) {
		int greaterA = 0;
		int greaterB = 0;
		
		for (int i = 0; i<4; i++) {
			for (int r = 0; r<4; r++) {
				if (A[i] > B[r]) {
					greaterA ++;
				}
				if (B[i] > A[r]) {
					greaterB ++;
				}
			}
		}
		return greaterB>greaterA;
	}
}

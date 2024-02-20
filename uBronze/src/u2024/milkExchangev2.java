//package u2024; 3/16

import java.io.*;
import java.util.*;

public class milkExchangev2 {
	public static void main (String [] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
				
		char [] direction = new char [N];
		String s = in.readLine();
		for (int i =0; i<N;i ++) {
			direction[i] = s.charAt(i);
		}
		
		int total = 0;
		int [] full = new int [N];
		st = new StringTokenizer(in.readLine());
		for (int i = 0; i<N; i++) {
			full[i] = Integer.parseInt(st.nextToken());
			total += full[i];
		}
		
		int waste = 0;
		
		int [] add = new int [N];
		for (int i = 0; i<N; i++) {
			if ( i==0) {
				if (direction[N-1] == 'R') {
					add[i] = add[i] + 1;
				}
				if (direction [1] == 'L') {
					add[i] = add[i] + 1;
				}
			}
			else if (i== N-1) {
				if (direction[i-1] == 'R') {
					add[i] = add[i] + 1;
				}
				if (direction [0] == 'L') {
					add[i] = add[i] + 1;
				}
			}
			else {
				if (direction[i-1] == 'R') {
					add[i] = add[i] + 1;
				}
				if (direction [i+1] == 'L') {
					add[i] = add[i] + 1;
				}
			}
		}
		for (int i = 0; i<N; i++) {
			int t = 0;
			if (add[i] == 2) {
				if (i == 0) {
					if (add[N-1] == 0) {
						t = full[N-1];
					}
					if (add[i+1] == 0) {
						if (t > 0) {
							t = Math.min(t, full[i+1]);
						}else {
							t = full[i+1];
						}
					}
				}
				else if (i==N-1) {
					if (add[i-1] == 0) {
						t = full[i-1];
					}
					if (add[0] == 0) {
						if (t > 0) {
							t = Math.min(t, full[0]);
						}else {
							t = full[0];
						}
					}
				}
				else {
					if (add[i-1] == 0) {
						t = full[i-1];
					}
					if (add[i+1] == 0) {
						if (t > 0) {
							t = Math.min(t, full[i+1]);
						}else {
							t = full[i+1];
						}
					}
				}
				//System.out.println (i + " " + t);
				if (t<M && t>0) {
					waste += t;
				}
				else {
					waste += M;
				}
			}
		}
		
		System.out.println (total - waste);
	}
}

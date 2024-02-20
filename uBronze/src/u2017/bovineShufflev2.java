//package u2017;

import java.io.*;
import java.util.*;

public class bovineShufflev2 {
	public static void main (String [] args) throws IOException {
		BufferedReader in = new BufferedReader(new FileReader("shuffle.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("shuffle.out")));
		
		int n = Integer.parseInt(in.readLine());
		int [] order = new int [n];
		int [] cows = new int [n];
		int [] beg = new int [n];
		
		StringTokenizer st = new StringTokenizer  (in.readLine());
		for (int i = 0; i< n; i++) {
			order [i] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer  (in.readLine());
		for (int i = 0; i< n; i++) {
			cows [i] = Integer.parseInt(st.nextToken());
		}
		
		for (int r = 0; r< 3; r++) {
			for (int i = 0; i<n; i++) {
				beg[i] = cows[order[i]-1];
			}
			for (int i = 0; i<n; i++) {
				cows[i] = beg[i];
			}
		}
		
		for (int r:beg) {
			out.println (r);
		}
		out.close();
		in.close();
	}
}

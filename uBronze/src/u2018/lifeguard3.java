
//package u2018;

import java.io.*;
import java.util.*;

public class lifeguard3 {
	static class Lifeguard {
		public int start, end;
		
		public Lifeguard(int start, int end) {
			this.start = start;
			this.end = end;
		}
	}
	
	public static void main (String [] args) throws IOException {
		BufferedReader in = new BufferedReader (new FileReader ("lifeguards.in"));
		PrintWriter out = new PrintWriter (new BufferedWriter (new FileWriter ("lifeguards.out")));
		
		int N = Integer.parseInt(in.readLine());
		int [] times = new int [1001];
		Lifeguard [] cows = new Lifeguard [N];
		
		for (int i = 0; i<N; i++) {
			StringTokenizer st = new StringTokenizer (in.readLine());
			cows[i] = new Lifeguard (Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
			
			for (int r = cows[i].start; r<cows[i].end; r++) {
				times [r]++;
			}
		}
		
		int total = 0;
		for (int i = 0; i<1001; i++) {
			if (times[i] > 0) {
				total ++;
			}
		}
		
		int min = 20000;
		
		for (int i = 0; i<N; i++) {
			int num = 0;
			
			for (int r = cows[i].start; r<cows[i].end; r++) { 
				if (times[r] == 1) {
					num++;
				}
			}
			
			if (num<min) {
				min = num;
			}
		}
		out.println (total - min);
		in.close();
		out.close();
	}
}
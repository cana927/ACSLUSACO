//package u2018;

import java.io.*;
import java.util.*;

public class lifeguard2 {
	public static void main (String [] args) throws IOException {
		BufferedReader in = new BufferedReader (new FileReader ("lifeguards.in"));
		PrintWriter out = new PrintWriter (new BufferedWriter (new FileWriter ("lifeguards.out")));
		
		int N = Integer.parseInt(in.readLine());
		int [] times = new int [1001];
		int [][] cows = new int [100][2];
		
		for (int i = 0; i<N; i++) {
			StringTokenizer st = new StringTokenizer (in.readLine());
			cows[i][0] = Integer.parseInt(st.nextToken());
			cows[i][1] = Integer.parseInt(st.nextToken());
			
			for (int r = cows[i][0]; r<cows[i][1]; r++) {
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
			
			for (int r = cows[i][0]; r<cows[i][1]; r++) { 
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
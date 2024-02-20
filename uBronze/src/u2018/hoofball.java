package u2018;

import java.io.*;
import java.util.*;

public class hoofball {
	public static void main (String [] args) throws IOException {
		BufferedReader in = new BufferedReader (new FileReader("hoofball.in"));
		PrintWriter out = new PrintWriter (new BufferedWriter (new FileWriter ("hoofball.out")));
		
		int N = Integer.parseInt (in.readLine());
		int [] cows = new int [N];
		
		StringTokenizer st = new StringTokenizer (in.readLine());
		for (int i = 0; i<N; i++) {
			cows[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(cows);
		
		int circles = 1;
		  		
		
		// make new code about the changes in direction of increase/decrease
		
		for (int i = 1; i<N-2; i++) {   // if the teo circles have a 2+ gap, add 1
			if (cows[i+1]-cows[i] < cows[i]-cows[i-1] && cows[i+1]-cows[i] <= cows[i+2]-cows[i+1]) {
				circles ++;
			}
		}
		System.out.println (circles);
		int num = 0;
		
		if (N>2) {
			if (cows[1]-cows[0] <= cows[2]-cows[1] || cows[N-1]-cows[N-2] < cows[N-2]-cows[N-3]) {
				num = circles + 1;
				System.out.println ("hi");
			}
			else {
				num = circles+1;
			}
		}
		
		if (N <=2) {
			num = 1;
		}
		
		out.println (num);
		
		out.close();
		in.close();
	}
}

//package u2024; 9/17

import java.io.*;
import java.util.*;

public class maximizingProductivity {
	public static void main (String [] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		int N = Integer.parseInt(st.nextToken()); // number of farms
		int Q = Integer.parseInt(st.nextToken()); // queries 
		
		int [] latestArrival = new int[N];
		StringTokenizer c = new StringTokenizer(in.readLine());
		StringTokenizer t = new StringTokenizer(in.readLine());
		for (int i = 0; i<N; i++) {
			latestArrival[i] = Integer.parseInt(c.nextToken())-Integer.parseInt(t.nextToken());
		}
		
		Arrays.sort(latestArrival);
		
		StringBuilder sb = new StringBuilder();
		
		for (int i = 0; i<Q; i++) {
			st = new StringTokenizer(in.readLine());
			
			int V = Integer.parseInt(st.nextToken()); // number of farms
			int S = Integer.parseInt(st.nextToken()); // queries 
			
			int place = N-1;
			
			while (latestArrival[place]>S) {
				place--;
			}
			
			if (N-1 - place < V) {
				sb.append("NO\n");
			}else {
				sb.append("YES\n");
			}
		}
		
		String s = sb.toString(); 
		s = s.substring(0, s.length()-1);
		System.out.println(s);
	}
}

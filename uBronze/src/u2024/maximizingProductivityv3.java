//package u2024; // 9/17

import java.io.*;
import java.util.*;

public class maximizingProductivityv3 {
	public static void main (String [] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		long N = Long.parseLong(st.nextToken()); // number of farms
		long Q = Long.parseLong(st.nextToken()); // queries 
		
		ArrayList <Integer> nums = new ArrayList <Integer>();
		int [] latestArrival = new int[1000000];
		StringTokenizer c = new StringTokenizer(in.readLine());
		StringTokenizer t = new StringTokenizer(in.readLine());
		
		for (int i = 0; i<N; i++) {
			int n = Integer.parseInt(c.nextToken())-Integer.parseInt(t.nextToken());
			if (n>0) {
				latestArrival[n] = latestArrival[n] + 1;
				if (!nums.contains(n)) {
					nums.add(n);
				}
			}
		}
		
		StringBuilder sb = new StringBuilder();
		
		for (int i = 0; i<Q; i++) {
			st = new StringTokenizer(in.readLine());
			
			long V = Long.parseLong(st.nextToken()); // number of farms visited
			long S = Long.parseLong(st.nextToken()); // wake 
			
			long total = 0;
			
			for (int n:nums) {
				if (n>S) {
					total += latestArrival[n];
				}
			}
			
			if (total < V) {
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

//package u2024; 8/16

import java.io.*;
import java.util.*;

public class milkExchange {
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
		
		int [] full = new int [N];
		st = new StringTokenizer(in.readLine());
		for (int i = 0; i<N; i++) {
			full[i] = Integer.parseInt(st.nextToken());
		}
		
		int [] bucket = new int [N];
		for (int i = 0; i<N; i++) {
			bucket[i] = full[i];
		}
		
		for (int t = 0; t<M; t++) {
			//add buckets of milk; if og has 0, no add; if destination is more than full, no add
			for (int i = 0; i<N; i++) {
				if (bucket[i] > 0) {
					if (direction[i] == 'L') {
						if (i==0) {
							if (bucket[N-1] <= full[N-1]) {
								bucket[N-1] = bucket[N-1] + 1;
							}
						}else {
							if (bucket[i-1] <= full[i-1]) {
								bucket[i-1] = bucket[i-1] + 1;
							}
						}
					}else {
						if (i==N-1) {
							if (bucket[0] <= full[0]) {
								bucket[0] = bucket[0] + 1;
							}
						}else {
							if (bucket[i+1] <= full[i+1]) {
								bucket[i+1] = bucket[i+1] + 1;
							}
						}
					}
				}
			}
			
			//all subtract 1
			for (int i = 0; i<N; i++) {
				if (bucket[i] > 0) {
					bucket [i] = bucket[i] - 1;
				}
			}
		}
		
		long total = 0;
		for (int i = 0; i<N; i++) {
			total += bucket[i];
		}
		
		System.out.println (total);
	}
}

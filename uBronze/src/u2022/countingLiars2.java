package u2022;

import java.util.*;
import java.io.*;
public class countingLiars2 {

	static class Cow implements Comparable<Cow> {
		char statement;
		int pos;
		
		public Cow(char statement, int pos) {
			this.statement = statement;
			this.pos = pos;
		}
		
		@Override
		public int compareTo(Cow c) {
			if(pos != c.pos) {
				return pos - c.pos;
			}
			return statement - c.statement;
		}
		
	}
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(in.readLine());
		Cow[] cows = new Cow[n];
		for(int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			cows[i] = new Cow(st.nextToken().charAt(0), Integer.parseInt(st.nextToken()));
		}
		
		Arrays.sort(cows);
		
		int[] lyingL = new int[n];
		for(int i = 1; i < n; i++) {
			lyingL[i] += lyingL[i-1];
			if(cows[i-1].statement == 'L' && cows[i].pos >= cows[i-1].pos) {
				lyingL[i] += 1;
			}
		}
		
		int[] lyingR = new int[n];
		for(int i = n-2; i >= 0; i--) {
			lyingR[i] += lyingR[i+1];
			if(cows[i+1].statement == 'G' && cows[i].pos <= cows[i+1].pos) {
				lyingR[i] += 1;
			}
		}
		
		int min = n;
		for(int i = 0; i < n; i++) {
			min = Math.min(min, lyingL[i]+lyingR[i]);
		}
		
		System.out.println(min);

	}

}

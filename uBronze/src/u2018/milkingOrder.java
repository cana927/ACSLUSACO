package u2018;

import java.io.*;
import java.util.*;

public class milkingOrder {
	public static void main (String [] args) throws IOException {
		BufferedReader in = new BufferedReader (new FileReader ("lifeguards.in"));
		PrintWriter out = new PrintWriter (new BufferedWriter (new FileWriter ("lifeguards.out")));
		
		StringTokenizer st = new StringTokenizer (in.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int [] strict = new int [M];
		st = new StringTokenizer (in.readLine());
		for (int i = 0; i<M; i++) {
			strict[i] = Integer.parseInt(st.nextToken());
		}
		
		for (int i = 0; i<K; i++) {
			st = new StringTokenizer (in.readLine());
			int cow = Integer.parseInt(st.nextToken());
			int place = Integer.parseInt(st.nextToken());
			strict[place] = cow;
		}
		
		int earliest = N;
		
		for (int i = 0; i<= K; i++) {
			
		}
	}
	
	public static int indexOf(int [] l, int cow) {
		for (int i = 0; i <= l.length; i++) {
			if (l[i] == cow) {
				return i;
			}
		}
		return -1;
	}
}

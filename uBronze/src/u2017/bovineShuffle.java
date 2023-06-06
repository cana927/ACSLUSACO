package u2017;


import java.io.*;
import java.util.*;

public class bovineShuffle {
	static BufferedReader in;
	static PrintWriter out;
	static StringTokenizer st;
	static int N;
	static int [] shuffle;
	static int [] finalOrder;
	static int [] output;
	
	public static void main (String [] args) throws IOException {
		init();
		solve();
		output();
	}
	public static void init() throws IOException {
		in = new BufferedReader(new FileReader ("shuffle.in"));
		out = new PrintWriter (new BufferedWriter(new FileWriter ("shuffle.out")));
		st = new StringTokenizer (in.readLine());
		N = Integer.parseInt(st.nextToken());
		
		shuffle = new int [N];
		st = new StringTokenizer(in.readLine());
		for (int i =0; i<N; i++) {
			shuffle[i] = Integer.parseInt(st.nextToken());
		}
		
		finalOrder = new int [N];
		st = new StringTokenizer (in.readLine());
		for (int i =0; i<N; i++) {
			finalOrder[i] = Integer.parseInt(st.nextToken());
		}
		output = new int [N];
	}
	public static void solve () {
		int [] past = new int [N];
		int [] now = new int [N];
		
		for (int i =0; i<N; i++) {
			past [i] = i;
		}
		
		for (int r = 0; r<3; r++) {
			for (int w = 0; w<N; w++) {
				now [shuffle[w]-1] = past [w];
			}
			for (int w = 0; w<N; w++) { 
				past [w] = now [w];
			}
		}
		for (int i= 0; i<N; i++) {
			output [now[i]] = finalOrder[i]; 
			
		}
	}
	public static void output () throws IOException {
		for (int i =0; i<N; i++) {
			out.println(output[i]);

		}
		in.close();
		out.close();
	}
}

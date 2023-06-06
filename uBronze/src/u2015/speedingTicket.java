package u2015;

import java.util.*;
import java.io.*;

public class speedingTicket {
	static BufferedReader in;
	static PrintWriter out;
	static StringTokenizer st;
	static ArrayList<Integer> roadlimits, bessie;
	static int M, N;
	static int output;
	
	public static void main (String [] args) throws IOException {
		init();
		solve();
		output();
	}
	static void init() throws IOException {
		in = new BufferedReader(new FileReader("speeding.in"));
		out = new PrintWriter(new BufferedWriter(new FileWriter("speeding.out")));
		st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		output = 0;
		roadlimits = new ArrayList <Integer>();
		bessie = new ArrayList <Integer>();
		for (int i = 0; i<N; i++) {
			st = new StringTokenizer(in.readLine());
			int miles = Integer.parseInt(st.nextToken());
			int limit = Integer.parseInt(st.nextToken());
			for (int r = 0; r<miles; r++) {
				roadlimits.add(limit);
			}
		}
		for (int i = 0; i<M; i++) {
			st = new StringTokenizer(in.readLine());
			int miles = Integer.parseInt(st.nextToken());
			int limit = Integer.parseInt(st.nextToken());
			for (int r = 0; r<miles; r++) {
				bessie.add(limit);
			}
		}
	}
	static void solve() {
		for (int i = 0; i<100; i++) {
			int over = Math.max( 0, (bessie.get(i) -roadlimits.get(i)));
			output = Math.max(output, over);
		}
	}
	static void output () throws IOException {
		out.print(output);
		in.close();
		out.close();
	}
}

package u2018;
import java.util.*;
import java.io.*;

public class bucketList {
	static BufferedReader in;
	static PrintWriter out;
	static StringTokenizer st;
	static int N;
	static int [] start, till, buckets;
	static int output;
	
	public static void main (String [] args) throws IOException {
		init();
		solve();
		output();
	}
	public static void init( ) throws IOException {
		in = new BufferedReader(new FileReader ("blist.in"));
		out = new PrintWriter(new BufferedWriter (new FileWriter ("blist.out")));
		st = new StringTokenizer (in.readLine());
		N = Integer.parseInt(st.nextToken());
		start = new int [N];
		till = new int [N];
		buckets = new int [N];
		for (int i =0; i<N; i++) {
			st = new StringTokenizer (in.readLine());
			start[i] = Integer.parseInt(st.nextToken());
			till[i] = Integer.parseInt(st.nextToken());
			buckets[i] = Integer.parseInt(st.nextToken());
		}
		output = 0;
	}
	public static void solve () {
		int maxt = 0;
		for (int i =0; i<N; i++) {
			maxt = Math.max (maxt, till[i]);
		}
		for (int t = 1; t<=maxt; t++) {
			int need= 0;
			for (int i = 0; i<N; i++) {
				if (start[i] <=t && till[i]>=t) {
					need += buckets[i];
				}
			output = Math.max(need, output);
			}
		}
	}
	public static void output () throws IOException {
		out.print (output);
		in.close();
		out.close();
		
	}
	
}

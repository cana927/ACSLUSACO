package u2016;
import java.util.*;
import java.io.*;

public class blockGame {
	static int n;
	static String [] first, sec;
	static BufferedReader in;
	static PrintWriter out;
	static StringTokenizer st;
	static int []output;
	
	public static void main (String [] args) throws IOException {
		init();
		solve();
		output();
	}
	public static void init() throws IOException  {
		output = new int [26];
		in = new BufferedReader(new FileReader("blocks.in"));
		out = new PrintWriter(new BufferedWriter(new FileWriter ("blocks.out")));
		st = new StringTokenizer(in.readLine());
		n = Integer.parseInt(st.nextToken());
		first = new String [n];
		sec = new String [n];
		for (int i = 0; i<n; i++) {
			st = new StringTokenizer(in.readLine());
			first [i] = st.nextToken();
			sec[i] = st.nextToken();
		}
	}
	public static void solve() {
		for (int i = 'a'; i<='z'; i++) {
			for (int r = 0; r<n; r++) {
				//first
				int one = 0;
				for (int e = 0; e<first[r].length(); e++) {
					if (first[r].charAt(e) == i) {
						one ++;
					}
				}
				//sec
				int two = 0;
				for (int e = 0; e<sec[r].length(); e++) {
					if (sec[r].charAt(e) == i) {
						two ++;
					}
				}
				output[i-'a'] += Math.max(one, two);
			}
		}
	}
	public static void output() throws IOException {
		for (int i = 0; i<26; i++) {
			out.print(output[i]);
			out.println();
		}
		in.close();
		out.close();
	}
	
}

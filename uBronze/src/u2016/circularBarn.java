package u2016;
import java.util.*;
import java.io.*;

public class circularBarn {
	static int n;
	static int [] number;
	static int output;
	static BufferedReader in;
	static PrintWriter out;
	static StringTokenizer st;
	public static void main (String [] args) throws IOException {
		init();
		solve();
		output();
		
	}
	public static void init() throws IOException {
		in = new BufferedReader(new FileReader ("cbarn.in"));
		out = new PrintWriter (new BufferedWriter (new FileWriter ("cbarn.out")));
		st = new StringTokenizer (in.readLine());
		n = Integer.parseInt(st.nextToken());
		number = new int [n];
		for (int i = 0; i<n; i++) {
			st = new StringTokenizer(in.readLine());
			number[i] = Integer.parseInt(st.nextToken());
		}
	}
	public static void solve() {
		for (int r = 0; r<n; r++) {
			int sum = 0;
			for (int i = 0; i<n; i++) {
				if (i!=r) {
					int distance = i-r;
					if (distance<0) {
						distance = n-r + i ;
					}
					
					sum += distance * number[i];

				}
			}
			if (output>0) {
				output = Math.min(output, sum);
			} else {
				output = sum;
			}
		}
	}
	public static void output () throws IOException {
		out.print (output);
		in.close();
		out.close();
	}
}

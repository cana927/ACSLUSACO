package u2019;
import java.util.*;
import java.io.*;

public class measuringTraffic {
	static BufferedReader in;
	static PrintWriter out;
	static StringTokenizer st;
	static int N;
	static int [] segment, low, high;
	static int [] output;
	
	public static void main (String [] args ) throws IOException {
		init();
		solve();
		output();
	}
	public static void init() throws IOException {
		in = new BufferedReader(new FileReader ("traffic.in"));
		out = new PrintWriter (new BufferedWriter (new FileWriter ("traffic.out")));
		st = new StringTokenizer (in.readLine());
		N = Integer.parseInt(st.nextToken());
		segment = new int [N];
		low = new int [N];
		high = new int [N];
		for (int i =0; i<N; i++) {
			st = new StringTokenizer(in.readLine());
			String type = st.nextToken();
			if (type.equals ("on")) {
				segment[i] = 1;
			} else if (type.equals("none")) {
				segment [i] = 0;
			} else {
				segment [i] = -1;
			}
			low [i] = Integer.parseInt(st.nextToken());
			high [i] = Integer.parseInt(st.nextToken());
		}
		output = new int [] {-1, -1, -1, -1};
	}
	public static void solve() {
		for (int i = 0; i<=1000; i++) {
			int [] end = simulate(i);
			if (end[0] != -1) {
				if (output[0] == -1) {
					output [0] = i;
				}else if(i<output[0]) {
					output[0] = i;
				}
				if (i > output[1]) {
					output[1] = i;
				}
			}
		}
		
		int [ ]a  = simulate(output[0]);
		int [] b = simulate (output[1]);
		output[2] = a[0];
		output[3] = b[1];
		
	}
	public static int[] simulate (int k) {
		int l = k;
		int h = k;
		for (int i =0; i<N; i++) {
			if (segment[i] ==1) { 
				l += low[i];
				h += high[i];
			}else if (segment [i] == -1) {
				if (h<low[i]) {
					return new int [] {-1,-1};
				}
				l = Math.max(l-high[i],0); // 
				h = Math.max(h-low[i],0); //
			}else {
				if (h<low[i] || l>high[i]) { 
					return new int [] {-1,-1};
				} 
				else {
					l = Math.max(l, low[i]);
					h = Math.min(h, high[i]);
				}
			}
		}
		return new int [] {l,h};
	}
	/*public static void solve2() {
		int start = 0;
		for (int i =0; i<N; i++) {
			if (segment[i] == 0) {
				start = i;
				break;
			}
		}
		output [0] = low [start];
		output [1] = high [start];
		
		int contin = start + 1; 
		while (contin<N && segment [contin] == 0) {
			output [0] = Math.max (output [0], low[contin]);
			output [1] = Math.min(output [1], high [contin]);
			contin ++;
		}

		if (start >0) {
			for (int i = start - 1; i>=0; i--) {
				int l = low [i];
				int h = high [i];
				if (segment [i ] == -1 ) {
					output[0] += l;
					output [1] += h;
				} else  {
					output[0] -= h;
					output [1] -= l;
				}
			}

		}
		
		int end = 0;
		for (int i =N-1; i>=0; i--) {
			if (segment[i] == 0) {
				end = i;
				break;
			}
		}

		output [2] = low [end];
		output [3] = high [end];
		
		contin = end - 1; 
		while (contin >-1 && segment [contin] == 0) {
			output [2] = Math.max (output [2], low[contin]);
			output [3] = Math.min(output [3], high [contin]);
			contin --;
		}

		if (end != N-1) {
			for (int i = end+1; i<N; i++) {
				int l = low [i];
				int h = high [i];
				if (segment [i] == -1 ) {
					output[2] -= h;
					output [3] -= l;

				} else  {
					output[2] += l;
					output [3] += h;
				
				}

			}
		}
	}*/
	public static void output () throws IOException {
		out.print(output[0] + " " + output[1]);
		out.println ();
		out.print (output [2] + " " + output[3]);
		in.close();
		out.close(); 
	}
}

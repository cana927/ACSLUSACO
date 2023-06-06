package u2016;

import java.util.*;
import java.io.*;

public class cowSignal {
	static BufferedReader in;
	static PrintWriter out;
	static StringTokenizer st;
	static int M, N,K;
	static String [][]output;
	
	public static void main (String [] args) throws IOException {
		init();
		solve();
		output();
	}
	public static void init() throws IOException {
		in = new BufferedReader(new FileReader("cowsignal.in"));
		out = new PrintWriter(new BufferedWriter(new FileWriter("cowsignal.out")));
		st = new StringTokenizer(in.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
	}
	public static void solve() throws IOException {
		output = new String [M*K][N*K];
		for (int m = 0; m < M; m++) {
			String w =in.readLine();
			for (int n = 0; n<N; n++) {
				String a = Character.toString(w.charAt(n));
				for (int q = 0; q<K; q++) {
					output[K*m][K*n+q] = a;
				}
			}
			for (int q = 1; q<K; q++) {
				for (int e = 0; e<N*K; e++) {
					output[K*m+q][e] = output[K*m][e]; 
				}
			}	
		}
		
	}
	public static void output() throws IOException {
		for (int m = 0; m<M*K; m++) {
			for (int n = 0; n<N*K; n++) {
				out.print(output[m][n]);
			}
			out.println("");
		}
		in.close();
		out.close();
	}
}

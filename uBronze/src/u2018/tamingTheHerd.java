//package u2018;

import java.io.*;
import java.util.*;

public class tamingTheHerd {
	public static void main (String [] args) throws IOException {
		BufferedReader in = new BufferedReader (new FileReader("taming.in"));
		PrintWriter out = new PrintWriter (new BufferedWriter (new FileWriter ("taming.out")));
		
		int N = Integer.parseInt(in.readLine());
		int [] log = new int [N];
		StringTokenizer st = new StringTokenizer (in.readLine());
		
		for (int i = 0; i<N; i++) {
			log[i] = Integer.parseInt(st.nextToken());
		}
		
		if (log[0]>0) {
			out.println (-1);
			out.close();
			in.close();
			System.exit(0);
		}
		log[0] = 0;
		
		int t = -1; // t days since break out 
		int req = 0;
		int pos = 0;
		
		for (int i =N-1; i>=0; i--) {
			if ((t != -1 && log[i] != -1 ) && log[i] != t) {
				out.println (-1);
				out.close();
				in.close();
				System.exit(0);
			}
			if ( t == -1 ) {
				t = log[i];
			}
			if ( log[i] == -1) {
				log[i] = t;
			}
			if (log[i] == 0) {
				req ++;
			}
			if (log[i] == -1) {
				pos ++;
			}
			if (t>-1) {
				t--; 
			}
		}
		
		pos += req;
		out.println (req + " " + pos);
		
		out.close();
		in.close();
	}
}

//package u2017;

import java.io.*;
import java.util.StringTokenizer;

public class cownomics {
	public static void main (String [] args) throws IOException {
		BufferedReader in = new BufferedReader (new FileReader("cownomics.in"));
		PrintWriter out = new PrintWriter (new BufferedWriter (new PrintWriter ("cownomics.out")));
		
		StringTokenizer st = new StringTokenizer (in.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		String [] spots = new String [N];
		String [] plain = new String [N];
		
		for (int i = 0; i<N; i++) {
			spots[i] = in.readLine();
		}
		for (int i = 0; i<N; i++) {
			plain[i] = in.readLine();
		}
		
		int positions = 0;
		
		for (int i =0; i<M; i++) {
			boolean hadA = false;
			boolean hadG = false;
			boolean hadT = false;
			boolean hadC = false;
			
			boolean validpos = true;

			for (int r = 0; r<N; r++) {
				if (spots[r].charAt(i) == 'A') {
					hadA = true;
				}
				else if (spots[r].charAt(i) == 'G') {
					hadG = true;
				}
				else if (spots[r].charAt(i) == 'T') {
					hadT = true;
				}
				else {
					hadC = true;
				}
			}
			for (int r = 0; r<N; r++) {
				if (plain[r].charAt(i) == 'A' && hadA == true) {
					validpos = false;
				}
				else if (plain[r].charAt(i) == 'G' && hadG == true) {
					validpos = false;
				}
				else if (plain[r].charAt(i) == 'T' && hadT == true) {
					validpos = false;
				}
				else if (plain[r].charAt(i) == 'C' && hadC == true){
					validpos = false;
				}
			}
			if (validpos) {
				positions++;
			}
		}
		out.println (positions);
		out.close();
		in.close();
	}
}

//package u2017;
import java.io.*;
import java.util.*;

public class cowtip {
	public static void main (String [] args) throws IOException {
		BufferedReader in = new BufferedReader(new FileReader ("cowtip.in"));
		PrintWriter out = new PrintWriter (new BufferedWriter(new FileWriter ("cowtip.out")));
		
		int n = Integer.parseInt(in.readLine());
		int[][] cows = new int [n][n];
		
		String s = "";
		for (int i = 0; i<n; i++) {
			s += in.readLine();
		}

		for (int i = 0; i<n; i++) {
			for (int r =0; r<n; r++) {
				cows [i][r] = s.charAt(i*n+r)-'0';
			}
		}
		
		int times = 0;
		
//		for (int i =0; i<n; i++) {
//			for (int r = 0; r<n; r++) {
//				System.out.print(cows[i][r]);
//			}
//			System.out.println ();
//		}
		
		for (int mult = n*n; mult>=1; mult--) {
			for (int i = n; i>=1; i--) {
				if (mult % i ==0 && mult/i <= n) {
					int r = mult/i;
					//System.out.println (i + " " + r);
					if (cows[i-1][r-1] == 1) {
						//System.out.println ("hi");
						for (int x = i-1; x>=0; x--) {
							for (int y = r-1; y>=0; y--) {
								cows[x][y] = Math.abs(cows[x][y]-1);
							}
						}
						times ++;
					}
				}
			}
		}
		
		out.println (times);
		out.close();
		in.close();
	}
}
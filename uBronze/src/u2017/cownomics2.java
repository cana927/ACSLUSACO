package u2017;


import java.util.*;
import java.io.*;

public class cownomics2 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader in = new BufferedReader(new FileReader("cownomics.in"));
		PrintWriter out = new PrintWriter("cownomics.out");
		
		StringTokenizer st = new StringTokenizer(in.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		char[][] spottedCows = new char[n][];
		char[][] plainCows = new char[n][];
		for(int i = 0; i < n; i++) {
			spottedCows[i] = in.readLine().toCharArray();
		}
		for(int i = 0; i < n; i++) {
			plainCows[i] = in.readLine().toCharArray();
		}
		
		int possible = 0;
		for(int i = 0; i < m; i++) {
			boolean dupe = false;
			for(int j = 0; j < n; j++) {
				for(int k = 0; k < n; k++) {
					if(spottedCows[j][i] == plainCows[k][i]) {
						dupe = true;
						break;
					}
				}
			}
			if(!dupe) {
				possible++;
			}
		}
		
		out.println(possible);
		out.close();
		in.close();

	}

}

//package u2016;
import java.io.*;
import java.util.*;

public class blockGame2 {
	public static void main (String [] args) throws IOException {
		BufferedReader in = new BufferedReader (new FileReader ("blocks.in"));
		PrintWriter out = new PrintWriter (new BufferedWriter (new PrintWriter ("blocks.out")));
		
		StringTokenizer st = new StringTokenizer (in.readLine());
		int n = Integer.parseInt(st.nextToken());
		
		int [] alph = new int [26];
		
		for (int i = 0; i<n; i++) {
			st = new StringTokenizer(in.readLine());
			String one = st.nextToken();
			String two = st.nextToken();
			
			for (int r ='a'; r<='z'; r++) {
				int countone = 0;
				
				for (int j = 0; j<one.length(); j++) {
					if (one.charAt(j) == r) {
						countone++;
					}
				}
				
				int counttwo = 0;
				
				for (int j = 0; j<one.length(); j++) {
					if (two.charAt(j) == r) {
						counttwo++;
					}
				}
				
				alph[r - 'a'] += Math.max(countone, counttwo);
				
			}
		}
		for (int i : alph) {
			out.println (i);
		}
		in.close();
		out.close();
	}
}

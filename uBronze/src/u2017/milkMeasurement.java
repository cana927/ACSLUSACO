//package u2017;
import java.io.*;
import java.util.*;

public class milkMeasurement {
	public static void main (String [] args) throws IOException{
		BufferedReader in = new BufferedReader (new FileReader ("measurement.in"));
		PrintWriter out = new PrintWriter (new FileWriter ("measurement.out"));
		
		int [][] days = new int [101][2];
		int n = Integer.parseInt(in.readLine());
		
		for (int i=0; i<n; i++) {
			StringTokenizer st = new StringTokenizer (in.readLine());
			int day = Integer.parseInt(st.nextToken());
			String name = st.nextToken();
			if (name.equals( "Bessie")) {
				days[day][0] = 1;
				days[day][1] = Integer.parseInt(st.nextToken());
			}
			if (name.equals( "Elsie")) {
				days[day][0] = 2;
				days[day][1] = Integer.parseInt(st.nextToken());
			}
			if (name.equals("Mildred")) {
				days[day][0] = 3;
				days[day][1] = Integer.parseInt(st.nextToken());
			}
		}
		int b = 7;
		int e = 7;
		int m = 7;
		int changes = 0;
		Boolean bmax = false;
		Boolean emax = false;
		Boolean mmax = false;

		
		for (int i =1; i<101; i++) {
			boolean changed = false; 
			if (days[i][0] != 0) {
				if (days[i][0] == 1) {
					b += days[i][1];
				}
				if (days[i][0] == 2) {
					e += days[i][1];
				}
				if (days[i][0] == 3) {
					m += days[i][1];
				}
				
				if (b >= m && b>= e) {
					if (bmax == false) {
						bmax = true;
						changed = true;
					}
				}
				else {
					if (bmax == true) {
						bmax = false;
						changed = true;
					}
				}
				if (e >= m && e>= b) {
					if (emax == false) {
						emax = true;
						changed = true;
					}
				}
				else {
					if (emax == true) {
						emax = false;
						changed = true;
					}
				}
				if (m >= e && m>= b) {
					if (mmax == false) {
						mmax = true;
						changed = true;
					}
				}
				else {
					if (mmax == true) {
						mmax = false;
						changed = true;
					}
				}
				
				if (changed) {
					changes++;
				}
			}
		}
		out.println (changes);
		out.close();
		in.close();
	}
}

package u2018;

import java.io.*;
import java.util.*;

public class billboard2_alt {
	public static void main (String [] args) throws IOException {
		BufferedReader in = new BufferedReader (new FileReader ("billboard.in"));
		PrintWriter out = new PrintWriter (new BufferedWriter (new FileWriter ("billboard.out")));
		
		StringTokenizer st = new StringTokenizer (in.readLine());
		
		int lawnx1 = Integer.parseInt(st.nextToken());
		int lawny1 = Integer.parseInt(st.nextToken());
		int lawnx2 = Integer.parseInt(st.nextToken());
		int lawny2 = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer (in.readLine());
		int feedx1 = Integer.parseInt(st.nextToken());
		int feedy1 = Integer.parseInt(st.nextToken());
		int feedx2 = Integer.parseInt(st.nextToken());
		int feedy2 = Integer.parseInt(st.nextToken());
		
		int tarpx1 = lawnx1;
		int tarpy1 = lawny1;
		int tarpx2 = lawnx2;
		int tarpy2 = lawny2;
		
		if (lawnx1<=feedx1) {
			if (lawnx2>=feedx2) {
				if (lawny2>=feedy2) {
					tarpx1 = lawnx1;
					tarpx2 = lawnx2;
					tarpy1 = lawny1;
					tarpy2 = feedy1;
				}
				if (lawny1<=feedy1) {
					tarpx1 = lawnx1;
					tarpx2 = lawnx2;
					tarpy1 = feedy2;
					tarpy2 = lawny2;
				}
			}
		}
		
		if (lawny1<=feedy1) {
			if (lawny2>=feedy2) {
				if (lawnx2>=feedx2 ) {
					tarpx1 = lawnx1;
					tarpx2 = feedx1;
					tarpy1 = lawny1;
					tarpy2 = lawny2;
				}
				if (lawnx1<=feedx1) {
					tarpx1 = feedx2;
					tarpx2 = lawnx2;
					tarpy1 = lawny1;
					tarpy2 = lawny2;
				}
			}
		}
		
		if (lawnx1<=feedx1) {
			if (lawny1<=feedy1) {
				if (lawnx2>=feedx2) {
					if (lawny2 >= feedy2) {
						tarpx1 = 0;
						tarpx2 = 0;
						tarpy1 = 0;
						tarpy2 = 0;
					}
				}
			}
		}
		
		out.println ((tarpx1-tarpx2)*(tarpy1-tarpy2));
		
		out.close();
		in.close();
	}
}

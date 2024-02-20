//package u2017;

import java.io.*;
import java.util.*;

public class lostCow3 {
	public static void main (String [] args) throws IOException {
		BufferedReader in = new BufferedReader (new FileReader("lostcow.in"));
		PrintWriter out = new PrintWriter (new BufferedWriter (new PrintWriter ("lostcow.out")));
		
		StringTokenizer st = new StringTokenizer (in.readLine());
		int x = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());
		
		int distance = 0;
		int r = 1;
		if (x>y) {

			while (x+r > y) { 
				distance += 3*Math.abs(r)/2;
				r = r*(-2);
				//System.out.println (r + " " +distance);
			}
			distance += 3*Math.abs(r)/2  - Math.abs(y-(x+r));
		}
		else if (y>x) {
			while (x+r < y) { 
				distance += 3*Math.abs(r)/2;
				r = r*(-2);
				//System.out.println (r + " " + distance);
			}
			distance += 3*Math.abs(r)/2  - Math.abs(y-(x+r));
		}
		
		out.print (distance);
		out.close();
		in.close();
	}
}

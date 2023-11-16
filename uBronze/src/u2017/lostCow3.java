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
		
		while (Math.abs(x+r) <= Math.abs(y) || (x+r)*y<0) { 
			distance += 3*Math.abs(r)/2;
			if (r > 0) {
				r = (r + 1)*(-1);
			}
			else {
				r = r*(-2);
			}
			//System.out.println (distance);
		}
		distance += 3*Math.abs(r)/2  - Math.abs(y-(x+r));
		
		out.print (distance);
		out.close();
		in.close();
	}
}

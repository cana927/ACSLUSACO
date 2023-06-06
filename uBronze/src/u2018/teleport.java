package u2018; //get rid of when submitting
import java.io.*;
import java.util.*;

public class teleport {
	public static void main (String [] args) throws IOException {
		BufferedReader in = new BufferedReader(new FileReader("teleport.in"));
		StringTokenizer st = new StringTokenizer (in.readLine());
		
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		int x = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());
		
		if (a>b) {
			int t = b;
			b = a;
			a = t;
		}
		if (x>y) {
			int t = x;
			x = y;
			y = t;
		}
		
		int output = 0;
		
		
		int one = Math.abs(x-a) + Math.abs(y-b);
		int two = Math.abs(b-a);
		output = Math.min(one, two);
		
		
		PrintWriter out = new PrintWriter(new BufferedWriter (new FileWriter("teleport.out")));
		out.println (output);
		out.close();
	}	
}

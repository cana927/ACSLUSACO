//package u2016;
import java.io.*;
import java.util.*;

public class pails {
	public static void main (String [] args) throws IOException {
		Scanner sc = new Scanner(new File("pails.in"));
        PrintWriter out = new PrintWriter("pails.out");
		
		int X = sc.nextInt();
		int Y = sc.nextInt();
		int M = sc.nextInt();
		
		int max = M / Y;
		
		int maxmilk = 0;
		
		for (int i =0; i<=max; i++) {
			int left = M - Y*i;
			int smalls = left/X;
			
			int total = smalls*X + i*Y;
			
			if (total>maxmilk) {
				maxmilk = total;
			}
		}
		
		out.println (maxmilk);
		out.close();
	}
}

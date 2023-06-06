package u2020;
import java.io.*;
import java.util.*;

public class stuckInARut {
	static int N;
	static char [] d;
	static int [] x, y;
	public static void main (String [] args ) {
		Scanner sc = new Scanner (System.in);
		
		N = sc.nextInt();
		
		d = new char[N];
		x = new int [N];
		y= new int [N];
		
		for (int i=0; i< N; i++) {
			d[i] = sc.next().charAt(0);
			x[i] = sc.nextInt();
			y[i] = sc.nextInt();
		}
		
		
		
		for (int i = 0; i<N; i++) {
			// Integer.MAX_VALUE --> "Infinity"
			int answer = check(i);
			if (answer ==Integer.MAX_VALUE) System.out.println ("Infinity");
			else System.out.println (answer);
			
		}
	}
	static int check (int i) {
		int min = Integer.MAX_VALUE;
		
		for (int j = 0; j<N; j++) {
			if (i==j) continue;
			if (d[i] == d[j]) continue; //parallel lines
			
			int dx = Math.abs(x[j] - x[i]);
			int dy = Math.abs (y[j] - y[i]);
			
			if (d[i] == 'N') {
				// d[j] must be moving east
				if (x[i] <x [j] || y[i]>y[j]) continue;
				
				if (dx < dy && check(j) >= dx) min = Math.min (min, dy);
			}
			else {
				if (x[i] > x[j] || y[i]<y[j]) continue;
				if (dx > dy && check(j) >= dx) min = Math.min (min, dx);
			
			}
		}
		return min;
	}
}

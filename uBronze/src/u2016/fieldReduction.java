package u2016;
import java.util.*;
import java.io.*;

public class fieldReduction {
	public static void main (String [] args) throws IOException {
		BufferedReader in = new BufferedReader (new FileReader ("reduce.in"));
		PrintWriter out = new PrintWriter (new BufferedWriter(new FileWriter ("reduce.out")));
		
		StringTokenizer st = new StringTokenizer(in.readLine());
		int N = Integer.parseInt(st.nextToken());
		
		int [] cowsx = new int [N];
		int [] cowsy = new int[N];
		
		for (int i = 0; i<N; i++) {
			st = new StringTokenizer(in.readLine());
			cowsx[i] = Integer.parseInt(st.nextToken());
			cowsy[i] = Integer.parseInt(st.nextToken());
		}
		
		int minarea = 2147483647;
		
		for (int i = 0; i<N; i++) {
			int area = 0;
			int minx = 40001;
			int maxx = 0;
			int miny = 40001;
			int maxy = 0;
			
			for (int r = 0; r<N; r++) {
				if (r!=i) {
					if (cowsx[i] > maxx) {
						
					}
					else (cowsx[i] > maxx) {
						
					}
				}
			}
		}
		
	}
}

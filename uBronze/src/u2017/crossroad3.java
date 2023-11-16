//package u2017;

import java.io.*;
import java.util.*;

public class crossroad3 {
	public static void main (String [] args) throws IOException {
		BufferedReader in = new BufferedReader (new FileReader("cowqueue.in"));
		PrintWriter out = new PrintWriter (new BufferedWriter (new PrintWriter ("cowqueue.out")));
		
		int N = Integer.parseInt(in.readLine());
		Cow [] cows = new Cow [N];
		for (int i = 0; i<N; i++) {
			StringTokenizer st = new StringTokenizer (in.readLine());
			cows[i] = new Cow(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		Arrays.sort(cows);
		
		int time = 0;
		
		for (Cow c : cows) {
			if (c.time > time) {
				time = c.time;
				time += c.length;
			}
			else {
				time += c.length;
			}
		}
		out.print (time);
		out.close();
		in.close();
	}
	
	public static class Cow implements Comparable <Cow>{
		int time;
		int length;
		
		public Cow (int time, int length) {
			this.time = time;
			this.length = length;
		}
		
		public int compareTo (Cow c) {
			return this.time-c.time;
		}
	}
}

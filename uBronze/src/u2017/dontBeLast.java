//package u2017;
import java.util.*;
import java.io.*;

public class dontBeLast {
	public static void main (String [] args) throws IOException{
		BufferedReader in = new BufferedReader(new FileReader ("notlast.in"));
		PrintWriter out = new PrintWriter (new BufferedWriter(new FileWriter ("notlast.out")));
		int N = Integer.parseInt(in.readLine());
		
		String [] names = {"Bessie", "Elsie", "Daisy", "Gertie", "Annabelle", "Maggie", "Henrietta"};
		int [] milk = new int [8];
		milk[7] = 100000;
		
		for (int i =0; i<N; i++) {
			StringTokenizer st = new StringTokenizer (in.readLine());
			String name = st.nextToken();
			for (int r = 0; r<7; r++) {
				if (name.equals(names[r])) {
					milk [r] += Integer.parseInt(st.nextToken());
				}
			}
		}		
		int last = 7;
		int second = 7;
		
		for (int i = 0; i<7; i++) {
			if (milk[i] < milk[last]) {
				last = i;
			}
		}
		
		for (int i = 0; i<7; i++) {
			if (milk[i] > milk[last] && milk[i] < milk[second]) {
				second = i;
			}
		}
		
		int count = 0;
		for (int m : milk) {
			if (m == milk [second]) { 
				count ++;
			}
		}
		
		if (count >1 || second == 7) {
			out.println ("Tie");
		}
		else {
			out.println (names[second]);
		}
		in.close();
		out.close();

	}
}

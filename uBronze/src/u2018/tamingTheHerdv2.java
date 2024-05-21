//package u2018;

import java.io.*;
import java.util.*;

public class tamingTheHerdv2 {
	public static void main (String [] args) throws IOException {
		BufferedReader in = new BufferedReader (new FileReader("taming.in"));
		PrintWriter out = new PrintWriter (new BufferedWriter (new FileWriter ("taming.out")));
		
		int N = Integer.parseInt(in.readLine());
		int [] log = new int [N];
		StringTokenizer st = new StringTokenizer (in.readLine());
		
		for (int i = 0; i<N; i++) {
			log[i] = Integer.parseInt(st.nextToken());
		}

		boolean fails = false;
		if (log[0] >0) {
			fails = true;
		}
		else {
			log[0] = 0;
		}
	
		for (int i = N-1; i>=0; i--) {
			if (log[i] > 0) {
				//System.out.println (i + " " + log[i]);
				int num = log[i];
				int place = i;
				while (num >= 0) {
					if (log[place] != num && log[place] != -1) {
						fails = true;
					}
					if (place == 0 && num != 0) {
						fails = true;
						num = -1;
					}
					log [place] = num;
					//System.out.print("/ " + place + " " + num);
					place --;
					num --;
				}
				//System.out.println();
				i = i - log[i]; 
			}
		}
		if (fails) {
			out.println (-1);
		}
		else {
			int min = 0;
			int max = 0;
			//System.out.println();
			for (int i = 0; i<N; i++) {
				System.out.print(log[i] + " ");
				if (log[i] == -1) {
					max++;
				}
				if (log[i]==0) {
					min ++;
				}
			}
			max += min;
			out.println (min + " " + max);
		}
		
		out.close();
		in.close();
	}
}

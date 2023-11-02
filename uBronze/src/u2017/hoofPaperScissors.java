//package u2017;

import java.io.*;
import java.util.*;

public class hoofPaperScissors {
	public static void main (String [] args) throws IOException {
		BufferedReader in = new BufferedReader(new FileReader ("hps.in"));
		PrintWriter out = new PrintWriter (new BufferedWriter(new FileWriter ("hps.out")));
		
		int [] moves = new int [6]; // 12, 13, 21, 23, 31, 32
		int maxwins = 0;
		
		int N = Integer.parseInt(in.readLine());
		for (int i = 0; i<N; i++) {
			StringTokenizer st = new StringTokenizer (in.readLine());
			
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			if (a==1) {
				if (b==2) {
					moves[0] ++;
				}
				if (b==3) {
					moves[1] ++;
				}
			}
			else if (a==2) {
				if (b==1) {
					moves[2] ++;
				}
				if (b==3) {
					moves[3] ++;
				}
			}
			else if (a==3) {
				if (b==1) {
					moves[4]++;
				}
				if (b==2) {
					moves[5]++;
				}
			}
		}
		
//		for (int i : moves) {
//			System.out.println (i);
//		}
			
		//if 1 = rock, 2 = paper, 3 = scissors --> 13 32 21
		maxwins = Math.max(maxwins, moves[1]+ moves[5] + moves[2]);
		
		//if 1 = rock, 3 = paper, 2 = scissors --> 12 23  31
		maxwins = Math.max(maxwins, moves[0]+ moves[3] + moves[4]);
		
		//if 2 = rock, 3 = paper, 1 = scissors --> 21 13 32
		maxwins = Math.max(maxwins, moves[2]+ moves[1] + moves[5]);
		
		//if 2 = rock, 1 = paper, 3 = scissors --> 23 31 12
		maxwins = Math.max(maxwins, moves[3]+ moves[4] + moves[0]);
		
		//if 3 = rock, 1 = paper, 2 = scissors --> 32 21 13
		maxwins = Math.max(maxwins, moves[5]+ moves[2] + moves[1]);
		
		//if 3 = rock, 2 = paper, 1 = scissors --> 31 12 23
		maxwins = Math.max(maxwins, moves[4]+ moves[0] + moves[3]);
		
		out.println(maxwins);
		
		in.close();
		out.close();
	}
}

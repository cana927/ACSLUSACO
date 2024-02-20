//package u2023;

import java.util.*;

public class candyCaneFeast {
	public static void main (String [] args) {
		Scanner sc = new Scanner (System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		long [] cowh = new long [N];
		for (int i = 0; i<N; i++) {
			cowh[i] = sc.nextLong();
		}
		long [] cch = new long [M];
		for (int i = 0; i<M; i++) {
			cch[i] = sc.nextLong();
		}
		
		for (int c = 0; c< M; c++) {
			long ccmax = cch[c];
			long ccmin = 0;
			int cowplace = 0;
			
			while (ccmin<ccmax && cowplace <N) {
				if (cowh[cowplace] > ccmin) {
					long h = cowh[cowplace];
					cowh[cowplace] += Math.min(h, ccmax) - ccmin;
					ccmin = h;
				}
				//System.out.println (cowplace + " " + ccmin);
				cowplace ++; 
			}
		}
		for (long h : cowh) {
			System.out.println (h);
		}
	}
}

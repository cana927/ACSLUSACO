//package u2020;
import java.io.*;
import java.util.*;

public class daisyChains2 {
	public static void main (String [] args) throws IOException {
		BufferedReader in = new BufferedReader (new InputStreamReader (System.in));
		int N = Integer.parseInt(in.readLine());
		StringTokenizer st = new StringTokenizer (in.readLine());
		
		int [] flowers = new int [N];
		for (int i = 0; i<N; i++) {
			flowers[i] = Integer.parseInt(st.nextToken());
		}
		
		int total = 0;
		
		for (int i = 0; i<N; i++) {
			for (int j = i; j<N; j++) {
				double sum = 0;
				
				for (int r = i; r<=j; r++) {
					sum += flowers[r];
				}
				
				double avg = sum / (j-i+1);
				
				int num = 0;
				for (int r = i; r<=j; r++) {
					if ((double)flowers[r] == avg){
						num ++;
					}
				}
				
				if (num > 0) {
					total++;
				}
			}
		}
		
		System.out.println (total);
	}
	
}

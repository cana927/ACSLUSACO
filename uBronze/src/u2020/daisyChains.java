package u2020;
import java.io.*;
import java.util.*;

public class daisyChains {
	public static void main (String [] args) {
		Scanner in = new Scanner (System.in);
		
		int N = in.nextInt();
		
		int [] n = new int [N];
		for (int i =0; i<N; i++) {
			n[i] = in.nextInt();
		}
		
		int answer = 0;
		for (int i = 0; i<N; i++) { //starting pos
			for (int j =i; j<N; j++) { //ending pos
				int sum = 0;
				for (int r = i; r<=j; r++) {
					sum += n[r];
				}
				double average = sum / (j-i + 1.0);
				
				boolean contains = false;;
				for (int r = i; r<=j; r++) {
					if (n[r] == average) {
						contains = true;
						break;
					}
				}
				if (contains) answer++;
			}
		}
		System.out.println(answer);
	}
}

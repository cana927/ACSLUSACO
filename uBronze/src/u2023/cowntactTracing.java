//package u2023;

import java.util.Scanner;

public class cowntactTracing {
	public static void main (String [] args) {
		Scanner sc = new Scanner (System.in);
		int N = sc.nextInt();
		int [] cows = new int [N];
		String cs = sc.next();
		for (int i = 0; i < N; i++) {
			cows[i] = cs.charAt(i) - '0';
		}
		Boolean valid = true;
		int sum = 0;
		
		while (valid) {
			sum = 0;
			for (int c : cows) {
				sum += c;
			}
			if (sum == N) {
				valid = false;
				sum = 1;
			}
			
			//System.out.println (cows[0]+" "+cows[1]+" "+cows[2]+" "+cows[3]+" "+cows[4]+" "+cows[5]);

			for (int i = 0 ; i< N; i++) {
				if (N >1 && i ==0 && cows[i] == 1 && cows[i+1] == 0) {
					valid = false;
					//System.out.println ("H");
				}
				else if (N >1 && i ==0 && cows[i] == 1 && cows[i+1] == 1 && cows[i+2] == 1) {
					cows[i] = 0;
				}
				else if (N >1 && i ==0 && cows[i] == 1 && cows[i+1] == 1 && cows[i+2] == 0) {
					cows[i+1] = 0;
					i++;
				}
				else if (N >1 && i ==N-1 && cows[i] == 1 && cows[i-1] == 0) {
					valid = false;
					//System.out.println (i + " " + "E");
				}
				else if (N >1 && i ==N-1 && cows[i] == 1 && cows[i-1] == 1 && cows[i-2] == 1) {
					cows[i] = 0;
					i++;
				}
				else if (N >1 && i ==N-1 && cows[i] == 1 && cows[i-1] == 1 && cows[i-2] == 0) {
					cows[i-1] = 0;
					i++;
				}
				else if (i>0 && i<N-1 && cows[i] == 1) {
					if (cows[i-1] == 0 && cows[i+1] == 0) {
						valid = false;
						//System.out.println ("S");
					}
					else if (i<N-2 && cows[i+1] == 1 && cows[i+2] == 0) {
						valid = false;
						//System.out.println ("J");
					}
					else if (cows[i-1] == 0) {
						cows[i] = 0;
					}
					else if (cows[i+1] == 0) {
						cows[i] = 0;
						i++;
					}
				}
			}
		}
		System.out.println (sum);
	}
}

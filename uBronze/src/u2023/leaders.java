//package u2023;
import java.util.*;
import java.io.*;


public class leaders {
	public static void main (String [] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(in.readLine());
		
		int firstG = -1;
		int firstH = -1;
		int lastG = 0;
		int lastH = 0;
		
		String c = in.readLine();
		char [] cows = new char [n];
		for (int i = 0; i<n; i++) {
			cows[i] = c.charAt(i);
			if (cows[i] == 'G') {
				if (firstG == -1) {
					firstG = i;
				}
				lastG = i;
			}
			if (cows[i] == 'H') {
				if (firstH == -1) {
					firstH = i;
				}
				lastH = i;
			}
		}
		int [] list = new int [n];
		StringTokenizer st = new StringTokenizer (in.readLine());
		for (int i = 0; i<n; i++) {
			list[i] = Integer.parseInt(st.nextToken());
		}
		
		boolean [] containsall = new boolean [n];
		//G 
		for (int i = 0; i<=firstG; i++) {
			if (cows[i] == 'G') {
				containsall[i] = (list[i] > lastG);
			}
		}
		//H 
		for (int i = 0; i<=firstH; i++) {
			if (cows[i] == 'H') {
				containsall[i] = (list[i] > lastH);
			}
		}
		
		int validpairs = 0;
		
		for (int a = 0; a<=Math.max(firstH, firstG); a++) {
			if (a == 'H') {
				if (firstG>a) {
					boolean acontainsb = (firstG <= list[a]-1);
					if ((acontainsb || containsall[a]) && containsall [firstG]) {
						validpairs++;
					}
				}
			}
			else if (a == 'G'){
				if (firstH>a) {
					boolean acontainsb = (firstH <= list[a]-1);
					if ((acontainsb || containsall[a]) && containsall [firstH]) {
						validpairs++;
					}
				}
			}
		}
		System.out.println (validpairs);
	}
}


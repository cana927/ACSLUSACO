//package u2017;

import java.io.*;
import java.util.*;

public class crossroad2 {
	public static void main (String [] args ) throws IOException {
		BufferedReader in = new BufferedReader (new FileReader("circlecross.in"));
		PrintWriter out = new PrintWriter (new BufferedWriter (new PrintWriter ("circlecross.out")));
		
		String cows = in.readLine();
		int crosspair = 0;
		
		for (int i =0; i<52; i++) {
			char cow = cows.charAt(i);
			Boolean [] gotcow = new Boolean [26];
			for (int r = 0; r<26; r++) {
				gotcow[r] = false;
			}
			int place = i+1;
			if (place == 52) {
				place = 0;
			}
			
			while (cows.charAt(place) != cow) {
				if (gotcow[cows.charAt(place)-'A']) {
					gotcow[cows.charAt(place)-'A'] = false;
				}
				else {
					gotcow[cows.charAt(place)-'A'] = true;
				}
				
				
				place++;
				if (place == 52) {
					place = 0;
				}
			}
			
			for (Boolean b : gotcow) {
				if (b) {
					crosspair++;
				}
			}
		}
		
		crosspair = crosspair / 4;
		out.print(crosspair);
		in.close();
		out.close();
	}
}

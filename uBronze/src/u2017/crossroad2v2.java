package u2017;

import java.util.*;
import java.io.*;

public class crossroad2v2 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader in = new BufferedReader(new FileReader("circlecross.in"));
		PrintWriter out = new PrintWriter("circlecross.out");
		
		String crossing = in.readLine();
		
		int pairs = 0;
		for(int a = 0; a < crossing.length(); a++) {
			for(int b = a+1; b < crossing.length(); b++) {
				for(int c = b+1; c <crossing.length(); c++) {
					for(int d = c+1; d < crossing.length(); d++) {
						pairs += (crossing.charAt(a) == crossing.charAt(c) && crossing.charAt(b) == crossing.charAt(d)) ? 1 : 0;
					}
				}
			}
		}
		
		out.println(pairs);
		in.close();
		out.close();

	}

}

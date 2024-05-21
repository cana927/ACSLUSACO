package u2018;

import java.io.*;
import java.util.*;

public class backAndForth {
	public static void Main (String [] args ) throws IOException {
		BufferedReader in = new BufferedReader(new FileReader("backforth.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("backforth.out")));
		
		StringTokenizer st = new StringTokenizer (in.readLine());
		
		in.close();
		out.close();
	}
}

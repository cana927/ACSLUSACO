package u2018;

import java.util.*;
import java.io.*;

public class badmilk {
	public static void main (String [] args) throws IOException {
		Scanner sc = new Scanner ("badmilk.in");
		PrintWriter out = new PrintWriter(new BufferedWriter (new FileWriter("badmilk.out")));
		
		int N = sc.nextInt();
		int M = sc.nextInt();
		int D = sc.nextInt();
		int S = sc.nextInt();
		
		int [][][] drank = new int [100][M][N]; //   100 = max time   m=milk   n=number of people max    
		int output = 0;
		
		for (int i =0; i<D; i++) {
			int p = sc.nextInt(); // person
			int m = sc.nextInt();  //milk
			int t = sc.nextInt(); //time
			drank[t][m][p] = 1;
		}
		
		
		
		
	}
}

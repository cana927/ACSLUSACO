package u2019;
import java.util.*;
import java.io.*;

public class shell {
	public static void main (String [] args) throws IOException {
		BufferedReader in = new BufferedReader(new FileReader("shell.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("shell.out")));
				
		int N = Integer.parseInt(in.readLine()); 
		
		Query [] queries = new Query [N];
		// int [][] queries = int [N][3];
		
		StringTokenizer st;
		
		for (int i =0; i<N; i++) {
			st = new StringTokenizer(in.readLine());
			int a = Integer.parseInt(st.nextToken()); 
			int b = Integer.parseInt(st.nextToken()); 
			int g = Integer.parseInt(st.nextToken()); 
			queries [i] = new Query (a, b, g);
		}
		
		int maxScore = -1;
		
		int [] shells = new int [4];
		for (int i=1; i<=3; i++) {
			shells [1] = 0;
			shells [2] = 0;
			shells [3] = 0;
			
			shells [i] = 1;
			int score = simulate (shells, queries);
			if (score>maxScore) {
				maxScore = score;
			}
		}
		out.println(maxScore);
		
		in.close();
		out.close();
	}
	
	public static int simulate (int [] shells, Query [] queries) {
		int score = 0;
		for (Query q : queries) {
			swap (q.a, q.b, shells);
			if (shells[q.g] == 1) {
				score++;
			}
		}
		return score;
	}
	public static void swap (int i1, int i2, int [] shells) {
		int temp = shells[1];
		shells [i1] = shells [i2];
		shells [i2] = temp;
	}
}

class Query {
	int a, b, g;
	
	public Query (int a, int b, int g) {
		this.a = a;
		this.b = b;
		this.g = g;
	}
}
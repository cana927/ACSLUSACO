package u2018;
import java.util.*;
import java.io.*;

public class mixmilk {
	static BufferedReader in;
	static PrintWriter out;
	static int [] cap;
	static int [] amt;
	static String output;
	
	public static void main (String [] args) throws IOException {
		init();
		solve();
		output();
	}
	
	public static void init() throws IOException {
		in = new BufferedReader(new FileReader("mixmilk.in"));
		out = new PrintWriter(new BufferedWriter(new FileWriter("mixmilk.out")));
		cap = new int [3];
		amt = new int [3];
		output = "";
		for (int i = 0; i<3; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			cap[i] = Integer.parseInt(st.nextToken());
			amt [i] = Integer.parseInt(st.nextToken());
		}
		
	}
	public static void solve() {
		for (int i =1; i<=100; i++) {
			int one = i%3-1;  
			if (one <0) {
				one = 2;
			}
			int two = i%3;
			
			int pour = Math.min(amt[one], cap[two]-amt[two]);
			amt[one] -= pour;
			amt[two] +=pour;
		}
		output = amt[0] + "\n" + amt[1] + "\n" + amt[2];
	}
	public static void output () throws IOException {
		out.println(output);
		in.close();
		out.close();
	}
}

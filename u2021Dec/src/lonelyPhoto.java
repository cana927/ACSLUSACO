import java.io.*;
import java.util.*;

public class lonelyPhoto {
	static int N;
	static String cows;
	static int output;
	static BufferedReader in;
	static PrintWriter out;
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		init();
		solve();
		output();
	}

	public static void init() throws IOException {
		in = new BufferedReader(new FileReader("stdin.in"));
		out = new PrintWriter(new BufferedWriter(new FileWriter("stdin.out")));
		st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		cows = st.nextToken();
		output = 0;

	}

	public static void solve() {

	}

	public static void output() {

	}
}

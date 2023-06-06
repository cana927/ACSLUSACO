package u2019;
import java.io.*;
import java.util.*;


public class shellGame {
	static BufferedReader in;
	static PrintWriter out;
	static int n;
	static int [] nums;
	static int output; 
	public static void main (String [] args) throws IOException {
		init();
		solve();
		output();
	}
	public static void init() throws IOException {
		in = new BufferedReader(new FileReader("shell.in"));
		out = new PrintWriter(new BufferedWriter(new FileWriter("shell.out")));
		n = Integer.parseInt(in.readLine()); 
		nums = new int [n*3]; 
		for (int i = 0; i<n; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			for (int e = 0;e<3; e++) {
				nums [3*i + e]= Integer.parseInt(st.nextToken());
			}
		}
		output = 0;
	}
	public static void solve() {
		int one = 0;
		int two = 0;
		int three = 0;
		
		int [] place = new int [3];
		place [ 0] = 1;
		place[1] = 2;
		place[2] = 3;
		
		for (int i = 0; i<n; i++) {
			int a = nums [i*3]-1;
			int b = nums [1 + i*3]-1;
			int w = place[a];
			place[a] = place[b];
			place [b] = w; 
			if (place[nums[2+i*3]-1] == 1) {
				one++;
			} else if (place[nums[2+i*3]-1] == 2) {
				two++;
			} else {
				three++;
			}
		}

		output = Math.max(one, Math.max(two, three));
	}
	public static void output () throws IOException {
		out.println(output);
		in.close();
		out.close();
	}
}


import java.util.*;
import java.io.*;

public class mowingField {
	static int [][][] farm;
	static char [] d;
	static int [] s;
	static int n, output;
	static BufferedReader in;
	static PrintWriter out;
	static StringTokenizer st;
	
	public static void main (String [] args) throws IOException {
		init();
		solve();
		output();
	}
	public static void init() throws IOException {
		in = new BufferedReader(new FileReader ("mowing.in"));
		out = new PrintWriter (new BufferedWriter (new FileWriter ("mowing.out")));
		st = new StringTokenizer (in.readLine());
		farm = new int [2001][2001][1];
		n = Integer.parseInt(st.nextToken());
		d = new char [n];
		s = new int [n];
		output = 10000;
		for (int i =0; i<n; i++) {
			st = new StringTokenizer (in.readLine());
			 d[i] = st.nextToken().charAt(0);
			 s[i] = Integer.parseInt(st.nextToken());
		}
	}
	public static void solve() {
		int r = 1;
		int x= 1000;
		int y = 1000;
		farm[x][y][0] = r;
		r++;
		for (int i =0; i<n; i++) {
			if (d[i] == 'N') {
				for (int e = 0; e<s[i]; e++) {
					y += 1;
					if (farm[x][y][0] >0) {
						output = Math.min(output, r - farm[x][y][0]); 
					}
					farm[x][y][0] = r;
					r++;
				}
			}
			else if (d[i] == 'E') {
				for (int e = 0; e<s[i]; e++) {
					x += 1;
					if (farm[x][y][0] >0) {
						output = Math.min(output, r - farm[x][y][0]); 
					}
					farm[x][y][0] = r;
					r++;
				}
			}
			else if (d[i] == 'S') {
				for (int e = 0; e<s[i]; e++) {
					y -= 1;
					if (farm[x][y][0] >0) {
						output = Math.min(output, r - farm[x][y][0]); 
					}
					farm[x][y][0] = r;
					r++;
				}
			}
			else if (d[i] == 'W') {
				for (int e = 0; e<s[i]; e++) {
					x -= 1;
					if (farm[x][y][0] >0) {
						output = Math.min(output, r - farm[x][y][0]); 
					}
					farm[x][y][0] = r;
					r++;
				}
			}
		}
		
	}
	public static void output () throws IOException {
		out.println (output);
		in.close();
		out.close();
	}
	
}

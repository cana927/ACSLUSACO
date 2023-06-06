package u2018;
import java.util.*;
import java.io.*;

public class TeamTicTacToe {
	static char [][] board;
	static int indiv, team;
	static BufferedReader in;
	static PrintWriter out;
	static StringTokenizer st;
	static ArrayList <Integer> one, two;
	
	public static void main (String [] args) throws IOException {
		init();
		solve();
		output();
	}
	public static void init() throws IOException {
		in = new BufferedReader(new FileReader ("tttt.in"));
		out = new PrintWriter (new BufferedWriter (new FileWriter ("tttt.out")));
		board = new char [3][3];
		for (int c = 0; c<3; c++) {
			st = new StringTokenizer (in.readLine());
			String full = st.nextToken().toLowerCase();
			for (int r = 0; r<3; r++) {
				board [c][r] = full.charAt(r);
			}
		}
		indiv = 0;
		team = 0;
		one = new ArrayList<Integer>();
		two = new ArrayList<Integer>();
	}
	public static void solve () {
		
		for (int i = 'a'; i<='z'; i++) {
			boolean onewin = false; 
			for (int r = 'a'; r<='z'; r++) {
				for (int v = 0; v<3; v++) {
					int e =check(board[v][0], board[v][1],board[v][2], (char)i, (char)r); 
					if (e == 1 && !onewin) {
						onewin = true;
						indiv ++;
					}
					if (e==2 && !use(i,r) && !use (r, i)) {
						team++;
						one.add(i);
						two.add(r);
					}
				}
				for (int h = 0; h<3; h++) {
					int e =check(board[0][h], board[1][h],board[2][h], (char)i, (char)r); 
					if (e == 1 && !onewin) {
						onewin = true;
						indiv ++;
					}
					if (e==2 && !use(i,r) && !use (r, i)) {
						team++;
						one.add(i);
						two.add(r);
					}
				}
				int e =check(board[0][0], board[1][1],board[2][2], (char)i, (char)r); 
				if (e == 1 && !onewin) {
					onewin = true;
					indiv ++;
				}
				if (e==2 && !use(i,r) && !use (r, i)) {
					team++;
					one.add(i);
					two.add(r);
				}
				e =check(board[2][0], board[1][1],board[0][2], (char)i, (char)r); 
				if (e == 1 && !onewin) {
					onewin = true;
					indiv ++;
				}
				if (e==2 && !use(i,r) && !use (r, i)) {
					team++;
					one.add(i);
					two.add(r);
				}
			}
		}
	}
	public static int check (char a, char b, char c, char one, char two) {
		if (a == b && b==c && c == one) {
			return 1;
		}
		else if (a == b && b == one && c == two) {
			return 2;
		}
		//else if (a == b && b == two && c == one) {
			//return 2;
		//}
		else if (a == c && c == two && b == one) {
			return 2;
		}
		return 0;
	}
		
	public static void output () throws IOException {
		out.print(indiv);
		out.println ();
		out.println(team);
		in.close();
		out.close();
	}
	
	public static boolean use (int a , int b) {
		for (int i =0; i<one.size(); i++) {
			if (one.get(i) == a && two.get(i) == b) {
				return true;
			} else if (one.get(i) == b && two.get(i) == a){
				return true;
			}
		}
		return false;
	}
}	

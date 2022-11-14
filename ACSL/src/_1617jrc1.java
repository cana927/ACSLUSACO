import java.util.*;

public class _1617jrc1 {
	static Scanner sc= new Scanner (System.in);
	static char [] opp;
	static char [][] dealer;
	static String output;
	
	public static void main (String [] args) {
		for (int i =0; i<5; i++) {
			init();
			solve();
			output();
		}
	}
	public static void init() {
		String all = sc.nextLine();
		all = all.replace(", ","");
		opp = new char [2];
		opp[0] = all.charAt(0);
		opp[1] = all.charAt(1);
		dealer = new char [5][2];
		for (int i =0; i<10; i+= 2) {
			dealer[i/2][0] = all.charAt(i+2);
			dealer[i/2][1] = all.charAt(i+3);
		}
		output = "";
		
	}
	public static void solve() {
		char a ='A' ;
		char b='A';
		for (int i = 0; i<5 ; i++) {
			if (dealer[i][1] == opp[1]) {
				if (dealer[i][0]<a && dealer[i][0]>opp[0]) {
					a = dealer[i][0];
				}else if (dealer[i][0]<b) {
					b = dealer[i][0];
				}
			}
		}
		if (b=='A' && a == 'A') {
			output = "NONE";
		}
		else if (a<'A') {
			int r = a - '0';
			output += r + ", " + Character.toString(opp[1]);
		}else {
			int r = b - '0';
			output += r + ", " + Character.toString(opp[1]);
		}
	}
	public static void output () {
		System.out.println (output);
	}
	
}
/*
5, D, 2, D, 6, H, 9, D, 9, S, 6, H 
4, C, 1, C, 6, C, 7, H, 5, S, 4, D 
3, D, 4, H, 5, C, 6, S, 2, D, 1, D 
9, S, 8, H, 7, C, 7, D, 9, H, 3, H 
1, C, 1, D, 9, H, 8, S, 9, S, 7, C

4, S, 2, S, 5, S, 6, S, 8, S, 9, S
7, H, 3, S, 3, H, 3, D, 3, C, 2, H
9, D, 3, C, 5, H, 1, S, 7, D, 9, S
6, C, 1, S, 2, H, 7, S, 8, D, 9, H
1, D, 2, S, 3, D, 4, S, 2, H, 2, C

*/
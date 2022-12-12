import java.io.*;
import java.util.*;

public class _1516allstar1 {
	static Scanner sc  = new Scanner (System.in);;
	static StringTokenizer st;
	public static void main (String [] args) {
		for (int i =0; i<5; i++) {
			program();
		}
	}
	public static void program () {
		st = new StringTokenizer(sc.nextLine().replace(",", ""));
		
		int num = Integer.parseInt(st.nextToken());
		
		String[][] pyram = new String [num][num];
		
		for (int i=0; i<num; i++) {
			pyram [0][i] = st.nextToken();
		}
		
		for (int i=1; i<num; i++) {
			for (int j=0; j<num-i; j++) {
				pyram [i][j] = st.nextToken();
			}
		}
		
		boolean keepGoing = true;
		
		for (int i=0; i<num-1; i++) {
			for (int j=0; j<num-i-1; j++) {
				String bot1 = "";
				String bot2 = "";
				if (i>0) {
					bot1 = "" + pyram [i][j].charAt(1);
					bot2 = "" + pyram [i][j+1].charAt(1);
				}else {
					bot1 = pyram [i][j];
					bot2 = pyram [i][j+1];
				}
				String top = pyram [i+1][j];
				if (keepGoing) {
					if (top.charAt(0) == 'R')  {
						if (bot1.equals("0") && bot2.equals("0")) {
							if (top.charAt(1) == '1') {
								keepGoing = false;
								System.out.println ("OR, " + (i+2) + ", " + (j+1));
							}
						}else {
							if (top.charAt(1) == '0') {
								keepGoing = false;
								System.out.println ("OR, " + (i+2) + ", " + (j+1));
							}
						}
					}else if (top.charAt(0) == 'A') {
						if (bot1.equals("1") && bot2.equals("1")) {
							if (top.charAt(1) == '0') {
								keepGoing = false;
								System.out.println ("AND, " + (i+2) + ", " + (j+1));
							}
						} else {
							if (top.charAt(1) == '1') {
								keepGoing = false;
								System.out.println ("AND, " + (i+2) + ", " + (j+1));
							}
						}
					} else {
						if (!bot1.equals (bot2)&&(bot1.equals("1") ||bot2.equals("1"))) {
							if (top.charAt(1) == '0') {
								keepGoing = false;
								System.out.println ("XOR, " + (i+2) + ", " + (j+1));
							}
						}else {
							if (top.charAt(1) == '1') {
								keepGoing = false;
								System.out.println ("XOR, " + (i+2) + ", " + (j+1));
							}
						}
					}
				}
				
			}
		}
		
		if (keepGoing) {
			System.out.println ("TRUE");
		}
	}
}

/*
4, 1, 0, 1, 1, R1, X1, A1, X0, A1, A0 
3, 1, 1, 0, A1, X0, R1
4, 0, 1, 1, 0, A0, A1, A0, R0, R1, X1
5, 0, 1, 0, 1, 0, R1, A0, A0, X1, X1, R1, A0, R0, X0, A1
6, 1, 1, 0, 0, 1, 1, A1, R1, X0, R1, A1, R1, A0, A0, R1, X1, R0, X1, A0, R1, X1

3, 1, 0, 1, A0, R1, X1 
4, 0, 0, 1, 1, R0, R1, R1, X1, X1, A0 
5, 1, 1, 1, 0, 0, X0, R1, A0, X1, R1, A1, X1, A0, A0, R0
5, 0, 1, 1, 0, 1, A0, R1, R1, X1, A0, X0, A1, R0, X1, A0
6, 1, 1, 1, 1, 1, 1, A1, R1, R1, A1, X0, X0, A1, R1, X1, R1, A1, R1, A1, R1, X1 
*/
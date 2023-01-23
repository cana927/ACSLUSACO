import java.util.*;
import java.io.*;

public class _1516allstar5 {
	static int num;
	static boolean [] bottom;
	static char [][] type;
	static boolean [][] value;
	static ArrayList <String> output;
	static Scanner sc = new Scanner (System.in);
	
	public static void main (String [] args) {
		for (int i =0; i<5; i++) {
			init();
			solve();
			output();
			System.out.println ();
		}
	}
	
	public static void init() {
		String line = sc.nextLine();
		line = line.replaceAll(", ", " ");
		StringTokenizer st = new StringTokenizer(line);
		num = Integer.parseInt(st.nextToken());
		
		bottom = new boolean [num];
		String hex = st.nextToken();
		int dec = Integer.parseInt(hex, 16);
		String binary = Integer.toBinaryString(dec);
		while (binary.length()<num) {
			binary = "0" + binary;
		}
		for (int i = 0; i<num; i++) {
			if (binary.charAt(i) == '0') {
				bottom[i] = false;
			}else {
				bottom[i] = true;
			}
		}
		
		type = new char [num+1][num];
		value = new boolean [num+1][num];
		for (int i =1; i<num; i++) {
			for (int j = 0; j<num - i; j++) {
				String card = st.nextToken();
				type [i][j] = card.charAt(0);
				if (card.charAt(1) == '0') {
					value [i][j] = false;
				}else {
					value[i][j] = true;
				}
			}
		}
		
		output = new ArrayList<String> ();
	}
	public static void solve() {
		for (int i =0; i<num-1; i++) {
			for (int j = 0; j<num - i - 1; j++) {
				boolean b1 = false;
				boolean b2 = false;
				if (i ==0) {
					b1 = bottom [ j];
					b2 = bottom [j+1];
				} else {
					b1 = value [i][j];
					b2 = value [i][j+1];
				}
				boolean end = value [i+1] [j];
				char relate = type[i+1][j];
				
				char ok = equalQuestion(b1, b2, relate, end);
				if (ok != type[i+1][j]) {
					String correct = "";
					if (ok == '0') {
						output.add((i+2) + ", " + (j+1) + ", " + "NONE");
						i = 100;
						j = 100;
					}else {
						if (ok == 'A') {
							correct = "AND";
						}else if (ok == 'R' ) {
							correct = "OR";
						} else {
							correct = "XOR";
						}
						if (value[i+1][j]) {
							correct += "1";
						}else {
							correct += "0";
						}
						
						output.add((i+2) + ", " + (j+1) + ", " + correct);
					}
					
				}
				
			}
		}
	}
	public static void output () {
		if (output.size() ==0) {
			System.out.println("TRUE");
		}else {
			for (int i =0; i<output.size(); i++) {
				System.out.println (output.get(i));
			}
		}
	}
	
	public static char equalQuestion (boolean b1, boolean b2, char type, boolean b3) {
		char a = '0';
		if ((b1^b2) == b3){
			if (type == 'X') {
				return 'X';
			}
			a = 'X';
		} 
		if ((b1 || b2) == b3) {
			if (type == 'R') {
				return 'R';
			}
			a = 'R';
		} 
		if ((b1 && b2) == b3) {
			if (type == 'A') {
				return 'A';
			}
			a = 'A';
		} 
		return a;
	}
}

/*
4, B, R1, X1, A1, X0, A1, A0
3, 6, A1, X0, R1
4, 6, A0, X1, A0, R0, R1, X1
5, 0, A0, R1, A0, A0, X1, X1, R1, A0, R0, X0
6, 33, A1, R1, X0, R1, A1, R1, A0, A0, R1, X1, R0, X1, A0, R1, X1

3, 6, A0, R1, A1
3, 6, X0, X0, R1
3, 6, X1, R1, A1 
4, F, X1, R1, A1, R0, R1, X1
4, C, A1, R1, X1, R0, X0, A1
4, 0, A0, X0, R0, X0, A0, R0 
5, 1F, R1, X1, R1, X1, A1, A1, R1, A1, X1, A1
5, 4, A0, X0, R0, X0, A1, R1, R0, A0, R0, A1
6, 33, A1, R1, A1, R1, A1, R1, X0, R0, X1, A1, X1, R0, R1, X0, A0, R1
6, 38, A1, R1, X1, R1, A1, X0, X0, X0, X0, A1, R0, A1, X1, X1, A0
*/

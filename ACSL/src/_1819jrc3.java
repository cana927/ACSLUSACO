import java.util.*;
import java.io.*;

public class _1819jrc3 {
	static Scanner sc = new Scanner(System.in);
	static int r, c, s;
	static int [][] table;
	static String output;
	
	public static void main (String [] args) {
		for (int i =0; i<5; i++) {
			init();
			solve();
			output();
		}
	}
	
	public static void init() {
		r = sc.nextInt();
		c = sc.nextInt();
		s = sc.nextInt();
		output = "";
		int n = sc.nextInt();
		table = new int [r][c];
		for (int i =0; i<n; i++) {
			int a = sc.nextInt();
			table[a/c][(a-1)%c] = 1;
		}
		
	}
	public static void solve () {
		int currR = s/c;
		int currC = (s-1)%c;
		int block = 1; // A=1 B=2 C=3
		ArrayList <Integer> list = new ArrayList <Integer> (); //list of used blocks
		
		while (currC<c-1) {
			if (blockPossible(block, currR, currC)) {
				if (block == 1) {
					currC += 3;
				}else if (block ==2) {
					currC+=2;
					currR+= 1;
				}else {
					currC += 2;
					currR+=2;
				}
				list.add(block);
				
				block++;
				if (block>3) {
					block = 1;
				}
				
			}else {
				block++;
				if (block>3) {
					block = 1;
				}
			}
		}
		
		for (int i=0; i<list.size(); i++) {
			if (list.get(i) ==1) {
				output += "A";
			}
			if (list.get(i) ==2) {
				output += "B";
			}
			if (list.get(i) ==3) {
				output += "C";
			}
		}
	}
	public static void output() {
		System.out.println (output);
	}
	public static boolean blockPossible (int b, int row, int col) {
		if (b==1) {
			if (col+2 >= c) {
				return false; 
			}
			if (table[row][col+1] == 1) {
				return false;
			}
			
			if (table[row][col+2] == 1) {
				return false;
			}
		}else if (b==2) {
			if (row+1 >= r) {
				return false;
			}
			if (table[row+1][col] == 1) {
				return false;
			}
			
			if (col+1>=c) {
				return false; 
			}
			if (table[row+1][col+1] == 1) {
				return false;
			}
		}else {
			if (col+1 >= c) {
				return false; 
			}
			if (table[row][col+1] == 1) {
				return false;
			}
			
			if (row+2 >= r) {
				return false; 
			}
			if (table[row+1][col+1] == 1) {
				return false;
			}
			
			if (table[row+2][col+1] == 1) {
				return false;
			}
		}
		
		return true;
		
	}
}

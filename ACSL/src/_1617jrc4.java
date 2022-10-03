import java.io.*;
import java.util.*;
public class _1617jrc4 {
	static ArrayList<String> permutations;
	static Scanner sc = new Scanner (System.in);
	static Clue c;
	static int output;
	
	public static void main (String [] args) {
		permutations = new ArrayList<String>();
		for (int a = 1; a<=5; a++) {
			for (int b =1; b<=5; b++) {
				if (a==b) continue;
				for (int c =1; c<=5; c++) {
					if (c!=a && c!=b) {
						for (int d = 1; d<=5; d++) {
							if (d!=a && d !=b && d!=c) {
								for (int e=1;e<=5; e++) {
									if (e!=a && e!=b && e!=c && e!=d) {
										String num = "" + a + b+ c+ d+e;
										permutations.add(num);
									}
								}
							}
						}
					}
					
					
				}
			}
		}
		
		for (int i =0; i<6; i++) {
			init();
			solve();
			output();
		}
		
	}
	public static void init() {
		String line = sc.nextLine();
		int lc = line.charAt(0) - '0';
		int rc = line.charAt(3) - '0';
		c = new Clue(lc,rc);
		output = 0;
	}
	public static void solve() {
		int count =0;
		for (int i =0; i<permutations.size(); i++) {
			Clue pC = generateClue(permutations.get(i));
			if (c.equals(pC)) {
				count++;
			}
		}
		
		output += count;
	}
	public static void output () {
		System.out.println (output);
	}
	public static Clue generateClue (String num) {
		int lc = 0;
		int max = 0;
		for (int i =0; i< num.length(); i++) {
			if (num.charAt(i) > max) {
				max = num.charAt(i);
				lc ++;
			}
		}
		int rc = 0;
		max = 0;
		for (int i =0; i< num.length(); i++) {
			if (num.charAt(i) > max) {
				max = num.charAt(i);
				rc ++;
			}
		}
		
		return new Clue (lc, rc);
	}
}

class Clue {
	int leftNum, rightNum;
	public Clue (int leftNum, int rightNum) {
		this.leftNum = leftNum;
		this.rightNum = rightNum;
	}
	public boolean equals (Clue c) {
		return this.leftNum==c.leftNum && this.rightNum == c.rightNum;
	}
}

/*
1, 2
1, 5
2, 1
2, 4
3, 5
*/
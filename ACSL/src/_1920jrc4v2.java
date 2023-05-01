import java.util.*;

public class _1920jrc4v2 {
	static Scanner sc = new Scanner (System.in);
	static int opp1, opp2, opp3, curr, num;
	static int [] moves;
	static int output;
	static int [][] special = {{6,8}, {11,13}, {16,18}, {21, 23}, {26,28}, {34, 36}, {39, 41}, {44,46}, {49,51}};
	public static void main (String [] args) {
		for (int i =0; i<5; i++) {
			init();
			solve();
			output();
		}
		
	}
	
	public static void init() {
		output = 0;
		opp1 = sc.nextInt();
		opp2 = sc.nextInt();
		opp3 = sc.nextInt();
		
		curr = sc.nextInt();
		
		num = sc.nextInt();
		moves = new int [num];
		
		for (int i = 0; i<num; i++) {
			moves[i] = sc.nextInt();
		}
	}
	public static void solve() {
		for (int i =0; i<num; i++) {
			output = curr + moves[i];
			
			if (output == opp1 || output == opp2 || output == opp3 ) {
				output = curr;
			}
			else if (output == 52) {
				output = -1;
			}
			else if (output >52) {
				output = curr;
			}
			else if (output == 1 || output == 3 || output == 5 || output == 7 || output == 11 
					 || output == 13 || output ==17 || output == 19 || output == 29 || output == 31
					 || output ==37 || output == 41 || output == 47) {
				for (int r = 0; r<6; r++) {
					output ++;
					if (output == opp1 || output == opp2 || output == opp3) {
						output --;
						break;
					}
				}
			}
			else if (output == 9 || output == 16 || output == 25 || output == 36 || output == 49) {
				for (int r = 0; r<6; r++) {
					output --;
					if (output == opp1 || output == opp2 || output == opp3) {
						output ++;
						break;
					}
				}
			}
			else { 
				for (int r = 0; r<special.length; r++) {
					if (curr <=special[r][0] && output >= special[r][1]) {
						output = curr +1 ;
						while (output % moves[i] != 0) {
							output ++;
						}
						if (output > 52) {
							output = curr;
						}
						
					}
				}
			}
			curr = output;
			
		}
	}
	public static void output() {
		if (curr == -1) {
			System.out.println ("GAME OVER");
		}else {
			System.out.println (output);
		}
	}
}




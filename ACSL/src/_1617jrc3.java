import java.util.*;

public class _1617jrc3 {
	static int [][] offsets = {
			{2,0},
			{1,-1}, {1,0}, {1,1},
			{0,-2}, {0, -1}, {0, 0}, {0,1}, {0, 2},
			{-1,-1}, {-1,0}, {-1,1},
			{-2,0}
	};
	
	
	static int [][] board;
	static Scanner sc;
	static String output;
	static int Row, Col;
	public static void main (String [] args) {
		sc = new Scanner (System.in);
		for (int i =0; i<5; i++) {
			init();
			solve();
			output();
		}
	}
	public static void init() {
		output = "";
		board = new int [8][8];
		
		int r = Integer.parseInt(sc.next().replace(",", "")); 
		for (int i=0; i<r; i++) {
			String num = sc.next().replace(",", "");
			int row = num.charAt(0) - '0' ;
			for (int e= 1; e<num.length(); e++) {
				int col = num.charAt(e) - '0' ;
			board [row-1][col-1] = 1;
			}
		}
		int w = sc.nextInt();
		Row = w/10 - 1;
		Col = w%10 -1;
	}
	public static void solve() {
		for (int i =0; i<offsets.length; i++) {
			int newRow = Row + offsets[i][0];
			int newCol = Col + offsets[i][1];
			
			if (0<= newRow && newRow<=7 && 0<=newCol && newCol<=7) {
				flip(newRow, newCol);
			}
		}
		
		int count = 0;
		for (int i =0; i<7; i++) {
			for (int j=0; j<=7; j++) {
				count += board[i][j];
			}
		}
		output = "" + count;
	}
	public static void output () {
		System.out.println (output);
	}
	
	public static void flip (int r, int c) {
		if (board[r][c] == 1) {
			board [r][c] = 0;
		}else {
			board[r][c] =1;
		}
	}
}
/*
2, 434, 523, 43
1, 58, 58
1, 58, 57
1, 518, 51
3, 32, 44, 56, 54

1, 11, 22
3, 223, 323, 423, 33 
3, 524, 63, 724, 53
4, 2345, 34, 54, 6345, 11 
4, 118, 435, 635, 818, 54
 */

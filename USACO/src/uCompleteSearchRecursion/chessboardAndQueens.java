package uCompleteSearchRecursion;
import java.util.*;

public class chessboardAndQueens {
	public static void main (String [] args) {
		int [][] board = new int [8][8];
		Scanner sc = new Scanner (System.in);
		
		for (int i = 0; i<8; i++) {
			String line = sc.next();
			for (int r = 0; r<8; r++) {
				if (line.charAt(r) == '.') {
					board[i][r] = 0;
				}
				else {
					board[i][r] = 1;
				}
			}
		}
		
		int num = 0;
		
		
	}
}

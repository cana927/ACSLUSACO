import java.io.*;
import java.util.*;

public class _1617intc4 {
	public static void main (String [] args) {
		Scanner sc = new Scanner (System.in);
		
		int [][] board = new int [6][6];
		
		String [] nums = sc.nextLine().split(", ");
		
		for (int i = 0; i<4; i++)  {
			board [0][i+1] = nums[0].charAt(i) - '0';
			board [5][i+1] = nums[5].charAt(i) - '0';
		}
		
		for (int i = 1; i<4; i++) {
			if (nums[i].length() == 2) {
				board [i][0] = nums[i].charAt(0) - '0';
				board [i][5] = nums[i].charAt(1) - '0';
			}else {
				board [i][0] = nums[i].charAt(0) - '0';
				board [i][1] = nums[i].charAt(1) - '0';
				board [i][2] = nums[i].charAt(2) - '0';
				board [i][3] = nums[i].charAt(3) - '0';
				board [i][4] = nums[i].charAt(4) - '0';
				board [i][5] = nums[i].charAt(5) - '0';
			}
		}
		
		for (int i = 1; i<5; i++) {
			if (board[i][0] == 1)
		}
	}
}

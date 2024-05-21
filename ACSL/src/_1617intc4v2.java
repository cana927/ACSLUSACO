
import java.util.*;
import java.io.*;
public class _1617intc4v2 {

	static int N = 4;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String[] input = in.readLine().split(" ");
		
		int[][] grid = new int[4][4];
		String[] colRules = new String[4];
		String[] rowRules = new String[4];
		for(int i = 0; i < 4; i++) {
			colRules[i] = input[0].charAt(i) + "" + input[5].charAt(i);
		}
		for(int i = 1; i < 5; i++) {
			if(input[i].length() == 2) {
				rowRules[i-1] = input[i];
			}
			else {
				rowRules[i-1] = input[i].charAt(0) + "" + input[i].charAt(5);
				for(int j = 0; j < 4; j++) {
					grid[i-1][j] = input[i].charAt(j+1)-'0';
				}
			}
		}
		
		boolean temp = fillGrid(grid, 0, 0, rowRules, colRules);
		
		for(int i = 0;  i< 5; i++) {
			String coord = in.readLine();
			int r = coord.charAt(0)-'0'-1;
			int c = coord.charAt(1)-'0'-1;
			System.out.println(grid[r][c]);
		}

	}
	
	public static boolean fillGrid(int[][] grid, int row, int col, String[] rowRules, String[] colRules) {
		
		if(row == N-1 && col == N) {
			return true;
		}
		
		if(col == N) {
			row++;
			col = 0;
		}
		
		if(grid[row][col] != 0) {
			return fillGrid(grid, row, col+1, rowRules, colRules);
		}
		
		for(int num = 1; num <= 4; num++) {
			
			if(isSafe(grid, row, col, num, rowRules, colRules)) {
				grid[row][col] = num;
				if(fillGrid(grid, row, col+1, rowRules, colRules)) {
					return true;
				}
			}
			grid[row][col] = 0;
			
		}
		return false;
	}
	
	public static boolean isSafe(int[][] grid, int row, int col, int num, String[] rowRules, String[] colRules) {
		
		for(int i = 0; i < N; i++) {
			if(grid[row][i] == num) {
				return false;
			}
		}
		
		for(int i = 0; i < N; i++) {
			if(grid[i][col] == num) {
				return false;
			}
		}
		
		int visible = 0;
		int max = Integer.MIN_VALUE;
		//go through the row clue for the current row we are in, going left to right
		for(int i = 0; i < N; i++) {
			int rowClue = rowRules[row].charAt(0)-'0';
			if(grid[row][i] != 0 && grid[row][i] > max) {
				max = grid[row][i];
				visible += 1;
			}
			if(visible > rowClue) {
				return false;
			}
		}
		
		//go through the col rule for the current col we are in (top to bottom for col)
        visible = 0;
        max = Integer.MIN_VALUE;
        for(int i = 0; i < 4; i++) {
        	int colClue = colRules[col].charAt(0)-'0';
        	if(grid[i][col] != 0 && grid[i][col] > max) {
        		max = grid[i][col];
        		visible += 1;
        	}
        	if(visible > colClue) {
        		return false;
        	}
        }
        
        //go through the row rule for the current row we are in (right to left)
        visible = 0;
        max = Integer.MIN_VALUE;
        for(int i = 3; i >= 0; i--) {
        	int rowClue = rowRules[row].charAt(1)-'0';
        	if(grid[row][i] != 0 && grid[row][i] > max) {
        		max = grid[row][i];
        		visible += 1;
        	}
        	if(visible > rowClue) {
        		return false;
        	}
        }
        
        //go through the col rule for the current col we are in (bottom to top)
        visible = 0;
        max = Integer.MIN_VALUE;
        for(int i = 3; i >= 0; i--) {
        	int colClue = colRules[col].charAt(1)-'0';
        	if(grid[i][col] != 0 && grid[i][col] > max) {
        		max = grid[i][col];
        		visible += 1;
        	}
        	if(visible > colClue) {
        		return false;
        	}
        }
 
        return true;
		
	}

}
/*
3221 41 22 14 231422 2313
14
34
23
32
21

2124 23 13 221432 41 3321
11
23
42
24
14

*/

import java.util.*;
/*
231, 1233, 1302, 1201
1, 1
2, 4
3, 2
4, 4
2, 2 

31, 203, 1 3120
3, 4
1, 1
3, 2
2, 3
4, 4
  
 */
public class _1718jrc3 {
	static Scanner sc;
	static int [][] ogrid;
	static String output;
	static int begX, begY;
	
	public static void main (String [] args) {
		sc= new Scanner (System.in);
		String input = sc.nextLine();
		input = input.replace(", "," ");
		StringTokenizer st  = new StringTokenizer(input);
		ogrid = new int [4][4];
		
		for (int i = 0; i<4; i++) {
			String fournum = st.nextToken();
			for (int j = 0; j<4; j++) {
				if (j>=4-fournum.length()) {
					ogrid [i][j] = fournum.charAt(j-(4-fournum.length()))-'0';
				} else {
					ogrid [i][j] = 0;
				}
			}
		}
		
		for (int e = 0; e<5; e++) {
			init();
			solve();
			output();
		}
	}
	public static void init() {
		String line = sc.nextLine();
		line= line.replace(", ", " ");
		StringTokenizer a = new StringTokenizer(line);
		begY = Integer.valueOf(a.nextToken());
		begX = Integer.valueOf(a.nextToken());
		output = "";
	}
	public static void solve() {
		int [][] grid = new int [4][4];
		for (int i = 0; i<4; i++) {
			for (int j = 0; j<4; j++) {
				grid[i][j] = ogrid [i][j];
			}
		}
		//positioning
		int rowsY = begY -1;
		int colsX = begX -1;
		
		for (int i = 0; i<6; i++ ) {
			if (grid[rowsY][colsX] == 3) {
				if (grid[rowsY][colsX] <3) {
					grid[rowsY][colsX]++;
				}else {
					grid[rowsY][colsX] =0;
				}
				if (rowsY<3) {
					rowsY++;
				}else {
					rowsY = 0;
				}
			} else if (grid[rowsY][colsX] == 2) {
				if (grid[rowsY][colsX] <3) {
					grid[rowsY][colsX]++;
				}else {
					grid[rowsY][colsX] =0;
				}
				if (rowsY>0) {
					rowsY--;
				}else {
					rowsY = 3;
				}
			}else if (grid[rowsY][colsX] == 0) {
				if (grid[rowsY][colsX] <3) {
					grid[rowsY][colsX]++;
				}else {
					grid[rowsY][colsX] =0;
				}
				if (colsX<3) {
					colsX++;
				}else {
					colsX=0;
				}
			}else if (grid[rowsY][colsX] == 1) {
				if (grid[rowsY][colsX] <3) {
					grid[rowsY][colsX]++;
				}else {
					grid[rowsY][colsX] =0;
				}
				if (colsX>0) {
					colsX--;
				}else {
					colsX=3;
				}
			}

		}
		rowsY++;
		colsX++;
		output = rowsY + ", " + colsX;
		
	}
	public static void output () {
		System.out.println(output);
	}
}

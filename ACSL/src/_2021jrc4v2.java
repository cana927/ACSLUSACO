import java.util.*;

public class _2021jrc4v2 {
	static int question;
	static int [][] matrix;
	static Scanner sc = new Scanner (System.in);
	static int output; 
	public static void main (String [] args) {
		for (int i =0; i<5; i++) {
			init();
			solve();
			output();
		}
	}
	public static void init() {
		question = sc.nextInt();
		matrix = new int [9][9];
		StringTokenizer st = new StringTokenizer(sc.nextLine());
		
		while (st.hasMoreTokens()) {
			String t = st.nextToken();
			matrix[t.charAt(0)-'0'-1][t.charAt(1)-'0'-1] = 1;
		}
		output = 0;
	}
	public static void solve () {
		if (question == 1) {
			for (int i = 0; i<9; i++) {
				if (matrix[i][i] == 1) {
					output++;
				}
				for (int r = 0; r<i; r++) {
					if (matrix[i][r] == 1 && matrix[r][i] == 1) {
						output++;
					}
				}
			}
		}else if (question ==2) {
			int num = 0;
			int max = 0;
			for (int i =0; i<9; i++) {
				int count = 0;
				for (int r = 0; r<9; r++) {
					count += matrix[i][r];
				}
				if (count > max) {
					max = count;
					num = i;
				}
			}
			for (int i =0; i<9; i++) {
				if (matrix[num][i] == 1) {
					output += (num+1)*10 + i+1;
				}
			}
		} else {
			for (int i =0; i<9; i++) {
				for (int r = 0; r<9; r++) {
					if (matrix[i][r] == 1) {
						for (int t = 0; t<9; t++) {
							if (matrix[r][t] == 1) {
								output ++;
							}
						}
					}
				}
			}
		}
	}
	public static void output () {
		System.out.println (output);
	}
}
/*
2 12 13 23 31 34 41
1 12 23 34 11 21 32 45 53 95 43 99 29 91
3 12 23 34 41 31 52 45 61 14 21 33 55 13 54 32 56 36
1 12 11 33 34 43 55 52 41 31 25 88 79 98 45 13 42 87 35 51 21 14 78
2 12 11 33 34 43 55 52 41 31 25 88 79 98 45 13 42 87 35 51 21 14 78

1 12 31 41 42 43 45 51 63 64 56 16
2 12 13 22 23 24 34 42 98 71 87 17 96 67
3 12 14 21 24 25 32 41 43 59 65 91 87 76 95
2 11 12 14 15 23 25 31 43 45 51 52 68 79 87 89
3 55 77 45 54

 */

import java.util.*;
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

public class _2021jrc4 {
	static int query;
	static int [][] adj;
	static Scanner sc;
	static int output;
	
	public static void main (String [] args) {
		sc = new Scanner (System.in);
		
		for (int i =0; i<5; i++) {
			init();
			solve();
			output();
		}
	}
	public static void init() {
		query = sc.nextInt();
		adj = new int [9][9];
		output = 0;
		
		StringTokenizer st = new StringTokenizer(sc.nextLine());
		while(st.hasMoreTokens()) {
			String t = st.nextToken();
			int origin = t.charAt(0) - '0' -1;
			int dest = t.charAt(1) - '0' -1;
			adj[origin][dest] = 1;
		}
	}
	public static void solve() {
		if (query ==1) {
			int sum =0;
			for (int i =0; i<9; i++) {
				if (adj[i][i] == 1) {
					sum++;
				}
				for (int j =0; j<9; j++) {
					if (i<j) {
						if (adj[i][j] ==1 && adj [j][i] ==1) {
							sum++;
						}
					}
				}
			}
			output = sum;
		}
		else if (query ==2) {
			int vertex = 0;
			int maxedges = 0;
			for (int i=0; i<9; i++) {
				int edges = 0;
				for (int r=0; r<9; r++) {
					if (adj[i][r] ==1) { 
						edges ++;
					}
				}
				if (edges>maxedges) {
					vertex = i;
					maxedges = edges;
				}
				
			}
			int sum =0;
			for (int i =0; i<9; i++) {
				if (adj[vertex][i] == 1) {
					sum += (vertex+1)* 10 + i + 1;
				}
			}
			output = sum;
		}
		else {
			int sum = 0;
			for (int i= 0; i<9; i++) {
				for (int j = 0; j<9; j++) {
					if (adj[i][j] ==1) {
						for (int r =0; r<9; r++) { 
							if (adj[j][r] == 1) {
								sum++;
							}
						}
					}
				}
			}
			output = sum;
		}
	}
	public static void output() {
		System.out.println (output);
	}
}

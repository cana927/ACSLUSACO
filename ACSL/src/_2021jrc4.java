import java.util.*;

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
			int origin = t.charAt(0) - '0';
			int dest = t.charAt(1) - '0';
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
			//find sum
			output = 
		}
		else {
			
		}
	}
	public static void output() {
		
	}
}

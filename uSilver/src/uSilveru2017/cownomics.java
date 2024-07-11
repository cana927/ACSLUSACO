package uSilveru2017;

import java.util.*;
import java.io.*;
public class cownomics {

	static String[] spotty, plain;
	static int N, M;
	static int[][] S, P;
	static int[] A;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader in = new BufferedReader(new FileReader("cownomics.in"));
		PrintWriter out = new PrintWriter("cownomics.out");
		
		StringTokenizer st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		spotty = new String[500];
		plain = new String[500];
		S = new int[500][50];
		P = new int[500][50];
		A = new int[64];
		
		for(int i = 0 ; i < N; i++) {
			spotty[i] = in.readLine();
			for(int j = 0; j < M; j++) {
				if(spotty[i].charAt(j) == 'A') S[i][j] = 0;
				if(spotty[i].charAt(j) == 'C') S[i][j] = 1;
				if(spotty[i].charAt(j) == 'G') S[i][j] = 2;
				if(spotty[i].charAt(j) == 'T') S[i][j] = 3;
			}
		}
		
		for(int i = 0 ; i < N; i++) {
			plain[i] = in.readLine();
			for(int j = 0; j < M; j++) {
				if(plain[i].charAt(j) == 'A') P[i][j] = 0;
				if(plain[i].charAt(j) == 'C') P[i][j] = 1;
				if(plain[i].charAt(j) == 'G') P[i][j] = 2;
				if(plain[i].charAt(j) == 'T') P[i][j] = 3;
			}
		}
		
		int ans = 0;
		for(int i = 0;i < M; i++) {
			for(int j = i+1; j < M; j++) {
				for(int k = j+1; k < M; k++) {
					if(testLocation(i,j,k)) {
						ans++;
					}
				}
			}
		}
		
		out.println(ans);
		in.close();
		out.close();

	}
	
	public static boolean testLocation(int i, int j, int k) {
		
		boolean good = true;
		
		for(int x = 0; x < N; x++) {
			A[S[x][i]*16 + S[x][j]*4 + S[x][k]] = 1;
		}
		
		for(int x = 0; x < N; x++) {
			if(A[P[x][i]*16 + P[x][j]*4 + P[x][k]] == 1) {
				good = false;
			}
		}
		
		for(int x = 0; x < N; x++) {
			A[S[x][i]*16 + S[x][j]*4 + S[x][k]] = 0;
		}
		
		return good;
		
	}

}
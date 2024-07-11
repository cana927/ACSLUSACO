package u2019;

import java.io.*;
import java.util.*;

public class gymnastics {

	public static void main(String[] args) throws IOException {
		
		BufferedReader in = new BufferedReader(new FileReader("gymnastics.in"));
		PrintWriter out = new PrintWriter("gymnastics.out");
		StringTokenizer st = new StringTokenizer(in.readLine());
		int K = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		
		int[][] data = new int[K][N];
		int[][] better = new int[N][N];
		
		for(int i = 0; i < K; i++) {
			st = new StringTokenizer(in.readLine());
			for(int j = 0; j < N; j++) {
				data[i][j] =  Integer.parseInt(st.nextToken())-1;
			}
		}
		
		for(int i= 0; i < K; i++) {
			for(int j = 0; j < N; j++) {
				for(int k = j+1; k < N; k++) {
					better[data[i][j]][data[i][k]]++;
				}
			}
		}
		
		int ans = 0;
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if(better[i][j] == K) {
					ans++;
				}
			}
		}
		
		out.println(ans);
		in.close();
		out.close();

	}

}

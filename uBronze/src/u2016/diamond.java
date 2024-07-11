package u2016;

import java.util.*;
import java.io.*;
public class diamond {

	public static void main(String[] args) throws IOException {
		
		BufferedReader in = new BufferedReader(new FileReader("diamond.in"));
		PrintWriter out = new PrintWriter("diamond.out");
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int[] diamonds = new int[n];
		
		for(int i = 0; i < n; i++) {
			diamonds[i] = Integer.parseInt(in.readLine());
		}
		
		int most = 0;
		for(int a : diamonds) {
			
			int fits = 0;
			for(int b : diamonds) {
				if(a <= b && b <= a+k) {
					fits += 1;
				}
			}
			most = Math.max(most, fits);
		}
		
		out.println(most);
		in.close();
		out.close();

	}

}

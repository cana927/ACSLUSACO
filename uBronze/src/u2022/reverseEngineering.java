package u2022;

import java.util.*;
import java.io.*;
public class reverseEngineering {

	static String[] strings = new String[100];
	static int[] output = new int[100];
	static boolean[] used = new boolean[100];
	static int N, M, T;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		T = Integer.parseInt(in.readLine());
		for(int i = T; i > 0; i--) {
			
			in.readLine();
			st = new StringTokenizer(in.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			
			for(int j = 0; j < M; j++) {
				st = new StringTokenizer(in.readLine());
				strings[j] = st.nextToken();
				output[j] = Integer.parseInt(st.nextToken());
			}
			
			Arrays.fill(used, false);
			
			while(true) {
				
				boolean splitFound = false;
				for(int j = 0; j < N; j++) {
					if(split(j, '0', 0) || split(j, '0', 1) || split(j, '1', 0) || split(j, '1', 1)) {
						splitFound = true;
					}
				}
				
				if(!splitFound) {
					System.out.println("LIE");
					break;
				}
				
				if(allEqual(0) || allEqual(1)) {
					System.out.println("OK");
					break;
				}
				
			}
			
		}

	}
	
	public static boolean allEqual(int testOut) {
		for(int i = 0; i < M; i++) {
			if(!strings[i].isEmpty() && (output[i] != testOut)) return false;
		}
		return true;
	}
	
	public static boolean split(int j, char comp, int out) {
		//if b[j] == comp return out
		
		if(used[j]) return false;
		
		for(int i = 0; i < M; i++) {
			if(!strings[i].isEmpty() && (strings[i].charAt(j) == comp) && (output[i] != out) ) {
				return false;
			}
		}
		
		//do a split here
		used[j] = true;
		
		for(int i = 0; i < M; i++) {
			if(!strings[i].isEmpty() && (strings[i].charAt(j) == comp)) {
				strings[i] = "";
			}
		}
		
		return true;
		
	}

}
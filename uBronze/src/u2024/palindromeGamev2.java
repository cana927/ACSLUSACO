//package u2024; 13/13

import java.io.*;
import java.util.*;

public class palindromeGamev2 {
	public static void main (String [] args ) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());
		
		StringBuilder sb = new StringBuilder();
		
		for (int i = 0; i<T; i++) {
			String stones = in.readLine();
			if (stones.charAt(stones.length()-1) == '0') {
				sb.append("E\n");
			}else {
				sb.append("B\n");
			}
		}
		String s = sb.toString(); 
		s = s.substring(0, s.length()-1);
		System.out.println(s);
	}
}

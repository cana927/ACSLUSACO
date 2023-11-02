//package u2022;
import java.io.*;
import java.util.*;
	
public class sleepingInClass {
	public static void main (String [] args) throws IOException {
		BufferedReader in = new BufferedReader (new InputStreamReader(System.in));
		int t = Integer.parseInt(in.readLine());
		
		for (int w = 0; w<t; w++) {
			int n = Integer.parseInt(in.readLine());
			int [] nums = new int [n];
			
			StringTokenizer st = new StringTokenizer (in.readLine());
			for (int i =0; i<n; i++) {
				nums[i] = Integer.parseInt(st.nextToken());
			}
			
			int sum = 0;
			for (int a : nums) {
				sum += a;
			}
			
			int minchange = n;
			//for every possible divisor
			for (int i =n; i>= 1; i--) {
				if (sum%i == 0) {
					int value = sum/i;
					
					int currsum = 0;
					//add parts of array to check if possible
					for (int r = 0; r <n; r++) {
						if (currsum <value) {
							currsum += nums[r];
						}
						else if (currsum == value) {
							currsum = 0;
							currsum+=nums[r];
						}
						else {
							break;
						}
					}
					if (currsum == value && n-i < minchange) {
						minchange = n- i;
					}
					
				}
			}
			System.out.println (minchange);
		}
	}
}

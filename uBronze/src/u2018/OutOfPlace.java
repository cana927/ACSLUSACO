//package u2018;

import java.io.*;
import java.util.*;

public class OutOfPlace {
	public static void main (String [] args ) throws IOException{
		BufferedReader in = new BufferedReader(new FileReader("outofplace.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("outofplace.out")));
		
		int N = Integer.parseInt(in.readLine());
		int [] nums = new int [N];
		
		for (int i = 0; i<N; i++) {
			nums[i] = Integer.parseInt(in.readLine());
		}
		
		int count = 0;
		int bessie = 0;
		for (int i =0; i<N; i++) {
			//bessie is before
			if (i>0) {
				if (nums[i] < nums[i-1]) {
					if (i<N-1) {
						if (nums[i-1]<=nums[i+1]) {
							bessie = nums[i];
						}
					}
					else {
						bessie = nums[i];
					}
				}
			}
			if (i<N-1) {
				if (nums[i] > nums[i+1]) {
					if (i>1) {
						if (nums[i-1]<=nums[i+1]) {
							bessie = nums[i];
						}
					}
					else {
						bessie = nums[i];
					}
				}
			}
		}
		if (bessie!=0) {
			int beg = 0;
			
			while (nums[beg]<bessie) {
				beg++;
			}
			
			int end = N-1;
			
			while (nums[end]>bessie) {
				end--;
			}
			
			int prev = nums[beg];
			for (int i = beg; i<end+1; i++) {
				if (nums[i] != prev) {
					count++;
					prev = nums[i];
				}
			}
		}
		
		out.println (count);
		out.close();
		in.close();
	}
}

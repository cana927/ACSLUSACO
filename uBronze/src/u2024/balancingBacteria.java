//package u2024;
import java.util.*;
import java.io.*;

public class balancingBacteria {

	public static void main(String[] args) throws IOException {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		long[] grass = new long[N];
		String[] input = in.readLine().split(" ");
		for(int i = 0; i < input.length; i++) {
			grass[i] = Long.parseLong(input[i]);
		}
		
		//keeping track of how much to adjust the next grass patch bacteria value by
		long adjustment = 0;
		//keeps track of the total number of increase operations that have occurred
		long increase = 0;
		//keeps track of the total number of decrease operations that have occurred
		long decrease = 0;
		
		for(int i = 0; i < N; i++) {
			//adjust the current grass bacteria level value by adjustment
			grass[i] += adjustment;
			if(grass[i] < 0) { //if grass bacteria level is in the negative
				//apply increase operations
				increase = increase - grass[i];
			}
			else { //if grass bacteria level is in the positive
				//apply decrease operations
				decrease = decrease + grass[i];
			}
			//update the adjustment variable for the next element
			adjustment = adjustment + increase - decrease - grass[i];
		}
		
		System.out.println(increase+decrease);

	}

}

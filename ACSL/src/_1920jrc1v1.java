import java.io.*;
import java.util.*;

public class _1920jrc1v1 {
static Scanner sc = new Scanner (System.in);
	
	static char[] N;
	static int P, D;
	
	static char[] output;
	
	
	
	public static void main (String [] args) {
		init();
		solve();
		output();
	}
	
	public static void init() { //initialization
		N = sc.next().toCharArray();
		
		P = sc.nextInt();
		D = sc.nextInt();
		
		output = new char [N.length];
	}
	
	public static void solve() {
		int digit = N[N.length - P] - '0';	
		if (digit <4) {
			digit += D;
			output[N.length-P] = (char)(digit %10 + '0');
		}
		else {
			digit = Math.abs(digit - D); 
			while (digit>9) {
				digit /= 10; 
			}
			output[N.length - P] = (char) (digit + '0');
		}
		for (int i = 0; i<N.length; i++) {
			if (i <N.length-P) {
				output[i] = N[i];
			} else if (i > N.length - P) {
				output [i] = 0;
			}
		}
	}
	
	public static void output () {
		String outs = new String (output);
		System.out.println(outs);
	}
}

import java.util.*;

public class _1920jrc1 {
	static long N,  output;
	static int D,P;
	static Scanner sc = new Scanner (System.in);
	public static void main (String [] args) {
		for (int i=0; i<5; i++) {
			init();
			solve();
			output();
		}
	}
	public static void init() {
		N = sc.nextLong();
		P = sc.nextInt();
		D = sc.nextInt();
		output = 0;
	}
	public static void solve() {
		long digit = N;
		if ((""+N).length() != P) {
			digit = (int)(N % Math.pow(10, P));
		}
		digit = (int)(digit / Math.pow(10, P-1));
		
		if (digit<5)  {
			output = (long)((long)(N/Math.pow(10, P))*Math.pow(10, P));
			
			digit = digit + D;
			digit = digit%10;
			
			output += digit*Math.pow(10, P-1);
		}else {
			output = (long)((long)(N/Math.pow(10, P))*Math.pow(10, P));
			
			digit = Math.abs(digit-D);
			while (digit>9) {
				digit = digit /10;
			}
			
			output += digit *Math.pow(10, P-1);
		}
	}
	public static void output() {
		System.out.println (output);
	}
}


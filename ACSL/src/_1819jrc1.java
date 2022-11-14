import java.util.*;

public class _1819jrc1 {
	static Scanner sc = new Scanner (System.in);
	static int t;
	static String num;
	static int output ; 
	
	public static void main (String [] args) {
		for (int i = 0; i<5; i++) {
			t = i + 1;
			init ();
			solve();
			output();
		}
	}
	public static void init() {
		num = sc.next();
		output = 0;
	}
	public static void solve () {
		if (t ==1) {
			output = num.length();
		}else if (t==2) {
			for (int i =0; i<num.length(); i++) {
				output += num.charAt(i) - '0';
			}
		}else if (t==3) {
			for (int i =0; i<num.length(); i=i+2)  {
				output += num.charAt(i) - '0';
			}
		}else if (t==4) {
			for (int i =0; i<num.length(); i++) {
				if (num.charAt(i) == '4') {
					output ++;
				}
			}
		}else if (t==5) {
			if (num.length()%2 == 0) {
				output = num.charAt(num.length()/2 -1) - '0';
			}else {
				output = num.charAt(num.length()/2 +1) - '0';
			}
		}
	}
	public static void output () {
		System.out.println (output);
	}
}


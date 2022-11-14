import java.util.*;

public class _1617jrc1v1 {
	static Scanner sc;
	
	static int oppnum;
	static String oppshape;
	
	static int [] nums;
	static String [] shapes;
	
	static String output;
	
	public static void main (String [] args) {
		init();
		solve();
		output();
		
	}
	
	public static void init () {
		sc = new Scanner (System.in);
		
		nums = new int [5];
		shapes= new String [5];
		output = "";
		
		String all = sc.nextLine();
		all = all.replace(", ","");
		
		oppnum = all.charAt(0) - '0';
		oppshape = "" + all.charAt(1);
		
		for (int i=2; i<all.length()-1; i=i+2) {
			nums [i/2-1] = all.charAt(i) - '0';
			shapes [i/2-1] = "" + all.charAt(i+1);
		}
		
	}
	
	public static void solve() {
		int isSuit = 0;
		int lowest = 20;
		int lowesthigher = 20;
		for (int i = 0; i<5; i++) {
			if (shapes[i].equals (oppshape)) {
				isSuit++;
				if (nums[i] < lowest) {
					lowest = nums[i];
				}
				if ( nums[i] < lowesthigher && nums[i] > oppnum) {
					lowesthigher = nums[i];
				}
			}
		}
		
		if (isSuit>0) {
			if (lowesthigher != 20) {
				output += lowesthigher;
			}
			else {
				output += lowest;
			}
			output = output + ", " + oppshape;

		} else {
			output = "NONE";
		}
	}
	
	public static void output () {
		System.out.println (output);
	}
}

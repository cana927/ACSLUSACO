import java.util.*;

public class _1617jrc1 {
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
		System.out.println (all);
		
		oppnum = all.charAt(0) - '0';
		oppshape = "" + all.charAt(1);
		
		for (int i=2; i<all.length(); i=i+2) {
			nums [i/2-1] = all.charAt(i);
			shapes [i/2-1] = "" + all.charAt(i+1);
		}
	//problem?
	}
	
	public static void solve() {
		
	}
	public static void output () {
		
	}
}

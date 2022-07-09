import java.util.*;

public class _1718jrc2 {
	static Scanner sc;
	static String equation;
	static String output;
	
	public static void main (String [] args) {
		init();
		solve();
		output();
	}
	public static void init() {
		sc = new Scanner (System.in);
		equation = sc.nextLine();
		output = "";
	}
	public static void solve() {
		int par = -1;
		for (int j=0; j<equation.length(); j++) {
			if (equation.charAt(j) == '(') {
				par = j;
				for (int i = par+2; i<equation.length(); i++) {
					if (Character.isDigit(equation.charAt(i))) {
						output = output + (i+2) + ", ";
					}
				}
				output = output.substring(0, output.length()-2);
			}
			else if (equation.charAt(j) == ')') {
				par = j;
				for (int i = 0; i<par-2; i++) {
					if (Character.isDigit(equation.charAt(i))) {
						output = output + (i+1) + ", ";
					}
				}
				output = output.substring(0, output.length()-2);
			}
		}

	}
	public static void output() {
		System.out.println(output);
	}
}

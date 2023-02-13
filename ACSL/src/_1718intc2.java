import java.io.*;
import java.util.*;

public class _1718intc2 {
	static String eq, output;
	static Scanner sc = new Scanner (System.in);
	
	public static void main (String [] args) {
		init();
		solve();
		output();
	}
	public static void init() {
		eq = sc.next();
		output = "";
	}
	public static void solve () {
		int [] place = {-1, -1, -1, -1};
		for (int i =0; i<eq.length(); i++) {
			if (eq.charAt(i) == '(') {
				place[0]=i;
			}
			else if (eq.charAt(i) == ')') {
				place[1]=i;
			}
			else if (eq.charAt(i) == '[') {
				place[2]=i;
			}
			else if (eq.charAt(i) == ']') {
				place[3]=i;
			}
		}
		
		boolean haspass = false;
		if (place[0]>=0 && place[1]<0) {// )
			System.out.println (")");
			for (int i = place[0]+1; i<eq.length(); i++) {
				if (eq.charAt(i) == '[' || eq.charAt(i) == ']') {
					output += (i+2) + ", ";
					break;
				}
				else if (eq.charAt(i) == '+' ||eq.charAt(i) == '-' ||eq.charAt(i) == '*' ||eq.charAt(i) == '/') {
					if (haspass) {
						output += (i+2) + ", ";
					}
					haspass = true;
				}
			}
		}
		else if (place[1]>=0 && place[0]<0) {// (
			System.out.println ("(");
			for (int i = place[1]-1; i>=0; i--) {
				if (eq.charAt(i) == '[' || eq.charAt(i) == ']') {
					output += (i+2) + ", ";
					break;
				}
				else if (eq.charAt(i) == '+' ||eq.charAt(i) == '-' ||eq.charAt(i) == '*' ||eq.charAt(i) == '/') {
					if (haspass) {
						output += (i+2) + ", ";
					}
					haspass = true;
				}
			}
		}
		
		else if (place[2]>=0 && place[3]<0) {// ]
			System.out.println ("]");
			boolean notp = true;
			for (int i = place[2]+1; i<eq.length(); i++) {
				System.out.println (i + place[])
				if (eq.charAt(i) == '(') {
					notp = false;
				}
				if (eq.charAt(i) == ')') {
					notp = true;
				}
				else if (notp && (eq.charAt(i) == '+' ||eq.charAt(i) == '-' ||eq.charAt(i) == '*' ||eq.charAt(i) == '/')) {
					if (haspass) {
						output += (i+2) + ", ";
					}
					haspass = true;
				}
			}
		}
		else if (place[3]>=0 && place[2]<0) {// [
			System.out.println ("[");
			boolean notp = true;
			for (int i = place[3]-1; i>=0; i--) {
				if (eq.charAt(i) == ')') {
					notp = false;
				}
				if (eq.charAt(i) == '(') {
					notp = true;
				}
				else if (notp && (eq.charAt(i) == '+' ||eq.charAt(i) == '-' ||eq.charAt(i) == '*' ||eq.charAt(i) == '/')) {
					if (haspass) {
						output += (i+2) + ", ";
					}
					haspass = true;
				}
			}
		}
		System.out.println (output);
		output = output.substring(0, output.length()-2);
	}
	public static void output () {
		System.out.println(output);
	}
}
/*
[2+3*8–3)]+6
[(2–5)+6

*/
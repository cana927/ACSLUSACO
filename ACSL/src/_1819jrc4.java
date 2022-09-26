import java.util.*;
import java.io.*;

public class _1819jrc4 {
	static Scanner sc = new Scanner (System.in);
	static StringTokenizer st;
	static ArrayList<Integer> exp;
	static ArrayList<String> type; 
	static int output;
	
	public static void main(String [] args) {
		for (int i =0; i<5; i++) {
			init();
			solve();
			output();
		}
	}
	public static void init() {
		st = new StringTokenizer(sc.nextLine());
		exp = new ArrayList<Integer>();
		type = new ArrayList<String>();
		while (st.hasMoreTokens()) {
			String a = st.nextToken();
			if (a.equals("*")) {
				type.add(a);
				exp.add(-1);
			} else if (a.equals("-")) {
				type.add(a);
				exp.add(-1);
			} else if (a.equals("+")) {
				type.add(a);
				exp.add(-1);
			} else if (a.equals("@")) {
				type.add(a);
				exp.add(-1);
			} else {
				type.add("n");
				exp.add(Integer.parseInt(a));
			}
		}
		output = -1;
		
	}
	public static void solve() {
		while (exp.size()>1) {
			for (int i =0; i<exp.size(); i++) {
				if (type.get(i).equals ("*") && type.get(i+1).equals("n")&& type.get(i+2).equals("n")) {
					exp.set(i, exp.get(i+1) * exp.get(i+2));
					exp.remove(i+1);
					exp.remove(i+1);
					type.set(i, "n");
					type.remove(i+1);
					type.remove(i+1);
				} else if (type.get(i).equals ("-") && type.get(i+1).equals("n")&& type.get(i+2).equals("n")) {
					exp.set(i, exp.get(i+1) - exp.get(i+2));
					exp.remove(i+1);
					exp.remove(i+1);
					type.set(i, "n");
					type.remove(i+1);
					type.remove(i+1);
				}else if (type.get(i).equals ("+") && type.get(i+1).equals("n")&& type.get(i+2).equals("n")) {
					exp.set(i, exp.get(i+1) + exp.get(i+2));
					exp.remove(i+1);
					exp.remove(i+1);
					type.set(i, "n");
					type.remove(i+1);
					type.remove(i+1);
				}else if (type.get(i).equals ("@") && type.get(i+1).equals("n")&& type.get(i+2).equals("n")&& type.get(i+3).equals("n")) {
					int a = exp.get(i+1);
					int b = exp.get(i+2);
					int c = exp.get(i+3);
					if (a >0) {
						exp.set(i, b);
					} else {
						exp.set(i, c);
					}
					exp.remove(i+1);
					exp.remove(i+1);
					exp.remove(i+1);
					type.set(i, "n");
					type.remove(i+1);
					type.remove(i+1);
					type.remove(i+1);
				}
			}
		}
		output = exp.get(0);
	}
	public static void output() {
		System.out.println(output);
	}
	
}
/* 
* + 4 5 - 3 1
@ - 8 9 7 + 4 2
@ - 3 5 - * 2 4 1 0
* 4 @ - 5 7 * 3 2 + 1 9
* + @ 4 6 9 @ - 3 8 1 7 2

*/
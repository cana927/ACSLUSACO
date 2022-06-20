import java.util.*;

public class _1920jrc2 {
	static Scanner sc ;
	static String A, B;
	
	static String output;
	
	public static void main(String[] args) {
		
		init();
		solve();
		output();
	}
	
	public static void init() {
		sc = new Scanner (System.in);
		
		A = sc.next();
		B = sc.next();
		
		output = "";
	}
	
	public static void solve() {
		A = vow(conson(A)); 
		B = vow(conson (B));
		
		for (int i = 0; i< Math.min(A.length(), B.length()); i++)  {
			if (A.charAt(i) == B.charAt(i)) {
				A = A.substring(0,i) + A.substring(i+1);
				B = B.substring(0, i) + B.substring(i+1);
				i--;
			}
		}
		for (int i = 0; i< Math.min(A.length(), B.length()); i++)  {
			if (A.charAt(A.length() -1 -i) == B.charAt(B.length() -1 -i)) {
				A = A.substring(0,A.length() -1 -i) + A.substring(A.length() -i);
				B = B.substring(0, B.length() -1 -i) + B.substring(B.length()-i);
				i--;
			}
		}
		
		if (A.length()<B.length()) {
			output = A;
		}else if (A.length()>B.length()){
			output = B;
		} else {
			for (int i =0; i<A.length(); i++) {
				if (A.charAt(i) < B.charAt(i)) {
					output = A;
					break;
				} 
				if (A.charAt(i) > B.charAt(i)) {
					output = B;
					break;
				} 
			}
		}
	}
	
	public static void output () {
		System.out.println (output);
	}
	
	public static String conson (String a) {
		int i = 0;
		while (i< a.length()-1) {
			if (a.charAt(i) == a.charAt(i+1)) {
				a = a.substring(0,i) + a.substring(i+1);
			}
			i++; 
		}
		return a;
	}
	
	public static String vow (String a ) {
		int i = 0;
		while (i< a.length()) {
			if (a.charAt(i)=='A' || a.charAt(i)=='E' ||a.charAt(i)=='I' ||a.charAt(i)=='O' ||a.charAt(i)=='U') {
				a = a.substring(0,i) + a.substring(i+1);
				i--;
			}
			i++; 
		}
		return a;
	}
	
}


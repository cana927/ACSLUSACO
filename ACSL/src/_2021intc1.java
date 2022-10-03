import java.io.*;
import java.util.*;

public class _2021intc1 {
	static int s, d, r;
	static Scanner sc = new Scanner (System.in);
	static int output;
	
	public static void main (String[]args) {
		for (int i =0; i<6; i++) {
			init();
			solve();
			output();
		}
	}
	public static void init() {
		s = sc.nextInt();
		d = sc.nextInt();
		r = sc.nextInt();
	}
	public static void solve() {
		int place = 0;
		for (int i = 1; i<r; i++) {
			place +=i;
		}
		for (int q =0 ; q<r; q++) {
			int num = toOct(toDec(s) + place*(toDec(d)));
			System.out.println (toDec(s));
			String number = "" + num;
			System.out.println (number);
			for (int i=0;i<number.length();i++) {
				output += number.charAt(i) - '0';
			}
			place++;
		}
	}
	public static void output () {
		System.out.println (output);
	}
	public static int toDec (int a) {  // issue 
		String num = "" + a;
		int sum=0;
		for (int i =num.length()-1; i>=0; i--) {
			sum += (num.charAt(i)-'0') * (Math.pow(8, i));
		}
		return sum;
	}
	public static int toOct (int a) {
		int oct = 0;
		int ten = 0;
		while (a>0) {
			int remainder = a %8;
			oct += remainder * Math.pow(10,ten);
			ten++;
			a = a/8;
		}
		return oct;
	}
}

/*
2 3 5 
221 2 4 
1 4 20 3
10 10 10
3245 5 11 

 */
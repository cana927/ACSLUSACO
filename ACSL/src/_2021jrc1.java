import java.util.*;
import java.io.*;

public class _2021jrc1 {
	static Scanner sc = new Scanner(System.in);
	static int s, d, r;
	
	static int  output;
	
	public static void main(String [] args) {
		for (int i=0; i<5; i++) {
			init();
			solve();
			output();
		}
	}
	public static void init() {
		s = sc.nextInt();
		d = sc.nextInt();
		r = sc.nextInt();
		output = 0;
	}
	public static void solve() {
		int num = r*(r-1)/2; 
		num--;
		int value = s;
		for (int i=0; i<num; i++) {
			value +=d;
			while (value%10<value) {
				value = value/10 + value%10;
			}
		}
		for (int i = 0; i<r; i++) {
			value +=d;
			while (value%10<value) {
				value = value/10 + value%10;
			}
			output += value;
		}
	}
	public static void output() {
		System.out.println (output);
	}
}


/*
2 3 5 
221 2 4 
184 231 35 
71 5 27 
1 24 100

599 23 43
4326 1234 80
704 1776 200
6283 185 31
3141 59 26

*/
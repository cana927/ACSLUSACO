import java.io.*;
import java.util.*;

public class _1617intc2 {
	static ArrayList <Integer> list;
	static String output;
	static int inital, length;
	static Scanner sc = new Scanner (System.in);
	
	public static void main (String [] args) {
		for (int i =0; i<5; i++) {
			init();
			solve();
			output();
		}
	}
	
	public static void init () {
		String str = sc.next();
		length = str.charAt(0) - '0';
		inital = Integer.parseInt(str.substring(1,length+1));
		output = inital + " ";
		list = new ArrayList <Integer> ();
		for (int i =str.length()-1; i>=length + 1; i--) {
			list.add(str.charAt(i) - '0');
		}
		
	}
	
	public static void solve() {
		int num = inital; 
		int len = length;
		
		int newnum = 0;
		
		while (len <= list.size()) {
			newnum = 0;
			for (int i =0; i<len; i++) {
				newnum += list.get(i)*Math.pow(10, len-1-i);
			}
			if (newnum> num) {
				for (int i =0; i<len; i++) {
					list.remove(0);
				}
				output += newnum + " ";
				num = newnum;
				len = (""+num).length();
			}else {
				len++;
			}
		}
	}
	
	public static void output () {
		System.out.println (output);
	}
}

/*
1314159265
11223344
225897257
412342987656784352
33984567176534321

111235813213455
219782017
420165102
26625122455675318505
364311
*/

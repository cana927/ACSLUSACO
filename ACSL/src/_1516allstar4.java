import java.util.*;
import java.io.*;

public class _1516allstar4 {
	static String word;
	static String output;
	static Scanner sc = new Scanner (System.in);
	
	public static void main (String [] args ) {
		for (int i =0; i<10; i++) {
			init() ;
			solve() ;
			output() ;
		}
	}
	
	public static void init () {
		word = sc.nextLine();
		output = "";
	}
	
	public static void solve () {
		while (word.length() % 3 != 0) {
			word += "0";
		}
		for (int e =0; e< word.length()/3; e++) {
			int begin = 3*e;
			
			String three = "" + word.substring(begin, begin+3);
			
			String binaryEight = "";
			
			//letter to char to binary 8 bit
			for (int r = 0; r<3; r++) {
				int dec = three.charAt(r);
				String bin = Integer.toBinaryString(dec);
				while (bin.length()<8) {
					bin = "0" + bin;
				}
				binaryEight +=bin;
			}
			
			//binary 8 to binary 6 to dec, add 32, new char
			while (binaryEight.length() % 6 != 0) {
				binaryEight += "0";
			}
			
			for (int i =0; i< binaryEight.length()/6; i++) {
				int beg = 6*i;
				
				String binarySix = binaryEight.substring(beg, beg+6);
				int newDec = Integer.parseInt(binarySix, 2);
				newDec +=32;
				if (newDec == 32) {
					output += "~";
				}else {
					output += (char) newDec;
				}
			}
			
		}
		
	}
	
	public static void output () {
		System.out.println (output);
	}
}

/*
Cat
tiger
Cats
Mathematics
String Data
PHP
ACSL!
division
May 2016
Test Output

dog
Java
Python
Computer
Invitational
winner!
New Hampshire
Graph Theory
Laptop
//REMARK//

*/

import java.util.*;
import java.io.*;

public class _1516allstar2 {
	static double fraction;
	static ArrayList <Integer> binary;
	static String binaryAnswer;
	static double decimal;
	static String decimalAnswer;
	static Scanner sc = new Scanner (System.in);
	
	public static void main (String [] args) {
		for (int i =0; i<5; i++) {
			init();
			solve();
			output();
		}
		
	}
	
	public static void init() {
		String str = sc.next();
		double a = Integer.parseInt(str.substring(0,str.length()-1)); 
		double b = sc.nextInt();
		fraction = a/b;
		
		binary = new ArrayList<Integer> ();
		binaryAnswer = "";
		decimal = 0;
		decimalAnswer = "";
	}
	
	public static void solve () {
		//binary
		int whole = (int) fraction;
		if (whole >=1) {
			while (whole >0) {
				binary.add(0, whole%2);
				whole = whole/2;
			}
		}
		
		binary.add(-1); // shows "."
		if (binary.size() ==1) {
			binary.add(0, 0);
		}
		fraction = fraction - (int)fraction;
		
		for (int i =0; i<6; i++) {
			if (fraction >0) {
				fraction *=2;
				if (fraction>=1) {
					binary.add(1);
					fraction -=1;
				}else {
					binary.add(0);
				}
			}else {
				binary.add(0);
			}
		}
		
		
		
		for (int i =0; i<binary.size(); i++) {
			// turn binary into binary string
			if (binary.get(i) <0) {
				if (i == 0) {
					binaryAnswer += "0";
				}
				binaryAnswer += ".";
			} else {
				binaryAnswer += binary.get(i);    
			}
		}
	
		//binary to decimal
		int e  = binaryAnswer.length()-6;
		decimal = (int) Double.parseDouble(binaryAnswer);
		for (int i = -1; i>=-6; i--) {
			decimal += binary.get(e)* Math.pow(2, i);
			e++;
		}
		decimalAnswer = "" + decimal;
		
		String decLength = "" + (decimal - (int) decimal);
		if (decLength.length()<8 ) {
			for (int i =0; i<8- decLength.length(); i++) {
				decimalAnswer += "0";
			}
		}
		
	}
	public static void output () {
		System.out.println (binaryAnswer + ", " + decimalAnswer);
	}
}



/*
3, 10 
1, 4 
3, 5 
5, 8 
33, 25 

3, 4
5, 12
4, 50
7, 9
38, 5

*/
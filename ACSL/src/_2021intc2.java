import java.io.*;
import java.util.*;

public class _2021intc2 {
	static int max;
	static int [][] chart;
	static String output; 
	static Scanner sc = new Scanner (System.in);
	
	public static void main (String [] args) {
		for (int i =0; i<5; i++) {
			init();
			solve();
			output();
		}
	}
	public static void init() {
		String letters = sc.next();
		max = sc.nextInt();
		chart = new int [100][26];

		char last = 0;
		int num = 0;
		for (int i =0; i<letters.length(); i++) {
			char curr = letters.charAt(i);
			if (last == curr) {
				num++;
			} else {
				if (num >0) {
					chart[num-1][last-'A']++;
					last = curr;
					num =1;
				}else {
					last = curr;
					num =1;
				}
			}
		}
		chart[num-1][last-'A']++;
		output = "";
	}
	
	public static void solve() {
		char last = 0;
		int num = 0;
		int takeout = 0;
		for (int i = 99; i>=0; i--) {
			for (int r = 0; r<26; r++) {
				if (chart[i][r] >0) { 
					for (int w = 0; w<chart[i][r]; w++) {
						
						char curr = (char)(r + 'A');
						if (last == curr) {
							num += i+1;
							if (num >max) {
								takeout = num-max;
								num = max;
							}
						}else {
							last = curr; 
							num = i+1;
							if (num >max) {
								takeout = num-max;
								num = max;
							} else {
								takeout = 0; 
							}
						}
						
						for (int t = 0; t<i+1 - takeout; t++) {
							output += Character. toString(r+'A');
						}
					}
				}
			}
		}
	}
	public static void output() {
		System.out.println(output);
	}
}


/*
MBAMMDXXMMMGGMMZ 3
MHHHHJLDDHHDDD 3
THETENNESSEEVOLUNTEERS 2
MISSISSIPPI 3
BOOOKEEEPEEERR 4

BOOOKEEEPEERBBBBUZZZOOKEEEEPEER 2
MASSACHUSETTSVSMISSISSIPPI 2
OOOOZESSPPOOOOOYYYSSSUPY 4
SHESELLSSEASHELLSANDBALLOONS 3
HHHGGRDDCFFFGGGTTTYUIKJHHH 1

*/
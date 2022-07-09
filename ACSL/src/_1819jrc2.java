import java.util.*;

public class _1819jrc2 {
	static Scanner sc;
	static int [] letters;
	static String sentence;
	static String output;
	
	public static void main (String [] args) {
		init();
		solve();
		output();
	}
	
	public static void init () { 
		sc = new Scanner (System.in);
		sentence = sc.nextLine();
		letters = new int [26];
		
	}
	
	public static void solve() {
		String lowercase = sentence.toLowerCase();
		
		lettercount(lowercase);
		int letterNumber = 0;
		for (int i = 0; i<26; i++) {
			if (letters[i]>0) {
				letterNumber++;
			}
		}
		output = output + letterNumber + "/n";
		
		int vowelCount = 
		
	}
	
	public static void output () {
		
	}
	
	public static void lettercount (String sent) {
		for (int i =0; i<sent.length(); i++) {
			char let = sent.charAt(i);
			if (Character.isLetter(let)) {
				letters[let-'a']++;
			}
		}
	}
}

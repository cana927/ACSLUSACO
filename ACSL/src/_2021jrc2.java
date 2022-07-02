import java.util.*;

public class _2021jrc2 {
	static Scanner sc;
	
	static String sentence;
	static String newString;
	
	public static void main (String [] args) {
		init();
		solve();
		output();
	}
	public static void init() {
		sc = new Scanner (System.in);
		sentence = sc.nextLine();
		newString = "";
	}
	public static void solve() {
		int[]letterCount = letterCount(sentence);
		
		while (!isEmpty(letterCount)) {
			String toAdd = "";
			for (int i =0; i<26; i++) {
				if (letterCount[i]>0) {
					letterCount[i]--;
					toAdd+= (char)('a' + i);
				}
			}
			
			newString += toAdd;
		}
		
		for (int i = 0; i<newString.length()-1; i++) {
			if (newString.charAt(i) == newString.charAt(i+1)) {
				newString = deleteChar(newString, i+1);
				i--;
			}
		}
	}
	public static void output() {
		System.out.println (newString);
	}
	/*
	 * index 0 refers to how many a's in string
	 */
	public static int [] letterCount(String sentence) {
		sentence = sentence.toLowerCase();
		
		int[] letterCount = new int[26];
		for (int i = 0; i<sentence.length(); i++ ) {
			if (Character.isAlphabetic(sentence.charAt(i))) {
				letterCount[sentence.charAt(i) - 'a']++;
			}
		}
		return letterCount;
	}
	
	public static boolean isEmpty(int[]a) {
		for (int i=0; i<a.length; i++ ) {
			if (a[i] != 0) {
				return false;
			}
		}
		return true;
	}
	
	public static String deleteChar(String s, int i) {
		return s.substring(0,i) + s.substring(i+1);
	}
}

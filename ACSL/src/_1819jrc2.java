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
		output = "";
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
		output = output + letterNumber + "  \n";
		
		int vowelCount = letters[0] + letters['i' - 'a'] + letters['e' - 'a']+ letters['o' - 'a']+ letters['u' - 'a'];
		output = output + vowelCount + "  \n";
		
		int uppercaseCount = 0;
		for (int i =0; i<sentence.length(); i++) {
			if (sentence.charAt(i) != lowercase.charAt(i)) {
				uppercaseCount ++;
			}
		}
		output = output + uppercaseCount + "  \n";
		
		int freq = 0;
		for  (int i =0; i<26; i++) {
			if (letters[i] > freq) {
				freq = letters[i];
			}
		}
		output = output + freq + "  \n";
		
		StringTokenizer st = new StringTokenizer(sentence);
		String longword = "";
		while (st.hasMoreTokens()) {
			String word = st.nextToken();
			if (word.length() > longword.length()) {
				longword = word;
			}
		}
		String finallong = "";
		for (int i=0; i<longword.length(); i++) {
			if (Character.isLetter(longword.charAt(i))) {
				finallong += longword.charAt(i);
			}
		}
		output = output + finallong;
	}
	
	public static void output () {
		System.out.println (output);
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

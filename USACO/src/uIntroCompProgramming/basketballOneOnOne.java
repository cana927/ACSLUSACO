package uIntroCompProgramming;
import java.util.*;

public class basketballOneOnOne {
	public static void main (String [] args) {
		Scanner sc= new Scanner (System.in);
		
		String word= sc.next();
		
		int a =0;
		int b = 0;
		
		for (int i =0; i<word.length()-1; i+= 2) {
			if (word.charAt(i) == 'A') {
				a += word.charAt(i+1) - '0';
			}
			else if (word.charAt(i) == 'B') {
				b += word.charAt(i+1) - '0';
			}
			
		}
		if (a > b) {
			System.out.println ("A");
		}
		else {
			System.out.println ("B");
		}
	}
}

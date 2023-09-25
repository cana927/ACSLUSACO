package u2023;
import java.io.*;
import java.util.*;

public class mooLanguage {
	public static void main (String [] args) {
		Scanner sc = new Scanner (System.in);
		int T = sc.nextInt();
		
		for (int t = 0; t<T; t++) {
			int N = sc.nextInt();
			int C = sc.nextInt();
			int P = sc.nextInt();
			
			Stack <String> nouns = new Stack<>(); 
			Stack <String> transitive = new Stack<>();
			Stack <String> intransitive = new Stack<>();
			Stack <String> conjunctions = new Stack <>();
			
			String sentence = "";
			
			for (int i = 0; i < N; i++) {
				String word = sc.next();
				String type = sc.next();
				
				switch (type) {
					case "noun" :
						nouns.push(word);
						break;
					case "transitive-verb" :
						transitive.push(word);
						break;
					case "intransitive-verb" :
						intransitive.push(word);
						break;
					case "conjunction" :
						conjunctions.push(word);
				}	
			}
			Boolean compound = false;
			int senleft = P + Math.min(P, conjunctions.size());
			int possintran = Math.min(Math.min(senleft, intransitive.size()), nouns.size());
			int posstran = Math.min(Math.min(senleft - possintran, transitive.size()), (nouns.size()-possintran)/2);
			
			while (P>0) {
				
				if (nouns.size()==0 || intransitive.size()+transitive.size()==0 || (intransitive.size()==0 && nouns.size()<2)) {
					break;
				}
				
				if (posstran>0) {
					sentence += nouns.pop() + " " + transitive.pop() + " " + nouns.pop() + " ";
					while (C > 0 && nouns.size()> possintran + 2*(posstran-1)) {
						sentence = sentence.substring(0,sentence.length()-1) + ", " + nouns.pop() + " ";
						C--;
					}
					posstran--;
				} 
				else {
					if (intransitive.size()>0) {
						sentence += nouns.pop() + " " + intransitive.pop() + " ";
						possintran--;
					}
					else {
						break;
					}
				}
				if (!compound) {
					if (conjunctions.size()>0 && nouns.size()>0 && (intransitive.size()>0 || nouns.size()>2)) {
						compound = true;
						sentence += conjunctions.pop() + " ";
					}
					else {
						sentence = sentence.substring(0,sentence.length()-1) + ". ";
						P--;
						compound = false;
					}
				}
				else {
					sentence = sentence.substring(0,sentence.length()-1) + ". ";
					compound = false;
					P--;
				}
			}
			String [] words = sentence.split(" "); 
			int num = words.length;
			if (num <2) {
				System.out.println (0);
				System.out.println ();
			}
			else {
				System.out.println (num);
				System.out.println (sentence.substring(0,sentence.length()-1));

			}
		}
	}
}


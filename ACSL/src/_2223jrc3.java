import java.util.*;

public class _2223jrc3 {
	public static void main (String [] args) {
		Scanner sc = new Scanner (System.in);
		String word = sc.next();
		listByValue (word);
	}
	
	public static void listByValue (String input) {
		ArrayList <Letter> l = new ArrayList<Letter> ();
		Letter [] letters = new Letter [input.length()];
		
		for (int i =0; i<input.length(); i++) {
			char a = input.charAt(i);
			int val = 0;
			int place = 0;
			
			for (int r =0; r<l.size(); r++) {
				if (a > l.get(r).character) {
					place ++;
				}
			}
			if (place ==0) {
				if (i >0) {
					val = l.get(0).value +1;
				} 
			}
			else if (place == l.size()) {
				val = l.get(l.size()-1).value+1;
			} else {
				val = Math.max(l.get(place).value, l.get(place-1).value)+1;
			}
			letters [i] = new Letter (val, a);
			l.add(place, letters[i]); 
			
		}
		Arrays.sort(letters);

		for (int i =0; i<l.size(); i++) {
			System.out.print (letters[i].character );
		}
		
	}
	public static class Letter implements Comparable<Letter> {
		int value;
		char character;
		
		public Letter (int value, char character) {
			this.value = value;
			this.character = character;
		}

		public int compareTo (Letter o) {
			if (this.value < o.value) {
				return -1;
			} else if (o.value < this.value) {
				return 1;
			} else return this.character - o.character;
		}
	}
}

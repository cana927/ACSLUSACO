import java.util.*;

public class _1718jrc4v2 {
	public static void main (String [] args) {
		Scanner sc = new Scanner (System.in);
		for (int w = 0; w<5; w++) {
			String line = sc.nextLine();
			
			int pos = line.charAt(0) - '0';
			pos--;
			
			ArrayList<Character> list = new ArrayList<Character>();
			ArrayList<Character> past = new ArrayList<Character>();
			int num = 0;
			
			String word = line.substring(1);
			word = word.toLowerCase();
			word = word.replaceAll(" ", "");
			
			for (int i =0; i<word.length(); i++){
				
				list.add(word.charAt(i));
				Collections.sort(list);
				
				if (list.size()>pos && ! isInList(past, list.get(pos)) ) {
					past.add(list.get(pos));
					num++;
				}
				
			}
			System.out.println (num);
		}
		
	}
	public static boolean isInList (ArrayList<Character> list, Character a) {
		for (Character c : list) {
			if (c==a) {
				return true;
			}
		}
		return false;
	}
}

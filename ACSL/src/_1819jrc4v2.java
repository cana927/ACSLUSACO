import java.util.*;

public class _1819jrc4v2 {
	public static void main(String [] args) {
		Scanner sc = new Scanner (System.in);
		
		for (int q =0; q<5; q++) {
			
			ArrayList<String> eq = new ArrayList<String> ();
			
			StringTokenizer st = new StringTokenizer (sc.nextLine());
			
			while (st.hasMoreTokens()) {
				eq.add(st.nextToken());
			}
			
			while (eq.size() >1) {
				int place = 0;
				//for (int i =0; i<eq.size(); i++) {
					//System.out.println (Character.isDigit(eq.get(i).charAt(eq.get(i).length()-1)));
				//}
				while (notmath (eq, place)) {
					place++;
				}
				//System.out.println (place);
				
				if (eq.get(place).charAt(eq.get(place).length()-1) == '*') {
					eq.set(place, ""+(Integer.parseInt(eq.get(place+1))*Integer.parseInt(eq.get(place+2))));
					eq.remove(place+1);
					eq.remove(place+1);
				}
				else if  (eq.get(place).charAt(eq.get(place).length()-1) == '-') {
					eq.set(place, "" + (Integer.parseInt(eq.get(place+1))-Integer.parseInt(eq.get(place+2))));
					eq.remove(place+1);
					eq.remove(place+1);
				}
				else if (eq.get(place).charAt(eq.get(place).length()-1) == '+') {
					eq.set(place,  "" + (Integer.parseInt(eq.get(place+1))+Integer.parseInt(eq.get(place+2))));
					eq.remove(place+1);
					eq.remove(place+1);
				}
				else if (eq.get(place).charAt(eq.get(place).length()-1) == '@') {
					if (Character.isDigit(eq.get(place+3).charAt(eq.get(place).length()-1))) {
						if (Integer.parseInt(eq.get(place+1))<0) {
							eq.set(place, eq.get(place+3));
							eq.remove(place+1);
							eq.remove(place+1);
							eq.remove(place+1);
						}
						else {
							eq.set(place, eq.get(place+2));
							eq.remove(place+1);
							eq.remove(place+1);
							eq.remove(place+1);
						}
					}
				}
				//for (int i =0; i<eq.size(); i++) {
					//System.out.print (eq.get(i));
				//}
				//System.out.println ();
				
			}
			System.out.println(eq.get(0));
		}
	}
	public static boolean notmath (ArrayList<String>eq, int place) {
		if (eq.get(place).charAt(eq.get(place).length()-1)=='@') {
			return (!Character.isDigit(eq.get(place+1).charAt(eq.get(place+1).length()-1)) || 
				!Character.isDigit(eq.get(place+2).charAt(eq.get(place+2).length()-1)) ||
				!Character.isDigit(eq.get(place+3).charAt(eq.get(place+3).length()-1) ));
		} else {
			return (Character.isDigit(eq.get(place).charAt(eq.get(place).length()-1)) || 
					!Character.isDigit(eq.get(place+1).charAt(eq.get(place+1).length()-1)) || 
					!Character.isDigit(eq.get(place+2).charAt(eq.get(place+2).length()-1)));
		}
	}
}

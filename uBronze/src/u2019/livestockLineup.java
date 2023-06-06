package u2019;
import java.io.*;
import java.util.*;

public class livestockLineup {
	static String [] cows;
	
	public static void main (String [] args) throws IOException {
		cows = "Bessie Buttercup Belinda Beatrice Bella Blue Betsy  Sue".split(" ");
		Arrays.sort(cows);
		
		Scanner sc = new Scanner (new File("lineup.in"));
		int n = Integer.parseInt(sc.nextLine());
		String [][] conditions = new String [n][];
		for (int i =0; i<n; i++) {
			String [] pair = sc.nextLine().split(" must be milked beside");
			conditions [i] = pair; 
		}
		sc.close();
		
		String[] order = permute (new String [cows.length], 0, conditions);
		
		PrintWriter out = new PrintWriter (new BufferedWriter (new FileWriter("lineup.in")));
		
		out.close();
	}
	
	public static String [] permute (String [] currOrder, int k, String [][] conditions) {
		if (k == cows.length) {
			for (String [] condition : conditions) {
				if (!checkCondition(currOrder, condition)) {
					return null;
				}
			}
			return currOrder;
		}else {
			for (int i=0; i<cows.length; i++) {
				if (cows[i] != null) {
					currOrder[k] = cows[i];
					cows[i] = null;
					
					if (permute(currOrder, k+1, conditions)!= null) {
						return currOrder;
					}
					
					cows[i] = currOrder[k];
					currOrder[k] = null;
					
				}
			}
		}
		return null;
	}
	public static boolean checkCondition (String [] currOrder, String [] condition) {
		for (int i=0; i<currOrder.length; i++) {
			if (i>0 && currOrder[i].equals(condition[0]) && currOrder[i-1].equals(condition[i])) {
				return true;
			}
			if (i<currOrder.length-1 && currOrder[i].equals(condition[0]) && currOrder[i-1].equals(condition[1])){
				return true;
			}
		}
		return false;
	}
}

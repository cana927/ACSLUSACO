import java.util.*;

public class _1718jrc1 {
	static Scanner sc = new Scanner (System.in);
	static ArrayList <Integer> player;
	static int total;
	static int[] steps;
	static String output;
	
	public static void main (String [] args) {
		for (int i=0; i<5; i++) {
			init();
			solve();
			output();
		}
		
	}
	public static void init() {
		total = sc.nextInt();
		player = new ArrayList<Integer>();
		for (int i =0;i<3; i++) {
			player.add(sc.nextInt());
		}
		steps = new int [7];
		for (int i =0; i<7; i++) {
			steps[i] = sc.nextInt();
		}
		output = "";
	}
	public static void solve() {
		int r = 0;
		while (total <=99) {
			total+= value(player.get(0),total);
			if (total>99) {
				output += total + ", dealer";
				break;
			}
			player.remove(0);
			player.add(steps[r]);
			r++;
			
			total += value(steps[r], total);
			r++;
			if (total>99) {
				output += total + ", player";
			}

		}
	}
	public static void output() {
		System.out.println (output);
	}
	public static int value (int r, int total) {
		if (r == 9) {
			return 0;
		}
		if (r == 4) {
			return -10;
		}
		if (r == 0 ) {
			if (total >= 89) {
				return 1;
			}
			return 11;
		}
		return r;
		
	}
}

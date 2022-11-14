import java.util.ArrayList;
import java.util.Scanner;

public class _1718jrc1v1 {
	static Scanner sc;
	static ArrayList <Integer> cards;
	static int tot; 
	static boolean player;
	static String output; 
	
	public static void main (String [] args) {
		init();
		solve();
		output();
		
	}
	
	public static void init () {
		sc = new Scanner (System.in);
		cards = new ArrayList <Integer> ();
		tot = sc.nextInt();
		cards.add(sc.nextInt());
		cards.add(sc.nextInt());
		cards.add(sc.nextInt());
		boolean player = true;
		output = "";
		
	}
	public static void solve () {
		while (tot <=99) {
			tot = getNewTotal( tot, cards.get(0));
			cards.remove (0);
			if (tot>99) {
				break;
			}else {
				player = false;
			}
			cards.add(sc.nextInt());
			tot = getNewTotal(tot, sc.nextInt());
			if (tot>99) {
				break;
			}else {
				player = true;
			}
		}
		output += tot + ", ";
		if (player ) {
			output += "dealer";
		}
		else {
			output += "player";
		}
	}
	public static void output () {
		System.out.println (output);
	}
	
	public static int getNewTotal (int r, int a) {
		if (a == 9) {
			return r;
		}
		if (a ==4) {
			return r -10;
		}
		if (a == 0) {
			if (r + 11 >99) {
				return r + 1;
			} else {
				return r + 11;
			}
		}
		return r + a;
	}
}

import java.io.*;
import java.util.*;

public class _1718intc1 {
	static int total, output, win;
	static int [] player;
	static ArrayList <Integer> turn; 
	static Scanner sc = new Scanner (System.in);
	
	public static void main (String [] args) {
		for (int i=0; i<5; i++) {
			init();
			solve();
			output();
		}
	}
	public static void init() {
		win = 0;
		String a = sc.nextLine().replaceAll(",", " ");
		StringTokenizer st = new StringTokenizer (a);
		total = check(st.nextToken());
		output = total;
		player = new int [3];
		for (int i =0; i<3; i++) {
			player[i] = check(st.nextToken());
		}
		turn = new ArrayList<Integer>();
		while (st.hasMoreTokens()) {
			turn.add(check(st.nextToken()));
		}

	}
	public static void solve() {
		for (int i =0; i < turn.size(); i++)  {
			if (total <100) {
				if (i%2 == 0) { // player turn
					int place = 0;
					for (int r=1; r<3; r++) {
						if (player[place] < player [r]) {
							place = r;
						}
					}
					if (total >85 && player[place] ==14) {
						total ++;
					} else if (player[place] == 10) {
						total += -10;
					}else if (player[place] == 9) {
						total += 0;
					}else {
						total += player[place];
					}
					player[place] = turn.get(i);
					if (total > 99) {
						win = 2;
					}
				}
				else { // opp turn
					if (total >85 && turn.get(i) ==14) {
						total ++;
					} else if (turn.get(i) == 10) {
						total += -10;
					}else if (turn.get(i) == 9) {
						total += 0;
					}else {
						total += turn.get(i);
					}
					if (total > 99) {
						win = 1;
					}
				}
			}
		}
	}
	public static void output () {
		if (win == 1) {
			System.out.println( total + ", player");
		}else System.out.println( total + ", dealer");
	}
	public static int check (String a) {
		if (a.equals("T")) {
			return 10;
		}
		if (a.equals("A")) {
			return 14;
		}
		if (a.equals ("K" )) {
			return 13;
		}
		if (a.equals("Q")) {
			return 12;
		}
		if (a.equals ("J")) {
			return 11;
		}
		else {
			return Integer.parseInt(a);
		}
	}
}
/*
75, 7, 3, 8, 8, 7, T, 5, 9, A, 6
80, 9, T, 7, 8, K, A, 3, 5, Q, T
94, 4, 2, 2, 7, T, 3, A, 5, J, K 
80, 6, 6, 4, T, 9, 8, 6, 5, Q, K 
90, T, 8, 5, 9, 9, Q, K, A, J, 8

65, 5, 6, 7, 8, 9, T, J, Q, K, A 
74, A, 2, 9, T, 9, 7, A, 9, 8, A 
55, A, K, Q, J, T, A, K, Q, J, T 
59, A, T, K, A, Q, A, T, 7, 9, 4
70, T, Q, 9, 9, A, Q, J, K, Q, T

*/
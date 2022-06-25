import java.util.*;

public class _2021jrc1 {
	static Scanner sc;
	static int s, d, r;
	
	static int  output;
	
	static ArrayList <Integer> a;
	
	public static void main(String [] args) {
		init();
		solve();
		output();
	}
	

	public static void init() {
		Scanner sc = new Scanner (System.in);
		
		s = sc.nextInt();
		d = sc.nextInt();
		r = sc.nextInt();
		
		output = 0;
		
		a = new ArrayList<Integer>();
	}
	public static void solve() {
		int num = s;
		for (int i =1; i<=r; i++) {
			for (int r=0; r<i; r++) {
				if (s<10) {
					 a.add(s);
				}
				else {
					while (s>9) {
						s = single (s);
					}
					a.add(s);
				}
				s +=d;
			}
		}
		
		int e = 0;
		for (int i = 1; i<=r; i++) {
			e = e+i;
		} 
		
		int b = e-r;
		
		for (int i = b; i<e; i++) {
			output +=a.get(i);
		}
		
	}
	public static void output() {
		System.out.println(output);
	}
	 
	public static int single (int s ) {
		int tot = 0;
		while (s>0) {
			tot += s%10;
			s= s/10;
		}
		return tot;
	}
}

//package u2017;
import java.io.*;

public class modernArtv3 {
	public static void main (String [] args) throws IOException {
		BufferedReader in = new BufferedReader (new FileReader("art.in"));
		PrintWriter out = new PrintWriter (new BufferedWriter (new PrintWriter ("art.out")));
		
		int N = Integer.parseInt(in.readLine());
		
		int [][] art = new int [N][N];
		int [] appears = new int [10];
		
		int [][] limits = new int [10][4];
		for (int i =1; i< 10; i++) {
			limits[i][0] = 15; // min x
			limits[i][1] = 15; // min y
			limits[i][2] = 0; // max x
			limits[i][3] = 0; // max y
		}
		boolean [] coversOther = new boolean [10];
		
		for (int i = 0; i<N; i++) {
			String s = in.readLine();
			for (int r = 0; r<N; r++) {
				int num = s.charAt(r) - '0';
				art[i][r] = num;
				appears[art[i][r]] ++;
				if (i < limits[num][0]) {
					limits[num][0] = i;
				}
				if (i > limits[num][2]) {
					limits[num][2] = i;
				}
				if (r < limits[num][1]) {
					limits[num][1] = r;
				}
				if (r > limits[num][3]) {
					limits[num][3] =r;
				}
			}
		}
		
		for (int c = 1; c<= 9; c++) {
			for (int x = limits[c][0]; x<= limits[c][2]; x++) {
				for (int y = limits[c][1]; y<= limits[c][3]; y++) {
					if (art[x][y]!= c) {
						coversOther[art[x][y]] = true;
//						System.out.println ("Cow" + c + " cover" + art[x][y]);
//						System.out.println (limits[c][0] + " " + limits[c][1] + " " + limits[c][2] + " " + limits[c][3]);
					}
				}
			}
		}
		int possible = 0;
		
//		for (Boolean k : coversOther) {
//			System.out.println (k);
//		}
//		for (int n: appears) {
//			System.out.println (n);
//		}
//		System.out.println();
		for (int i = 1; i<10; i++) {
			if (coversOther[i] != true && appears[i]>0) {
				//System.out.println (i);
				possible++;
			}
		}
		out.println (possible);
		out.close();
		in.close();
	}		
}

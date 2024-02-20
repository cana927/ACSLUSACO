package u2017;

//too simple

import java.io.*;

public class modernArtv2 {
	public static void main (String [] args) throws IOException {
		BufferedReader in = new BufferedReader (new FileReader("art.in"));
		PrintWriter out = new PrintWriter (new BufferedWriter (new PrintWriter ("art.out")));
		
		int N = Integer.parseInt(in.readLine());
		
		int [][] art = new int [N][N];
		int [] appears = new int [10];
		
		for (int i = 0; i<N; i++) {
			String s = in.readLine();
			for (int r = 0; r<N; r++) {
				art[i][r] = s.charAt(r) - '0';
				appears[art[i][r]] ++;
			}
		}
		
		boolean [] coversOther = new boolean [10];

		for (int row = 0; row<N-1; row++) {
			for (int col = 0; col<N-1; col++) {
				int [] count = new int [10];
				
				int n1 = art[row][col];
				count[n1] ++;
				int n2 = art[row][col+1];
				count[n2] ++;
				int n3 = art[row+1][col];
				count[n3] ++;
				int n4 = art[row+1][col+1];
				count[n4] ++;
				
				for (int w = 1; w<10; w++) {
					if (count[w] == 2) {
						if (n1==n4 && n1!=0) {
							coversOther[n2] = true;
							coversOther[n3] = true;
						}
						else if (n2==n3 && n2!=0) {
							coversOther[n1] = true;
							coversOther[n4] = true;
						}
					}
					else if (count[w] == 3) {
						if (n1 != w) {
							coversOther[n1] = true;
						}
						else if (n2 != w) {
							System.out.println (w + " " + n2);
							coversOther[n2] = true;
						}
						else if (n3 != w) {
							coversOther[n3] = true;
						}
						else if (n4 != w) {
							coversOther[n4] = true;
						}
					}
				}
			}
		}
		
		int possible = 0;
		

		for (Boolean k : coversOther) {
			System.out.println (k);
		}
		
		for (int i = 1; i<10; i++) {
			if (coversOther[i] != true && appears[i]>0) {
				System.out.println (i);
				possible++;
			}
		}
		
		out.println(possible);
		out.close();
		in.close();
	}
	
}

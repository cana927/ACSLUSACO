import java.util.*;
import java.io.*;
public class _2223allstar1v2 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		for(int i = 0; i < 10; i++) {
			
			StringTokenizer st = new StringTokenizer(in.readLine());
			ArrayList<Integer> input = new ArrayList<>();
			while(st.hasMoreTokens()) {
				input.add(Integer.parseInt(st.nextToken()));
			}
			
			int counter = 1;
			int change = 0;
			int ogSize = input.size();
			while(counter <= ogSize) {
				
				ArrayList<Integer> temp = new ArrayList<>();
				int ind = input.indexOf(counter);
				for(int j = ind; j >= 0; j--) {
					temp.add(input.get(j));
				}
				
				for(int j = 0; j <= ind; j++) {
					if(input.get(j) != temp.get(j)) {
						change++;
					}
				}
				
				for(int j = 0; j <= ind; j++) {
					input.set(j, temp.get(j));
				}
				input.remove(0);
				
				counter++;
				
			}
			
			System.out.println(change);
			
		}

	}

}
/*
4 6 2 3 1 7 5
6 10 3 7 5 2 1 8 9 4
9 5 1 7 10 4 6 8 3 11 2 12
1 2 3 4 5 6 7 8 9
13 12 11 10 9 8 7 6 5 4 3 2 1

1 2 3 4 5 6 7 8
15 14 13 12 11 10 9 8 7 6 5 4 3 2 1
7 5 2 9 12 4 8 6 3 10 1 11
2 5 11 7 12 9 10 8 1 6 3 4
1 4 3 2 5 7 6
6 7 8 1 2 10 3 9 5 4
18 9 14 2 1 12 19 20 15 4 7 6 8 13 10 16 17 3 11 5
7 3 1 5 2 6 4 8 9
11 8 6 3 12 7 5 18 14 19 1 13 10 20 2 16 4 9 15 17
1 3 5 7 9 11 13 15 17 19 20 18 16 14 12 10 8 6 4 2

*/

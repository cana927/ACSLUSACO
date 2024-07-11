package u2019;

import java.util.*;
import java.io.*;

public class guessTheAnimal {

	public static void main(String[] args) throws IOException {
		
		BufferedReader in = new BufferedReader(new FileReader("guess.in"));
		PrintWriter out = new PrintWriter("guess.out");
		
		int N = Integer.parseInt(in.readLine());
		List<String>[] characteristics = new List[N];
		for(int i =0; i < N; i++) {
			characteristics[i] = new ArrayList<>();
			String[] words = in.readLine().split(" ");
			for(int j = 2; j < words.length; j++) {
				characteristics[i].add(words[j]);
			}
		}
		
		int maxCommon = 0;
		for(int i = 0; i < N; i++) {
			for(int j = i+1; j < N; j++) {
				int common = 0;
				
				for(String characteristic1  : characteristics[i]) {
					for(String characteristic2 : characteristics[j]) {
						if(characteristic1.equals(characteristic2)) {
							common++;
							break;
						}
					}
				}
				
				maxCommon = Math.max(maxCommon, common);
				
			}
		}
		
		out.println(maxCommon + 1);
		in.close();
		out.close();

	}

}
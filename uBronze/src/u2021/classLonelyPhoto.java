package u2021;
import java.util.*;
import java.io.*;

public class classLonelyPhoto {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		int N = in.nextInt();
		String s = in.next();

		int answer = 0;

		for (int i = 0; i < N; i++) {
			int g = 0;
			int h = 0;

			for (int j = i; j < N; j++) {
				if (s.charAt(j) == 'G')
					g++;
				else
					h++;

				if (g + h >= 3 && (g == 1 || h == 1)) {
					answer++;
				}

				if (g > 1 && h > 1)
					break;
			}
		}

		System.out.println(answer);
	}
}

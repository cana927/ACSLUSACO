package u2021;
import java.io.*;
import java.util.*;

public class airCownditioning {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();

		int[] a = new int[N];
		int[] b = new int[N];
		int[] d = new int[N + 2];

		for (int i = 0; i < N; i++) {
			a[i] = sc.nextInt();
		}
		for (int i = 0; i < N; i++) {
			b[i] = sc.nextInt();
		}
		for (int i = 0; i < N; i++) {
			d[i + 1] = a[i] - b[i];
		}

		int answer = 0;
		for (int i = 0; i <= N; i++) {
			answer += Math.abs(d[i] - d[i + 1]);
		}

		System.out.println(answer / 2);
	}
}

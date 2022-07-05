package baekjun.BOJ7568;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ7568 {

	public static void main(String[] args) {
	Scanner in = new Scanner(System.in);

		int N = in.nextInt();
		int[][] people = new int[N][2];

		for (int i = 0; i < N; i++) {
			int wieght = in.nextInt();
			int height = in.nextInt();

			people[i] = new int[] {wieght, height};
		}

		for (int i = 0; i < N; i++) {
			int degree = 1;
			for (int j = 0; j < N; j++) {
				if (i == j) {
					continue;
				}
				if (people[i][0] < people[j][0] && people[i][1] < people[j][1]) {
					degree++;
				}
			}
			System.out.print(degree + " ");
		}
	}
}
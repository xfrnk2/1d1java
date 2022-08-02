package boj.p11k.p11700;

import java.util.Scanner;

public class P11729 {
	static int total = 0;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		solution(sc.nextInt());
	}

	public static void solution(int n) {
		hanoi(n, 1, 3, 2);
		System.out.println(total);
	}

	private static void hanoi(int count, int start, int end, int temp) {

		if (count == 1) {
			System.out.printf("%d %d%n", start, end);
			total++;
			return;
		}

		hanoi(count - 1, start, temp, end);
		System.out.printf("%d %d%n", start, end);
		total++;
		hanoi(count - 1, temp, end, start);
	}
}

package boj.p1k.p1700;

import java.util.Scanner;

public class P1789 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long n = sc.nextLong();
		solution(n);
	}

	public static void solution(long n) {
		long sum = 0; int cnt = 0, i = 1;
		while (sum <= n) {
			sum += i;
			i++;
			cnt++;
		}
		System.out.print(cnt - 1);
	}
}


package boj.p1k.p1000;

import java.util.Scanner;

public class P1016 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long min = sc.nextLong();
		long max = sc.nextLong();

		boolean[] pow = new boolean[(int) (max - min + 1)];
		// idx는 idx - min , idx는 현재 순회중인 수

		for (long i = 2; i <= (int) Math.sqrt(max); i++) {
			long num = i * i;
			for (long j = min % num != 0 ? (min / num) + 1 
					: min / num; j * num <= max; j++) {
				pow[(int) ((j * num) - min)] = true;
			}
		}
		int ans = 0;
		for (int i = 0; i < (int) (max - min + 1); i++) {
			if (!pow[i]) {
				ans++;
			}
		}
		System.out.println(ans);
	}

}

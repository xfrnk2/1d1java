package boj.p1k.p1500;


import java.util.Scanner;

public class P1562 {
	static int MOD = 1000000000;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		long[][][] d = new long[N + 1][10][1024];

		for (int i = 1; i < 10; i++) {
			d[1][i][1 << i] = 1;
		}
		for (int i = 2; i <= N; i++) {
			for (int j = 0; j <= 9; j++) {
				for (int k = 0; k < 1024; k++) {
					int next = k | (1 << j);
					if (j == 0) {
						d[i][j][next] += d[i - 1][j + 1][k] % MOD;
					} else if (j == 9) {
						d[i][j][next] += d[i - 1][j - 1][k] % MOD;
					} else {
						d[i][j][next] += d[i - 1][j - 1][k] % MOD + d[i - 1][j + 1][k] % MOD;
					}

				}
			}
		}
		long ans = 0;
		for (int i = 0; i <= 9; i++) {

			ans += d[N][i][1023] % MOD;
			ans %= MOD;
		}
		System.out.println(ans);

	}
}

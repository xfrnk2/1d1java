package boj.p1k.p1100;

import java.util.Arrays;
import java.util.Scanner;

public class P1146 {
	public static int MOD = 1000000;
	public static long[][] euiler;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		euiler = new long[N + 1][N + 1];
		for (int i = 0; i <= N; i++) {
			Arrays.fill(euiler[i], -1);
		}
		euiler[0][0] = 1;
		System.out.println(N == 1 ? 1 : ((dfs(N, N)%MOD) * 2) % MOD);
	}

	public static long dfs(int n, int r) {

		if (r == 0)
			return n == 0 ? 1 : 0;

		if (euiler[n][r] != -1)
			return euiler[n][r] % MOD;
		return euiler[n][r] = (dfs(n, r - 1) % MOD + dfs(n - 1, n - r) % MOD) % MOD;

	}

}

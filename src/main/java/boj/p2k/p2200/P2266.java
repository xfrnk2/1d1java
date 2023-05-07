package boj.p2k.p2200;

import java.util.Arrays;
import java.util.Scanner;

public class P2266 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N, K;
		N = sc.nextInt();
		K = sc.nextInt();

		int[][] dp = new int[N + 1][K + 1];
		for (int i = 1; i <= N; i++) {
			Arrays.fill(dp[i], Integer.MAX_VALUE);
			dp[i][1] = i;
		}
		Arrays.fill(dp[1], 1);

		// E(n, k)에서 1회 떨어뜨렸을 때, 부숴지면 E(n-1, k-1)을 구하고,
		// 부숴지지 않으면 E(n-k, k)를 구한다. 둘 중 최악의 경우에 대해 1회를 더한다.
		for (int i = 2; i <= N; i++) {
			for (int j = 2; j <= K; j++) {

				for (int k = 1; k <= i; k++) {
					dp[i][j] = Math.min(dp[i][j], 1 + Math.max(dp[k - 1][j - 1], dp[i - k][j]));
				}
			}
		}
		System.out.println(dp[N][K]);
	}
}

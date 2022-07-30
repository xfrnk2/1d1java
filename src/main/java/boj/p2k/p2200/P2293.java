package boj.p2k.p2200;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P2293 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		solution(n, m, arr);
	}

	static void solution(int n, int m, int[] coins) {
		int[][] dp = new int[n + 1][m + 1];
		Arrays.sort(coins);

		for (int i = 0; i < n + 1; i++) {
			dp[i][0] = 1;
		}

		for (int i = 1; i < n + 1; i++) {
			int coin = coins[i - 1];
			for (int j = 1; j < m + 1; j++) {
				if (j < coin) {
					dp[i][j] = dp[i - 1][j];
				} else {
					dp[i][j] = dp[i][j - coin] + dp[i - 1][j];
				}
			}
		}

		System.out.print(dp[n][m]);
	}
}
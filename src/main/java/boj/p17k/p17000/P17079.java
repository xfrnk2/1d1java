package boj.p17k.p17000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P17079 {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(in.readLine());
		boolean[][] map = new boolean[n + 1][n + 1];
		long[][][] dp = new long[n + 1][n + 1][3];

		for (int i = 1; i <= n; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			for (int j = 1; j <= n; j++) {
				map[i][j] = st.nextToken().equals("1") ? true : false;
			}

		}

		dp[1][2][0] = 1;
		if (map[1][2] || map[1][1])
			dp[1][2][0] = 0;

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {

				if (map[i][j])
					continue;
				dp[i][j][0] += dp[i][j - 1][0]; // 가로
				dp[i][j][0] += dp[i][j - 1][2];

				dp[i][j][1] += dp[i - 1][j][1]; // 세로
				dp[i][j][1] += dp[i - 1][j][2];

				if (!map[i - 1][j] && !map[i][j - 1]) {
					dp[i][j][2] += dp[i - 1][j - 1][2]; // 대각선
					dp[i][j][2] += dp[i - 1][j - 1][1];
					dp[i][j][2] += dp[i - 1][j - 1][0];
				}

			}

		}

		System.out.println(dp[n][n][0] + dp[n][n][1] + dp[n][n][2]);

	}

}

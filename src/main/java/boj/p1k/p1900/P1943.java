package boj.p1k.p1900;


import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;


public class P1943 {

  
	static int N, total;
	static Point[] money;
	static boolean[] dp;

  
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		for (int t = 0; t < 3; t++) {
			N = Integer.valueOf(in.readLine());
			dp = new boolean[100001];
			dp[0] = true;
			money = new Point[N + 1];

			total = 0;
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(in.readLine());
				int coin = Integer.valueOf(st.nextToken());
				int number = Integer.valueOf(st.nextToken());

				money[i] = new Point(coin, number);
				total += coin * number;
				for (int j = 1; j <= number; j++) {
					dp[coin * j] = true;
				}
			}

			if (total % 2 == 1) {
				System.out.println(0);
				continue;
			} else if (dp[total / 2]) {
				System.out.println(1);
				continue;
			}

			solve();
		}
	}

	public static void solve() {
		for (int i = 0; i < N; i++) {
			int c = money[i].x;
			int n = money[i].y;

			for (int j = total / 2; j >= c; j--) {
				if (dp[j - c]) {

					for (int k = 1; k <= n; k++) {
						if (j - c + c * k > total / 2)
							break;
						dp[j - c + c * k] = true;
					}
				}
			}
		}
		System.out.println(dp[total / 2] ? 1 : 0);
	}
}

package boj.p12k.p12800;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class P12869 {
	static int N, ans = Integer.MAX_VALUE;
	static int[] scv;
	static int[][][] dp;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = Integer.valueOf(sc.nextInt());
		scv = new int[3];
		for (int i = 0; i < N; i++) {
			scv[i] = Integer.valueOf(sc.nextInt());
		}
		dp = new int[61][61][61];

		cal(scv[0], scv[1], scv[2], 0);
		System.out.println(ans);

	}

	public static void cal(int a, int b, int c, int cnt) {
		if (a <= 0 && b <= 0 && c <= 0) {
			ans = Math.min(ans, cnt);
			return;
		}
		a = Math.max(a, 0);
		b = Math.max(b, 0);
		c = Math.max(c, 0);
		if (dp[a][b][c] <= cnt && 0 != dp[a][b][c])
			return;
		dp[a][b][c] = cnt;

		cal(a - 9, b - 3, c - 1, cnt + 1);
		cal(a - 9, b - 1, c - 3, cnt + 1);
		cal(a - 3, b - 9, c - 1, cnt + 1);
		cal(a - 3, b - 1, c - 9, cnt + 1);
		cal(a - 1, b - 3, c - 9, cnt + 1);
		cal(a - 1, b - 9, c - 3, cnt + 1);
	}

}

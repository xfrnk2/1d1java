package boj.p20k.p20500;

import java.util.Scanner;

public class P20500 {
	static int MOD = 1000000007;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[][] d = new int[3][1516];
		d[0][2] = 1;
		d[1][2] = 1;

		for (int i = 3; i <= N; i++) {
			d[0][i] = (d[2][i - 1] + d[1][i - 1]) % MOD;
			d[1][i] = (d[0][i - 1] + d[2][i - 1]) % MOD;
			d[2][i] = (d[0][i - 1] + d[1][i - 1]) % MOD;
		}
		System.out.println(d[0][N]);

	}

}

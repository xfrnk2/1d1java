package boj.p11k.p11400;

import java.util.Scanner;

public class P11401 {
	static int MOD = 1000000007;
	static int N, K;
	static long[] factorial = new long[4000001];

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		K = sc.nextInt();
		factorial[0] = 1;
		for (int i = 1; i < 4000001; i++) {
			factorial[i] = factorial[i - 1] * i % MOD;
		}

		long nFac = factorial[N] % MOD;
		long kFac = factorial[K] % MOD;
		long nSubKFac = factorial[N - K] % MOD;

		System.out.println((nFac * pow((kFac * nSubKFac) % MOD, MOD - 2)) % MOD);

	}

	public static long pow(long a, long b) {
		if (b == 0)
			return 1;
		long half = pow(a, b / 2);
		if (b % 2 == 0) {
			return ((half % MOD) * (half % MOD)) % MOD;
		}
		return (((a * half) % MOD) * (half % MOD)) % MOD;

	}

}

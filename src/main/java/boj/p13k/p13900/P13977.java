package boj.p13k.p13900;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class P13977 {
	static int MOD = 1000000007;
	static long[] factorial;

	public static void main(String[] args) throws IOException {

		factorial = new long[4000001];
		factorial[0] = 1;
		for (int i = 1; i <= 4000000; i++) {
			factorial[i] = (i * factorial[i - 1]) % MOD;
		}

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st;
		int M = Integer.valueOf(in.readLine());
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(in.readLine());
			int N = Integer.valueOf(st.nextToken());
			int K = Integer.valueOf(st.nextToken());

			long nFac = factorial[N] % MOD;
			long nSubKFac = factorial[N - K] % MOD;
			long kFac = factorial[K] % MOD;

			out.write((nFac * pow((kFac * nSubKFac) % MOD, MOD - 2)) % MOD + "\n");

		}
		out.flush();
	}

	private static long pow(long a, long p) {
		if (p == 0)
			return 1;
		long half = pow(a, p / 2);
		if (p % 2 == 0) {
			return ((half % MOD) * (half % MOD)) % MOD;
		}
		return (((a * half) % MOD) * (half % MOD)) % MOD;
	}

}

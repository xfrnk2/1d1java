package swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P5607 {
	static int N, P = 1234567891;
	static long[] factorial = new long[1000001];

	public static void initFactorial() {
		factorial[0] = 1;
		for (int i = 1; i < 1000001; i++) {
			factorial[i] = (factorial[i - 1] * i) % P;
		}
	}

	public static void main(String[] args) throws Exception {

		initFactorial();

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = Integer.parseInt(in.readLine());
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(in.readLine());

			int lhs = Integer.parseInt(st.nextToken());
			int rhs = Integer.parseInt(st.nextToken());
            
            long n = factorial[lhs]%P;
            long r = factorial[rhs]%P;
            long nSubR = factorial[lhs-rhs]%P;

            
            System.out.println("#" + tc + " " + (n * pow((r * nSubR)%P, P-2)) % P);
		}
	}

	public static long pow(long a, int b) {
		if (b == 0) {
			return 1;
		}
		long mid = pow(a, b / 2);
		if (b % 2 == 0)
			return ((mid%P) * (mid%P)) % P;
		else {
		return (((mid*a)%P) * (mid % P)) % P;
		}
	}

}


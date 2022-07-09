package baekjun.BOJ2609;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2609 {

	private static int swap(int a, int b) {
		return a;
	}

	private static int gcd(int a, int b) {
		if (a % b == 0) {
			return b;
		}
		return gcd(b, a % b);
	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());

		if (a < b) {
			b = swap(a, a = b);
		}

		int result = gcd(a, b);
		System.out.print(result);
		System.out.print(" ");
		System.out.print(a * b / result);
	}
}

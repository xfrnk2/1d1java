package boj.p3k.p3600;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class P3687 {

	static int[] num = new int[] { 0, 0, 1, 7, 4, 2, 0, 8, 10 };

	public static void main(String[] args) throws IOException {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		long[] minDp = new long[101];
		// minDp[i]는 i개의 성냥개비로 만들 수 있는 숫자

		for (int i = 0; i < 9; i++) {
			minDp[i] = num[i];
		}
		minDp[6] = 6;

		for (int i = 9; i < 101; i++) {
			minDp[i] = minDp[i - 2] * 10 + num[2];
			for (int j = 7; j >= 3; j--) {
				minDp[i] = Math.min(minDp[i], minDp[i - j] * 10 + num[j]);
			}
		}

		int T = Integer.valueOf(in.readLine());
		while (T-- > 0) {

			int n = Integer.valueOf(in.readLine());
			StringBuilder maxValue = new StringBuilder();
			out.write(minDp[n] + " ");

			while (0 < n) {
				if (n % 2 == 0) {
					maxValue.append(1);
					n -= 2;
				} else {
					maxValue.append(7);
					n -= 3;
				}
			}
			out.write(maxValue.toString() + "\n");

		}
		out.flush();

	}

}

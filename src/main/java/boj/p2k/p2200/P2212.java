package boj.p2k.p2200;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P2212 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.valueOf(in.readLine());
		int K = Integer.valueOf(in.readLine());
		int[] arr = new int[N];
		int[] sensors = new int[N - 1];
		StringTokenizer st = new StringTokenizer(in.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.valueOf(st.nextToken());
		}
		Arrays.sort(arr);

		for (int i = 1; i < N; i++) {
			sensors[i - 1] = arr[i] - arr[i - 1];
		}
		Arrays.sort(sensors);

		int ans = 0;
		for (int i = N - 1 - K; i >= 0; i--) {
			ans += sensors[i];
		}
		System.out.println(ans);
	}

}

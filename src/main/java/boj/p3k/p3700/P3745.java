package boj.p3k.p3700;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P3745 {
	static int N;
	static int[] arr;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String input = "";
		StringTokenizer st;

		while ((input = in.readLine()) != null) {
			N = Integer.parseInt(input.trim());
			arr = new int[N];

			st = new StringTokenizer(in.readLine().trim());
			for (int i = 0; i < N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}

			int[] lis = new int[N];
			lis[0] = arr[0];
			int size = 1;
			for (int i = 1; i < N; i++) {

				int now = arr[i];
				int k = Arrays.binarySearch(lis, 0, size, arr[i]);
				if (k < 0) {
					k = Math.abs(k) - 1;

					lis[k] = now;
					if (size == k) {
						size++;

					}
				}

			}

			sb.append(size + "\n");

		}

		System.out.println(sb.toString());

	}

}

package boj.p20k.P20300;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P20366 {
	static int N;
	static int[] arr;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(in.readLine());
		arr = new int[N];
		StringTokenizer st = new StringTokenizer(in.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		int startX = 0, ans = Integer.MAX_VALUE;
		while (startX < N - 3) {
			int endX = 3;
			while (endX < N) {
				int innerStart = startX + 1;
				int innerEnd = endX - 1;
				int sumOuter = arr[startX] + arr[endX];

				while (innerStart < innerEnd) {
					int sumInner = arr[innerStart] + arr[innerEnd];
					int dif = sumInner - sumOuter;
					ans = Math.min(ans, Math.abs(dif));
					if (dif < 0) {
						innerStart++;
					} else {
						innerEnd--;
					}

				}
				endX++;
			}
			startX++;

		}

		System.out.println(ans);
	}

}

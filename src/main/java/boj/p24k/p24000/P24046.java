package boj.p24k.p24000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P24046 {
	static int N, K;
	static ArrayList<Integer> arr, sortedArr;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		N = Integer.valueOf(st.nextToken());
		K = Integer.valueOf(st.nextToken());
		arr = new ArrayList<>(N);
		sortedArr = new ArrayList<>(N);
		st = new StringTokenizer(in.readLine());
		for (int i = 0; i < N; i++) {
			int cur = Integer.valueOf(st.nextToken());
			arr.add(cur);
			sortedArr.add(cur);
		}

		// System.out.println(arr);
		sortedArr.sort(null);
		int[] res = bubbleSort();
		if (res == null) {
			System.out.println(-1);
		} else {
			Arrays.sort(res);
			System.out.println(res[0] + " " + res[1]);
		}

	}

	public static void swap(int idx1, int idx2) {
		int temp = arr.get(idx1);
		arr.set(idx1, arr.get(idx2));
		arr.set(idx2, temp);
	}

	public static int[] bubbleSort() {
		int cnt = 0;
		for (int i = 0; i < N - 1; i++) {
			for (int j = 0; j < N - i - 1; j++) {
				if (arr.get(j) > arr.get(j + 1)) {
					swap(j, j + 1);
					cnt++;
					// System.out.println(arr);
					if (K == cnt) {
						return new int[] { arr.get(j), arr.get(j + 1) };
					}
				}
			}
		}
		return null;
	}

}

package boj.p15k.p15600;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


public class P15654 {
	static int N, M;
	static int[] arr, numbers;
	static boolean[] select;

	static StringBuilder sb;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());

		N = Integer.valueOf(st.nextToken());
		M = Integer.valueOf(st.nextToken());
		sb = new StringBuilder();
		arr = new int[N];
		numbers = new int[N];
		select = new boolean[N];

		st = new StringTokenizer(in.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.valueOf(st.nextToken());
		}

		Arrays.sort(arr);
		permu(0);
		System.out.println(sb.toString());
	}

	public static void permu(int cnt) {
		if (cnt == M) {
			addAns();
			return;
		}

		for (int i = 0; i < N; i++) {
			if (select[i])
				continue;
			select[i] = true;
			numbers[cnt] = arr[i];
			permu(cnt + 1);
			select[i] = false;
		}
	}

	public static void addAns() {

		for (int i = 0; i < M; i++) {
			sb.append(numbers[i] + " ");
		}
		sb.append("\n");
	}

}

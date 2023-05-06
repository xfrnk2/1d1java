package boj.p7k.p7500;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P7453 {
	static int N;
	static int[] A, B, C, D, lhs, rhs;

	public static int getLowerBound(int val, int start, int end) {
		while (start < end) {
			int mid = (start + end) / 2;
			if (val > rhs[mid]) {
				start = mid + 1;

			} else {
				end = mid;
			}
		}
		return end;
	}

	public static int getUpperBound(int val, int start, int end) {

		while (start < end) {
			int mid = (start + end) / 2;
			if (val >= rhs[mid]) {
				start = mid + 1;
			} else {
				end = mid;
			}

		}
		return end;
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		A = new int[N];
		B = new int[N];
		C = new int[N];
		D = new int[N];
		StringTokenizer st;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			A[i] = Integer.parseInt(st.nextToken());
			B[i] = Integer.parseInt(st.nextToken());
			C[i] = Integer.parseInt(st.nextToken());
			D[i] = Integer.parseInt(st.nextToken());
		}
		int size = N * N;
		lhs = new int[size];
		rhs = new int[size];

		long cnt = 0;
		int idx = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				lhs[idx] = A[i] + B[j];
				rhs[idx++] = C[i] + D[j];
			}
		}

		Arrays.sort(rhs);
		for (int i = 0; i < size; i++) {

			cnt += getUpperBound(-lhs[i], 0, size) - getLowerBound(-lhs[i], 0, size);
		}

		System.out.println(cnt);
	}

}

package boj.p14k.p14000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

public class P14003 {
	static int n;
	static long[] arr;
	static long[] indicies;
	static List<Long> lis;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(in.readLine());
		arr = new long[n];

		lis = new ArrayList<>();
		indicies = new long[n];
		StringTokenizer st = new StringTokenizer(in.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Long.parseLong(st.nextToken());
		}

		int size = 0;
		for (int k = 0; k < n; k++) {

			if (lis.size() == 0 || lis.get(lis.size() - 1) < arr[k]) {
				lis.add(arr[k]);
				indicies[k] = lis.size() - 1;

			} else {

				int idx = binarySearch(arr[k]);
				lis.set(idx, arr[k]);
				indicies[k] = idx;
			}

		}
		;

		Stack<Long> stack = new Stack<>();
		int idx = lis.size() - 1;
		for (int i = n - 1; i >= 0; i--) {
			if (indicies[i] == idx) {
				idx--;
				stack.add(arr[i]);
			}
		}

		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		out.write(lis.size() + "\n");

		while (!stack.isEmpty()) {
			out.write(stack.pop() + " ");
		}

		out.flush();

	}

	public static int binarySearch(long num) {
		int l = 0, r = lis.size() - 1;
		while (l <= r) {
			int mid = (l + r) / 2;
			if (lis.get(mid) < num) {
				l = mid + 1;
			} else {
				r = mid - 1;
			}
		}

		return l;
	}

}

package boj.p1k.p1400;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Iterator;
import java.util.StringTokenizer;

public class P1477 {

	static int N, M, L;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());

		N = Integer.valueOf(st.nextToken());
		M = Integer.valueOf(st.nextToken());
		L = Integer.valueOf(st.nextToken());
		int maxTemp = Integer.MIN_VALUE;

		int[] arr = new int[N + 2];

		st = new StringTokenizer(in.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.valueOf(st.nextToken());
		}
		arr[N + 1] = L;
		Arrays.sort(arr);
//		System.out.println(Arrays.toString(arr));

		int[] diff = new int[N + 1];

		int start = 1, end = maxTemp;
		for (int i = 0; i < N + 1; i++) {
			int j = i + 1;

			diff[i] = arr[j] - arr[i] - 1;
			end = Math.max(end, diff[i] + 1);

		}
//		System.out.println(start + " " + end);		
		// System.out.println(Arrays.toString(diff));

		// System.out.println("---------------");
		end = Math.max(end, L);
		int ans = 0;
		while (start <= end) {
			int mid = (start + end) / 2;
			// System.out.println("mid" + mid);
			int res = 0;

			for (int i = 0; i < N + 1; i++) {
				int val = diff[i] / mid;
				res += val == 0 ? 0 : val;
			}

			if (res > M) {
				start = mid + 1;
			} else {
				end = mid - 1;
			}
			// System.out.println(start + " " + end);
			ans = mid;

		}
		System.out.println(start);
	}
}

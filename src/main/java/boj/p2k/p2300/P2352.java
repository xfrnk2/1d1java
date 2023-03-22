package boj.p2k.p2300;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P2352 {

	static int N;
	static int[] arr;
	static int[] len;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.valueOf(in.readLine());
		StringTokenizer st = new StringTokenizer(in.readLine());
		arr = new int[N];
		len = new int[N];

		for (int i = 0; i < N; i++) {
			arr[i] = Integer.valueOf(st.nextToken());
		}

		int p = 0;
		len[0] = arr[0];
		// System.out.println(Arrays.toString(len));
		for (int i = 1; i < N; i++) {
			// len 마지막 값보다 작으면 이분탐색으로 자리를 찾기
			// 그렇지 않다면 제일 뒤에 추가

			if (len[p] < arr[i])
				len[++p] = arr[i];
			else {
				int start = 0, end = p;
				while (start < end) {
					int mid = (start + end) / 2;
//					if (end < mid || mid < start) break;
//					
					if (arr[i] > len[mid]) {
						start = mid + 1;
					} else {
						end = mid;
					}

				}
				len[end] = arr[i];
				// System.out.println("start...end.." + start + " " + p);
			}
//			System.out.println("p..." + p);
//			System.out.println(Arrays.toString(len));
		}
		System.out.println(p + 1);

	}

}

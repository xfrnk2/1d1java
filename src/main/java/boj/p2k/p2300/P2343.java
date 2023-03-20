package boj.p2k.p2300;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P2343 {

	public static void main(String[] args) throws IOException {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());

		int N, M, maxValue = Integer.MIN_VALUE, total = 0;
		N = Integer.valueOf(st.nextToken());
		M = Integer.valueOf(st.nextToken());
		st = new StringTokenizer(in.readLine());

		int[] arr = new int[N];
		for (int i = 0; i < N; i++) {
			total += arr[i] = Integer.valueOf(st.nextToken());
			maxValue = Math.max(arr[i], maxValue);
		}

		/*
		 * 
		 * 1. 가능한 블루레이 크기 중 최소를 출력하는게 목표이다. 2. 전체 합계를 최대로, 전체 합계/M을 최소로 잡는다. 3. 변수mid는
		 * (start + (end - start)) / 2 이다. 4. 전체를 순회하며 M 대비 m이 얼마나 나오는지 체크한다. 5. m <
		 * M이라면, 기존 ans와 비교하여 가장 작은 것으로 갱신시킨다. 그리고 start를 mid + 1로 변경한다. 6. m >= M이라면,
		 * end를 mid - 1로 변경한다.
		 * 
		 */

		int start = total / M;
		int end = total;
		int ans = Integer.MAX_VALUE;

		while (start <= end) {
			int mid = (start + end) / 2;
			int sum = 0;
			int num = 0;
			if (maxValue > mid) {
				start = mid + 1;
				continue;
			}

			for (int i = 0; i < N; i++) {
				sum += arr[i];
				if (mid < sum) {
					num++;
					sum = arr[i];
				}

			}

			if (num < M) {
				end = mid - 1;
				ans = Math.min(ans, mid);
			} else {
				start = mid + 1;
			}

		}
		System.out.println(ans);

	}

}

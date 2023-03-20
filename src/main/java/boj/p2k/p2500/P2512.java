package boj.p2k.p2500;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P2512 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.valueOf(in.readLine());
		StringTokenizer st = new StringTokenizer(in.readLine());
		int[] arr = new int[N];
		int start = Integer.MAX_VALUE;
		int end = Integer.MIN_VALUE;

		for (int i = 0; i < N; i++) {
			arr[i] = Integer.valueOf(st.nextToken());
			start = Math.min(start, arr[i]);
			end = Math.max(end, arr[i]);
		}
		// System.out.println(start + " " + end);
		int M = Integer.valueOf(in.readLine());
		int ans = 0;

		while (start <= end) {
			int mid = (start + end) / 2;
			int sum = 0;
			for (int i = 0; i < N; i++) {

				sum += mid >= arr[i] ? arr[i] : mid;
			}

			if (sum > M) { // 기준값보다 크면 작게 만들기
				end -= 1;

			} else { // 기준값보다 작으면 크게 만들기
				start += 1;
			}
			ans = end;

		}

		System.out.println(ans);

		/*
		 * 
		 * 최대값을 구하라
		 * 
		 * 1. 최소, 최대를 각각 START, END로 지정하여 N으로 나눈 값을 MID 2. MID로 ARR[0..N-1]의 값을 모두 SUM이란
		 * 변수에 더한 뒤 값을 비교 3. SUM이 M보다 크면 START, END -> START, MID로 변경 4. SUM이 M보다 작으면
		 * START, END -> MID, END로 변경 5. 전에 작았다가 커지면 작았던 값을 리턴 6. 전에 컸다가 작아지만 작아진 값을 리턴
		 * 
		 * 
		 */

	}

}

package boj.p1k.p1600;

import java.util.ArrayList;
import java.util.Scanner;

public class P1644 {
	static int N, len;
	static ArrayList<Integer> list = new ArrayList<>();
	static boolean[] notPrime = new boolean[4000001];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		if (N < 2) {
			System.out.println(0);
			System.exit(0);
		}
		init();

		// right가 size 이상이면 끝
		// 합계값이 N과 동일하면 left, rigt 각각 +1
		// 합계값이 N 미만이면 right +1
		// 초과하면 left + 1

		int left, right, size, cnt;
		left = right = cnt = 0;

		size = list.size();
		int sum = list.get(left);

		while (right < size) {

			if (sum == N) {
				cnt++;
				sum -= list.get(left);
				left++;
				right++;
				if (size <= right)
					break;
				sum += list.get(right);
				continue;
			}
			if (sum < N) {

				right++;
				if (size <= right)
					break;
				sum += list.get(right);
			} else if (sum > N) {
				sum -= list.get(left);
				left++;
			}
		}
		System.out.println(cnt);
	}

	public static void init() {
		notPrime[0] = notPrime[1] = true;
		for (int i = 2; i * i <= N; i++) {
			if (!notPrime[i]) {
				for (int j = i * i; j <= N; j += i) {
					notPrime[j] = true;
				}
			}
		}

		for (int i = 2; i <= N; i++) {
			if (notPrime[i])
				continue;
			list.add(i);
		}
	}

}

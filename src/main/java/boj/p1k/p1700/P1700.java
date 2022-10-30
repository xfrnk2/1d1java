package boj.p1k.p1700;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;


public class P1700 {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());

		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		int[] order = new int[K];

		st = new StringTokenizer(in.readLine());
		for (int i = 0; i < K; i++) {
			order[i] = Integer.parseInt(st.nextToken());

		}

		int ans = 0;

		if (N == 1) {
			for (int i = 1; i < K; i++) {
				if (order[i] != order[i - 1]) {
					ans++;
				}
			}
			System.out.println(ans);
			System.exit(0);
		}

		Set<Integer> rec = new HashSet<>();
		loop: for (int i = 0; i < K; i++) {
			int cur = order[i];
			if (rec.contains(cur)) {

				continue;
			}

			if (rec.size() < N) {
				rec.add(cur);

				continue;
			} else if (rec.size() == N) {
				Set<Integer> temp = new HashSet<>(rec);

				for (int j = i + 1; j < K; j++) {
					if (temp.contains(order[j])) {
						temp.remove(order[j]);
					}
					if (temp.size() < 2) {
						break;
					}
				}

				rec.remove(temp.iterator().next());
				rec.add(order[i]);
				ans++;
			}

		}

		/*
		 * 콘센트가 꽂혀있으면 넘어간다. i번 물건의 record cnt를 감소시킨다. 꽂혀있지 않다면 아래의 조건을 본다. - 자리가 있다면
		 * 꽂는다. - 자리가 없다면 - 꽂혀있는 콘센트중 나중에 사용될 콘센트가 있는지 확인한다. - 나중에 사용될 일이 없는 콘센트가 있다면
		 * 우선적으로 꽂고 넘어간다. - 나중에 사용될 일이 없는 콘센트가 없다면, 남아있는 콘센트 중 가장 뒤에 사용될 콘센트를 빼고, 새로운 i번
		 * 물건을 꽂는다.
		 * 
		 */

		System.out.println(ans);
	}

}

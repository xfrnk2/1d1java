package boj.p1k.p1000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public class P1043 {
	/*
	   nice tc
		10 10 
		1 1 
		2 10 1
		2 9 2
		2 8  3
		2 7  4
		2 6  5
		2 5  7 
		2 4  8
		2 3 9 
		2 2 10 
		1 1
	 */
	static int N, M;
	static boolean[] isKnow;
	static boolean[][] lie;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		N = Integer.valueOf(st.nextToken());
		M = Integer.valueOf(st.nextToken());

		isKnow = new boolean[N + 1];
		lie = new boolean[N + 1][2];

		st = new StringTokenizer(in.readLine());
		int K = Integer.valueOf(st.nextToken());
		for (int i = 0; i < K; i++) {
			isKnow[Integer.valueOf(st.nextToken())] = true;
		}

		List<Integer[]> list = new ArrayList<>();

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(in.readLine());
			int j = Integer.valueOf(st.nextToken());
			Integer[] arr = new Integer[j];
			for (int k = 0; k < j; k++) {
				arr[k] = Integer.valueOf(st.nextToken());
			}
			list.add(arr);
			// container에 들어감

		}

		for (int k = 0; k < 50; k++) {
			for (int i = 0; i < list.size(); i++) {
				boolean f1 = false; // 하나라도 참인 자가 포함되었는지, 그렇다면 true
				for (int j = 0; j < list.get(i).length; j++) {
					if (isKnow[list.get(i)[j]]) {
						f1 = true;
						break;
					}
				}

				if (f1) { // 하나라도 참이면 연결된 자들 모두 참
					for (int j = 0; j < list.get(i).length; j++) {
						isKnow[list.get(i)[j]] = true;
					}
				}
			}
		}

		int ans = 0;
		loop: for (Integer[] is : list) {
			ArrayList<Integer> temp = new ArrayList<>();
			boolean[] flag = new boolean[is.length];
			int idx = 0;
			for (int elem : is) {
				if (isKnow[elem]) {
					flag[idx++] = true;
				} else {
					temp.add(elem);
				}
			}
			boolean f = false;
			for (boolean bb : flag) {
				if (bb) {
					f = true;
				}
			}
			if (f) {
				for (Integer elem : temp) {
					lie[elem][1] = true;
				}
				continue loop;
			}

			ArrayList<Integer> temp2 = new ArrayList<>();
			for (Integer elem : temp) {
				if (lie[elem][1]) {
					continue loop;
				}
				temp2.add(elem);
			}
			for (Integer elem : temp2) {
				lie[elem][0] = true;
			}
			ans++;

		}
		System.out.println(ans);

	}

}

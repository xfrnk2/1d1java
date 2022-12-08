package boj.p1k.p1500;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;

public class P1525 {

	static Set<ArrayList<Integer>> set = new HashSet<>();
	static int[] di = { -3, 3, -1, 1 };

	static class Info {
		int idx;
		ArrayList<Integer> arr;

		public Info(int idx, ArrayList<Integer> arr) {
			super();
			this.idx = idx;
			this.arr = arr;
		}

	}

	public static boolean isOut(int x) {
		return x < 0 || 8 < x;
	}

	public static boolean isOver(ArrayList<Integer> array) {
		return array.get(0) == 1 && array.get(1) == 2 && array.get(2) == 3 && array.get(3) == 4 && array.get(4) == 5
				&& array.get(5) == 6 && array.get(6) == 7 && array.get(7) == 8 && array.get(8) == 0;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ArrayList<Integer> arr = new ArrayList<>(9);
		int zeroIdx = -1;
		for (int i = 0; i < 9; i++) {
			arr.add(i, sc.nextInt());
			if (arr.get(i) == 0) {
				zeroIdx = i;
			}
		}

		int cnt = 0;

		if (isOver(arr)) { // 이동할 필요가 없으므로 종료
			System.out.println(cnt);
			System.exit(0);
		}
		set.add(arr);

		Queue<Info> q = new LinkedList<>();
		q.add(new Info(zeroIdx, arr));

		while (!q.isEmpty()) {
			int size = q.size();
			for (int z = 0; z < size; z++) {
				Info cur = q.poll();

				for (int i = 0; i < 4; i++) {

					int nIdx = cur.idx + di[i];
					if (isOut(nIdx) || (2 <= i && (cur.idx + di[i]) / 3 != cur.idx / 3)) {
						continue;
					}

					// 새로운 array 생성과 swap
					ArrayList<Integer> array = new ArrayList<>(9);
					for (Integer item : cur.arr) {
						array.add(item);
					}

					int temp = array.get(cur.idx);
					array.set(cur.idx, array.get(nIdx));
					array.set(nIdx, temp);

					if (set.contains(array)) {
						continue;
					}
					if (isOver(array)) {
						System.out.println(cnt + 1);
						System.exit(0);
					} else {

						q.add(new Info(nIdx, array));
						set.add(array);

					}
				}

			}
			cnt++;

		}
		System.out.println(-1);
	}

}

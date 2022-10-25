package boj.p13k.p13700;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

public class P13711 {

	static int[] arr;
	static Integer[] nodes;
	static List<Integer> lis;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		int[] origin = new int[N];
		Map<Integer, Integer> idxMap = new HashMap<>();

		StringTokenizer st = new StringTokenizer(in.readLine());
		for (int i = 0; i < N; i++) {
			origin[i] = Integer.valueOf(st.nextToken());
			idxMap.put(origin[i], i);

		}

		st = new StringTokenizer(in.readLine());
		arr = new int[N];
		nodes = new Integer[N];
		lis = new ArrayList<>();
		for (int i = 0; i < N; i++) {

			arr[i] = idxMap.get(Integer.valueOf(st.nextToken()));
			if (lis.size() == 0 || lis.get(lis.size() - 1) < arr[i]) {
				lis.add(arr[i]);
				nodes[i] = lis.size() - 1; // num, idx
			} else {
				int idx = binarySearch(arr[i]);
				lis.set(idx, arr[i]);
				nodes[i] = idx;
			}
		}

		Set<Integer> set = new HashSet<Integer>(Arrays.asList(nodes));

		System.out.println(set.size());
	}

	public static int binarySearch(int num) {
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

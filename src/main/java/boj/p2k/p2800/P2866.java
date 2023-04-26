package boj.p2k.p2800;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

public class P2886 {

	static int R, C;
	static StringBuilder[] arr;

	public static boolean isDuplicated(int from) {
		Set<String> set = new HashSet();
		for (int i = 0; i < C; i++) {
			String str = arr[i].substring(from);
			if (set.contains(str))
				return true;
			set.add(str);
		}
		return false;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		arr = new StringBuilder[C];
		for (int i = 0; i < C; i++) {
			arr[i] = new StringBuilder();
		}

		for (int i = 0; i < R; i++) {
			String input = in.readLine();
			for (int j = 0; j < C; j++) {
				arr[j].append(input.charAt(j));
			}

		}

		int start = 0, end = R;
		int ans = 0;
		while (start <= end) {
			int mid = (start + end) / 2;
			if (isDuplicated(mid)) {
				end = mid - 1;
			} else {
				start = mid + 1;
				ans = mid;
			}

		}
		System.out.println(ans);

	}

}

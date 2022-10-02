package boj.p9k.p9400;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class P9466 {
	static int ans = 0;
	static int n;
	static int[] arr;
	static boolean[] visit, finish;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());
		for (int tc = 0; tc < T; tc++) {
			n = Integer.parseInt(in.readLine());
			arr = new int[n + 1];
			visit = new boolean[n + 1];
			finish = new boolean[n + 1];
			StringTokenizer st = new StringTokenizer(in.readLine());
			for (int i = 1; i <= n; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}

			for (int i = 1; i <= n; i++) {
				dfs(i);
			}
			System.out.println(n - ans);
			ans = 0;
		}
	}

	public static void dfs(int cur) {
		if (visit[cur])
			return;
		visit[cur] = true;
		int next = arr[cur];
		if (visit[next]) {
			if (!finish[next]) {
				ans++;
				for (int i = next; i != cur; i = arr[i]) {
					ans++;
				}

			}

		} else {
			dfs(next);
		}
		finish[cur] = true;
	}
}

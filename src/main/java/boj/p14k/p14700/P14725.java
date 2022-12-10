package boj.p14k.p14700;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class P14725 {
	static int N;
	static StringBuilder sb;

	static class Container {
		Map<String, Container> map;

		public Container() {
			super();
			this.map = new TreeMap<String, Container>();
		}

	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.valueOf(in.readLine());
		StringTokenizer st;
		sb = new StringBuilder();
		Container root = new Container();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			int k = Integer.valueOf(st.nextToken());

			String[] items = new String[k];
			for (int j = 0; j < k; j++) {
				items[j] = st.nextToken();
			}
			go(root, items, k, 0);

		}
		print(root, 0);
		System.out.println(sb.toString());

	}

	public static void go(Container c, String[] items, int size, int idx) {
		if (size <= idx) {
			return;
		}
		if (!c.map.containsKey(items[idx])) {
			c.map.put(items[idx], new Container());
		}
		// 있다면 그대로 탐색
		go(c.map.get(items[idx]), items, size, idx + 1);
	}

	public static void addHypen(int depth) {
		for (int i = 0; i < depth; i++) {
			sb.append("--");
		}
	}

	public static void print(Container c, int depth) {
		for (String key : c.map.keySet()) {
			if (c.map.get(key) != null) {
				addHypen(depth);
				sb.append(key);
				sb.append("\n");
				print(c.map.get(key), depth + 1);
			}
		}
	}
}

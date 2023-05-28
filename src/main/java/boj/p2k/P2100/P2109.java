package boj.p2k.P2100;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.StringTokenizer;

public class P2109 {

	static PriorityQueue<Point> pq;
	static boolean[] visited;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());

		if (N == 0) {
			System.out.println(0);
			return;
		}

		int ans = 0;
		visited = new boolean[10001];
		pq = new PriorityQueue<>(new Comparator<Point>() {

			@Override
			public int compare(Point p1, Point p2) {

				int cost = p2.x - p1.x;
				if (cost == 0) {
					return p2.y - p1.y;
				}
				return cost;
			}

		});

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int p = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			pq.add(new Point(p, d));
		}

		for (Point cur = pq.poll(); N-- > 0; cur = pq.poll()) {
			for (int i = cur.y; i > 0; i--) {
				if (visited[i])
					continue;
				visited[i] = true;
				ans += cur.x;
				break;
			}

		}
		while (N-- > 0) {
		}
		System.out.println(ans);

	}

}

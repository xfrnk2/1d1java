package boj.p3k.p3000;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class P3108 {

	static int N, ans = 0;
	static boolean[] visit;

	static boolean[][] crossed;
	static Area[] areas;
	static Integer[] parents;

	static class Area {
		int x1, y1, x2, y2;

		public Area(int x1, int y1, int x2, int y2) {
			super();
			this.x1 = x1;
			this.y1 = y1;
			this.x2 = x2;
			this.y2 = y2;
		}

		public boolean isCross(Area another) {
			int _x1 = another.x1;
			int _y1 = another.y1;
			int _x2 = another.x2;
			int _y2 = another.y2;
			return !(_x2 < x1 || x2 < _x1 || _y2 < y1 || y2 < _y1 || (x1 < _x1 && x2 > _x2 && y1 < _y1 && y2 > _y2)
					|| (_x1 < x1 && _x2 > x2 && _y1 < y1 && _y2 > y2));
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.valueOf(in.readLine());
		visit = new boolean[N];
		areas = new Area[N];
		parents = new Integer[N];
		boolean flag = false;
		for (int i = 0; i < N; i++) {
			parents[i] = i;
		}
		StringTokenizer st;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());

			areas[i] = new Area(x1, y1, x2, y2);

			if (y1 == 0 && x1 * x2 <= 0 || y2 == 0 && x1 * x2 <= 0 || x1 == 0 && y1 * y2 <= 0
					|| x2 == 0 && y1 * y2 <= 0) {
				flag = true;
			}

		}

		crossed = new boolean[N][N];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (areas[i].isCross(areas[j])) {
					crossed[i][j] = true;
				}
			}
		}

		for (int i = 0; i < N; i++) {
			if (!visit[i]) {
				search(i);
				ans++;
			}
		}

		System.out.println(flag ? ans - 1 : ans);
	}

	public static void search(int idx) {
		visit[idx] = true;

		for (int i = 0; i < N; i++) {
			if (!visit[i] && crossed[idx][i]) {
				search(i);
			}
		}
	}

}

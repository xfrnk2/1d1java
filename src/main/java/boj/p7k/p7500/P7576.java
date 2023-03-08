package boj.p7k.p7500;


import java.awt.Point;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P7576 {

	static int[][] di = new int[][] { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
	static int M, N;
	static byte[][] map;
	static Queue<Point> ripenTomatoQ = new LinkedList<>();
	static int tomato, ripen;

	private static boolean isOut(int x, int y) {
		return x < 0 || y < 0 || N <= x || M <= y;
	}

	private static int simulate() {
		int cnt = -1;

		while (!ripenTomatoQ.isEmpty()) {
			int size = ripenTomatoQ.size();
			while (size-- > 0) {
				Point cur = ripenTomatoQ.poll();
				for (int i = 0; i < 4; i++) {
					int nx = cur.x + di[i][0], ny = cur.y + di[i][1];
					if (isOut(nx, ny) || map[nx][ny] != 0)
						continue;
					ripen++;
					map[nx][ny] = 1;
					ripenTomatoQ.add(new Point(nx, ny));

				}
			}
			cnt++;
		}
		return cnt;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		M = Integer.valueOf(st.nextToken());
		N = Integer.valueOf(st.nextToken());
		map = new byte[N][M];
		tomato = ripen = 0;

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Byte.valueOf(st.nextToken());
				if (map[i][j] != -1)
					tomato++;
				if (map[i][j] == 1) {
					ripenTomatoQ.add(new Point(i, j));
					ripen++;
				}
			}
		}

		int ans = -1;
		if (ripen == tomato) {
			ans = 0;
		} else {
			int res = simulate();
			if (ripen == tomato) {
				ans = res;
			}
		}
		System.out.println(ans);

	}

}

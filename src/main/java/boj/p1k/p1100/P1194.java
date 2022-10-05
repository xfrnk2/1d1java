package boj.p1k.p1100;


import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N, M, ans = -1;
	static char[][] map;
	static boolean[][][] visit;
	static int[][] di = new int[][] { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

	static class Pos {
		int x, y, step, bit;

		public Pos(int x, int y, int step, int bit) {
			super();
			this.x = x;
			this.y = y;
			this.step = step;
			this.bit = bit;
		}

		@Override
		public String toString() {
			return "Pos [x=" + x + ", y=" + y + ", step=" + step + ", bit=" + bit + "]";
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new char[N][M];
		visit = new boolean[N][M][1 << 6];
		Queue<Pos> q = new LinkedList<>();

		for (int i = 0; i < N; i++) {
			map[i] = br.readLine().toCharArray();
		}

		searchMinsik: for (int j = 0; j < N; j++) {
			for (int k = 0; k < M; k++) {

				if (map[j][k] == '0') {
					q.offer(new Pos(j, k, 0, 0));
					break searchMinsik;
				}
			}
		}
		System.out.println(go(q));

	}

	public static int go(Queue<Pos> q) {

		visit[q.peek().x][q.peek().y][0] = true;
		while (!q.isEmpty()) {
			Pos p = q.poll();
			for (int i = 0; i < 4; i++) {
				int nx = p.x + di[i][0];
				int ny = p.y + di[i][1];
				if (nx < 0 || ny < 0 || N <= nx || M <= ny || visit[nx][ny][p.bit])
					continue;
				if (map[nx][ny] == '#')
					continue;
				if (map[nx][ny] == '1')
					return p.step + 1;
				if ('a' <= map[nx][ny] && map[nx][ny] <= 'f') {
					visit[nx][ny][p.bit] = true;
					q.offer(new Pos(nx, ny, p.step + 1, p.bit | 1 << 'f' - map[nx][ny]));
					continue;
				}
				if ('A' <= map[nx][ny] && map[nx][ny] <= 'F') {
					if ((p.bit & 1 << 'F' - map[nx][ny]) == 0)
						continue;
				}
				visit[nx][ny][p.bit] = true;
				q.offer(new Pos(nx, ny, p.step + 1, p.bit));
			}
		}
		return -1;
	}

}
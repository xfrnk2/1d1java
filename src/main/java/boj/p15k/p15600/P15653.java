package boj.p15k.p15600;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;

public class P15653 {
	static int N, M, ans = Integer.MAX_VALUE;
	static int[][] di = new int[][] { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
	static char[][] map;
	static Point hole;
	static boolean[][][][] visit;

	static class Unit {
		Point red, blue;
		int cnt;

		public Unit(Point red, Point blue, int cnt) {
			super();
			this.red = red;
			this.blue = blue;
			this.cnt = cnt;
		}

		public Point[] getList(int dCode) {
			Point[] list = new Point[2];
			list[0] = red;
			list[1] = blue;

			switch (dCode) {
			case 0:
				Arrays.sort(list, new Comparator<Point>() {
					@Override
					public int compare(Point o1, Point o2) {
						return o1.x - o2.x;
					}
				});
				break;
			case 1:
				Arrays.sort(list, new Comparator<Point>() {
					@Override
					public int compare(Point o1, Point o2) {
						return o2.x - o1.x;
					}
				});
				break;

			case 2:
				Arrays.sort(list, new Comparator<Point>() {
					@Override
					public int compare(Point o1, Point o2) {
						return o1.y - o2.y;
					}
				});
				break;
			case 3:
				Arrays.sort(list, new Comparator<Point>() {
					@Override
					public int compare(Point o1, Point o2) {
						return o2.y - o1.y;
					}
				});
				break;
			}
			return list;
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String[] info = in.readLine().split(" ");
		N = Integer.parseInt(info[0]);
		M = Integer.parseInt(info[1]);
		map = new char[N][M];
		visit = new boolean[N][M][N][M];

		Point red = null, blue = null;

		for (int i = 0; i < N; i++) {
			map[i] = in.readLine().toCharArray();
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 'R') {
					map[i][j] = '.';
					red = new Point(i, j);
					continue;
				}
				if (map[i][j] == 'B') {
					map[i][j] = '.';
					blue = new Point(i, j);
					continue;
				}
				if (map[i][j] == 'O') {
					hole = new Point(i, j);
				}
			}
		}

		Queue<Unit> q = new LinkedList<>();
		q.offer(new Unit(red, blue, 0));
		visit[red.x][red.y][blue.x][blue.y] = true;
		
		bfs(q);
		System.out.println(ans == Integer.MAX_VALUE ? -1 : ans);
	}

	public static void bfs(Queue<Unit> q) {

		while (!q.isEmpty()) {

			Unit unit = q.poll();



			for (int i = 0; i < 4; i++) {
				Point[] list = unit.getList(i);
				Point newBlue = null;
				Point newRed = null;

				if (list[0].equals(unit.blue)) // 파랑이 먼저라면
				{
					newBlue = update(unit.blue, i);
					newRed = update2(unit.red, i, newBlue);
				} else {

					newRed = update(unit.red, i);
					newBlue = update2(unit.blue, i, newRed);
				}

				if (newRed.equals(newBlue) || (newRed.equals(unit.red) && newBlue.equals(unit.blue))
						|| (!newRed.equals(hole) && newBlue.equals(hole))

				) {
					continue;
				}

				if (newRed.equals(hole) && !newBlue.equals(hole)) {
					ans = Math.min(ans, unit.cnt + 1);
					return;
				}
				
				if (visit[newRed.x][newRed.y][newBlue.x][newBlue.y]) continue;
				
				
				
				visit[newRed.x][newRed.y][newBlue.x][newBlue.y] = true;
				
				q.offer(new Unit(newRed, newBlue, unit.cnt + 1));

				// 빨간 공과 파란공의 도달할 위치를 구한다.
				// 두 위치가 같으면 둘다 골인이므로 실패
				// 두 공 모두 움직일 수 없다면 실패
				// 파란 구슬이 빠지면 실패
			}

		}
	}

	public static Point update(Point p, int dCode) {
		int x = p.x, y = p.y;
		while (true) {
			int nx = x + di[dCode][0], ny = y + di[dCode][1];
			if (map[nx][ny] == 'O') {
				x = nx;
				y = ny;
				break;
			}
			if (map[nx][ny] == '.') {
				x = nx;
				y = ny;
				continue;
			}
			break;
		}
		return new Point(x, y);
	}

	public static Point update2(Point p, int dCode, Point otherBall) {
		int x = p.x, y = p.y;
		while (true) {

			int nx = x + di[dCode][0], ny = y + di[dCode][1];
			if (map[nx][ny] == 'O') {
				x = nx;
				y = ny;
				break;
			}

			if (otherBall.x == nx && otherBall.y == ny) {
				break;
			}
			if (map[nx][ny] == '.') {
				x = nx;
				y = ny;
				continue;
			}

			break;
		}
		return new Point(x, y);
	}

}

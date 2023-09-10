package boj.p2k.p2400;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class P2424 {
	static int N, M;
	static Point Y, T, V;
	static char[][] map;
	static int[] rowMin, colMin;
	static int[][] di = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };
	static int[][] vVisit, vLowest;
	static boolean[][] yVisit;

	static class Node {
		int x, y, c;

		public Node(int x, int y, int c) {
			this.x = x;
			this.y = y;
			this.c = c;
		}

		@Override
		public String toString() {
			return "Node{" + "x=" + x + ", y=" + y + ", c=" + c + '}';
		}
	}

	private static boolean isOut(int x, int y) {
		return x <= 0 || y <= 0 || N < x || M < y;
	}

	private static int fillLineAlongRow(int rowNum, int colStart) {
		// 고정된 row의 column 기준 start와 end 구간에 대하여 최솟값을 갱신해준다.
		int colEnd = colStart;
		while (colEnd <= M && map[rowNum][colEnd] != 'I')
			colEnd++;
		int minValue = rowQuery(1, M, colStart, colEnd, 1, rowNum);
		for (int i = colStart; i < colEnd; i++) {
			vLowest[rowNum][i] = Math.min(vLowest[rowNum][i], minValue);
		}
		return colEnd;
	}

	private static int fillLineAlongColumn(int colNum, int rowStart) {
		// 고정된 column의 row 기준 start와 end 구간에 대하여 최솟값을 갱신해준다.
		int rowEnd = rowStart;
		while (rowEnd <= N && map[rowEnd][colNum] != 'I')
			rowEnd++;
		int minValue = colQuery(1, N, rowStart, rowEnd, 1, colNum);
		for (int i = rowStart; i < rowEnd; i++) {
			vLowest[i][colNum] = Math.min(vLowest[i][colNum], minValue);
		}
		return rowEnd;
	}

	private static int rowInit(int start, int end, int node, int rowNum) {
		if (start == end) {
			return rowMin[node] = vVisit[rowNum][start];
		}
		int mid = (start + end) / 2;
		return rowMin[node] = Math.min(rowInit(start, mid, node * 2, rowNum),
				rowInit(mid + 1, end, node * 2 + 1, rowNum));
	}

	private static int colInit(int start, int end, int node, int colNum) {
		if (start == end) {
			return colMin[node] = vVisit[start][colNum];
		}
		int mid = (start + end) / 2;
		return colMin[node] = Math.min(colInit(start, mid, node * 2, colNum),
				colInit(mid + 1, end, node * 2 + 1, colNum));
	}

	private static int rowQuery(int start, int end, int left, int right, int node, int rowNum) {
		if (right < start || end < left)
			return Integer.MAX_VALUE;
		if (left <= start && end <= right) {
			return rowMin[node];
		}
		int mid = (start + end) / 2;
		return Math.min(rowQuery(start, mid, left, right, node * 2, rowNum),
				rowQuery(mid + 1, end, left, right, node * 2 + 1, rowNum));
	}

	private static int colQuery(int start, int end, int left, int right, int node, int colNum) {
		if (right < start || end < left)
			return Integer.MAX_VALUE;
		if (left <= start && end <= right) {
			return colMin[node];
		}
		int mid = (start + end) / 2;
		return Math.min(colQuery(start, mid, left, right, node * 2, colNum),
				colQuery(mid + 1, end, left, right, node * 2 + 1, colNum));
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new char[N + 1][M + 1];
		vVisit = new int[N + 1][M + 1];
		vLowest = new int[N + 1][M + 1];
		rowMin = new int[M * 4];
		colMin = new int[N * 4];
		for (int i = 1; i <= N; i++) {
			String line = in.readLine();
			for (int j = 1; j <= M; j++) {
				map[i][j] = line.charAt(j - 1);
			}
			Arrays.fill(vVisit[i], Integer.MAX_VALUE);
			Arrays.fill(vLowest[i], Integer.MAX_VALUE);
		}

		for (int i = 1; i <= N; i++) {

			for (int j = 1; j <= M; j++) {
				if (map[i][j] == 'Y') {
					Y = new Point(i, j);
					continue;
				}
				if (map[i][j] == 'V') {
					V = new Point(i, j);
					continue;
				}
				if (map[i][j] == 'T') {
					T = new Point(i, j);
				}
			}
		}

		Queue<Node> q = new LinkedList<>();
		q.add(new Node(V.x, V.y, 0));
		vVisit[V.x][V.y] = 0;

		while (!q.isEmpty()) {

			Node cur = q.poll();
			int nx, ny;
			for (int i = 0; i < 4; i++) {
				nx = cur.x + di[i][0];
				ny = cur.y + di[i][1];
				if (isOut(nx, ny) || map[nx][ny] == 'I' || vVisit[nx][ny] != Integer.MAX_VALUE) {
					continue;
				}

				vVisit[nx][ny] = cur.c + 1;
				q.add(new Node(nx, ny, cur.c + 1));

			}
		}
		// 시작점을 1로 초기화
		vVisit[V.x][V.y] = vLowest[V.x][V.y] = 1;

		for (int i = 1; i <= N; i++) {
			int np = 1;
			Arrays.fill(rowMin, Integer.MAX_VALUE);
			rowInit(1, M, 1, i);

			// next pointer, I가 아닌 곳에 대한 구간을 탐색는 함수로 진입.
			while (np <= M) {
				if (map[i][np] == 'I') {
					np++;
					continue;
				}
				np = fillLineAlongRow(i, np);
			}
		}

		for (int i = 1; i <= M; i++) {
			int np = 1;
			Arrays.fill(colMin, 0);
			colInit(1, N, 1, i);

			// next pointer, I가 아닌 곳에 대한 구간을 탐색는 함수로 진입.
			while (np <= N) {
				if (map[np][i] == 'I') {
					np++;
					continue;
				}
				np = fillLineAlongColumn(i, np);
			}
		}

		yVisit = new boolean[N + 1][M + 1];
		q.add(new Node(Y.x, Y.y, 0));
		yVisit[Y.x][Y.y] = true;

		loop: while (!q.isEmpty()) {
			Node cur = q.poll();
			int nx, ny;

			for (int i = 0; i < 4; i++) {
				nx = cur.x + di[i][0];
				ny = cur.y + di[i][1];

				if (isOut(nx, ny) || map[nx][ny] == 'I' || yVisit[nx][ny] || vLowest[nx][ny] <= cur.c + 1)
					continue;
				yVisit[nx][ny] = true;
				if (Y.x == nx && Y.y == ny)
					break loop;
				q.add(new Node(nx, ny, cur.c + 1));

			}
		}
		System.out.println(yVisit[T.x][T.y] ? "YES" : "NO");
	}

}

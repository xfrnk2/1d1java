package boj.p2k.p2900;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class P2933 {
	static int N, M, K;
	static int[][] di = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
	static char[][] map;

	private static int crash(int dir, int row) {

		if (dir % 2 == 0) { // 왼쪽 -> 오른쪽

			for (int i = 0; i < M; i++) {
				if (map[row][i] == 'x') {
					return i;
				}
			}

		} else { // 왼쪽 <- 오른쪽
			for (int i = M - 1; i >= 0; i--) {
				if (map[row][i] == 'x') {
					return i;
				}
			}
		}

		return -1;
	}

	private static void print() {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				sb.append(map[i][j]);

			}
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}

	static class ClusterInfo {
		// 부숴진 칸에서 인접한 영역의 클러스터가 공중에 떠있는지 확인후 결과 반환
		// 결과 instance - isFloat :boolean, PriorityQueue[M], maxRowArr[M]
		boolean isFloat;
		PriorityQueue[] pq;
		int[] maxRowArr;

		public ClusterInfo() {
			super();
			isFloat = true;
			pq = new PriorityQueue[M];
			for (int i = 0; i < M; i++) {
				pq[i] = new PriorityQueue<Point>(new Comparator<Point>() {

					@Override
					public int compare(Point p1, Point p2) {
						// TODO Auto-generated method stub
						return p2.x - p1.x;
					}

				});
			}

			maxRowArr = new int[M];
			Arrays.fill(maxRowArr, -1);
		}
	}

	private static boolean isOut(int x, int y) {
		return x < 0 || y < 0 || N <= x || M <= y;
	}

	private static void track(ClusterInfo clusterInfo, Queue<Point> q, boolean[][] visit) {

		// print();

		while (!q.isEmpty()) {

			Point cur = q.poll();
			for (int i = 0; i < 4; i++) {
				int nx = cur.x + di[i][0], ny = cur.y + di[i][1];
				if (isOut(nx, ny) || visit[nx][ny])
					continue;
				if (map[nx][ny] == 'x') {
					visit[nx][ny] = true;
					if (nx == N - 1)
						clusterInfo.isFloat = false;
					clusterInfo.pq[ny].add(new Point(nx, ny));
					clusterInfo.maxRowArr[ny] = Math.max(clusterInfo.maxRowArr[ny], nx);
					q.add(new Point(nx, ny));
				}
			}
		}
	}

	private static int getMaxCnt(int[] maxRowArr) {
		int cnt = Integer.MAX_VALUE;
		for (int i = 0; i < M; i++) {
			if (maxRowArr[i] == -1)
				continue;
			int x = maxRowArr[i], y = i;
			int res = 0;
			while (true) {
				if (N <= x + 1 || map[x + 1][y] == 'x') {
					// 더 진행 못한다면
					cnt = Math.min(res, cnt);
					break;
				}
				x++;
				res++;

			}

		}
		return cnt;
	}

	private static void fallDown(ClusterInfo clusterInfo) {
		int maxCnt = getMaxCnt(clusterInfo.maxRowArr);

//		System.out.println(Arrays.toString(clusterInfo.maxRowArr));
//		
//		System.out.println("maxCnt..." + maxCnt);

		for (int i = 0; i < M; i++) {
			while (!clusterInfo.pq[i].isEmpty()) {
				Point cur = (Point) clusterInfo.pq[i].poll();
				int x = cur.x, y = cur.y;
				int cnt = maxCnt;
				while (cnt-- > 0) {
					map[x + 1][y] = map[x][y];
					map[x][y] = '.';
					x++;
				}
			}

		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());

		N = Integer.valueOf(st.nextToken());
		M = Integer.valueOf(st.nextToken());
		map = new char[N][M];
		for (int i = 0; i < N; i++) {
			map[i] = in.readLine().toCharArray();
		}
		K = Integer.valueOf(in.readLine());
		st = new StringTokenizer(in.readLine());
		for (int i = 0; i < K; i++) {
			// System.out.println("i..." + i);
			int cur = Integer.valueOf(st.nextToken());
			int row = N - cur;
			int crashRes = crash(i, row);
			if (crashRes == -1) { // 부술 것이 없으므로 계속
				continue;
			}

			map[row][crashRes] = '.'; // 부숨
			for (int j = 0; j < 4; j++) {
				int nx = row + di[j][0], ny = crashRes + di[j][1];
				if (!isOut(nx, ny) && map[nx][ny] == 'x') {

					boolean[][] visit = new boolean[N][M];
					visit[nx][ny] = true;

					// 탐색 가능한 인접 칸
					ClusterInfo clusterInfo = new ClusterInfo();
					clusterInfo.pq[ny].add(new Point(nx, ny));
					clusterInfo.maxRowArr[ny] = nx;

					Queue q = new LinkedList<>(); // 좌표를 담기위한 queue
					q.add(new Point(nx, ny));

					track(clusterInfo, q, visit);
					if (clusterInfo.isFloat) {
						// System.out.println("isFloat..");
						fallDown(clusterInfo);

					}
					// print();
					// System.out.println("dir..." + j);

				}

			}

			// print(); 잘 부숴진다.

			// 부숴진 칸에서 인접한 영역의 클러스터가 공중에 떠있는지 확인후 결과 반환
			// 결과 instance - isFloat :boolean, PriorityQueue[M], maxRowArr[M]

			// maxRowArr[M] 내의 값을 통해 최대 하강 cnt를 구할 수 있다.
			// -> PriorityQueue[M]을 순회하며 cnt만큼 아래로 내린다.
		}
		print();
	}

}

package boj.p14k.p14400;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class P14442 {
	static int N, M, K;
	static int[][] di = new int[][] { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

	public static class Node {
		public Node(int x, int y, int k, int cnt) {
			super();
			this.x = x;
			this.y = y;
			this.k = k;
			this.cnt = cnt;
		}

		int x, y, k, cnt;
	}

	public static boolean isOut(int x, int y) {
		return x < 0 || y < 0 || N <= x || M <= y;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		N = Integer.valueOf(st.nextToken());
		M = Integer.valueOf(st.nextToken());
		K = Integer.valueOf(st.nextToken());
		char[][] map = new char[N][M];
		boolean[][][] visit = new boolean[N][M][K + 1];
		for (int i = 0; i < N; i++) {
			map[i] = in.readLine().toCharArray();
		}

		Queue<Node> q = new LinkedList<>();
		visit[0][0][0] = true;
		q.offer(new Node(0, 0, 0, 1));
		while (!q.isEmpty()) {
			Node node = q.poll();
			if (node.x == N - 1 && node.y == M - 1) {
				System.out.println(node.cnt);
				System.exit(0);
			}
			for (int i = 0; i < 4; i++) {
				int nx = node.x + di[i][0], ny = node.y + di[i][1];
				if (isOut(nx, ny) || visit[nx][ny][node.k])
					continue;
				if (map[nx][ny] == '1') {
					if (node.k < K) {
						visit[nx][ny][node.k] = true;
						q.offer(new Node(nx, ny, node.k + 1, node.cnt + 1));
					}
				} else {
					visit[nx][ny][node.k] = true;
					q.offer(new Node(nx, ny, node.k, node.cnt + 1));
				}

			}
		}
		System.out.println(-1);
	}

}

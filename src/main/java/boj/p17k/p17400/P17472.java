package boj.p17k.p17400;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class P17472 {
	static int N, M, tmpIslandIdx;
	static int[] parents;
	static int[][] di = new int[][] { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
	static int map[][], islandNumArr[][];
	static ArrayDeque<int[]> islandArr[];
	static boolean[][] initVisited;
	static ArrayList<Edge> edges;

	static class Edge implements Comparable<Edge> {
		int from, to, weight;

		public Edge(int from, int to, int weight) {
			super();
			this.from = from;
			this.to = to;
			this.weight = weight;
		}

		@Override
		public String toString() {
			return "Edge [from=" + from + ", to=" + to + ", weight=" + weight + "]";
		}

		@Override
		public int compareTo(Edge o) {
			return this.weight - o.weight;
		}

	}

	static void make() {
		parents = new int[tmpIslandIdx];
		for (int i = 0; i < tmpIslandIdx; i++) {
			parents[i] = i;
		}
	}

	static int find(int a) {
		if (parents[a] == a)
			return a;
		return parents[a] = find(parents[a]);
	}

	static boolean union(int a, int b) {
		int aRoot = find(a);
		int bRoot = find(b);
		if (aRoot == bRoot)
			return false;
		parents[aRoot] = bRoot;
		return true;
	}

	public static void initDfs(int tempIslandIdx, int x, int y) {
		initVisited[x][y] = true;
		for (int i = 0; i < 4; i++) {
			int nx = x + di[i][0], ny = y + di[i][1];
			if (nx < 0 || ny < 0 || N <= nx || M <= ny || map[nx][ny] == 0 || initVisited[nx][ny]) {
				continue;
			}
			islandNumArr[nx][ny] = tempIslandIdx;
			islandArr[tempIslandIdx].add(new int[] { nx, ny });
			initDfs(tempIslandIdx, nx, ny);
		}
	}

	public static void check(int x, int y, int k, int islandNum, int cnt) { // 한 좌표에서 각각의 사방향으로 어느 거리만큼 있는지 체크하는 함수
		// x, y 는 좌표, k는 방향, islandNum 시작한 섬 번호, cnt는 거리
		int nx = x + di[k][0], ny = y + di[k][1];
		if (nx < 0 || ny < 0 || N <= nx || M <= ny || islandNumArr[nx][ny] == islandNum) { // 출발 섬과 다르거나 유효 범위가 아니라면 종료
			return;
		}
		if (islandNumArr[nx][ny] == -1) { // 이동 가능한 섬이라면 이동
			check(nx, ny, k, islandNum, cnt + 1);
			return;
		}
		if (cnt < 2)
			return; // 다른 섬에 도달하였을 때 거리가 2 미만이면 종료
		edges.add(new Edge(islandNum, islandNumArr[nx][ny], cnt)); // 도달한 거리가 2 이상인 경우 ArrayList에 추가
	}

	// 2차원 배열, 섬 넘버와 visited
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		islandNumArr = new int[N][M];
		islandArr = new ArrayDeque[100];
		edges = new ArrayList<>();

		initVisited = new boolean[N][M];

		tmpIslandIdx = 0;

		// 입력 받기
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			for (int j = 0; j < M; j++) {
				int cur = Integer.parseInt(st.nextToken());
				map[i][j] = cur;
			}
			// 섬 영역을 구분하기 위한 islandNumArr의 값을 모두 -1로 초기화한다.
			Arrays.fill(islandNumArr[i], -1);
		}

		// 섬 영역을 구분한 islandNumArr을 초기화한다.
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 1 && !initVisited[i][j]) {
					islandArr[tmpIslandIdx] = new ArrayDeque<int[]>();
					islandArr[tmpIslandIdx].add(new int[] { i, j });
					islandNumArr[i][j] = tmpIslandIdx;
					initDfs(tmpIslandIdx, i, j);
					tmpIslandIdx++; // 섬의 갯수 증가
				}
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (islandNumArr[i][j] != -1) { // 섬이 아닌 영역인 경우
					for (int k = 0; k < 4; k++) { // 사방향에 대해서 다른 섬에 닿을 수 있는지 확인한다.
						check(i, j, k, islandNumArr[i][j], 0);
					}
				}
			}
		}

		// MST를 구성한다.
		Collections.sort(edges);
		make();
		int ans = 0;
		int cc = 0;

		for (Edge edge : edges) {
			if (union(edge.from, edge.to)) {
				ans += edge.weight;
				cc++;
			}
		}
		System.out.println(cc >= tmpIslandIdx - 1 ? ans : -1);
	}
}

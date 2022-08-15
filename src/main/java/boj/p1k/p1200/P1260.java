

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class P1260 {
	static int N, M, V, cnt;
	static boolean[][] matrix;
	static boolean[] visited;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		V = sc.nextInt();
		matrix = new boolean[N + 1][N + 1];
		visited = new boolean[N + 1];
		for (int i = 0; i < M; i++) {
			int lhs = sc.nextInt();
			int rhs = sc.nextInt();
			matrix[lhs][rhs] = true;
			matrix[rhs][lhs] = true;
		}
		
		
		// 출발점을 방문 처리후 dfs
		visited[V] = true;
		dfs(V);
		
		// 기존에 사용한 cnt와 visited 전역변수를 bfs를 위해 초기화
		cnt = 0;
		visited = new boolean[N + 1];
		
		// 줄 구분
		sb.append("\n");
		
		// 출발점을 방문 처리 후 bfs
		visited[V] = true;
		bfs(V);
		System.out.print(sb);
	}

	public static void dfs(int v) {
		sb.append(v).append(" ");
		cnt++;
		if (cnt == N) {
			return;
		}
		for (int i = 1; i <= N; i++) {
			if (matrix[v][i]) {
				if (visited[i])
					continue;
				visited[i] = true;
				dfs(i);
			}
		}
	}

	public static void bfs(int v) {
		Queue<int[]> q = new LinkedList<int[]>();
		q.offer(new int[] { 0, v });
		while (!q.isEmpty() && cnt++ < N) {
			int[] cur = q.poll();
			int nxt = cur[1];
			sb.append(nxt).append(" ");
			for (int i = 1; i <= N; i++) {
				if (!matrix[nxt][i] || visited[i])
					continue;
				visited[i] = true;
				q.offer(new int[] { nxt, i });
			}
		}
	}
}

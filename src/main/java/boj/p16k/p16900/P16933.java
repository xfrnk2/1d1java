package boj.p16k.p16900;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class P16933 {
	static int N, M, K;
	static char[][] map;
	static int[][] di = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
	static boolean[][][][] visit;
	
	static class Info {
		int isNight;
		int x, y, k;
		public Info(int isNight, int x, int y, int k) {
			super();
			this.isNight = isNight;
			this.x = x;
			this.y = y;
			this.k = k;
		}
		@Override
		public String toString() {
			return String.format("Info [isNight=%s, x=%s, y=%s, k=%s", isNight, x, y, k);
		}

		
	}
	
	private static boolean isOut(int x, int y) {
		return x < 0 || y < 0 || N <= x || M <= y;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		N = Integer.valueOf(st.nextToken());
		M = Integer.valueOf(st.nextToken());
		K = Integer.valueOf(st.nextToken());
		
		map = new char[N][M];
		for (int i = 0; i < N; i++) {
			map[i] = in.readLine().toCharArray();
		}
		visit = new boolean[N][M][K + 1][2]; // 마지막 idx가 0이면 낮, 1이면 밤
		

		ArrayDeque<Info> q = new ArrayDeque<>();
		visit[0][0][0][0] = true;
		q.offer(new Info(0, 0, 0, 0));
		int tick = 1;
		int ans = -1;

		loop:
		while (!q.isEmpty()) {
			int size = q.size();
			for (int z = 0; z < size; z++) {
				
				
				
				Info now = q.poll();
				if (now.x == N - 1 && now.y == M - 1) {
					ans = tick;
					break;
				}

				if (!visit[now.x][now.y][now.k][(now.isNight + 1) % 2]) {
					visit[now.x][now.y][now.k][(now.isNight + 1)%2] = true;
					q.offer(new Info((now.isNight + 1)%2, now.x, now.y, now.k));
				}
				
				for (int i = 0; i < 4; i++) {
					int nx = now.x + di[i][0], ny = now.y + di[i][1];
			
					
					if (isOut(nx, ny)) continue;
		

					if (map[nx][ny] == '0') {
						int nextNight = now.isNight == 0 ? 1 : 0; // 밤이면 낮으로, 낮이면 밤으로
						if (visit[nx][ny][now.k][nextNight]) continue;

						visit[nx][ny][now.k][nextNight] = true;
						q.offer(new Info(nextNight, nx, ny, now.k));
						continue;
					}
					if (map[nx][ny] == '1' && now.isNight == 0) {
						if (K <= now.k) continue;
						// 현재 낮이고 그 위치에 방문한적 없다면 방문처리
						if (!visit[nx][ny][now.k][1]) {
							// 현재가 낮이고 해당 위치의 밤이 방문처리가 안되어 있다.
							visit[nx][ny][now.k + 1][1] = true;
							q.offer(new Info(1, nx, ny, now.k + 1));
							continue;
						} 
					}
				}
			}
			
			if (ans!= -1) break;
			tick ++;
			


			
			
		}
		System.out.println(ans);
		
		
	}

}

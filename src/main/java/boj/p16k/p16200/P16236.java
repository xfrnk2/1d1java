package boj.p16k.p16600;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;


public class P16236 {
	static int[][] di = new int[][] {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
	static int[][] map;
	static boolean[][] visited;
	static int N, size = 2, exp = 0, moveCnt = 0;
	
	
	
	
	public static class Shark {
		int x, y, cnt;
		Shark(int x, int y, int cnt) {
			this.x = x;
			this.y = y;
			this.cnt = cnt;
		}
		
		@Override
		public String toString() {
			return this.x + " " + this.y + " " + this.cnt;
		}
	}
	
	private static boolean isNotIn(int x, int y) {
		return x < 0 || y < 0 || N <= x || N <= y;
	}
	
	
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		visited = new boolean[N][N];

		int sx = 0, sy = 0;
		

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				int val = Integer.parseInt(st.nextToken());
				if (val == 9) {
					sx = i;
					sy = j;
					map[i][j] = 0;
				} else map[i][j] = val;
			}

		}

		while (true) {
			ArrayDeque<Shark> queue = new ArrayDeque<>();
			ArrayList<Shark> fishes = new ArrayList<>();
			visited = new boolean[N][N];
			int flag = Integer.MAX_VALUE;
			queue.offer(new Shark(sx, sy, 0));
			
			while (!queue.isEmpty()) {
				Shark cur = queue.poll();
				if (flag < cur.cnt) break;
				
				for (int i = 0; i < 4; i++) {
					int nx = cur.x + di[i][0], ny = cur.y + di[i][1];
					
					if (isNotIn(nx, ny) || visited[nx][ny] || size < map[nx][ny]) continue;
			
					if (map[nx][ny] != 0 && map[nx][ny] < size) {
						fishes.add(new Shark(nx, ny, cur.cnt + 1));
						flag = cur.cnt;
					}
					visited[nx][ny] = true;
					queue.offer(new Shark(nx, ny, cur.cnt + 1));
					}
				}
			
	
			if (fishes.size() > 0) {
				Collections.sort(fishes, new Comparator<Shark>() {

					@Override
					public int compare(Shark o1, Shark o2) {
						int cDif = o1.cnt - o2.cnt;
						if (cDif == 0) {
							int xDif = o1.x - o2.x;
							if (xDif == 0) {
								return o1.y - o2.y;
							} else return xDif;
							
						}
						else return cDif;
					}
					
				});
				
				Shark cur = fishes.get(0);
				moveCnt += cur.cnt;
				exp ++;
				map[cur.x][cur.y] = 0;
				if (exp == size) {
					exp = 0;
					size ++;
				}
						
				sx = cur.x;
				sy = cur.y;

			} else {
				break;
			}		
		}
		
		System.out.println(moveCnt);
			
			
		}
		
		
		

}


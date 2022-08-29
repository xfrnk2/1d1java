package boj.p17k.p17100;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class P17143 {
	static class Shark {
		int no, x, y, s, d, z; 
		boolean dead;
		public Shark(int no, int x, int y, int s, int d, int z) {
			this.no = no;
			this.x = x;
			this.y = y;
			this.s = s;
			this.d = d;
			this.z = z;
		}
		
		void move() {
			if (dead) return;
			
			for (int i = 0; i < s; i++) {
				int nx = x + dx[d];
				int ny = y + dy[d];
				
				if (!checkBoundary(nx, ny)) {
					d = reverseDir(d);
					nx = x + dx[d];
					ny = y + dy[d];
				}
				
				x = nx;
				y = ny;
			}
			
			if (temp[x][y] == 0) {
				temp[x][y] = no;
			} else {
				if (z < sharks[temp[x][y]].z) {
					this.dead = true;
				} else {
					sharks[temp[x][y]].dead = true;
					temp[x][y] = no;
				}
			}
			
		}
		
		int reverseDir(int dir) {
			switch(dir) {
			case 0:
				return 1;
			case 1:
				return 0;
			case 2:
				return 3;
			case 3:
				return 2;
			}
			
			return -1;
		}
	}
	
	static int R, C, M, total;
	
	static int[][] map;
	static int[][] temp;
	static Shark[] sharks;
	
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, 1, -1};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		sharks = new Shark[M + 1];
		map = new int[R + 1][C + 1];
		
		for (int i = 1; i <= M; i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken()) - 1;
			int z = Integer.parseInt(st.nextToken());
			
			sharks[i] = new Shark(i, r, c, s, d, z);
			map[r][c] = i;
		}
		
		for (int j = 1; j <= C; j++) {
			catchShark(j);
			moveSharks();
		}
		
		System.out.println(total);
	}
	
	static void catchShark(int j) {
		for (int i = 1; i <= R; i++) {
			if (map[i][j] != 0) {
				int no = map[i][j];
				map[i][j] = 0;
				total += sharks[no].z;
				sharks[no].dead = true;
				return;
			}
		}
	}
	
	static void moveSharks() {
		temp = new int[R + 1][C + 1];
		for (int i = 1; i <= M; i++) {
			sharks[i].move();
		}
		copyMap(temp, map);
	}
	
	static boolean checkBoundary(int nx, int ny) {
		if (nx > 0 && nx <= R && ny > 0 && ny <= C) {
			return true;
		}
		return false;
	}
	
	static void copyMap(int[][] src, int[][] dst) {
		for (int i = 1; i <= R; i++) {
			for (int j = 1; j <= C; j++) {
				dst[i][j] = src[i][j];
			}
		}
	}
}


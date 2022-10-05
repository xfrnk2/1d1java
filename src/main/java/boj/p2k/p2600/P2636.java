package boj.p2k.p2600;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P2636 {

	static int[][] di = new int[][] { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
	static int N, M, ans, cheeseCnt;
	static byte[][] ch;
	static boolean[][] visit;

	public static boolean isHole(int x, int y) {

		loop: for (int i = 0; i < 4; i++) {
			int nx = x, ny = y;
			while (0 <= nx && 0 <= ny && nx < N && ny < M && ch[nx][ny] == 0) {

				nx = nx + di[i][0];
				ny = ny + di[i][1];
				if (nx < 0 || ny < 0 || N <= nx || M <= ny) {
					return false;
				}
				if (ch[nx][ny] == 1) continue loop;
			}
		}
		return true;
	}

	public static boolean isEmpty() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (ch[i][j] == 1)
					return false;
			}
		}
		return true;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		ch = new byte[N][M];
		visit = new boolean[N][M];

		ans = 0;
		int prevCheeseCnt = 0;
		cheeseCnt = 0;
		
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			for (int j = 0; j < M; j++) {
				ch[i][j] = Byte.parseByte(st.nextToken());
				if (ch[i][j] == 1) cheeseCnt ++;
			}
		}
		tick: 
			while (!isEmpty()) {
			ans++;
			prevCheeseCnt = cheeseCnt;


			visit = new boolean[N][M];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (ch[i][j] == 1)
						continue;
					if (isHole(i, j))
						continue;

					trackEmpty(i, j);
					continue tick;

				}
			}

		}
		System.out.println(ans);
		System.out.println(prevCheeseCnt);

	}

	public static void trackEmpty(int x, int y) {
		Queue<Point> q = new LinkedList<>();
		Queue<Point> outside = new LinkedList<>();
		visit[x][y] = true;
		q.offer(new Point(x, y));
		while (!q.isEmpty()) {
			Point p = q.poll();

			for (int i = 0; i < 4; i++) {
				int nx = p.x + di[i][0], ny = p.y + di[i][1];
				if (nx < 0 || ny < 0 || N <= nx || M <= ny || visit[nx][ny])
					continue;
				
				visit[nx][ny] = true;
				
				if (ch[nx][ny] == 1) {
					outside.offer(new Point(nx, ny));
					continue;
				}
				
				q.offer(new Point(nx, ny));
				

			}

		}

		removeOutside(outside);
	}

	public static void removeOutside(Queue<Point> q) {
		while (!q.isEmpty()) {
			Point p = q.poll();
			ch[p.x][p.y] = 0;
			cheeseCnt --;
		}
	}

}
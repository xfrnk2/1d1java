package boj.p9k.p9300;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class P9328 {

	static int H, W;
	static int[][] di = new int[][] { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
	static char[][] map;
	static boolean[][] visit;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(in.readLine());
		for (int tc = 0; tc < T; tc++) {
			st = new StringTokenizer(in.readLine());
			H = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			map = new char[H][W];
			visit = new boolean[H][W];
			Queue<Point> q = new LinkedList<>();

			for (int i = 0; i < H; i++) {
				map[i] = in.readLine().toCharArray();
			}

			int docCnt = 0;
			boolean[] knd = new boolean[123];
			List<Point>[] dp = new LinkedList[91];
			for (int i = 0; i < 91; i++) {
				dp[i] = new LinkedList<>();
			}
			String keys = in.readLine();
			if (!keys.equals("0")) {
				for (int i = 0, size = keys.length(); i < size; i++) {
					knd[keys.charAt(i)] = true;
				}
			}

			// 가로 외곽 열쇠 또는 문서 줍기
			for (int i = 0; i < W; i++) {
				if (Character.isLowerCase(map[0][i])) {

					knd[map[0][i]] = true;
					map[0][i] = '.';
				}
				if (Character.isLowerCase(map[H - 1][i])) {

					knd[map[H - 1][i]] = true;
					map[H - 1][i] = '.';
				}

				if (map[0][i] == '$') {
					map[0][i] = '.';
					q.offer(new Point(0, i));
					docCnt++;
				}

				if (map[H - 1][i] == '$') {
					map[H - 1][i] = '.';
					q.offer(new Point(H - 1, i));
					docCnt++;
				}
			}

			// 세로 외곽 열쇠 또는 문서 줍기
			for (int i = 1, end = H - 1; i < end; i++) {
				if (Character.isLowerCase(map[i][0])) {
					knd[map[i][0]] = true;
					map[i][0] = '.';
				}
				if (Character.isLowerCase(map[i][W - 1])) {
					knd[map[i][W - 1]] = true;
					map[i][W - 1] = '.';
				}

				if (map[i][0] == '$') {
					map[i][0] = '.';
					q.offer(new Point(i, 0));
					docCnt++;
				}

				if (map[i][W - 1] == '$') {
					map[i][W - 1] = '.';
					q.offer(new Point(i, W - 1));
					docCnt++;
				}
			}

			// 가로 외곽 입구 찾기
			for (int i = 0; i < W; i++) {
				if (map[0][i] == '.') {
					q.offer(new Point(0, i));
				}
				if (map[H - 1][i] == '.') {
					q.offer(new Point(H - 1, i));
				}

				if (Character.isUpperCase(map[0][i])) {
					if (knd[map[0][i] + 32]) { // 외곽에 문이 있고 열쇠가 있다면
						knd[map[0][i]] = true;
						map[0][i] = '.';
						q.offer(new Point(0, i));
					} else {
						dp[map[0][i]].add(new Point(0, i));
					}
				}
				if (Character.isUpperCase(map[H - 1][i])) {
					if (knd[map[H - 1][i] + 32]) { // 외곽에 문이 있고 열쇠가 있다면
						knd[map[H - 1][i]] = true;
						map[H - 1][i] = '.';
						q.offer(new Point(H - 1, i));
					} else {
						dp[map[H - 1][i]].add(new Point(H - 1, i));
					}
				}

			}

			// 1~ H-1 행 사이의 세로 외곽 입국 찾기
			for (int i = 1, end = H - 1; i < end; i++) {
				if (map[i][0] == '.') {
					q.offer(new Point(i, 0));
				}
				if (map[i][W - 1] == '.') {
					q.offer(new Point(i, W - 1));
				}

				if (Character.isUpperCase(map[i][0])) {
					if (knd[map[i][0] + 32]) { // 외곽에 문이 있고 열쇠가 있다면
						knd[map[i][0]] = true;
						map[i][0] = '.';
						q.offer(new Point(i, 0));
					} else {
						dp[map[i][0]].add(new Point(i, 0));
					}
				}
				if (Character.isUpperCase(map[i][W - 1])) {
					if (knd[map[i][W - 1] + 32]) { // 외곽에 문이 있고 열쇠가 있다면
						knd[map[i][W - 1]] = true;
						map[i][W - 1] = '.';
						q.offer(new Point(i, W - 1));
					} else {
						dp[map[i][0]].add(new Point(i, 0));
					}
				}

			}

			// 열쇠를 저장한다. knd가 true일 경우
			// - 열쇠 : 보유중, - 문 : 방문 완료.
			// dp는 문의 위치를 저장하고, 열쇠를 주울시 소문자->대문자로 변환하여 해당 위치로 점프한다.

			while (!q.isEmpty()) {
				Point cur = q.poll();
				visit[cur.x][cur.y] = true;
				for (int i = 0; i < 4; i++) {
					int nx = cur.x + di[i][0], ny = cur.y + di[i][1];
					if (nx < 0 || ny < 0 || H <= nx || W <= ny)
						continue;
					if (visit[nx][ny])
						continue;
					if (map[nx][ny] == '*')
						continue;
					if (map[nx][ny] == '$') { // 문서일 경우 get 후 q에 offer
						docCnt++;
						map[nx][ny] = '.';
						q.offer(new Point(nx, ny));
						continue;
					}
					if (Character.isLowerCase(map[nx][ny])) { // 열쇠일경우 저장
						// System.out.println("열쇠 get...");
						knd[map[nx][ny]] = true;
						q.offer(new Point(nx, ny)); // 열쇠 획득후 그 위치에서 이동
//						System.out.println(map[nx][ny]);
//						System.out.println(map[nx][ny] - 32);
//						System.out.println("열쇠로 열 수 있는 대상..." + dp[map[nx][ny] - 32]);
						if (dp[map[nx][ny] - 32].size() != 0) {
							// System.out.println("순간 이동...");
							for (Point elem : dp[map[nx][ny] - 32]) {
								q.offer(elem);

							}
						}
						map[nx][ny] = '.';
						continue;
					}
					if (Character.isUpperCase(map[nx][ny])) { // 문일경우 저장
						// System.out.println("this is door..." + nx + " " + ny);
						// 열쇠가 있다면 문 열기
						if (knd[map[nx][ny] + 32]) {
							// System.out.println("open the door...");
							map[nx][ny] = '.';
							knd[map[nx][ny] - 32] = true; // 문에 방문 표시
							q.offer(new Point(nx, ny));
							continue;
						}
						// 열쇠가 없으면 저장
						dp[map[nx][ny]].add(new Point(nx, ny));

						continue;
					}
					q.offer(new Point(nx, ny));

				}
			}

			sb.append(docCnt + "\n");
		}
		System.out.println(sb.toString());
	}

}

package boj.p17k.p17300;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P17371 {

	public static float getDis(int x1, int y1, int x2, int y2) {
		return (float) (Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));

	}

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.valueOf(in.readLine());
		Point[] arr = new Point[N];
		StringTokenizer st;

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			int x = Integer.valueOf(st.nextToken());
			int y = Integer.valueOf(st.nextToken());
			arr[i] = new Point(x, y);
		}
		float ans = 999999999;
		int minIdx = 0;
		for (int i = 0; i < N; i++) {

			float max = 0;
			int maxIdx = 0;

			for (int j = 0; j < N; j++) {
				if (i == j)
					continue;
				float dis = getDis(arr[i].x, arr[i].y, arr[j].x, arr[j].y);
				if (max < dis) {
					maxIdx = i;
					max = dis;
				}
			}
			if (ans > max) {
				minIdx = maxIdx;
				ans = max;
			}
		}

		System.out.println(arr[minIdx].x + " " + arr[minIdx].y);
	}

}

package boj.p13k.p13100;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P13141 {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		float[][][] dis = new float[N + 1][N + 1][2];
		// 0은 시간, 1은 거리
		for (int i = 0; i < N + 1; i++) {
			for (int j = 0; j < N + 1; j++) {
				Arrays.fill(dis[i][j], Float.MAX_VALUE);
			}
		}

		// 자신에게의 거리는 0이다.
		for (int i = 1; i < N + 1; i++) {
			dis[i][i][0] = 0;
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(in.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			float weight = Float.parseFloat(st.nextToken());
			if (dis[from][to][1] == Float.MAX_VALUE || dis[from][to][1] < weight) {
				dis[to][from][1] = weight;
				dis[from][to][1] = weight;
			}

			dis[from][to][0] = Math.min(dis[from][to][0], weight);
			dis[to][from][0] = Math.min(dis[to][from][0], weight);

		} // 0은거리이므로 min, 1은 시간이므로 가장 긴 간선을 알아야 하니 max

		// 거리를 최단거리로
		for (int k = 1; k < N + 1; k++) {
			for (int i = 1; i < N + 1; i++) {
				for (int j = 1; j < N + 1; j++) {
					dis[i][j][0] = Math.min(dis[i][j][0], dis[i][k][0] + dis[k][j][0]);
				}
			}
		}

		float ans = Float.MAX_VALUE;

		// 시간을 계산한다
		for (int start = 1; start < N + 1; start++) {

			float maxTime = 0;

			for (int mid = 1; mid < N + 1; mid++) {
				for (int end = 1; end < N + 1; end++) {
					/*
					 * 
					 * mid로부터 end까지 향하는 최소시간은 보다 긴 간선의 길이와 가장 짧은 간선의 길이간의 차를 2로 나눈 것이다. 이 값을 time이라고
					 * 한다면
					 * 
					 * 어떤 정점 start를 기준으로 end까지 이르는 최소 시간은 start to end의 최단거리와 time의 합이다.
					 * 
					 */

					if (dis[mid][end][1] == Float.MAX_VALUE)
						continue;
					// 간선이 없으면 동작하지 않음

					float distance = dis[start][end][0] - dis[start][mid][0];
					float remaining_time = (dis[mid][end][1] - distance) / 2;
					if (remaining_time <= 0)
						continue;

					float spentTime = remaining_time + dis[start][end][0];
					maxTime = Math.max(spentTime, maxTime);
				}

			}
			ans = Math.min(maxTime, ans);
		}
		System.out.println(ans);

	}

}

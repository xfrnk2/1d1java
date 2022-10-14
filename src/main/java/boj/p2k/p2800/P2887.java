package boj.p2k.p2800;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class P2887 {

	static int N;
	static int[] parents;

	public static int find(int a) {

		if (parents[a] == a)
			return a;
		return parents[a] = find(parents[a]);
	}

	public static boolean union(int a, int b) {
		int aR, bR;
		aR = find(a);
		bR = find(b);

		if (aR == bR)
			return false;

		parents[aR] = bR;
		return true;
	}

	public static void make() {

		for (int i = 0; i < N; i++) {
			parents[i] = i;
		}

	}

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(in.readLine());

		parents = new int[N];
		Integer[][] xArr = new Integer[N][2];
		Integer[][] yArr = new Integer[N][2];
		Integer[][] zArr = new Integer[N][2];

		StringTokenizer st;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			xArr[i] = new Integer[] {Integer.parseInt(st.nextToken()), i};
			yArr[i] = new Integer[] {Integer.parseInt(st.nextToken()), i};
			zArr[i] = new Integer[] {Integer.parseInt(st.nextToken()), i};
			
		}
		make();

		Arrays.sort(xArr, (a, b) -> a[0] - b[0]);
		Arrays.sort(yArr, (a, b) -> a[0] - b[0]);
		Arrays.sort(zArr, (a, b) -> a[0] - b[0]);


		List<int[]> edges = new ArrayList<>();
		for (int i = 0; i < N - 1; i++) {
			edges.add(new int[] { xArr[i+1][0] - xArr[i][0], xArr[i][1], xArr[i+1][1]}); // 가중치, 출발지, 도착지
			edges.add(new int[] { yArr[i+1][0] - yArr[i][0], yArr[i][1], yArr[i+1][1]}); // 가중치, 출발지, 도착지
			edges.add(new int[] { zArr[i+1][0] - zArr[i][0], zArr[i][1], zArr[i+1][1]}); // 가중치, 출발지, 도착지
		}

		Collections.sort(edges, new Comparator<int[]>() {
			@Override
			public int compare(int[] a, int[] b) {
				return a[0] - b[0];
			}
		});


		int cnt = 0;
		int cost = 0;
		int E = N - 1;

		for (int[] edge : edges) {
			if (union(edge[1], edge[2])) {
				cost += edge[0];
				cnt++;
				if (cnt == E) {
					break;
				}
			}

		}
		System.out.println(cost);

	}

}

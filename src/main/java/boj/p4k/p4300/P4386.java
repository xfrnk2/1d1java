package boj.p4k.p4300;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class P4386 {
	static int N;
	static StarPos[] vertex;
	static float[][] d;
	static List<Edge> edges;
	static int[] parents;

	static class StarPos {
		float x, y;

		public StarPos(float x, float y) {
			super();
			this.x = x;
			this.y = y;
		}
	}

	static class Edge {
		int from, to;
		float distance;

		public Edge(int from, int to, float distance) {
			super();
			this.from = from;
			this.to = to;
			this.distance = distance;
		}
	}

	public static int find(int a) {
		if (a == parents[a])
			return a;
		return parents[a] = find(parents[a]);
	}

	public static void make() {
		parents = new int[N];
		for (int i = 0; i < N; i++) {
			parents[i] = i;
		}
	}

	public static boolean union(int a, int b) {
		int aR = find(a);
		int bR = find(b);
		if (aR == bR)
			return false;
		parents[bR] = aR;
		return true;
	}

	public static float getDistance(StarPos a, StarPos b) {
		if (a.x != b.x && a.y != b.y) {
			return (float) Math.sqrt(Math.pow(Math.abs(a.x - b.x), 2) + Math.pow(Math.abs(a.y - b.y), 2));
		} else if (a.x == b.x) {
			return (float) Math.abs(a.y - b.y);
		} else {
			return (float) Math.abs(a.x - b.x);
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(in.readLine());
		vertex = new StarPos[N];
		d = new float[N][N];
		edges = new ArrayList<>();
		parents = new int[N];
		make();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			float x = Float.parseFloat(st.nextToken());
			float y = Float.parseFloat(st.nextToken());
			vertex[i] = new StarPos(x, y);
		}

		for (int i = 0; i < N; i++) {
			for (int j = i + 1; j < N; j++) {
				float dis = getDistance(vertex[i], vertex[j]);
				edges.add(new Edge(i, j, dis));
			}
		}
		Collections.sort(edges, new Comparator<Edge>() {
			@Override
			public int compare(Edge o1, Edge o2) {
				return Float.compare(o1.distance, o2.distance);
			}
		});

		int cnt = 0;
		float res = 0;

		for (Edge edge : edges) {

			if (union(edge.from, edge.to)) {

				res += edge.distance;
				if (++cnt == N - 1) {
					break;
				}
			}
		}

		System.out.printf("%.2f", res);

	}

}

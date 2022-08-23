package swea.d4;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;


public class P1251 {
	static int[] parents;
	static int N;
	
	public static class Edge implements Comparable<Edge> {
		
		int from, to; long weight;
		
		Edge(int from, int to, long weight) {
			this.from = from;
			this.to = to;
			this.weight = weight;
		}
		
		public int compareTo(Edge e) {
			return Long.valueOf(this.weight).compareTo(e.weight);
		}
		
		@Override
		public String toString() {
			return this.from + " " + this.to + " " + this.weight;
 		}
	}
	
	
	public static void make() {
		parents = new int[N];
		for (int i = 0; i < N; i++) {
			parents[i] = i;
		}
	}
	
	public static int find(int a) {
		if (parents[a] == a) return a;
		return parents[a] = find(parents[a]);
	}
	
	public static boolean union(int a, int b) {
		int aRoot = find(a);
		int bRoot = find(b);
		if (aRoot == bRoot) return false;
		parents[bRoot] = aRoot;
		return true;
	}
	
	
	
	public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
         
        StringTokenizer st;
        
        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			int[][] co = new int[N][2];
			
			
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				co[i][0] = Integer.parseInt(st.nextToken());
			}
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				co[i][1] = Integer.parseInt(st.nextToken());
			}

			
			double rate =  Double.parseDouble(br.readLine());
			
			make();
			
			List<Edge> edges = new ArrayList<>();
			for (int i = 0; i < N; i++) {
				for (int j = i + 1; j < N; j++) {
					long dx = Math.abs(co[i][0] - co[j][0]);
					long dy = Math.abs(co[i][1] - co[j][1]);
					edges.add(new Edge(i, j, dx * dx + dy * dy));
				}
			}
	
			Collections.sort(edges);
			
			long sum = 0;
			int cnt = 0;
			
			for (Edge edge : edges) {
				if (union(edge.from, edge.to)) {
					sum += edge.weight;
					if (++cnt == N - 1) break;
				}
			}
	
			System.out.printf("#%d %d%n", tc, Math.round(sum * rate));
			
			
		}
	}

}


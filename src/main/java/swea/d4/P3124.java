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

public class P3124 {

	static int N;
	static int[] parents;

	public static class Edge implements Comparable<Edge> {
		
		int from, to, weight;
		
		Edge(int from, int to, int weight) {
			this.from = from;
			this.to = to;
			this.weight = weight;
		}
		
		public int compareTo(Edge e) {
			return this.weight - e.weight; 
		}
	}
	
	
	public static void make() {
		parents = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			parents[i] = i;
		}
	}
	
	public static int find (int a) {
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
        	bw.write("#" + tc + " ");
        	
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			List<Edge> edges = new ArrayList<>(e + 1);
			long weightSum = 0;
	
			make();
			
			for(int i = 0; i < e; i ++) {
				st = new StringTokenizer(br.readLine());
				int from =  Integer.parseInt(st.nextToken());
				int to =  Integer.parseInt(st.nextToken());
				int weight =  Integer.parseInt(st.nextToken());
				edges.add(new Edge(from, to, weight));
			}
			Collections.sort(edges);
			
			int cnt = 0;
			for (Edge edge : edges) {
				if (union(edge.from, edge.to)) {
					weightSum += edge.weight;
					if (cnt++ == N - 1) break;
				}
			}
			bw.write(weightSum + "\n");

        	
        	
		}
        bw.flush();
	}

}

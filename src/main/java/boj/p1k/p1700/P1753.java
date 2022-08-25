package boj.p1k.p1700;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


public class P1753 {
	
	static class Node implements Comparable<Node>{
		int to, weight;
		public Node(int to, int weight) {
			this.to = to;
			this.weight = weight;
			}
		public int compareTo(Node o) {
			return this.weight - o.weight;
		}
		
		
		}
	
	
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		List<Node>[] adjList = new ArrayList[V + 1];
		for (int i = 0; i <= V; i++) {
			adjList[i] = new ArrayList<Node>();
		}
		int[] D = new int[V + 1]; 
		boolean[] visited = new boolean[V + 1];
		
		int start = Integer.parseInt(in.readLine());
		int end = V;
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(in.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			adjList[from].add(new Node(to, weight));
		}
		


		
		Arrays.fill(D, Integer.MAX_VALUE);
		// 출발정점 처리
		D[start] = 0;
		PriorityQueue<Node> queue = new PriorityQueue<>();
		queue.offer(new Node(start, 0));
		
		while (!queue.isEmpty()) {
			Node currentNode = queue.poll();
			int cur = currentNode.to;
			if (visited[cur]) continue;
			visited[cur] = true;
			
			for (Node node : adjList[cur]) {
				if (D[cur] + node.weight  < D[node.to]) {
					D[node.to] = D[cur] + node.weight;
					queue.offer(new Node(node.to, D[node.to]));
				}
			}
			
 		}

		for (int j = 1; j <= V; j++) {
			System.out.println( D[j] == Integer.MAX_VALUE ? "INF" : D[j]);
		}
		
	}

}

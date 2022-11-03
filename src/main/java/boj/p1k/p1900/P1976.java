package boj.p1k.p1900;


import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class P1976 {
	
	static int N, M;
	static int[] order;
	static int[][] map;
	static boolean[][] visit;
	static int[] parents;
	
	public static void make() {
		parents = new int[N];
		for (int i = 0; i < N; i++) {
			parents[i] = i;
		}
	}
	
	public static int find(int a) {
		if (a == parents[a]) return a;
		return parents[a] = find(parents[a]);
	}
	
	public static boolean union(int a, int b) {
		int aR = find(a);
		int bR = find(b);
		if (aR == bR) return false;
		if (aR < bR) parents[aR] = bR;
		else parents[bR] = aR;
		return true;
			
	}
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		
		N = Integer.parseInt(in.readLine());
		M = Integer.parseInt(in.readLine());
		make();
		List<Point> list = new ArrayList<>();
		
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			for (int j = 0; j < N; j++) {
				int cur = Integer.parseInt(st.nextToken());
				if (cur == 1) {
					list.add(new Point(i, j));

				}
				
			}
		}

		for (Point point : list) {
			union(point.x, point.y);
		}
		
		st = new StringTokenizer(in.readLine());
		
		int prev =Integer.parseInt(st.nextToken()) - 1;
		boolean flag = true;
		for (int i = 0; i < M - 1; i++) {
			if (find(prev) != find(Integer.parseInt(st.nextToken()) - 1)) {
				flag = false;
				break;
			}
			
		}
		System.out.println(flag ? "YES" : "NO");
	}
	


	
	
	
	
}

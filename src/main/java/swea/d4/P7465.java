package swea.d4;


import java.awt.Point;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class P7465 {
	static int N, M;
	static int[] parents;

	
	
	public static void make() {
		parents = new int[N + 1];
		for (int i = 1, end = N + 1; i < end; i++) {
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
		
        
		for (int tc = 1, end = Integer.parseInt(br.readLine()); tc <= end; tc++) {
			
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			make();
			
	        ArrayList<Point> relation = new ArrayList<>(M);
	        
	        for (int i = 0; i < M; i++) {
	        	st = new StringTokenizer(br.readLine());
	        	int from = Integer.parseInt(st.nextToken());
	        	int to = Integer.parseInt(st.nextToken());
	        	relation.add(new Point(from, to));
			}
	        
	        int res = N;
	        for (Point point : relation) {
				if (union(point.x, point.y)) res --;
			}
	        
	        System.out.printf("#%d %d%n", tc, res);
			
		}
        
	}

}

package boj.p20k.p20000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P20040 {
	static int N, M;
	static int[] parents;
	
	
	static void make() {
		parents = new int[N];
		for (int i = 0; i < N; i++) {
			parents[i] = i;
		}
	}
	
	static int find (int a) {
		if (parents[a] == a) return a;
		return parents[a] = find(parents[a]);
	}
	
	static boolean union (int a, int b) {
		int aR = find(a);
		int bR = find(b);
		if (aR == bR) return false;
		parents[bR] = aR;
		return true;
	}
	
	
	
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		N = Integer.valueOf(st.nextToken());
		M = Integer.valueOf(st.nextToken());
		make();
		int ans = 0;
		int cnt = 0;
		
		for (int i = 0; i < M; i++) {
			 cnt ++;
			
			 st = new StringTokenizer(in.readLine());
			 int start = Integer.valueOf(st.nextToken());
			 int end = Integer.valueOf(st.nextToken());
			 
			 
			 if (!union(start, end)) {
				 ans = cnt;
				 break;
			 }
		}
		System.out.print(ans);
		
	}

}

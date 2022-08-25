package boj.p10k.p10900;
import java.util.Arrays;
import java.util.Scanner;

public class P10971 {
	static int N, ans = Integer.MAX_VALUE;
	static int[] city;
	static int[][] map;
	static boolean[] visited;
	
	
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		city = new int[N];
		map = new int[N][N];
		visited = new boolean[N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		
		
		permutation(0, 0);
		System.out.println(ans);
	}
	
	public static void permutation(int cnt, int sum) {
		if (cnt == N) {
			int lastCost = map[city[N - 1]][city[0]];
			if (lastCost != 0) {
				ans = Math.min(ans, sum + lastCost);
			}
			return;
		}
		for (int i = 0; i < N; i++) {
			if (visited[i]) continue;
			if (cnt > 0 && map[city[cnt - 1]][i] == 0) continue; 
			city[cnt] = i;
			visited[i] = true;
			permutation(cnt + 1,
					cnt == 0 ? 0 : sum + map[city[cnt-1]][i]);
			visited[i] = false;
		}
	}
}

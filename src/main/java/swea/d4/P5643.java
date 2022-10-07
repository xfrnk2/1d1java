package swea.d4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P5643 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());
		StringTokenizer st;
		for (int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(in.readLine());
			int M = Integer.parseInt(in.readLine());
			boolean[][] mat = new boolean[N+1][N+1]; 
			
			
			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(in.readLine());
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				mat[from][to]= true;
			}
			
			for (int k = 1; k <= N; k++) {
				for (int i = 1; i <= N; i++) {
					for (int j = 1; j <= N; j++) {
						if (mat[i][k] && mat[k][j]) mat[i][j] = true;
					}
				}
			}

			int s = 0;
			for (int i = 1; i <= N; i++) {
				
				boolean flag = true;
				for (int j = 1; j <= N; j++) {
					
					if (i == j || mat[i][j] ^ mat[j][i])
						continue;
					
					flag = false;
					break;

				}
				if (flag) s++; 
			}
			System.out.printf("#%d %d\n", tc, s);
		}
	}

}

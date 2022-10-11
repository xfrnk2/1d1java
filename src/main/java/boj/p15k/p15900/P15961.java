package boj.p15k.p15900;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

public class P15961 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		

		int N = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int[] sushi = new int[N];
		int[] eat = new int[3001];
		int cnt = 0;
		for (int i = 0; i < N; i++) {
			sushi[i] = Integer.parseInt(in.readLine());
		}
		

		for (int i = 0; i < k; i++) {
			if (eat[sushi[i]] == 0) cnt++;
			eat[sushi[i]]++;
		}
		int curMax = cnt;
		
		for (int i = 0; i < N; i++) {
			if (curMax <= cnt) {
				if (eat[c] == 0) curMax=cnt+1;
				else curMax = cnt; 
			}
			
			if (eat[sushi[i]] == 1) {
				cnt -=1;
			}
			eat[sushi[i]]--;
			if(eat[sushi[(i+k)%N]] == 0)cnt ++;
			eat[sushi[(i+k)%N]]++;
		}
		
		System.out.println(curMax);
		
		
	}

}

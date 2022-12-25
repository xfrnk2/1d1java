package boj.p10k.p10700;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class P10775 {
	static int G, P, ans = 0;
	static int[] visit;

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		G = Integer.valueOf(in.readLine());
		P = Integer.valueOf(in.readLine());
		visit = new int[G + 1];
		boolean finish = true;
		for (int i = 0; i < P; i++) {
			int target = Integer.valueOf(in.readLine());
			while (target > 0 && visit[target] > 0) {
				visit[target]++;
				target-= visit[target] - 1;
			}

			if (target <= 0) {
				break;
			} 
            
			visit[target] = 1;
			ans ++;
			


		}
		System.out.println(ans);
	}

}

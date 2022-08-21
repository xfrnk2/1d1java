package boj.p17k.p17200;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P17281 {

	static int N, curScore = 0, ans = 0, cursor= 0, nextCursor = 0;
	static int[] input, players;
	static boolean[] select;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
	

		
		StringTokenizer st;
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			input = new int[9];
			for (int j = 0; j < 9; j++) {
				input[j] = Integer.parseInt(st.nextToken());	
			}
			
			players = new int[9];
			select = new boolean[9];
			//각 이닝마다 시작
			select[0] = true;
			players[3]  = input[0]; // 4번타자를 1타순 선수로 고정
			System.out.println(cursor);
			System.out.println(5555);
			permutation(0);
			cursor = nextCursor;
			ans += curScore;
			curScore = 0;
			System.out.println(cursor);
			System.out.println(nextCursor);
			System.out.println(Arrays.toString(players));
		}
		System.out.println(ans);
		
		
		
		
		
	}
	
	public static void permutation(int cnt) {
			
//			System.out.println(Arrays.toString(players));
//			System.out.println(Arrays.toString(select));
		if (cnt > 8) {

			playGame(cursor);
			return;
		}
		
		if (cnt == 3) {
			permutation(cnt + 1);
			return;
		}
		
		for (int i = 0; i < 9; i++) {
			if (select[i]) continue;
			players[cnt] = input[i];
			select[i] = true;
			permutation(cnt + 1);
			select[i] = false;
		}
		
	}
	
	
	public static void playGame(int pos) {
		int outCnt = 0, res = 0;
		int[] base = new int[4];

		while(outCnt < 3) {
				
			base[0] = 1;
			switch(players[pos++]) {
			case 1:
				res += base[3];
				base[3] = base[2];
				base[2] = base[1];
				base[1] = base[0];
				base[0] = 0;
				break;
			case 2:
				res += base[2] + base[3];
				base[3] = base[1];
				base[2] = base[0];
				base[0] = base[1] = 0;
				break;
			case 3:
				res += base[1] + base[2] + base[3];
				base[3] = base[0];
				base[0] = base[1] = base[2] = 0;
				break;
			case 4:
				res += base[0] + base[1] + base[2] + base[3];
				base[0] = base[1] = base[2] = base[3] = 0;
				break;
			default:
				outCnt++;
				base[0] = 0;
				break;
//			case 0:
//				outCnt ++;
//				break;
//			case 1:
//				for (int i = 2; i >= 0; i--) {
//					if (base[i]) {
//						if (i == 2) {
//							res ++;
//							base[i] = false;
//							continue;
//						}
//						base[i + 1] = true;
//						base[i] = false;
//					} 
//				}
//				base[0] = true;
//				break;
//			case 2:
//				for (int i = 2 ; i >= 0; i--) {
//					if (base[i]) {
//						if (1 <= i) {
//							res ++;
//							base[i] = false;
//							continue;
//						}
//						base[i + 2] = true;
//						base[i] = false;
//					} 
//				}
//				base[1] = true;
//				break;
//			case 3:
//				for (int i = 2; i >= 0; i--) {
//					if (base[i]) {
//						res ++;
//						base[i] = false;
//					}
//				}
//				base[2] = true;
//				break;
//			case 4:
//				for (int i = 0; i < 3; i++) {
//					if (base[i]) {
//						res ++;
//						base[i] = false;
//					}
//				}
//				res ++;
//				break;
			}
			if (pos > 8) pos = 0;

		}

		if (curScore < res) {
			nextCursor = pos;
			curScore = res;

		}
		
	}

}

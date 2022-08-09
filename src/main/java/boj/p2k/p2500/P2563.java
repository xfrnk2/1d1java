package boj.p2k.p2500;
import java.util.Scanner;

public class P2563 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		boolean[][] paper = new boolean[100][100];
		int n = sc.nextInt();
		int ans = 0;
		for(int k = 0; k < n; k++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			for(int i = x, xEnd = x + 10; i < xEnd; i++ ) {
				for(int j = y, yEnd = y + 10; j < yEnd; j++) {
					if(paper[i][j]) continue;
					paper[i][j] = true;
					ans++;
				}
			}
		}
		System.out.print(ans);
	}
}
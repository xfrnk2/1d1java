import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;

public class P9252{
	static int s1len, s2len;
	static int[][] d;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String str1 = in.readLine();
		String str2 = in.readLine();

		s1len = str1.length();
		s2len = str2.length();

		d = new int[s1len + 1][s2len + 1];

		for (int i = 1; i <= s1len; i++) {

			for (int j = 1; j <= s2len; j++) {
				if(str1.charAt(i-1) == str2.charAt(j-1)) {
					d[i][j] = d[i-1][j-1] +1;
				}else {
					d[i][j] = Math.max(d[i-1][j], d[i][j-1]);
				}
			}
		}
		ArrayDeque<Character> q = new ArrayDeque<>();

		int i = s1len, j = s2len;
		
		while (0 < i && 0 < j) {
			if (d[i][j] == d[i - 1][j]) {
				i--;
				continue;
			}
			if (d[i][j] == d[i][j - 1]) {
				j--;
				continue;
			} else {
				q.offerFirst(str1.charAt(i - 1));
				i--;
				j--;
			}
		}
		
		System.out.println(d[s1len][s2len]);
		if (!q.isEmpty()) {
			String res = "";
			for (Character character : q) {
				res += character;
			}
			System.out.println(res);
		}
	}

}

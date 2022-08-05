import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

	static int N, K;
	static String[] words;
	static boolean[] selected = new boolean[26];
	static int answer = 0;

	public static void main(String[] args) throws NumberFormatException, IOException {

		selected[0] = true;
		selected[13] = true;
		selected[19] = true;
		selected[8] = true;
		selected[2] = true;

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] info = br.readLine().split(" ");
		N = Integer.parseInt(info[0]);
		K = Integer.parseInt(info[1]);
		if (K < 5) {
			System.out.println(0);
			return;
		}
		words = new String[N];

		for (int i = 0; i < N; i++) {
			String cur = br.readLine();
			words[i] = cur.substring(4, cur.length() - 4);
		}

		combination(0, 0);
		System.out.println(answer);

	}

	public static void updateMax(int cnt) {

		int result = 0;
		for (String word : words) {
			boolean flag = true;
			for (int i = 0; i < word.length(); i++) {
				if (!selected[word.charAt(i) - 97]) {
					flag = false;
					break;
				}
			}
			if (flag)
				result++;
		}
		answer = Math.max(answer, result);

	}

	public static void combination(int cnt, int start) {

		if (cnt == K - 5) {
			updateMax(cnt);
		}

		for (int i = start; i < 26; i++) {
			if (!selected[i]) {
				selected[i] = true;
				combination(cnt + 1, i + 1);
				selected[i] = false;
			}
		}
	}

}

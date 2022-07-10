package sw_expert_academy.d2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p1961 {

	private static int[][] rotate(int n, int[][] array) {
		int[][] result = new int[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				result[i][j] = array[n - 1 - j][i];
			}
		}
		return result;
	}

	private static void renderResult(int n, String[] array) {
		for (int i = 0; i < n; i++) {
			System.out.println(array[i].trim());
		}
	}

	private static void save(int n, int[][] array, String[] answer) {
		for (int i = 0; i < n; i++) {
			String temp = "";
			for (int j = 0; j < n; j++) {
				temp += Integer.toString(array[i][j]);
			}
			if (answer[i] == null) {
				answer[i] = temp += " ";
			} else {
				answer[i] += temp + " ";
			}
		}
	}

	public static void main(String[] args) throws IOException {

		final int ROTATION_COUNT = 3;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int t = Integer.parseInt(st.nextToken());
		for (int k = 0; k < t; k++) {
			int n = Integer.parseInt(br.readLine());
			int[][] array = new int[n][n];
			String[] answer = new String[n];

			System.out.printf("#%d\n", k + 1);
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < n; j++) {
					array[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			for (int c = 0; c < ROTATION_COUNT; c++) {
				array = rotate(n, array);
				save(n, array, answer);

			}
			renderResult(n, answer);
		}

	}
}

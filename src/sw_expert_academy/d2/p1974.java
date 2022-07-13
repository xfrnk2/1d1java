package sw_expert_academy.d2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class p1974 {

	private static int[] getNumbers(int[][] field, int start, int end) {
		int[] numbers = new int[9];
		int count = 0;
		for (int i = start; i < end; i++) {
			for (int j = start; j < end; j++) {
				numbers[count] = field[i][j];
				count++;
			}
		}
		return numbers;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int t = Integer.parseInt(st.nextToken());
		final int[][] field = new int[9][9];
		int[] required = {1, 2, 3, 4, 5, 6, 7, 8, 9};

		for (int k = 1; k < t + 1; k++) {
			int answer = 1;
			for (int i = 0; i < 9; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < 9; j++) {
					field[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			for (int i = 0; i < 9; i++) {
				int[] vertical = new int[9];
				int[] horizontal = new int[9];
				for (int j = 0; j < 9; j++) {
					vertical[j] = field[j][i];
					horizontal[j] = field[i][j];
				}
				Arrays.sort(vertical);
				Arrays.sort(horizontal);
				if (!(Arrays.equals(required, vertical) && Arrays.equals(required, horizontal))) {
					answer = 0;
					break;
				}

				if ((i + 1) != 9 && (i + 1) % 3 == 0) {
					int startCount = (i + 1) / 3;
					int[] result = getNumbers(field, startCount * 3, (startCount + 1) * 3);
					Arrays.sort(result);
					if (!(Arrays.equals(result, required))) {
						answer = 0;
						break;
					}
				}
			}

			System.out.println(String.format("#%d %d", k, answer));
		}
	}
}

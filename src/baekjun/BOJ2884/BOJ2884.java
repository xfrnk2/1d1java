package baekjun.BOJ2884;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2884 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int hour = 0;
		int minute = 0;
		int[] inputs = new int[2];

		for (int i = 0; i < 2; i++) {
			inputs[i] = Integer.parseInt(st.nextToken());
		}
		hour = inputs[0];
		minute = inputs[1];

		if (inputs[1] < 45) {
			hour -= 1;
			minute = 60 + inputs[1] - 45;
		} else {
			minute = inputs[1] - 45;
		}

		if (hour == -1) {
			hour = 23;
		}

		System.out.print(hour + " " + minute);

	}
}


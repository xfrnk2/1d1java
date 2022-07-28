package boj.p2k.p2900;

public class P2979 {
	public static void main(int a, int b, int c, int[][] bus) {
		int start = Integer.MAX_VALUE;
		int end = Integer.MIN_VALUE;
		int answer = 0;

		for (int[] ints : bus) {
			start = Math.min(start, ints[0]);
			end = Math.max(end, ints[1]);
		}

		int[] scores = new int[end];

		for (int i = start; i < end; i++) {
			if (start <= bus[i][0] && bus[i][1] < end) {
				scores[i]++;
			}
		}
		for (int i = start; i < end; i++) {
			int cur = scores[i];
			if (cur == 3)
				answer += c * 3;
			else if (cur == 2)
				answer += b * 2;
			else if (cur == 1)
				answer += a;
		}

		System.out.print(answer);

	}
}

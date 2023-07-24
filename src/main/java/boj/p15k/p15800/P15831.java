package boj.p15k.p15800;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P15831 {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());

		int N = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		int W = Integer.parseInt(st.nextToken());
		int max = 0;
		int wNum = 0;
		int bNum = 0;
		String input = in.readLine();
		for (int i = 0; i < N; i++) {
			if (input.charAt(i) == 'W') wNum++;
			else {
				bNum++;
				while (B < bNum) {
					if (input.charAt(i + 1 - (bNum + wNum)) == 'W') {
						wNum--;
					} else {
						bNum--;
					}
				}
			}
			if (W <= wNum && max < wNum + bNum) {
				max = Math.max(max, wNum + bNum);
			}
		}
		System.out.println(max);
	}

}

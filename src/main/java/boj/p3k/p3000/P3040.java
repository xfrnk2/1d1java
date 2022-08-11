import java.util.Scanner;

public class P3040 {
	static int N = 9, R = 7;
	static int[] dwarfs, answer;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		dwarfs = new int[N];
		answer = new int[R];
		for (int i = 0; i < N; i++) {
			dwarfs[i] = sc.nextInt();
		}

		combination(N, R);

	}

	public static void combination(int cnt, int r) {
		if (r == 0) {
			int sum = 0;
			for (int dwarf : answer) {
				sum += dwarf;
			}

			if (sum != 100)
				return;
			for (int dwarf : answer) {
				System.out.println(dwarf);
			}
			System.exit(0);
		}

		if (cnt < r)
			return;

		answer[r - 1] = dwarfs[cnt - 1];
		combination(cnt - 1, r - 1); // 선택
		combination(cnt - 1, r); // 선택하지 않음

	}

}

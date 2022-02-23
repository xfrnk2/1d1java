import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		int K = in.nextInt();

		int[] coin = new int[N];
		for (int i = 0; i < N; i++) {
			coin[i] = in.nextInt();
		}
		List<Integer> coinList = Arrays.stream(coin)
			.boxed()
			.sorted(Comparator.reverseOrder())
			.collect(Collectors.toList());

		int answer = calculate(coinList, N, K);
		System.out.println(answer);
	}

	static int calculate(final List<Integer> coinList, final int N, int K) {
		int result = 0;
		for (int i = 0; i < N; i++) {
			if (K <= 0) {
				break;
			}
			int num = coinList.get(i);
			result += K / num;
			K %= num;
		}
		return result;
	}
}
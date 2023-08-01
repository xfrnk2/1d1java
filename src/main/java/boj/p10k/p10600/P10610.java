package boj.p10k.p10600;


import java.util.*;


public class P10610 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String str = sc.next();
		int[] arr = new int[str.length()];
		int cnt = 0;
		for (int i = 0; i < str.length(); i++) {
			arr[i] = str.charAt(i) - 48;
			cnt += arr[i];
		}
		Arrays.sort(arr);
		if ((arr[0]==0) && (cnt % 3 == 0)) {
			for(int i = str.length()-1;i>-1;i--) {
				System.out.print(arr[i]);
			}
		} else {
			System.out.println(-1);
		}

	}
}

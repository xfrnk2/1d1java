package boj.p18k.p18400;


import java.util.Scanner;

public class P18409 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		String str = sc.next();
		int ans = 0;

		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == 'a') {
				ans++;
			} else if (str.charAt(i) == 'e') {
				ans++;
			} else if (str.charAt(i) == 'i') {
				ans++;
			} else if (str.charAt(i) == 'o') {
				ans++;
			} else if (str.charAt(i) == 'u') {
				ans++;
			}
		}
		System.out.println(ans);
	}

}

